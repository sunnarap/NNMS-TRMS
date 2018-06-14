
window.onload = function () {

var xhr2 = new XMLHttpRequest;
xhr2.open("GET","DBUserServlet",true);
xhr2.send();
xhr2.onreadystatechange = function() {
    if(xhr2.readyState == 4 && xhr2.status == 200) {
        var j = JSON.parse(xhr2.responseText);
        console.log(j);
        
        var name = j.firstName + " " + j.lastName + "!";
        console.log(name);
        document.getElementById("name").innerText = name;
        
              
    }
}

var xhr3 = new XMLHttpRequest;
xhr3.open("GET","DBDisplayServlet",true);
xhr3.send();
xhr3.onreadystatechange =  function() {
    if(xhr3.readyState == 4 && xhr3.status == 200) {
        var jrem = JSON.parse(xhr3.responseText);
        console.log(jrem);
        var fill = "<tr><th>ID</th><th>TYPE</th>"
        + "<th>AMOUNT</th><th>SUBMITTED</th><th>STATUS</th></tr>";
        for(var i = 0; i < jrem.length; i++) {
            var tid = "<tr><td>" + jrem[i].rid + "</td>";
            var ttype = "<td>" + jrem[i].type + "</td>";
            var tamt = "<td>" + jrem[i].amount + "</td>";
            var tsubmit = "<td>" + jrem[i].startdate + "</td>";
            var tstatus = "<td>" + jrem[i].status + "</td></tr>"
            fill += tid+ttype+tamt+tsubmit+tstatus;
        }
        remtable = document.getElementById("reim_table").innerHTML;
        console.log(remtable);
        console.log(fill);
        document.getElementById("reim_table").innerHTML = fill;
        console.log("Finished");

        console.log(jrem);

         //var trElement = document.createElement("tr");
         //trElement.innerHTML = tableData;
         //var reimTable = document.getElementById("reim_table");
        // while(tr)
         //reimTable.appendChild(trElement.firstChild);
        
    }


}
}
