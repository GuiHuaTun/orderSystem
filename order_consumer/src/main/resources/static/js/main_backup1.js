var pageIndex=1;
var maxPage=1;
$(function () {
   page2();
})


function page2() {
    $.ajax({
        type:"POST",
        url:"/selectDishesByRec?pageIndex=1",
        datatype:"json",
        success:function (data) {
            data=eval(data);
            $("#byrecommend").html("");
            var str="";
            var str1="<nav>\n" +
                "\t\t\t\t\t\t\t<ul class=\"pager\" style=\"margin-right: 20px\">\n" +
                "\n" +
                "\t\t\t\t\t\t\t\t<li class=\"next\"><a href=\"todishesadmin.order\">更多特色菜品 <span\n" +
                "\t\t\t\t\t\t\t\t\t\taria-hidden=\"true\">&rarr;</span></a></li>\n" +
                "\t\t\t\t\t\t\t</ul>\n" +
                "\t\t\t\t\t\t\t</nav>";
            for (var i=0;i<4;i++){
                var dishes=data[0][i];
                str+="<div id=\"byrecommend\" class=\"row placeholders\">\n" +
                    "\n" +
                    "\t\t\t\t\t\t\t<div class=\"col-xs-6 col-sm-3 placeholder\">\n" +
                    "\t\t\t\t\t\t\t\t<a href=\"#\"> <img class=\"img-thumbnail\"\n" +
                    "\t\t\t\t\t\t\t\t\tstyle=\"border-radius:20px\" alt=\"Generic placeholder thumbnail\"\n" +
                    "\t\t\t\t\t\t\t\t\tsrc=\"/img/dishes/1.jpg\"></a>\n" +
                    "\t\t\t\t\t\t\t\t<h4>"+dishes.dishesname+"</h4>\n" +
                    "\t\t\t\t\t\t\t\t<span class=\"text-muted\">"+dishes.dishesdiscript+"</span>\n" +
                    "\t\t\t\t\t\t</div>";
            }
            $("#byrecommend").append(str);
            $("#byrecommend").append(str1);
        }

    })
}