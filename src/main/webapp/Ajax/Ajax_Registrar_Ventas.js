
$(document).ready(function () {

    $("#enviar").click(function () {
        var name = $("#name").val();
        var ID = $("#ID").val();
        var tipo = 1;
        var ventas= 1;

        $.ajax({
            url: '../Servlet_Registrar_Ventas',
            type: 'GET',
            data: {name: name, ID: ID, tipo: tipo,ventas: ventas},
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


    $("#enviar3").click(function () {
        var name = $("#name3").val();
        var ID = $("#ID3").val();
        var tipo = 3;
        var ventas= 1;

        $.ajax({
            url: '../Servlet_Registrar_Ventas',
            type: 'GET',
            data: {name: name, ID: ID, tipo: tipo, ventas: ventas},
            dataType: 'json',
            success: function (data) {
                console.log("DATOS CORRECTOS: " + data.confirmacion);
                alert("Se registro la venta para el album " + name + " en la base de datos.");
                $("#Llegada").append("<p>" + data.confirmacion + "</p><br>");
            },
            error: function () {
                alert("Error");
            }
        });
    });



    $("#enviar4").click(function () {
        var name = $("#name4").val();
        var ID = $("#ID4").val();
        var ventas = $("#ventas4").val();
        var tipo = 4;

        $.ajax({
            url: '../Servlet_Registrar_Ventas',
            type: 'GET',
            data: {name: name, ID: ID, ventas: ventas, tipo: tipo},
            dataType: 'json',
            success: function (data) {
                console.log("DATOS CORRECTOS: " + data.confirmacion);
                alert("Se registraron " + ventas + " ventas para el album " + name + " en la base de datos.");
                $("#Llegada").append("<p>" + data.confirmacion + "</p><br>");
            },
            error: function () {
                alert("Error");
            }
        });
    });



});

