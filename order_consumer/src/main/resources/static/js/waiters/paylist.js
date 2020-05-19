var pageIndex=1;
var maxPage=1;
var index;

$(function () {
    page("first");
})



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

function changeByCondition(bt,et,pageIndex) {
    $.ajax({
        type:"POST",
        url:"/selectOrdeyBytime/"+bt+"/"+et+"/"+pageIndex+"/"+0,
        dataType:"json",
        success:function (data) {
            data=eval(data);
            pageIndex=data[3];
            maxPage=data[2];
            $("span[name=totalPage]").html(data[2]);
            var totalPrice = null;
            $("#orderTable").html("");
            var str="";
            for(var i=0;i<data[0].length;i++){
                var dishes=data[0][i];
                var dishes1=data[1][i];
                for(var j=0;j<data[1].length;j++){
                    totalPrice+=data[1][j].num*data[1][j].dishesinfo.dishesprice;
                }
                str+="<tr>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<td>"+dishes.tables.tableid+"</td>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<td>"+dishes.userinfo.useraccount+"</td>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<td>"+dishes.orderbegindate+"</td>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<td>"+totalPrice+"</td>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<td><a class='btn btn-danger' onclick='account("+dishes.orderid+")' style='width:150px'>买单</a></td>\n" +
                    "\t\t\t\t\t\t\t\t\t</tr>";
                totalprice=0;
            }
            $("#orderTable").append(str);
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