function readXML(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if(this.readyState==4 && this.status==200){
            showData(this);
        }
    };
    xhttp.open("GET", "./Xml/upcomingMatches.xml", true);
    xhttp.send();
};

function showData(xml) {
    var i;
    var code ="";
    var xmlDoc = xml.responseXML;
    var x = xmlDoc.getElementsByTagName("match");
    for (i = 0; i < x.length; i++) {
         code  += "<div class=\"event\"> <div class=\"event-left\">             <div class=\"event-date\">"+x[i].getElementsByTagName("matchDate")[0].childNodes[0].nodeValue+"</div> </div>     </div> "+"<div class=\"event-right\"> <h3 class=\"event-title\">Via Club VS "+x[i].getElementsByTagName("opponentTeam")[0].childNodes[0].nodeValue+"<div class=\"event-description\"> <p>Match type : "+x[i].getElementsByTagName("matchType")[0].childNodes[0].nodeValue+"</p><p>Venue"+x[i].getElementsByTagName("venue")[0].childNodes[0].nodeValue+"</p></div></div>  <div class=\"event-timing\"><img src=\"images/time.png\" alt=\"Time\">"+x[i].getElementsByTagName("matchTime")[0].childNodes[0].nodeValue+"</div></div>";
    }   
    document.getElementById("match-container").innerHTML = code + "<br><div class=\"see-more\">    <a href=\"#\"> See more......</a><br></div>";
}

readXML();