function getCitizenApplicationsForCouncil(){
    fetch("/getCitizenApplicationsForCouncil")
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
function addNotification(){
    let text = document.getElementById("notification").value;
    fetch("/addNotification", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            answer: text,
        })
    });
}
function addMessage(){
    let message = document.getElementById("message").value;
    let login = document.getElementById("recipient_login").value;
    fetch("/addMessage", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            login: login,
            message: message,
        })
    });
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
window.onload=function () {
    getCitizenApplicationsForCouncil();
}