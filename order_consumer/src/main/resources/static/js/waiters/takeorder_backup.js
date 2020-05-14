var pageIndex = 1;
var maxPage = 1;
var tableid = null;
var placeholder = null;
$(function () {
    tableid = $("#tableid");
    page(1);

    /**
     * 获得桌号
     * @type {string}
     */
    var table_id = location.search.split("=")[1];
    tableid.val(table_id);


    /**
     * 显示或隐藏餐车
     */
    $(".button").click(function () {
        if ($(".shoppcar").css("display") == "none") {
            $(".shoppcar").show("fast");
        } else {
            $(".shoppcar").hide("fast");
        }
    })
    
    
    $(".confirmOrder").on("click",function () {
        var arr = [];
        var paramsArr =[];
        var dishes_id=null;
        var nums=null;
        var obj1;
        arr = document.getElementsByClassName("shoppcarli");
        var shoppcarli = $(".shoppcarli");
        for (var i = 0; i < arr.length; i++) {
            dishes_id = shoppcarli.eq(i).find(".dishes_id").val();
            nums = shoppcarli.eq(i).find("#nums").val();
            var obj={
                dishesinfo:obj1={
                    dishesid:dishes_id
                },
                num:nums
            };
            paramsArr.push(obj);
        }
        $.ajax({
            type:"POST",
            url:"/insertOrder/"+tableid.val(),
            data:JSON.stringify(paramsArr),
            contentType:'application/json;charset=UTF-8',// 核心
            dataType:"json",
            success:function(data){

            },
            error:function(){
                alert("系统错误!");
            },
        });
    })
})

function prev() {
    if (pageIndex > 1) {
        pageIndex--;
        page(pageIndex);
    }
}

function next() {
    if (pageIndex < maxPage) {
        pageIndex++;
        page(pageIndex);
    }
}

function last() {
    pageIndex = maxPage;
    page(pageIndex);
}


function page(pIndex) {
    $.ajax({
        type: "POST",
        url: "/dishesInfoFindAll?pageIndex=" + pIndex,
        dataType: "json",
        success: function (data) {
            data = eval(data);
            pageIndex = data[2];
            maxPage = data[1];
            $("#dishesbord").html("");
            var str = "";
            for (var i = 0; i < data[0].length; i++) {
                var dishes = data[0][i];
                str += "<div class=\"col-xs-6 col-sm-3 placeholder\">\n" +
                    "\t\t\t\t\t\t\t\t<a href=\"#\"> <img class=\"img-thumbnail\"\n" +
                    "\t\t\t\t\t\t\t\t\tstyle=\"border-radius:20px\" id='dishesimg' \n" +
                    "\t\t\t\t\t\t\t\t\tsrc=\"/img/dishes/1.jpg\"></a>\n" +
                    "\t\t\t\t\t\t\t\t<h4 id='dishesname'>" + dishes.dishesname + "</h4>\n" +
                    "\t\t\t\t\t\t\t\t<span class=\"text-muted\" id='dishesprice'>￥" + dishes.dishesprice + "</span><input type='hidden' id=\"dishesid\" value=" + dishes.dishesid + " />\n" +
                    "\t\t\t\t\t\t\t\t<div class=\"form-group\">\n" +
                    "\t\t\t\t\t\t\t\t\t<form>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<div style=\"width:120px;margin: 0px auto\">\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t<div class=\"input-group\">\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"input-group-btn\">\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t<button class=\"btn btn-default\" type=\"button\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"operation($(this),'subtract')\">-</button>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t</span> <input type=\"text\" class=\"form-control\" value=\"1\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\tdisabled=\"disabled\" name=\"num\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"text-align: center;padding: 0px;cursor: text;\"><input\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\ttype=\"hidden\" name=\"dishes\" value=\"6\" /> <span\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"input-group-btn\">\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t<button class=\"btn btn-default\" type=\"button\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"operation($(this),'add')\">+</button>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t\t\t\t\t<p>\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t<input type=\"button\" class=\"btn btn-danger\"\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"width:120px;margin-top: 5px\" value=\"加入点餐车\" onclick='addOrder($(this))'></input>\n" +
                    "\t\t\t\t\t\t\t\t\t\t</p>\n" +
                    "\t\t\t\t\t\t\t\t\t</form>\n" +
                    "\t\t\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t\t</div>";
            }
            $("#dishesbord").append(str);
        }
    })
}

