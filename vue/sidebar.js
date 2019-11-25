$(document).ready(function () {

    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
    });
    
    $('#philcolor').bootstrapToggle();

    /*const userAction = async () => {
        const response = await fetch('http://localhost:8090/lamp/4');
        const myJson = await response.json(); //extract JSON from the http response
        alert("adsf");
        console.log(myJson);
      }*/
    
});


function changeColor(id, color) {
    document.getElementById(id).style.background = color;
}

function changeRoom(room) {
    document.getElementById("currentRoom").innerHTML = room;
}