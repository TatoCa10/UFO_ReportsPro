
$(document).ready(function () {

    $("#enviar").click(function () {
        var ID = $("#ID").val();
        var titulo = $("#titulo").val();
        var interprete = $("#interprete").val();
        var interprete_2 = $("#interprete_2").val();
        var interprete_3 = $("#interprete_3").val();
        var interprete_4 = $("#interprete_4").val();
        
        alert("Entro JS");
        $.ajax({
            url: '../Servlet_Registrar_Album',
            type: 'GET',
            data: {ID: ID, titulo: titulo, interprete: interprete, interprete_2: interprete_2, interprete_3: interprete_3, interprete_4: interprete_4},
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