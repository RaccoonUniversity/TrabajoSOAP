$(function () {
    $("#frmCliente").bind("submit", function () {
        return Create();
    });

    function Create() {
        $.ajax({
            url: 'cliente.do',
            type: 'POST',
            data: {
                nombreAsignatura: $("#txtNombreAsignatura").val()
            },
            success: function (responseText) {

            }
        });
    }
    
    List();
    function List() {
        $.ajax({
        url:'cliente.do',
                data:{},
                type:'GET',
                dataType:'json',
                success:function(respJson){
                $("#tblList").html("");
                        $("#tblList").html(
                        "<thead>" +
                        "<tr>" +
                        "<th>Id</th>" +
                        "<th>Nombre</th>" +
                        "</tr>" +
                        "</thead>" +
                        "<tbody>"+
                        "</tbody>"
                        );
                        for (var i in respJson){
                        var Asignatura = respJson[i];
                        $("#tblList tbody").append(
                        "<tr>" +
                        "<td>" + Asignatura.idAsignatura + "</td>" +
                        "<td>" + Asignatura.nombreAsignatura + "</td>" +
                        "</tr>"
                        );
                }
                }

        }
        );

    }
});
