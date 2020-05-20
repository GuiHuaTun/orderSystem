var pageIndex = 1;
var id = 1;
$(function () {
    page("first");
    $.ajax({
        type:"POST",
        url:"/selectCharts",
        dataType:"json",
        success:function(data){
            data=eval(data);
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById("main"));
            for (var i=0;i<data.length;i++){
                var obj=data[i];
                data[i][1]= obj[1].split(" ")[0];
            }
            // 指定图表的配置项和数据
            var option = {
                title: {
                    text: '七天经验数据统计'
                },
                tooltip: {},
                legend: {
                    data:['金额']
                },
                xAxis: {
                    data: [data[6][1],data[5][1], data[4][1], data[3][1], data[2][1], data[1][1], data[0][1]]
                },
                yAxis: {},
                series: [{
                    name: '日期',
                    type: 'line',
                    data: [data[6][0],data[5][0], data[4][0], data[3][0], data[2][0], data[1][0], data[0][0]]
                }]
            };
            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        },
        error:function(){
            alert("系统错误!");
        },
    });



})

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
                    "<th>" + dishes.dishesinfo.dishesname + "</th>\n" +
                    "<th>" + dishes.dishesinfo.dishesprice + ".00</th>\n" +
                    "<th>" + dishes.num + "</th>\n" +
                    "</tr>";
            }
            $("#detailTable").append(str);
            $('#myModal').modal('show');
        }
    })
}

//根据时间查经营数据
function search() {
    var bt = $("#bt").val();
    var et = $("#et").val();
    if (bt == null || bt == "") {
        bt = null;
    }
    if (et == null || et == "") {
        et = null;
    }
    $("#orderTable").html("");
    $.ajax({
        type: "POST",
        url: "/selectOrdeyBytime/" + bt + "/" + et + "/" + 1 + "/" + 2,
        dataType: "json",
        success: function (data) {
            changeByCondition(bt, et, 1);
        },
        error: function () {
            alert("系统错误!");
        },
    });
}

function page(op) {
    var $totalPage = parseInt($("span[name=totalPage]").html());
    var $pageIndex = parseInt($("span[name=pageIndex]").html());
    var bt = $("#bt").val();
    var et = $("#et").val();
    var index;
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
    if (bt == null || bt == "") {
        bt = null;
    }
    if (et == null || et == "") {
        et = null;
    }
    changeByCondition(bt, et, index);
}

function changeByCondition(bt, et, pageIndex) {
    $("#orderTable").html("");
    $.ajax({
        type: "POST",
        url: "/selectOrdeyBytime/" + bt + "/" + et + "/" + pageIndex + "/" + 1,
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
                tr += "<tr>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<td>" + orderinfo[i].tables.tableid + "</td>" +
                    "\t\t\t\t\t\t\t\t\t\t<td>" + orderinfo[i].orderenddate + "</td>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<td>" + orderinfo[i].userinfo.useraccount + "</td>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<td>" + totalPrice + ".0</td>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<td><i\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tstyle=\"cursor: pointer; font-size: 14px;\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tonmouseover=\"this.style.color='orange'\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tonmouseout=\"this.style.color='black'\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tclass=\"icon-sitemap icon-large\" title=\"查看订单详情\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tonclick=\"modal('" + orderinfo[i].tables.tableid + "','" + orderinfo[i].orderbegindate + "','" + orderinfo[i].orderenddate + "','100.00','" + orderinfo[i].userinfo.useraccount + "','" + 1 + "','" + orderinfo[i].orderid + "','" + totalPrice + "')\"></i><input type='hidden' id='hidden' name='hidden'> &nbsp;&nbsp;<i\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tstyle=\"cursor: pointer; font-size: 14px;\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tonmouseover=\"this.style.color='orange'\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tonmouseout=\"this.style.color='black'\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tclass=\" icon-remove-sign icon-large\" title=\"订单作废\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\tonclick=\"cancel(this)\"></i></td>\n" +
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
