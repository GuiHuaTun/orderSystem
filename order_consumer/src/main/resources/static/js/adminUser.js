$(function(){
    var userName = $(".search").html();
    if(userName=="" || userName==null){
        userName="null";
    }

    $.ajax({
        type : "GET",
        url:"/AllUsers/1/2/"+userName,
        dataType: "json",
        success: function (userList) {
            userList=eval(userList);
            $("#orderTable").html("");
            var empty = "";
            for(var i=0;i<userList.length;i++){
                var users = userList[i];
                empty+="<tr><td>"+users.userid+"</td><td>"+users.useraccount+"</td><td>"+users.roleinfo.rolename+"</td></tr>";
            }
            $("#orderTable").append(empty);
        },
        error:function () {
            alert("333");
        }
    })
})