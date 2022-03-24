function getCitizenApplicationsForEmbassy(){
    fetch("/getCitizenApplicationsForEmbassy")
        .then(res => res.json())
        .then(
            (result) => {
                createApplicationsForm(result);
            }
        )
}

function updateCitizenApplication(){
    let id = document.getElementById("id").value;
    let status = document.getElementById("status").value;
    let result = document.getElementById("result").value;
    let st = 'wait';
    fetch("/setStatusAndResult", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            id:id,
            text: null,
            status: status,
            result: result
        })
    });
}
window.onload=function () {
    fetch("/getNotifications", { method : 'GET'}).
    then(response => {
        return response.json();
    }).then((data) =>{
        createNotificationsForm(data);
    });
    fetch("/getMessages", { method : 'GET'}).
    then(response => {
        return response.json();
    }).then((data) =>{
        createMessagesForm(data);
    });
    getCitizenApplicationsForEmbassy();
}
function createNotificationsForm(data) {
    let notificationsForm = document.getElementById("notificationsForm");
    for(let i = 0; i < data.length; i++){
        let notification = document.createElement("div");
        notification.innerText = data[i].text;
        notificationsForm.append(notification);

    }
}
function createMessagesForm(data) {
    let messagesForm = document.getElementById("messages");
    for(let i = 0; i < data.length; i++){
        let message = document.createElement("div");
        message.innerText = data[i].text;
        messagesForm.append(message);
    }
}
function createApplicationsForm(data) {
    let applicationForm = document.getElementById("applications");
    while (applicationForm.firstChild){
        applicationForm.removeChild(applicationForm.firstChild);
    }
    for(let i = 0; i < data.length; i++){
        let application = document.createElement("div");
        application.className = "app";
        let applicationId = document.createElement("div");
        let applicationText = document.createElement("div");
        let applicationStatus = document.createElement("div");
        let applicationAnswer = document.createElement("div");
        applicationId.innerText = data[i].id;
        applicationId.className = "ids";
        applicationText.innerText = data[i].text;
        applicationText.className = "text";
        applicationStatus.innerText = data[i].status;
        applicationAnswer.innerText = data[i].result;
        application.append(applicationId,applicationText,applicationStatus, applicationAnswer);
        applicationForm.append(application);
    }
}
