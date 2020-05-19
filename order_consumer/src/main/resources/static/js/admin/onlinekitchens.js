$(function () {

})

function page(op) {
    var $totalPage = parseInt($("span[name=totalPage]").html());
    var $pageIndex = parseInt($("span[name=pageIndex]").html());
    var index;
    switch (op) {
        case "prev":
            if ($pageIndex == 1) {
                index = 1;
            } else {
                index = $pageIndex - 1;
            }
            break;
        case "next":
            if ($pageIndex == $totalPage) {
                index = $totalPage;
            } else {
                index = $pageIndex + 1;
            }
            break;
        case "first":
            index = 1;
            break;
        case "end":
            index = $totalPage;
            break;
    }
    ajax(index);
}

function ajax(pageIndex) {
    $.ajax({
        type:"POST",
        url:"/searchOnlinePeople/"+pageIndex+"/1",
        dataType:"json",
        success:function(data){
            data=eval(data);
            var online= data[0];
            var totalOnline= data[1];
            var onlineKitchen= data[2];
            var totalPage=data[3];
        },
        error:function(){
            alert("系统错误!");
        },
    });
}