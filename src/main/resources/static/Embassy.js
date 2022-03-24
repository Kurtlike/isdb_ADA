function getCitizenApplicationsForEmbassy(){
    fetch("/getCitizenApplicationsForEmbassy")
        .then(res => res.json())
        .then(
            (result) => {
                console.log(result);
            },
            (error) => {
                console.log(error);
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
