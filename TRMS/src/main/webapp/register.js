var fname = document.getElementById("fname");
var lname = document.getElementById("lname");
var user = document.getElementById("email");
var pw = document.getElementById("password");
var verify = document.getElementById("password2");
var buttons = document.getElementById("submituser");
var form = document.getElementById("registerdata");


function getInfo() {
    alert("test");
    form = document.getElementById("registerdata");
    var xhr = new XMLHttpRequest();
    var forminfo = new FormData(form);
    xhr.open("POST","/RegistrationServlet",true);
    xhr.send(forminfo);
}

document.getElementById('test').addEventListener('click',function() {
    alert("Test");
});


document.getElementById('registerdata').addEventListener('submit',getInfo);
