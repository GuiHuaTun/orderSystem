var userOldPass = null;
var facesSrc = null;
var userOldPassWord = null;
var userPass = null;
var userPass1 = null;
var addbtu = null;
var form = null;
var userid = null;
var imgform = null;
$(function () {
    userOldPass = $("#userOldPass");
    facesSrc = $("#facesSrc");
    userOldPassWord = $("#userOldPassWord");
    userPass = $("#userPass");
    userPass1 = $("#userPass1");
    addbtu = $("#addbtu");
    form = $("#form");
    userid = $("#userid");
    imgform = $("#imgform");

    var userinfoid = location.search.split("=")[1];
    $.ajax({
        type: "POST",
        url: "/selectUserInfo/" + userinfoid,
        dataType: "json",
        success: function (data) {
            data = eval(data);
            $("#firstname").attr("placeholder", data.useraccount);
            userOldPassWord.val(data.userpass);
            $("option[name=userRoleID]").html(data.roleinfo.rolename);
            $("#face").attr("src", "/img/faces/" + data.faceimg);
            userid.val(data.userid);
            $("[name=userid]").val(data.userid);
            facesSrc.val(data.faceimg);
        },
        error: function () {
            alert("系统错误!");
        }
    });

    //判断旧密码是否正确
    userOldPass.on("input", function () {
        if (userOldPass.val() == userOldPassWord.val()) {
            flag(userOldPass, true);
        } else {
            flag(userOldPass, false);
        }
    });
    //判断密码是否符合格式
    userPass.on("input", function () {
        var reg = /^[a-zA-Z]\w{5,17}$/;
        if (reg.test(userPass.val())) {
            flag(userPass, true);
        } else {
            flag(userPass, false);
        }
    });
    userPass1.on("input", function () {
        if (userPass.val() == userPass1.val() && userPass1.val() != "") {
            flag(userPass1, true);
        } else {
            flag(userPass1, false);
        }
    })

    addbtu.on("click", function () {
        if (userOldPass.attr("flag") != "true") {
            userOldPass.focus();
        } else if (userPass.attr("flag") != "true") {
            userPass.focus();
        } else if (userPass1.attr("flag") != "true") {
            userPass1.focus();
        } else {
            if (confirm("是否修改密码")) {
                $.ajax({
                    type: "POST",
                    url: "/modifyuser",
                    data: form.serialize(),
                    dataType: "json",
                    success: function (data) {
                        data = eval(data);
                        if (data) {
                            alert("密码修改成功");
                            window.location.reload();
                        } else {
                            alert("密码修改失败");
                        }
                    },
                    error: function () {
                        alert("系统错误!");
                    },
                });
            }
        }
    })
    $("#inputfile").change(function () {
        if ($.browser) {
            $("#face").attr("src", $(this).val())
            //$("#info").text("当前选择的文件:"+$(this).val())
        } else {
            //$("#info").text("当前选择的文件:"+$(this).val())
            var objUrl = getObjectURL(this.files[0]);
            console.log("objUrl=" + objUrl);
            if (objUrl) {
                $("#face").attr("src", objUrl);
            }
        }
        facesSrc.val($("#inputfile").val());

    })

    $("#uptfaces").click(function () {
        var formData = new FormData();
        formData.append("uploadFile", $("#inputfile")[0].files[0]);
        formData.append("userid", $("[name=userid]").val());
        $.ajax({
            type: "POST",
            url: "/userModifyImg",
            data: formData,
            dataType: "json",
            processData: false,// 告诉jQuery不要去处理发送的数据
            contentType: false,// 告诉jQuery不要去设置Content-Type请求头
            success: function (data) {
                alert("修改头像成功");
            },
            error: function () {
                alert("修改头像失败!");
            },
        });
    });

    //建立一個可存取到該file的url
    function getObjectURL(file) {
        var url = null;
        if (window.createObjectURL != undefined) {
            url = window.createObjectURL(file);
        } else if (window.URL != undefined) {
            url = window.URL.createObjectURL(file);
        } else if (window.webkitURL != undefined) {
            url = window.webkitURL.createObjectURL(file);
        }
        return url;
    }

    /* $("#uptfaces").on("click",function () {
        if ($("#inputfile").val() == '') {
            return;
        }
        alert(facesSrc.val());
     });*/
})

function flag(obj, boolean) {
    obj.attr("flag", boolean);
    if (boolean == true) {
        obj.addClass("ok").removeClass("no");
    } else {
        obj.addClass("no").removeClass("ok");
    }
}