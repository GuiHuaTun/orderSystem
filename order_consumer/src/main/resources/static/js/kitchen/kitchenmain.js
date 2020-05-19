var pageIndex=1;
var maxPage=1;
$(function () {
    page(1);
});

function page(pIndex) {
    $.ajax({
        type:"POST",
        url:"/selectByStatus",
        data:"pageIndex="+pIndex,
        dataType:"json",
        success:function (data) {
            pageIndex=data[1];
            maxPage=data[2];
            var orderdishes=data[0];
            $("#orderTable").html("");
            var tr="";
            for(var i=0;i<orderdishes.length;i++){
                var orderdish=orderdishes[i];
                tr+="<tr><td>"+orderdish.orderinfo.tables.tableid+"</td><td>"+orderdish.dishesinfo.dishesname+"</td><td>"+orderdish.num+"</td><td><a href='#'>上菜</a></td></tr>";
            }
            $("#orderTable").append(tr);
        },
        error:function () {
            alert("连接失败！");
        }
    });
}

function prev() {
    pageIndex==1?1:pageIndex--;
    alert(pageIndex);
    page(pageIndex);
}

function next() {
    pageIndex==maxPage?maxPage:pageIndex++;
    alert(pageIndex);
    page(pageIndex);
}

function last() {
    pageIndex=maxPage;
    alert(pageIndex);
    page(pageIndex);
}