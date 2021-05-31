function readXML(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if(this.readyState==4 && this.status==200){
            showData(this);
        }
    };
    xhttp.open("GET", "./Xml/previousmatches.xml", true);
    xhttp.send();
};

function showData(xml) {
   
    var xmlDoc = xml.responseXML;
    var x = xmlDoc.getElementsByTagName("match");
    var i =0;
    var last = "<div class=\"event\"> <div class=\"event-left\">             <div class=\"event-date\">"+x[i].getElementsByTagName("matchDate")[0].childNodes[0].nodeValue+"</div> </div>     </div> "+"<div class=\"event-right\"> <h3 class=\"event-title\">Via Club VS "+x[i].getElementsByTagName("opponentTeam")[0].childNodes[0].nodeValue+"<div class=\"event-description\"> <p>Match type : "+x[i].getElementsByTagName("matchType")[0].childNodes[0].nodeValue+"</p></div></div><p>Result:"+x[i].getElementsByTagName("result")[0].childNodes[0].nodeValue + " </p><p>Venue: "+x[i].getElementsByTagName("venue")[0].childNodes[0].nodeValue+"</p><div class=\"event-timing\"><img src=\"images/time.png\" alt=\"Time\">"+x[i].getElementsByTagName("matchTime")[0].childNodes[0].nodeValue+"</div></div>";
    document.getElementById("lastResult").innerHTML= last;

}

readXML();