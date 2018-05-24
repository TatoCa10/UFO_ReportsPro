
$(document).ready(function () {

    $("#enviar").click(function () {
        var ID = $("#ID").val();
        var nombre = $("#nombre").val();
        var interprete = $("#interprete").val();
        var album = $("#album").val();
        var id_album = $("#id_album").val();
        
        alert("Entro JS");
        $.ajax({
            url: '../Servlet_Registrar_Cancion',
            type: 'GET',
            data: {ID: ID, nombre: nombre, interprete: interprete, album: album, id_album:id_album},
            dataType: 'json',
            success: function (data) {
                console.log("DATOS CORRECTOS: " + data.confirmacion);
                alert("Se registro la cancion " + nombre + " en la base de datos.");
                $("#Llegada").append("<p>" + data.confirmacion + "</p><br>");
            },
            error: function () {
                alert("Error");
            }
        });
    });
});

