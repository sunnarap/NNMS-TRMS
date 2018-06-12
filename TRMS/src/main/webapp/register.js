var buttons = document.getElementbyId("submituser");
var form = document.getElementById("registerdata");


function getInfo() {
	alert("ok");
    form = document.getElementById("registerdata");
    var xhr = new XMLHttpRequest();
    var forminfo = new FormData(form);
    xhr.set('Content-Type','multipart/form-data');
    xhr.open('POST','/RegistrationServlet',true);
    xhr.send(forminfo);
}



buttons.addEventListener("click",function () {
	alert("ok");
    form = document.getElementById("registerdata");
    var xhr = new XMLHttpRequest();
    var forminfo = new FormData(form);
    xhr.set('Content-Type','multipart/form-data');
    xhr.open('POST','/RegistrationServlet',true);
    xhr.send(forminfo);
});

window.onload = function() {
    
    //form.addEventListener("submit",getInfo);

}