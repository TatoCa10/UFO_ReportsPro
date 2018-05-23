
$(document).ready(function () {

    $("#enviar").click(function () {
        var nombre = $("#nombre").val();
        var edad = $("#edad").val();
        var genero = $("#genero").val();
        var idioma = $("#idioma").val();
        alert("Entro JS");
        $.ajax({
            url: '../Servlet_Registrar_Artista',
            type: 'GET',
            data: {nombre: nombre, edad: edad, genero: genero, idioma: idioma},
            dataType: 'json',
            success: function (data) {
                console.log("DATOS CORRECTOS: " + data.confirmacion);
                alert("Se registro el artista " + nombre + " en la base de datos.");
                $("#Llegada").append("<p>" + data.confirmacion + "</p><br>");
            },
            error: function () {
                alert("Error");
            }
        });
    });
});