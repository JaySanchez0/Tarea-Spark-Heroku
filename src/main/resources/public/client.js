var client = (function(){
    return{
        calcular:function(numbers,show){
            $.post({
                url:"/calcular",
                data:JSON.stringify(numbers),
                contentType:"application/json"
            }).then((data)=>show(JSON.parse(data)),()=>alert("error"));
        }
    }
})();