function operation(obj, op) {
    placeholder = obj.parents(".placeholder");
    var num = placeholder.find("input[name=num]").val();
    num = parseInt(num);
    if (op == "subtract")
        num = num - 1 == 0 ? 1 : num - 1;
    else
        num = num + 1;
    placeholder.find("input[name=num]").val(num);
}

function addOrder(obj) {
    $("#hint").hide();
    var placeholders = $(".placeholders");
    placeholder = obj.parents(".placeholder");
    var dishesid = placeholder.find("#dishesid").val();//菜品ID
    var price = placeholder.find("#dishesprice").html();//菜品价格
    var num = parseInt(placeholder.find("input[name=num]").val());//菜品数量
    var dishesname = placeholder.find("#dishesname").html();//菜品名称
    var dishesimg = placeholder.find("#dishesimg").attr("src");
    var price_one = parseInt(price.substr(1));//单价
    price = price_one * num;//总价
    var arr = [];
    arr = document.getElementsByClassName("dishes_id");
    var dishes_id = $(".dishes_id");
    var flag = false;
    for (var i = 0; i < arr.length; i++) {
        if (dishes_id.eq(i).val() == dishesid) {
            dishes_id.eq(i).parent().prev().children("#prices").html("￥" + price);
            dishes_id.eq(i).prev().prev().val(num);
            flag = true;
            break;
        }
    }
    if (!flag) {
        var li = "<li class=\"shoppcarli\">\n" +
            "\t\t\t\t\t\t\t\t\t<div id=\"pictur\">\n" +
            "\t\t\t\t\t\t\t\t\t\t<img src=" + dishesimg + " >\n" +
            "\t\t\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t\t\t\t<div id=\"infors\">\n" +
            "\t\t\t\t\t\t\t\t\t\t<div id=\"namers\">\n" +
            "\t\t\t\t\t\t\t\t\t\t\t" + dishesname + "\n" +
            "\t\t\t\t\t\t\t\t\t\t</div>\n" +
            "\n" +
            "\t\t\t\t\t\t\t\t\t\t<div id=\"prices\">\n" +
            "\t\t\t\t\t\t\t\t\t\t\t￥" + price + "\n" +
            "\t\t\t\t\t\t\t\t\t\t</div>\n" +
            "\n" +
            "\t\t\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t\t\t\t<div id=\"numbers\">\n" +
            "\t\t\t\t\t\t\t\t\t\t<input class=\"btner btn_minus\" type=\"button\"  onclick=\"shoppcarOperation($(this),'subtract')\" value=\"\" />\n" +
            "\t\t\t\t\t\t\t\t\t\t<input  class=\"inputNum\" type=\"text\"  id=\"nums\" disabled='disabled' value=" + num + " />\n" +
            "\t\t\t\t\t\t\t\t\t\t<input type=\"button\" class=\"btner btn_plus\"   onclick=\"shoppcarOperation($(this),'add')\" value=\"\" />" +
            "<input type=\"hidden\" class='dishes_id' value=" + dishesid + " />" +
            "<input type=\"hidden\" class='price_one' value=" + price_one + " />\n" +
            "\t\t\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t\t\t</li>";
        $(".shoppcar").append(li);

    }
    calcPrice();
}

function shoppcarOperation(obj, op) {
    var obj = obj.parents(".shoppcarli");
    var price = parseInt(obj.find(".price_one").val());//单价
    var num = parseInt(obj.find("#nums").val());
    switch (op) {
        case "subtract":
            if ((num - 1) == 0) {
                if (confirm("是否移除该菜品")) {
                    obj.remove();
                    if ($(".dishes_id").length == 0) {
                        $("#hint").show();
                    }
                    break;
                }
            } else {
                num = --num;
            }
            break;
        case "add":
            num = ++num;
            break;

    }
    price = price * num;//总价
    obj.find("#nums").val(num);
    obj.find("#prices").html("￥" + price);
    calcPrice();
}

/*计算总菜品价格*/
function calcPrice() {
    var arr = [];
    arr = document.getElementsByClassName("shoppcarli");
    var shoppcarli = $(".shoppcarli");
    var totalPrice = 0.00;//菜品总价
    var price = 0.00;//菜品价格
    var nums = 0;//菜品数量
    var totalNum = 0;//总菜品数量
    for (var i = 0; i < arr.length; i++) {
        price = shoppcarli.eq(i).find(".price_one").val();
        nums = shoppcarli.eq(i).find("#nums").val();
        totalNum += parseInt(nums);
        totalPrice += price * nums;
    }
    $("#totalPrice").val(totalPrice);
}

