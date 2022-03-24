function sentCitizenApplication(){
    let citizenApplication = document.getElementById("citizenApplication").value;
    let st = 'wait';
    fetch("/sentCitizenApplication", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            id:0,
            text: citizenApplication,
            status: st,
            result: null
        })
    });
}
function getCitizenApplications(){
    fetch("/getCitizenApplications")
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
window.onload=function () {
    let promise = fetch("/getNotifications", { method : 'GET'}).
    then(response => {
        return response.json();
    }).then((data) =>{
        createNotificationsForm(data);
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