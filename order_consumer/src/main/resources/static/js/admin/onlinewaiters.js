var currentIndex = null;
$(function () {
    page("first");
})

function page(op) {
    var $totalPage = parseInt($("span[name=totalPage]").html());
    var $pageIndex = parseInt($("span[name=pageIndex]").html());
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
    currentIndex = index;
    ajax(index);

}

function ajax(pageIndex) {
    $.ajax({
        type: "POST",
        url: "/searchOnlinePeople/" + pageIndex + "/3",
        dataType: "json",
        success: function (data) {
            data = eval(data);
            var online = data[0];
            $("#sessionNum").html(data[1]);
            $("#waiterNum").html(data[2]);
            $("span[name=totalPage]").html(data[3]);
            $("#orderTable").html("");
            var empty = "";
            for (var i = 0; i < online.length; i++) {
                var users = online[i];
                empty += "<tr><td class='textcetern'>" + users.userid + "</td><td class='textcetern'>" + users.useraccount + "</td><td class='textcetern'>" + users.roleinfo.rolename + "</td><td class='textcetern'><i  class=\"iconfont green\" onclick=detail('" + users.useraccount + "','" + users.roleinfo.rolename + "','" + users.faceimg + "')>&#xe63e;</i><i class=\"iconfont red\" onclick='unOnline($(this))'>&#xe608;</i></td></tr>";
            }
            $("#orderTable").append(empty);
        },
        error: function () {
            alert("系统错误!");
        },
    });
}

function unOnline(obj) {
    if (confirm("是否将该员工强行下线?")) {
        var userid = obj.parent().siblings("td:eq(0)").html();
        $.ajax({
            type: "POST",
            url: "/modifyuser",
            data: "userid=" + userid + "&locked=" + 1,
            dataType: "json",
            success: function (data) {
                data = eval(data);
                if (data == true) {
                    obj.parent().parent().remove();
                    alert("强制离线成功！");
                    ajax(currentIndex);
                }
            },
            error: function () {
                alert("系统错误!");
            },
        });
    }
}