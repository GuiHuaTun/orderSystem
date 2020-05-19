var pageIndex=1;
var maxPage=1;
$(function () {
    $.ajax({
        type:"POST",
        url:"/webSocketLogin/chef",
        dataType:"json",
        success:function (data) {
            //alert("连接成功");
            WebSocketTest();
        },
        error:function () {
            alert("连接失败！");
        }
    });
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
                tr+="<tr><td>"+orderdish.orderinfo.tables.tableid+"</td><td>"+orderdish.dishesinfo.dishesname+"</td><td>"+orderdish.num+"</td><td><a href='javascript:serving("+orderdish.odid+","+orderdish.orderinfo.tables.tableid+",\""+orderdish.dishesinfo.dishesname+"\")'>上菜</a></td></tr>";
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

//上菜
function serving(odid,tableid,dishesname) {
    if(confirm("确定要上菜吗？")){
        $.ajax({
            type:"POST",
            url:"/updateStatus",
            data:"odid="+odid,
            dataType:"json",
            success:function (data) {
                if(data>0){
                    page(1);
                    var message=tableid+"号桌菜品："+dishesname+"已经完成！";
                    toWaiter(message);
                }else{
                    alert("上菜失败！");
                }
            },
            error:function () {
                alert("连接失败！");
            }
        });
    }
}

function WebSocketTest() {
    if ("WebSocket" in window)
    {
        //alert("您的浏览器支持 WebSocket!");

        // 打开一个 web socket
        var ws=new WebSocket("ws://localhost:8090/myHandler");

        //打开连接时
        ws.onopen = function()
        {
            // Web Socket 已连接上，使用 send() 方法发送数据
            //ws.send("发送数据");
            //alert("数据发送中...");
        };

        //收到消息时
        ws.onmessage = function (evt)
        {
            var received_msg = evt.data;
            //alert("数据已接收..."+received_msg);
            $("#message").html(received_msg);
        };

        //连接出错时
        ws.onerror = function (ev) {
            alert("连接出现问题!");
        }

        //连接关闭时
        ws.onclose = function()
        {
            // 关闭 websocket
            //alert("连接已关闭...");
        };
    }

    else
    {
        // 浏览器不支持 WebSocket
        alert("您的浏览器不支持 WebSocket!");
    }
}

function toWaiter(message) {
    $.ajax({
        type:"POST",
        url:"/sendMessageToUser/waiter/"+message,
        dataType:"json",
        success:function (data) {
            //alert("连接成功");
        },
        error:function () {
            alert("连接失败！");
        }
    });
}