
$(document).ready(function () {

    $("#enviar").click(function () {
        var ID = $("#ID").val();
        var titulo = $("#titulo").val();
        var interprete = $("#interprete").val();
        var canciones = $("#canciones").val();
        alert("Entro JS");
        $.ajax({
            url: '../Servlet_Registrar_Album',
            type: 'GET',
            data: {ID: ID, titulo: titulo, interprete: interprete, canciones: canciones},
            dataType: 'json',
            success: function (data) {
                console.log("DATOS CORRECTOS: " + data.confirmacion);
                alert("Se registro el album " + titulo + " en la base de datos.");
                $("#Llegada").append("<p>" + data.confirmacion + "</p><br>");
            },
            error: function () {
                alert("Error");
            }
        });
    });
});