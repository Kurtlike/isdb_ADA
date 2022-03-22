function getAnswer(){
    let id = document.getElementById("id").value;
    let perm = document.getElementById("perm").value;
    let login = document.getElementById("login").value;
    let pass = document.getElementById("pass").value;
    let name = document.getElementById("name").value;
    let race = document.getElementById("race").value;
    console.log(id, perm, login, pass, name, race);
    fetch("/adduser", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            id: id,
            permission: perm,
            login: login,
            password: pass,
            name: name,
            race: race,
            notifications_id: null,
        })
    });
}