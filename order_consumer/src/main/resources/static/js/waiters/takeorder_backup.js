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
    var str = location.search.split("=");
    var table_id = str[1];
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
    //模态框
    $("#modal").on("click", function () {
        var arr = [];
        arr = document.getElementsByClassName("shoppcarli");
        var shoppcarli = $(".shoppcarli");
        $(".tb").html("");
        var tr = "<tr>\n" +
            " <td>菜名</td>\n" +
            " <td>数量</td>\n" +
            " <td>单价</td>\n" +
            " <td>金额</td>\n" +
            " </tr>";
        if (arr.length == 0) {
            alert("餐车中没有菜品，请添加后再提交!");
            $("#modal").removeAttr("data-toggle");
        } else {
            $("#modal").attr("data-toggle", "modal");
            var price = null;
            var nums = null;
            var totalNum = null;
            var totalPrice = null;
            var dishesName = null;
            $(".tb").html("");
            for (var i = 0; i < arr.length; i++) {
                price = shoppcarli.eq(i).find(".price_one").val();
                nums = shoppcarli.eq(i).find("#nums").val();
                dishesName = shoppcarli.eq(i).find("#namers").html();
                totalNum = parseInt(nums);
                totalPrice = price * nums;
                tr += "<tr>\n" +
                    " <td>" + dishesName + "</td>\n" +
                    " <td>" + nums + "</td>\n" +
                    " <td>" + price + "</td>\n" +
                    " <td>" + totalPrice + "</td>\n" +
                    " </tr>"
            }
        }
        $(".tb").append(tr);
    })

    $(".confirmOrder").on("click", function () {
        var arr = [];
        arr = document.getElementsByClassName("shoppcarli");
        if (arr.length == 0) {
            alert("餐车中没有菜品，请添加后再提交!");
        } else {
            var paramsArr = [];
            var dishes_id = null;
            var nums = null;
            var obj1;
            var shoppcarli = $(".shoppcarli");
            for (var i = 0; i < arr.length; i++) {
                dishes_id = shoppcarli.eq(i).find(".dishes_id").val();
                nums = shoppcarli.eq(i).find("#nums").val();
                var obj = {
                    dishesinfo: obj1 = {
                        dishesid: dishes_id
                    },
                    num: nums
                };
                paramsArr.push(obj);
            }
            $.ajax({
                type: "POST",
                url: "/insertOrder/" + tableid.val() + "/" + str[2],
                data: JSON.stringify(paramsArr),
                contentType: 'application/json;charset=UTF-8',// 核心
                dataType: "json",
                success: function (data) {
                    data = eval(data);
                    if (data) {
                        alert("添加订单成功!");
                        top.mainwindow.location.href = "/pages/waiters/paylist.html";
                    } else {
                        alert("添加订单失败!");
                    }
                },
                error: function () {
                    alert("系统错误!");
                },
            });
        }

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
                    "<a href=\"#\"> <img class=\"img-thumbnail\"\n" +
                    "style=\"border-radius:20px\" id='dishesimg' \n" +
                    "src=\"/img/dishes/1.jpg\"></a>\n" +
                    "<h4 id='dishesname'>" + dishes.dishesname + "</h4>\n" +
                    "<span class=\"text-muted\" id='dishesprice'>￥" + dishes.dishesprice + "</span><input type='hidden' id=\"dishesid\" value=" + dishes.dishesid + " />\n" +
                    "<div class=\"form-group\">\n" +
                    "<form>\n" +
                    "<div style=\"width:120px;margin: 0px auto\">\n" +
                    "<div class=\"input-group\">\n" +
                    "<span class=\"input-group-btn\">\n" +
                    "<button class=\"btn btn-default\" type=\"button\"\n" +
                    "onclick=\"operation($(this),'subtract')\">-</button>\n" +
                    "</span> <input type=\"text\" class=\"form-control\" value=\"1\"\n" +
                    "disabled=\"disabled\" name=\"num\"\n" +
                    "style=\"text-align: center;padding: 0px;cursor: text;\"><input\n" +
                    "type=\"hidden\" name=\"dishes\" value=\"6\" /> <span\n" +
                    "class=\"input-group-btn\">\n" +
                    "<button class=\"btn btn-default\" type=\"button\"\n" +
                    "onclick=\"operation($(this),'add')\">+</button>\n" +
                    "</span>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "<p>\n" +
                    "<input type=\"button\" class=\"btn btn-danger\"\n" +
                    "style=\"width:120px;margin-top: 5px\" value=\"加入点餐车\" onclick='addOrder($(this))'></input>\n" +
                    "</p>\n" +
                    "</form>\n" +
                    "</div>\n" +
                    "</div>";
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

//添加菜品
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
            "<div id=\"pictur\">\n" +
            "<img src=" + dishesimg + " >\n" +
            "</div>\n" +
            "<div id=\"infors\">\n" +
            "<div id=\"namers\">\n" +
            "" + dishesname + "\n" +
            "</div>\n" +
            "\n" +
            "<div id=\"prices\">\n" +
            "￥" + price + "\n" +
            "</div>\n" +
            "\n" +
            "</div>\n" +
            "<div id=\"numbers\">\n" +
            "<input class=\"btner btn_minus\" type=\"button\"  onclick=\"shoppcarOperation($(this),'subtract')\" value=\"\" />\n" +
            "<input  class=\"inputNum\" type=\"text\"  id=\"nums\" disabled='disabled' value=" + num + " />\n" +
            "<input type=\"button\" class=\"btner btn_plus\"   onclick=\"shoppcarOperation($(this),'add')\" value=\"\" />" +
            "<input type=\"hidden\" class='dishes_id' value=" + dishesid + " />" +
            "<input type=\"hidden\" class='price_one' value=" + price_one + " />\n" +
            "</div>\n" +
            "</li>";
        $(".shoppcar").append(li);

    }
    calcPrice();
}

//增加或者减少菜品数量
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
    $(".modelPrice").html("￥" + totalPrice);
}

