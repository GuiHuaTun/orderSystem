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
    var totalprice=0;
    $.ajax({
        type:"POST",
        url:"/orderInfoFindAll?pageIndex="+pIndex,
        dataType:"json",
        success:function (data) {
            data=eval(data);
            pageIndex=data[3];
            maxPage=data[2];
            $("#orderTable").html("");
            var str="";
            for(var i=0;i<data[0].length;i++){
                var dishes=data[0][i];
                var dishes1=data[1][i];
                var orderenddate="";
                for(var j=0;j<data[1].length;j++){
                    totalprice+=data[1][j].num*data[1][j].dishesinfo.dishesprice;
                }
                str+="<tr>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<td></td>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<td></td>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<td></td>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<td></td>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<td><a class='btn btn-danger' style='width:150px'>买单</a></td>\n" +
                    "\t\t\t\t\t\t\t\t\t</tr>";
                totalprice=0;
            }
            $("#orderTable").append(str);
        }
    })
}