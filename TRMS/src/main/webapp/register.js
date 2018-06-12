
var fname = document.getElementById("fname");
var lname = document.getElementById("lname");
var user = document.getElementById("email");
var pw = document.getElementById("password");
var verify = document.getElementById("password2");
var buttons = document.getElementById("submituser");
var form = document.getElementById("registerdata");


function getInfo() {
    form = document.getElementById("registerdata");
    var xhr = new XMLHttpRequest();
    var forminfo = new FormData(form);
    xhr.open("POST","\loginscreen",true);
    xhr.send(forminfo);
}


window.onload = function() {
    buttons.addEventListener("click",function() {
    	
    });
    form.addEventListener("submit",getInfo);

}
