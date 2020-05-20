var index;
$(function () {
    page2();

    page("first");
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


function modal(tableid, orderbegintime, orderendtime, sumprice, useraccount, pIndex2, orderid, totalprice) {
    var tableId = document.getElementById("tableId");
    var orderBeginTime = document.getElementById("orderBeginTime");
    var orderEndTime = document.getElementById("orderEndTime");
    var sumPrice = document.getElementById("sumPrice");
    var userAccount = document.getElementById("userAccount");
    var sumPrice = document.getElementById("sumPrice");
    $("#tableId").html(tableid);
    $("#orderBeginTime").html(orderbegintime);
    $("#orderEndTime").html(orderendtime);
    $("#sumPrice").html(sumprice);
    $("#userAccount").html(useraccount);
    $("#sumPrice").html(totalprice + ".00");

    $.ajax({
        type: "POST",
        url: "/orderDishesFindById?orderid=" + orderid,
        dataType: "json",
        success: function (data) {
            data = eval(data);
            $("#detailTable").html("");
            var str = "";
            for (var i = 0; i < data[0].length; i++) {
                var dishes = data[0][i];
                str += "<tr>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<th>" + dishes.dishesinfo.dishesname + "</th>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<th>" + dishes.dishesinfo.dishesprice + ".00</th>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<th>" + dishes.num + "</th>\n" +
                    "\t\t\t\t\t\t\t\t\t</tr>";

            }
            $("#detailTable").append(str);
            $('#myModal').modal('show');
        }
    })

}


function page(op) {
    var $totalPage = parseInt($("span[name=totalPage]").html());
    var $pageIndex = parseInt($("span[name=pageIndex]").html());
    switch (op) {
        case "prev":
            if ($pageIndex == 1) {
                index = 1;
            } else {
                index = $pageIndex - 1;
            }
            break;
        case "next":
            if ($pageIndex == $totalPage) {
                index = $totalPage;
            } else {
                index = $pageIndex + 1;
            }
            break;
        case "first":
            index = 1;
            break;
        case "end":
            index = $totalPage;
            break;
    }
    changeByCondition(null, null, index);
}


function changeByCondition(bt, et, pageIndex) {
    $("#orderTable").html("");
    $.ajax({
        type: "POST",
        url: "/selectOrdeyBytime/" + bt + "/" + et + "/" + pageIndex + "/" + 0,
        dataType: "json",
        success: function (data) {
            data = eval(data);
            var orderinfo = data[0];
            var orderdishes = data[1];
            $("span[name=totalPage]").html(data[2]);
            var totalPrice = null;
            var tr = "";
            for (var i = 0; i < orderinfo.length; i++) {
                for (var j = 0; j < orderdishes.length; j++) {
                    if (orderdishes[j].orderinfo.orderid == orderinfo[i].orderid) {
                        totalPrice += orderdishes[j].num * parseInt(orderdishes[j].dishesinfo.dishesprice);
                    }
                }
                if(orderinfo[i].orderenddate==null || orderinfo[i].orderenddate==""){
                    orderinfo[i].orderenddate="未结账";
                }
                tr += "<tr>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<td>" + orderinfo[i].tables.tableid + "</td>" +
                    "\t\t\t\t\t\t\t\t\t\t<td>" + orderinfo[i].orderbegindate + "</td>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<td>" + orderinfo[i].orderenddate + "</td>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<td>" + totalPrice + ".0</td>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<td><i style=\"cursor: pointer; font-size: 14px;\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tonmouseover=\"this.style.color='orange'\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tonmouseout=\"this.style.color='black'\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tclass=\"icon-credit-card icon-large\" onclick='account("+orderinfo[i].orderid+")' title=\"确认结账\"></i>&nbsp;&nbsp;<i\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tstyle=\"cursor: pointer; font-size: 14px;\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tonmouseover=\"this.style.color='orange'\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tonmouseout=\"this.style.color='black'\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tclass=\"icon-sitemap icon-large\" title=\"查看订单详情\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tonclick=\"modal('" + orderinfo[i].tables.tableid + "','" + orderinfo[i].orderbegindate + "','" + orderinfo[i].orderenddate + "','100.00','" + orderinfo[i].userinfo.useraccount + "','" + 1 + "','" + orderinfo[i].orderid + "','" + totalPrice + "')\"></i><input type='hidden' id='hidden' name='hidden'> &nbsp;&nbsp;<i\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tstyle=\"cursor: pointer; font-size: 14px;\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tonmouseover=\"this.style.color='orange'\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tonmouseout=\"this.style.color='black'\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tclass=\" icon-remove-sign icon-large\"  title=\"订单作废\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tonclick=\"deleteorder("+orderinfo[i].orderid+")\"></i></td>\n" +
                    "\t\t\t\t\t\t\t\t\t</tr>";
                totalPrice = 0;
            }
            $("#orderTable").append(tr);
            $("span[name=pageIndex]").html(pageIndex);
        },
        error: function () {
            alert("系统错误!");
        },
    });
}

function account(id) {
    var msg = "确定要结账吗？";
    if (confirm(msg) == true) {
        $.ajax({
            type: "POST",
            url: "/oderAccount/" + id,
            dataType: "json",
            success: function (data) {
                alert("结账成功");
                changeByCondition(null, null, index);
                return true;
            },error:function () {
                alert("结账失败");
            }
        })
    }else{
        return false;
    }
}

function deleteorder(orderid) {
    var msg = "确定要作废该订单吗？";
    if (confirm(msg) == true) {
        $.ajax({
            type: "POST",
            url: "/deleteOrder/" + orderid,
            dataType: "json",
            success: function (data) {
                alert("订单已作废");
                changeByCondition(null, null, index);
            },error:function () {
                alert("操作失败");
            }
        })
    }else{
        return false;
    }
}