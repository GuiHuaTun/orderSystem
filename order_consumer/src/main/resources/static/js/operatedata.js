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

function page(pIndex1) {
    $.ajax({
        type:"POST",
        url:"/orderDishesFindAll?pageIndex"+pIndex1,
        dataType:"json",
        success:function (data) {
            data=eval(data);
            pageIndex=data[2];
            maxPage=data[1];
            $("#orderTable").html("");
            var str="";
            for(var i=0;i<data[0].length;i++){
                var dishes=data[0][i];
                str+="<tr>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<td>"+dishes.+"</td>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<td></td>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<td>ipsum</td>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<td>dolor</td>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<td><i style=\"cursor: pointer; font-size: 14px;\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tonmouseover=\"this.style.color='orange'\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tonmouseout=\"this.style.color='black'\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tclass=\"icon-credit-card icon-large\" title=\"确认结账\"></i>&nbsp;&nbsp;<i\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tstyle=\"cursor: pointer; font-size: 14px;\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tonmouseover=\"this.style.color='orange'\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tonmouseout=\"this.style.color='black'\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tclass=\"icon-sitemap icon-large\" title=\"查看订单详情\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tonclick=\"$('#myModal').modal('show')\"></i> &nbsp;&nbsp;<i\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tstyle=\"cursor: pointer; font-size: 14px;\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tonmouseover=\"this.style.color='orange'\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tonmouseout=\"this.style.color='black'\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tclass=\" icon-remove-sign icon-large\" title=\"订单作废\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tonclick=\"cancel(this)\"></i></td>\n" +
                    "\t\t\t\t\t\t\t\t\t</tr>";
            }
        }
    })
}