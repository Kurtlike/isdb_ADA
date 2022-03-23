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
       console.log(data);
    });
}