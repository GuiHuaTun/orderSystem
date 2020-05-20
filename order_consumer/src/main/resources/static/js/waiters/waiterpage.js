var tableId = null;
var tableresult = null;
var takeorder_backup = null;
var loginOut = null;
$(function () {
    tableId = $("#tableId");
    tableresult = $("#tableresult");
    takeorder_backup = $("#takeorder_backup");
    loginOut = $("#loginOut");
    var userid = location.search.split("=")[1];

    $.ajax({
        type: "POST",
        url: "/selectUserInfo/" + userid,
        dataType: "json",
        success: function (data) {
            data = eval(data);
            if (data.locked == 1) {
                alert("您的账号已被强制下线");
                location.href = "/loginout/" + data.userid + "/" + data.roleinfo.roleid;
            } else {
                $("#username").html(data.useraccount);
                $("#userface").attr("src", data.faceimg);
                $("#userface1").attr("src", data.faceimg);
                loginOut.attr("href", "/loginout/" + data.userid + "/" + data.roleinfo.roleid);
                $("#updatepass").attr("href", "/pages/users/modifyuser.html?userid=" + data.userid + "=" + userid);
            }
        },
        error: function () {
            alert("系统错误!");
        }
    });


    /**
     * 查询桌号
     */
    $.ajax({
        type: "POST",
        url: "/allocationTable",
        dataType: "json",
        success: function (data) {
            data = eval(data[0]);
            if (data != null) {
                tableId.val(data.tableid);
                tableresult.html("【" + data.tablename + "】");
                takeorder_backup.attr("href", "/pages/waiters/takeorder_backup.html?tableid=" + data.tableid + "=" + userid);
            } else {
                alert("已无空桌，请等待");
                tableresult.html("【已无空桌，请等待】");
            }
        },
        error: function () {
            alert("系统错误!");
            tableId.val("");
        }
    });

});

function setTableId() {
    $.ajax({
        type: "POST",
        url: "/setTableId/" + tableId.val(),
        dataType: "json",
        success: function (data) {
            data = eval(data);
            if (data != null) {
                tableId.val(data.tableid);
                tableresult.html("【" + data.tablename + "】");
                if (confirm("是否进入点餐页面")) {
                    top.mainwindow.location.href = "/pages/waiters/takeorder_backup.html?tableid=" + data.tableid;
                } else {
                    takeorder_backup.attr("href", "/pages/waiters/takeorder_backup.html?tableid=" + data.tableid);
                }
            } else {
                alert("该桌已在用餐");
            }
        },
        error: function () {
            alert("请重新设定餐桌!");
            tableId.val("");
        },
    });
}

