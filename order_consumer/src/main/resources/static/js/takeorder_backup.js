var pageIndex=1;
var maxPage=1;
$(function () {
    page(1);
})

function prev() {
    if(pageIndex>1){
        pageIndex--;
        page(pageIndex);
    }
}

function next() {
    if(pageIndex<maxPage){
        pageIndex++;
        page(pageIndex);
    }
}

function last() {
    pageIndex=maxPage;
    page(pageIndex);
}


function page(pIndex) {
    $.ajax({
        type:"POST",
        url:"/dishesInfoFindAll?pageIndex="+pIndex,
        dataType:"json",
        success: function (data) {
            data=eval(data);
            pageIndex=data[2];
            maxPage=data[1];
            $("#dishesbord").html("");
            var str="";
            for(var i=0;i<data[0].length;i++){
                var dishes=data[0][i];
                str+="<div class=\"col-xs-6 col-sm-3 placeholder\">\n" +
                    "\t\t\t\t\t\t\t\t<a href=\"#\"> <img class=\"img-thumbnail\"\n" +
                    "\t\t\t\t\t\t\t\t\tstyle=\"border-radius:20px\"\n" +
                    "\t\t\t\t\t\t\t\t\tsrc=\"/img/dishes/1.jpg\"></a>\n" +
                    "\t\t\t\t\t\t\t\t<h4>"+dishes.dishesname+"</h4>\n" +
                    "\t\t\t\t\t\t\t\t<span class=\"text-muted\">"+dishes.dishesdiscript+"</span>\n" +
                    "\t\t\t\t\t\t\t\t<div class=\"form-group\">\n" +
                    "\t\t\t\t\t\t\t\t\t<form>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<div style=\"width:120px;margin: 0px auto\">\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t<div class=\"input-group\">\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"input-group-btn\">\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t<button class=\"btn btn-default\" type=\"button\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"subtract(this)\">-</button>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t</span> <input type=\"text\" class=\"form-control\" value=\"1\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\tdisabled=\"disabled\" name=\"num\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"text-align: center;padding: 0px;cursor: text;\"><input\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\ttype=\"hidden\" name=\"dishes\" value=\"6\" /> <span\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"input-group-btn\">\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t<button class=\"btn btn-default\" type=\"button\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"add(this)\">+</button>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<p>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t<input type=\"button\" class=\"btn btn-danger\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"width:120px;margin-top: 5px\" value=\"加入点餐车\"></input>\n" +
                    "\t\t\t\t\t\t\t\t\t\t</p>\n" +
                    "\t\t\t\t\t\t\t\t\t</form>\n" +
                    "\t\t\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t\t</div>";
            }
            $("#dishesbord").append(str);
        }
    })
}