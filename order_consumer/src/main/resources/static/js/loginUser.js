function imagers() {
    $.ajax({
        type: "GET",
        url: "validateColorServlet",
        success: function (data) {
            $("#code2").attr("src", $("#code2").attr("src"));
        }
    });
}
function clean(){
    $("input[name=userpass]").val("");
    $("input[name=codetext]").val("");
}
$(function () {
    $("#code2").on("click", function () {
        imagers();
    });
    $("#login").on("click", function () {
        var useraccount = $("input[name=useraccount]").val();
        var userpass = $("input[name=userpass]").val();
        var codetext = $("input[name=codetext]").val();
        if (useraccount == "" && useraccount != null) {
            alert("账号不能为空!");
        } else if (userpass == "" && useraccount != null) {
            alert("密码不能为空");
        } else if (codetext == "" && useraccount != null) {
            alert("验证码不能为空");
        } else {
            $.ajax({
                type: "POST",
                url: "loginUser/" + useraccount + "/" + userpass + "/" + codetext,
                dataType: "json",
                success: function (data) {
                    var role = data[0].toString();
                    var userid=data[1];
                    switch (role) {
                        case "codeError":
                            alert("验证码错误!");
                            imagers();
                            $("input[name=codetext]").val("");
                            break;
                        case "admin":
                            clean();
                            location.href="/pages/page/admin.html?userid="+userid;
                            break;
                        case "chef":
                            clean();
                            location.href="/pages/page/kitchen.html?userid="+userid;
                            break;
                        case "waiter":
                            clean();
                            location.href="/pages/page/waiterpage.html?userid="+userid;
                            break;
                        case "false":
                            alert("账号或密码错误!");
                            imagers();
                            clean();
                            break;
                        case "lock":
                            alert("该账号已登录!");
                            imagers();
                            clean();
                            break;
                    }
                },
                error: function () {
                    alert("错误");
                }
            });
        }
    });
});