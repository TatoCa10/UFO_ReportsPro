
$(document).ready(function () {

    $("#enviar").click(function () {
        var name = $("#name").val();
        var ID = $("#ID").val();
        var tipo = 1;

        $.ajax({
            url: '../Servlet_Registrar_Ventas',
            type: 'GET',
            data: {name: name, ID: ID, tipo: tipo},
            dataType: 'json',
            success: function (data) {
                console.log("DATOS CORRECTOS: " + data.confirmacion);
                alert("Se registro la venta para la cancion " + name + " en la base de datos.");
                $("#Llegada").append("<p>" + data.confirmacion + "</p><br>");
            },
            error: function () {
                alert("Error");
            }
        });
    });


    $("#enviar2").click(function () {
        var name = $("#name2").val();
        var ID = $("#ID2").val();
        var ventas = $("#ventas").val();
        var tipo = 2;

        $.ajax({
            url: '../Servlet_Registrar_Ventas',
            type: 'GET',
            data: {name: name, ID: ID, ventas: ventas, tipo: tipo},
            dataType: 'json',
            success: function (data) {
                console.log("DATOS CORRECTOS: " + data.confirmacion);
                alert("Se registraron " + ventas + " ventas para la cancion " + name + " en la base de datos.");
                $("#Llegada").append("<p>" + data.confirmacion + "</p><br>");
            },
            error: function () {
                alert("Error");
            }
        });
    });
});

