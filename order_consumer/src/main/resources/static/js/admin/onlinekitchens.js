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
}

function ajax() {
    $.ajax({
        type:"POST",
        url:"",
        data:"",
        dataType:"json",
        success:function(data){
            
        },
        error:function(){
            alert("系统错误!");
        },
    });
}