function codeAddress() {
    document.querySelector('#token').value = window.localStorage.getItem("token")
}
window.onload = codeAddress;

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
    let score = document.querySelector('#score');
    if(name == "" || email == "" || password == "" || score == 0){
        alert("Заполните все поля")
        return;
    }
    let json = 'name='+name.value+ '&email='+email.value+ '&password='+password.value+'&score='+score.value;
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
                if(req.response["token"] === "emailIsRegistered"){
                    alert("Эта почта уже зарегестрирована")
                    return;
                }
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
    req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    req.responseType = "json"
    req.send(json);

}
function onLogout(){
    window.localStorage.removeItem("token");
    onPersonalClick()
}
function onPersonalClick(){
    var dispatchMouseEvent = function(target, var_args) {
        var e = document.createEvent("MouseEvents");
        // If you need clientX, clientY, etc., you can call
        // initMouseEvent instead of initEvent
        e.initEvent.apply(e, Array.prototype.slice.call(arguments, 1));
        target.dispatchEvent(e);
    };
    codeAddress()
    dispatchMouseEvent(document.querySelector("#personal_account"), 'click', true, true)
}
function onLogin(){
    let email = document.querySelector('#email');
    let password = document.querySelector('#password');
    if(email == "" || password == ""){
        alert("Заполните все поля")
        return;
    }
    let json = JSON.stringify({'email':email.value, 'password':password.value});
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
                if(req.response["token"] == "null"){
                    alert("Неверные имя пользователя или пароль")
                }else {
                    window.localStorage.setItem("token", req.response["token"])
                    onPersonalClick()
                }
            } else{
                console.log("not work " + req.readyState)
            }
        }
    } catch(e){
        console.log("catch", e)
    }
    req.open("POST", "/login")
    req.setRequestHeader("Content-Type", "application/json");
    req.responseType = "json"
    req.send(json);
}
function onSingUp(){
    window.location.href = "/singup"
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