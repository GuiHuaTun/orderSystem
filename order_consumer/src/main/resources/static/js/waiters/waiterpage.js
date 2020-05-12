var tableId=null;
var tableresult=null;
$(function () {
    tableId=$("#tableId");
    tableresult=$("#tableresult");
$.ajax({
    type:"POST",
    url:"/allocationTable",
    dataType:"json",
    success:function(data){
        data=eval(data[0]);
        if(data!=null){
            tableId.val(data.tableid);
            tableresult.html("【"+data.tablename+"】");
        }else{
            alert("已无空桌，请等待");
            tableresult.html("【已无空桌，请等待】");
        }
    },
    error:function(){
        alert("系统错误!");
    },
});

});
function setTableId() {
    $.ajax({
        type:"POST",
        url:"/setTableId/"+tableId.val(),
        dataType:"json",
        success:function(data){
            data= eval(data);
            alert(data);
            if(data!=null){
                tableId.val(data.tableid);
                tableresult.html("【"+data.tablename+"】");
            }
        },
        error:function(){
            alert("系统错误!");
        },
    });
}