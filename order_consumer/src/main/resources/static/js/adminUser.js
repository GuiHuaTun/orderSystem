
var pageIndex=1;
var maxPage=5;

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
                allRole+="<li><a href='#' onclick='bianli($(this))'>"+roles.rolename+"</a></li>";
            }
            $(".dropdown").append(allRole);
        }
    })
    $("#allRole").change(function () {
        page(1);
    })
})
function bianli(obj) {
    alert(obj.html());
    var x = obj.html();
    $(".xasd").html(x);
    alert($(".xasd").html());

}

function prev() {
    if(pageIndex>1){
        pageIndex--;
        page(pageIndex);
    }
}

function next() {
    if(pageIndex<maxPage){
        pageIndex++;
        page(pageIndex);
    }
}

function last() {
    pageIndex=maxPage;
    page(pageIndex);
}

function page(pageIndex) {
    var userName = $(".searchbyname").val();
    var userRole = $("#allRole").val();
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
            var totalpage = eval(List[0]);
            pageIndex = eval(List[1]);
            var userList = eval(List[2]);
            alert(totalpage);
            $("#orderTable").html("");
            $("#pageList").html("");
            var empty = "";
            var pageList = "";
            for (var i = 0; i < userList.length; i++) {
                var users = userList[i];
                empty += "<tr><td class='textcetern'>" + users.userid + "</td><td class='textcetern'>" + users.useraccount + "</td><td class='textcetern'>" + users.roleinfo.rolename + "</td><td class='textcetern'><i class='iconfont green'>&#xe63e;</i><i class='iconfont orange'>&#xe60f;</i><i class='iconfont red'>&#xe608;</i></td></tr>";
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
