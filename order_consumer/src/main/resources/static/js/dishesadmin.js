var pageIndex=1;
var maxPage=1;
$(function () {
    page(1);
});

function page(pIndex) {
    $.ajax({
        type:"POST",
        url:"/dishesInfoFindAll?pageIndex="+pIndex,
        dataType:"json",
        success:function (data) {
            pageIndex=data[2];
            maxPage=data[1];
            $("#orderTable").html("");
            var str="";
            for (var i=0;i<data[0].length;i++){
                var dish=data[0][i];
                str+="<tr><td>"+dish.dishesid+"</td><td>"+dish.dishesname+"</td><td>"+dish.dishesdiscript+"</td><td>"+dish.dishesprice+"</td><td>"+dish.recommend+"</td><td><i style='cursor: pointer; font-size: 14;'" +
                    "onmouseover='this.style.color=\"orange\"'\n" +
                    "onmouseout='this.style.color=\"black\"'\n" +
                    "class='icon-cogs icon-large' title='编辑菜品信息' onclick='window.location=\"/dishesInfoFindById?dishesid="+dish.dishesid+"\"'></i>&nbsp;&nbsp;<i\n" +
                    "style='cursor: pointer; font-size: 14;'\n" +
                    "onmouseover='this.style.color=\"orange\"'\n" +
                    "onmouseout='this.style.color=\"black\"'\n" +
                    "class='icon-sitemap icon-large' title='查看菜品详情'\n" +
                    "onclick=\"detail('"+dish.dishesname+"','"+dish.dishesdiscript+"','"+dish.dishestxt+"',"+dish.dishesprice+","+dish.recommend+",'"+dish.dishesimg+"')\"></i> &nbsp;&nbsp;\n" +
                    "<i style=\"cursor: pointer; font-size: 14px;\" onmouseover=\"this.style.color='orange'\" onmouseout=\"this.style.color='black'\" class=\" icon-remove-sign icon-large\" title=\"删除菜品\" onclick=\"deleteDishes("+dish.dishesid+",'"+dish.dishesname+"',this)\"></i></td></tr>";
            }
            $("#orderTable").append(str);
        },
        error:function () {
            alert("error");
        }
    });
}

function prev() {
    pageIndex==1?1:pageIndex--;
    page(pageIndex);
}

function next() {
    pageIndex==maxPage?maxPage:pageIndex++;
    page(pageIndex);
}

function last() {
    pageIndex=maxPage;
    page(pageIndex);
}

function del(id) {
    if(confirm("确定要删除吗？")){
        alert("删除成功"+id);
    }
}