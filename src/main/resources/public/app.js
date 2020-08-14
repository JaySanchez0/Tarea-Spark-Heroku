var app = (function(){
    var number = [];
    function drawData(){
        $("#set").html("");
        for(n of number){
            var data = $("<div style='width:100%; height:20px; border-bottom:1px solid black; background:MediumSeaGreen;'>"+n+"</div>");
            $("#set").append(data);
        }
    }

    function showResult(data){
        $("#av").text(data.average);
        $("#dt").text(data.deviation);
    }
    return{
        addElement:function(){
            var elm = $("#element").val();
            number.push(elm);
            drawData();
        },
        calcular:function(){
            client.calcular(number,(data)=>showResult(data));
        },limpiar:function(){
            number = [];
            drawData();
            $("#av").text("");
            $("#dt").text("");
        }
    }

})();