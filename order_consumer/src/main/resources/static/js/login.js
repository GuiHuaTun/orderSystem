function imagers(){
    $.ajax({
        type:"GET",
        url:"validateColorServlet",
        success:function(data){
            $("#code2").attr("src",$("#code2").attr("src"));
        }
    });
}
$(function(){
    $("#code2").on("click",function(){
        imagers();
    });
    $("#login").on("click",function(){
        var useraccount=$("input[name=userName]").val();
        var userpass=$("input[name=passWord]").val();
        var codetext=$("input[name=code]").val();
        if(useraccount==""){
            alert("账号不能为空!");
        }else if(userpass==""){
            alert("密码不能为空");
        }else if(codetext==""){
            alert("验证码不能为空");
        }else{
            $.ajax({
                type:"POST",
                url:"loginUser/"+useraccount+"/"+userpass+"/"+codetext,
                dataType:"json",
                success: function(data){
                    debugger;
                    data=eval(data);
                    if(data=="1"){
                        alert("验证码错误!");
                        imagers();
                        $("input[name=codetext]").val("");
                    }
                    if(data=="2"){
                        /*alert("管理员修改密码");*/
                        location.href="jsp/initpassword.jsp";
                    }
                    if(data=="3"){
                        /*alert("管理员");*/
                        location.href="jsp/adminframe.jsp";
                    }
                    if(data=="4"){
                        /*alert("用户");*/
                        location.href="jsp/adminframe.jsp";
                    }
                    if(data==false){
                        alert("账号或密码错误!");
                        imagers();
                        $("input[name=useraccount]").val("");
                        $("input[name=userpass]").val("");
                        $("input[name=codetext]").val("");
                    }
                },
                error:function(data){
                    debugger;
                    alert(data.toString());
                }
            });
        }
    });
});