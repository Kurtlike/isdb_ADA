function getCitizenApplicationsForCouncil(){
    fetch("/getCitizenApplicationsForCouncil")
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
function addNotification(){
    let text = document.getElementById("notification").value;
    fetch("/addNotification", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            text: text,
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

