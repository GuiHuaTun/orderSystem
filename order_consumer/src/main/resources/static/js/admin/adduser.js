var face = null;
var firstname=null;
var userPass=null;
var userPass1=null;
var roleId=null;
var faceimgname=null;
var addbtu=null;
var form=null;
$(function () {
    face = $("#face");
    firstname=$("#firstname");
    userPass=$("#userPass");
    userPass1=$("#userPass1");
    roleId=$("select[name=roleId]");
    faceimgname=$("#faceimgname");
    addbtu=$("#addbtu");
    form=$("#form");



    firstname.on("blur",function () {
        if(firstname.val()!="" && firstname.val()!=null){
            $.ajax({
                type:"POST",
                url:"/selectAccount/"+firstname.val(),
                dataType:"json",
                success:function(data){
                    data= eval(data);
                    if (data) {
                        flag(firstname, true);
                    }else {
                        flag(firstname, false);
                    }
                },
                error:function(){
                    alert("系统错误!");
                },
            });
        }else {
            flag(firstname, false);
        }
    });


    userPass.on("input", function () {
        var reg = /^[a-zA-Z]\w{5,17}$/;
        if (reg.test(userPass.val()) && userPass.val()!="") {
            flag(userPass, true);
        } else {
            flag(userPass, false);
        }
    });

    userPass1.on("input", function () {
        var reg = /^[a-zA-Z]\w{5,17}$/;
        if (reg.test(userPass.val()) && userPass.val()!="") {
            if (userPass.val() == userPass1.val() && userPass1.val() != "") {
                flag(userPass1, true);
            } else {
                flag(userPass1, false);
            }
        } else {
            flag(userPass1, false);
        }
    })

    addbtu.on("click", function () {
        if (firstname.attr("flag") != "true") {
            firstname.focus();
        } else if (userPass.attr("flag") != "true") {
            userPass.focus();
        } else if (userPass1.attr("flag") != "true") {
            userPass1.focus();
        } else {
            if (confirm("是否添加员工")) {
                $.ajax({
                    type: "POST",
                    url: "/insertUser",
                    data: form.serialize(),
                    dataType: "json",
                    success: function (data) {
                        data = eval(data);
                        if (data) {
                            alert("员工添加成功");
                            window.location.reload();
                        } else {
                            alert("员工添加失败");
                        }
                    },
                    error: function () {
                        alert("系统错误!");
                    },
                });
            }
        }
    })

















    //实时显示更改的头像
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
})
function flag(obj, boolean) {
    obj.attr("flag", boolean);
    if (boolean == true) {
        obj.addClass("ok").removeClass("no");
    } else {
        obj.addClass("no").removeClass("ok");
    }
}