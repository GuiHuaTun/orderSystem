var pageIndex=1;
var maxPage=1;
$(function () {
   page2();
    page(1);
})


function page2() {
    $.ajax({
        type: "POST",
        url: "/selectDishesByRec?pageIndex=1",
        datatype: "json",
        success: function (data) {
            data = eval(data);
            $("#byrecommend").html("");
            var str = "";
            var str1 = "<nav>\n" +
                "\t\t\t\t\t\t\t<ul class=\"pager\" style=\"margin-right: 20px\">\n" +
                "\n" +
                "\t\t\t\t\t\t\t\t<li class=\"next\"><a href=\"todishesadmin.order\">更多特色菜品 <span\n" +
                "\t\t\t\t\t\t\t\t\t\taria-hidden=\"true\">&rarr;</span></a></li>\n" +
                "\t\t\t\t\t\t\t</ul>\n" +
                "\t\t\t\t\t\t\t</nav>";
            for (var i = 0; i < 4; i++) {
                var dishes = data[0][i];
                str += "<div id=\"byrecommend\" class=\"row placeholders\">\n" +
                    "\n" +
                    "\t\t\t\t\t\t\t<div class=\"col-xs-6 col-sm-3 placeholder\">\n" +
                    "\t\t\t\t\t\t\t\t<a href=\"#\"> <img class=\"img-thumbnail\"\n" +
                    "\t\t\t\t\t\t\t\t\tstyle=\"border-radius:20px\" alt=\"Generic placeholder thumbnail\"\n" +
                    "\t\t\t\t\t\t\t\t\tsrc=\"/img/dishes/1.jpg\"></a>\n" +
                    "\t\t\t\t\t\t\t\t<h4>" + dishes.dishesname + "</h4>\n" +
                    "\t\t\t\t\t\t\t\t<span class=\"text-muted\">" + dishes.dishesdiscript + "</span>\n" +
                    "\t\t\t\t\t\t</div>";
            }
            $("#byrecommend").append(str);
            $("#byrecommend").append(str1);
        }

    })
}

var pageIndex=1;
var maxPage=1;
var id=1;

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

function page(pIndex1){
    var totalprice=0;
    $.ajax({
        type:"POST",
        url:"/orderInfoFindAll?pageIndex="+pIndex1,
        dataType:"json",
        success:function(data) {
            data=eval(data);
            pageIndex=data[3];
            maxPage=data[2];
            $("#orderTable").html("");
            var str="";
            for(var i=0;i<data[0].length;i++){
                var dishes=data[0][i];
                var dishes1=data[1][i];
                var orderenddate="";
                for (var j=0;j<data[1].length;j++){
                    if(data[1][j].orderinfo.orderid==dishes.orderid){
                        totalprice+=data[1][j].num*data[1][j].dishesinfo.dishesprice;
                        if(dishes.orderenddate!=null && dishes.orderenddate!=""){
                            orderenddate=dishes.orderenddate;
                        }else{
                            orderenddate="未结账";
                        }
                    }
                }
                str+="<tr>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<td>"+dishes.tables.tableid+"</td>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<td>"+dishes.orderbegindate+"</td>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<td>"+orderenddate+"</td>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<td>"+totalprice+".0</td>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<td><i style=\"cursor: pointer; font-size: 14px;\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tonmouseover=\"this.style.color='orange'\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tonmouseout=\"this.style.color='black'\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tclass=\"icon-credit-card icon-large\" title=\"确认结账\"></i>&nbsp;&nbsp;<i\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tstyle=\"cursor: pointer; font-size: 14px;\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tonmouseover=\"this.style.color='orange'\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tonmouseout=\"this.style.color='black'\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tclass=\"icon-sitemap icon-large\" title=\"查看订单详情\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tonclick=\"modal('"+dishes.tables.tableid+"','"+dishes.orderbegindate+"','"+dishes.orderenddate+"','100.00','"+dishes.userinfo.useraccount+"','"+pIndex1+"','"+dishes.orderid+"','"+totalprice+"')\"></i> &nbsp;&nbsp;<i\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tstyle=\"cursor: pointer; font-size: 14px;\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tonmouseover=\"this.style.color='orange'\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tonmouseout=\"this.style.color='black'\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tclass=\" icon-remove-sign icon-large\" title=\"订单作废\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tonclick=\"cancel(this)\"></i></td>\n" +
                    "\t\t\t\t\t\t\t\t\t</tr>";
                totalprice=0;
            }
            $("#orderTable").append(str);
        }
    })
}

function modal(tableid,orderbegintime,orderendtime,sumprice,useraccount,pIndex2,orderid,totalprice) {
    var tableId = document.getElementById("tableId");
    var orderBeginTime = document.getElementById("orderBeginTime");
    var orderEndTime = document.getElementById("orderEndTime");
    var sumPrice = document.getElementById("sumPrice");
    var userAccount = document.getElementById("userAccount");
    var sumPrice=document.getElementById("sumPrice");
    $("#tableId").html(tableid);
    $("#orderBeginTime").html(orderbegintime);
    $("#orderEndTime").html(orderendtime);
    $("#sumPrice").html(sumprice);
    $("#userAccount").html(useraccount);
    $("#sumPrice").html(totalprice+".00");

    $.ajax({
        type:"POST",
        url:"/orderDishesFindById?orderid="+orderid,
        dataType:"json",
        success:function(data) {
            data=eval(data);
            $("#detailTable").html("");
            var str="";
            for(var i=0;i<data[0].length;i++){
                var dishes=data[0][i];
                str+="<tr>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<th>"+dishes.dishesinfo.dishesname+"</th>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<th>"+dishes.dishesinfo.dishesprice+".00</th>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<th>"+dishes.num+"</th>\n" +
                    "\t\t\t\t\t\t\t\t\t</tr>";

            }
            $("#detailTable").append(str);
            $('#myModal').modal('show');
        }
    })

}
