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
        console.log(data);
    });
    fetch("/getMessages", { method : 'GET'}).
    then(response => {
        return response.json();
    }).then((data) =>{
        console.log(data);
    });
}
