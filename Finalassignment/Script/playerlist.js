function readXML(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if(this.readyState==4 && this.status==200){
            showData(this);
        }
    };
    xhttp.open("GET", "./Xml/Players.xml", true);
    xhttp.send();
};

function showData(xml) {
    var i;
    var code ="";
    var xmlDoc = xml.responseXML;
    var x = xmlDoc.getElementsByTagName("player");
    for (i = 0; i < x.length; i++) {
         code  += "<div class=\"player"+i+"\"><img src=\"./images/player"+x[i].getElementsByTagName("shirtNumber")[0].childNodes[0].nodeValue+".jpg\"><div class=\"wrap\"><p>Name: "+x[i].getElementsByTagName("name")[0].childNodes[0].nodeValue+"</p> <p>Shirt number: "+x[i].getElementsByTagName("shirtNumber")[0].childNodes[0].nodeValue +"</p><p>Position: "+x[i].getElementsByTagName("position")[0].childNodes[0].nodeValue+"</p><p>BirthDate : "+x[i].getElementsByTagName("birthDate")[0].childNodes[0].nodeValue +"</p></div></div>";
    }   
    document.getElementById("playertest").innerHTML = code;
}

readXML();