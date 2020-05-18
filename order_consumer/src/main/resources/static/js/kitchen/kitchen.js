var kitchenname = null;
var kitchenImgFace = null;
var kitchenImgFace1 = null;
var modifyuser = null;
var loginOut=null;
$(function () {
    kitchenname = $("#kitchenname");
    kitchenImgFace = $("#kitchenImgFace");
    kitchenImgFace1 = $("#kitchenImgFace1");
    modifyuser = $("#modifyuser");
    loginOut=$("#loginOut");
    var kichenid = location.search.split("=")[1];


    $.ajax({
        type: "POST",
        url: "/selectUserInfo/" + kichenid,
        dataType: "json",
        success: function (data) {
            data = eval(data);
            kitchenname.html(data.useraccount);
            kitchenImgFace.attr("src", data.faceimg);
            kitchenImgFace1.attr("src", data.faceimg);
            loginOut.attr("href", "/loginout/" + data.userid+"/"+1);
            modifyuser.attr("href", "/pages/users/modifyuser.html?userid=" + data.userid + "=" + kichenid);
        },
        error: function () {
            alert("系统错误!");
        },
    });
})