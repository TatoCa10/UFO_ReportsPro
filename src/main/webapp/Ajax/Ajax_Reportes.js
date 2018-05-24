
$(document).ready(function () {

    $("#enviar").click(function () {
        var dia = $("#dia").val();
        var mes = $("#mes").val();
        var year = $("#year").val();
        var album = $("#album").val();
        var id_album = $("#id_album").val();

        ComboIgual = document.getElementById("Combo");
        console.log("Combo Valor:" + ComboIgual.value);
        console.log("Combo: " + ComboIgual);

        $.ajax({
            url: '../Servlet_Reportes',
            type: 'GET',
            data: {dia: dia, mes: mes, year: year, ComboIgual: ComboIgual.value, album:album, id_album:id_album},
            dataType: 'json',
            success: function (data) {
                //console.log("DATOS CORRECTOS: " + data.confirmacion);
                alert("Se genero el reporte " + ComboIgual.value + " en el periodo " + dia + "/" + mes + "/" + year);
                
                for (var i = 0; i < data.Reportes.length; i++) {
                    
                    $("#Llegada").css("display", "block");
                    $("#Tabla").append("<tr><td>" + data.Reportes[i].puesto + "</td><td>" + data.Reportes[i].nombre + "</td><td>" + data.Reportes[i].interprete + "</td><td>" + data.Reportes[i].ventas + "</td><td>" + data.Reportes[i].anterior + "</td><td>" + data.Reportes[i].v_anterior + "</td></tr>");
                    $("#Llegada2").html("(<center><p style='color: #cccccc'>" + data.confirmacion + "</p></center><br>");
                }
            },
            error: function () {
                alert("Error");
            }
        });
    });
});