
$(document).ready(function () {

    $("#enviar").click(function () {
        var dia = $("#dia").val();
        var mes = $("#mes").val();
        var year = $("#year").val();

        ComboIgual = document.getElementById("Combo");
        console.log("Combo Valor:" + ComboIgual.value);
        console.log("Combo: " + ComboIgual);

        $.ajax({
            url: '../Servlet_Reportes',
            type: 'GET',
            data: {dia: dia, mes: mes, year: year, ComboIgual: ComboIgual.value},
            dataType: 'json',
            success: function (data) {
                console.log("DATOS CORRECTOS: " + data.confirmacion);
                alert("Se genero el reporte " + ComboIgual.value + " en el periodo " + dia + "/" + mes + "/" + year);
                $("#Llegada").css("display", "block");
                $("#Tabla").append("<tr><td>"+ data.puesto +"</td><td>" + data.nombre +"</td><td>" + data.interprete +"</td><td>"+ data.ventas +"</td><td>"+ data.anterior +"</td><td>"+ data.anterior + "</td></tr>");
                $("#Llegada2").html("(<center><p style='color: #cccccc'>" + data.confirmacion + "</p></center><br>");
            },
            error: function () {
                alert("Error");
            }
        });
    });
});