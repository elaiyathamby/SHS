$(document).ready(function () {

    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
    });
    
    $('#philcolor').bootstrapToggle();    
});


function changeColor(id, color) {
    document.getElementById(id).style.background = color;
}

function changeRoom(room) {
    document.getElementById("currentRoom").innerHTML = room;
}