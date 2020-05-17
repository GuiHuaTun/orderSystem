var loginOut = null;
var adminName = null;
var adminFace = null;
var adminFace1 = null;
$(function () {
    var adminid = location.search.split("=")[1];
    adminName = $("#adminName");
    adminFace = $("#adminFace");
    adminFace1 = $("#adminFace");
    loginOut = $("#loginOut");

    //获取管理员信息
    $.ajax({
        type:"POST",
        url:"/selectUserInfo/" + adminid,
        dataType:"json",
        success: function (data) {
            eval(data);
            adminName.html(data.useraccount);
            adminFace.attr("src", data.faceimg);
            adminFace1.attr("src", data.faceimg);
            loginOut.attr("href", "/loginout/" + data.userid + "/" + 3 + "/" + 2);
        },
        error: function () {
            alert("系统错误!");
        },
    });

    userOnline();

    setInterval("userOnline()","1000");


});

function userOnline() {
    $.ajax({
        type:"POST",
        url:"/getServletContext",
        dataType:"json",
        success:function(data){
            data= eval(data);
            $("#chef").html(data[0]);
            $("#waiter").html(data[1]);
        },
        error:function(){
            alert("系统错误!");
        },
    });
}