function getInfo() {
    form = document.getElementById("formapp");
    var xhr = new XMLHttpRequest();
    var forminfo = new FormData(form);
    xhr.open("POST","form",true);
    xhr.send(forminfo);
}




document.getElementById('formapp').addEventListener('submit',getInfo);
