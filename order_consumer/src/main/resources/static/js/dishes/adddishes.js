$(function () {
    $("#inputfile").change(function () {
        if($.browser){
            $("#face").attr("src",$(this).val())
            //$("#info").text("当前选择的文件:"+$(this).val())
        }else{
            //$("#info").text("当前选择的文件:"+$(this).val())
            var objUrl=getObjectURL($(this)[0].files[0]);
            console.log("objUrl="+objUrl);
            if(objUrl){
                $("#face").attr("src",objUrl);
            }
        }
    });

    $("#uploadImg").click(function () {
        var formData=new FormData();
        formData.append("uploadFile",$("#inputfile")[0].files[0]);
        $.ajax({
            type:"POST",
            url:"/dishesGetDishesImg",
            data:formData,
            dataType:"json",
            processData: false,// 告诉jQuery不要去处理发送的数据
            contentType: false,// 告诉jQuery不要去设置Content-Type请求头
            success:function(data){
                alert("添加头像成功: "+data);
                $("#dishesImg").val(data);
            },
            error:function(){
                alert("添加头像失败!");
            },
        });
    });
});

//建立一個可存取到該file的url
function getObjectURL(file) {
    var url = null ;
    if (window.createObjectURL!=undefined) {
        url = window.createObjectURL(file) ;
    } else if (window.URL!=undefined) {
        url = window.URL.createObjectURL(file) ;
    } else if (window.webkitURL!=undefined) {
        url = window.webkitURL.createObjectURL(file) ;
    }
    return url ;
}