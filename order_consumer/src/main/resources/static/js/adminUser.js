
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
                empty += "<tr><td class='textcetern'>" + users.userid + "</td><td class='textcetern'>" + users.useraccount + "</td><td class='textcetern'>" + users.roleinfo.rolename + "</td><td class='textcetern'><i  onclick='detail()' class='iconfont green'>&#xe63e;</i><i class='iconfont orange'>&#xe60f;</i><i class='iconfont red'>&#xe608;</i></td></tr>";
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
