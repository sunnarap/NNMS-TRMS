var buttons = document.getElementsByName("submituser");
var form = document.getElementById("registerdata");


function getInfo() {
    form = document.getElementById("registerdata");
    var xhr = new XMLHttpRequest();
    var forminfo = new FormData(form);
    xhr.open("POST","\loginscreen",true);
    xhr.send(forminfo);
}


window.onload = function() {
    buttons[0].addEventListener("click",getInfo);
    //form.addEventListener("submit",getInfo);

}