$(function () {
    $.ajax({
        type:"GET",
        url:"/userinfomation",
        dataType:"json",
        success:function(data){
            data=eval(data);
            $("#firstname").attr("placeholder",data.useraccount);
            $("#userOldPassWord").val(data.userpass);
            $("option[name=userRoleID]").html(data.roleinfo.rolename)
        },
        error:function(){
            alert("系统错误!");
        }
    });
})