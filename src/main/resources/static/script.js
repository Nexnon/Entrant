function onInfoClick(){
    window.location.href='/'
}
function onRegistryClick(){
    window.location.href='/registry'
}
function onRegister(){
    let name = document.querySelector('#name');
    let email = document.querySelector('#email');
    let password = document.querySelector('#password');
    if(name == "" || email == "" || password == ""){
        alert("Заполните все поля")
        return;
    }
    let json = JSON.stringify({'name':name.value, 'email':email.value, 'password':password.value});
    let req = CreateRequest();
    if (!req)
    {
        return;
    }
    console.log("Send");
    try{
        req.onreadystatechange = function()
        {
            if (req.readyState == 4)
            {
                window.localStorage.setItem("token",req.response["token"])
                onPersonalClick()
            } else{
                console.log("not work " + req.readyState)
            }
        }
    } catch(e){
        console.log("catch", e)
    }
    req.open("POST", "/user/register")
    req.setRequestHeader("Content-Type", "application/json");
    req.responseType = "json"
    req.send(json);

}
function onLogout(){
    window.localStorage.removeItem("token");
    onPersonalClick()
}
function onPersonalClick(){
    window.location.href = "/user?token="+window.localStorage.getItem("token");
}

function CreateRequest()
{
    var Request = false;

    if (window.XMLHttpRequest)
    {
        //Gecko-совместимые браузеры, Safari, Konqueror
        Request = new XMLHttpRequest();
    }
    else if (window.ActiveXObject)
    {
        //Internet explorer
        try
        {
            Request = new ActiveXObject("Microsoft.XMLHTTP");
        }
        catch (CatchException)
        {
            Request = new ActiveXObject("Msxml2.XMLHTTP");
        }
    }

    if (!Request)
    {
        alert("Невозможно создать XMLHttpRequest");
    }

    return Request;
}