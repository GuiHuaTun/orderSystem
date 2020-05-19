
var pageIndex=1;
var totalpage;

$(function(){
    page(1);
    var dd = new DropDown( $('#dd') );
    $(document).click(function() {
        // all dropdowns
        $('.wrapper-dropdown-3').removeClass('active');
    });

    $.ajax({
        type : "GET",
        url:"/getAllRole",
        dataType: "json",
        success: function (List) {
            var rolelist = eval(List[0]);
            var allRole="";
            $(".dropdown").html("");
            for(var i=0;i<rolelist.length;i++){
                var roles = rolelist[i];
                allRole+="<li><input class='roleids' style='display: none' value="+roles.roleid+"><a href='#' onclick='bianli($(this))' onchange='change()'>"+roles.rolename+"</a></li>";
            }
            $(".dropdown").append(allRole);
        }
    })

})
function bianli(obj) {
    var x = obj.html();
    $(".xasd").html(x);
   var rid = obj.siblings(".roleids").val();
   $(".initis").attr("value",rid);
    page(1);
}


function prev() {
    if(pageIndex>1){
        pageIndex--;
        page(pageIndex);
    }else{
        alert("这是第一页");
    }
}

function next() {
    if(pageIndex<totalpage){
        pageIndex++;
        page(pageIndex);
    }
    else{
        alert("这是最后一页");
    }
}

function last() {
    pageIndex=totalpage;
    page(pageIndex);
}

function delUser(uid) {
    alert(uid);
    if (confirm("您真的要删除吗？")) {
        $.ajax({
            type: "GET",
            url: "/deleteUser?userid="+uid,
            type: "JSON",
            success: function (flag) {
                if (flag == "true") {
                    alert("删除成功");
                    page(1);
                } else {
                    alert("删除失败");
                }
            }
        })
    }
}


function page(pageIndex) {
    var userName = $(".searchbyname").val();
    var userRole = $(".initis").val();
    if(userName=="" || userName==null){
        userName=null;
    }
    if(userRole=="" || userRole==null){
        userRole=0;
    }
    $.ajax({
        type : "GET",
        url:"/AllUsers/"+pageIndex+"/"+userName+"/"+userRole,
        dataType: "json",
        success: function (List) {
            totalpage = eval(List[0]);
            pageIndex = eval(List[1]);
            var userList = eval(List[2]);
            $("#orderTable").html("");
            $("#pageList").html("");
            var empty = "";
            var pageList = "";
            for (var i = 0; i < userList.length; i++) {
                var users = userList[i];
                empty += "<tr><td class='textcetern'>" + users.userid + "</td><td class='textcetern'>" + users.useraccount + "</td><td class='textcetern'>" + users.roleinfo.rolename + "</td><td class='textcetern'><i  class=\"iconfont green\" onclick=detail('"+users.useraccount+"','"+users.roleinfo.rolename+"','"+users.faceimg+"')>&#xe63e;</i><a class='iconfont orange' href='/pages/admin/modifyuser.html?uid='+users.userid>&#xe60f;</a><i class=\"iconfont red\" onclick='delUser("+users.userid+")'>&#xe608;</i></td></tr>";
            }
            for(var i = 1;i<=totalpage;i++){
                pageList += "<li><a href='#' onclick='page("+i+")' id='yema'>"+i+"</a></li>";
            }
            $("#orderTable").append(empty);
            $("#pageList").append(pageList);
        },
        error:function () {
            alert("333");
        }
    })
}
