

//登录检查,当session过期时，跳转到登录页面
function checkSessionDg() {
    $.ajaxSetup({
//         beforeSend: function() {
//             console.log(arguments);
// //			                 var params = arguments[1].data;
// //			                 var data = '';
// //			                 for (var key in params) {
// //				                     //这两行代码的意思是进行 base64 编码
// ////				                     var dataUtf8 = CryptoJS.enc.Utf8.parse(params[key]);
// ////				                     var dataBase64 = CryptoJS.enc.Base64.stringify(dataUtf8);
// ////				                     data = data.concat('&' + key + '=' + dataBase64);
// //				                 };
// //			                 arguments[1].data = data.substring(1, data.length);//将序列化后的参数重写
//         },
//         processData: true,
        // dataFilter: function() {
        //     console.log(arguments);//这是我的一个习惯，拿到一个函数之后，管他是什么东西，先看看里面有什么参数
        //     if(arguments[0] === "logout"){
        //         console.log("logout,session timeout?")
        //         //window.location.href = "../../index.ftl";
        //         window.top.location = "../../index.ftl";
        //     }else{
        //         //return arguments;
        //     }
        // }
        // ,
        // error: function (XMLHttpRequest, textStatus, errorThrown){
        //     if(XMLHttpRequest.status==499){
        //         window.top.location = "../../index.ftl";
        //         return false;
        //     }
        // },
        //这个方法是目前适应easyui和普通jquery ajax请求的唯一方法，上面的都有各种问题
        complete:function(XMLHttpRequest,textStatus){
            var sessionstatus=XMLHttpRequest.getResponseHeader("sessionstatus"); //通过XMLHttpRequest取得响应头,sessionstatus，
            if(sessionstatus=='logout'){
                //如果超时就处理 ，指定要跳转的页面
                window.top.location = "/login.ftl";
            }
        }
    });
}

function checkSession() {
    $.ajaxSetup({
//         beforeSend: function() {
//             console.log(arguments);
// //			                 var params = arguments[1].data;
// //			                 var data = '';
// //			                 for (var key in params) {
// //				                     //这两行代码的意思是进行 base64 编码
// ////				                     var dataUtf8 = CryptoJS.enc.Utf8.parse(params[key]);
// ////				                     var dataBase64 = CryptoJS.enc.Base64.stringify(dataUtf8);
// ////				                     data = data.concat('&' + key + '=' + dataBase64);
// //				                 };
// //			                 arguments[1].data = data.substring(1, data.length);//将序列化后的参数重写
//         },
//         processData: true,
//         dataFilter: function() {
//             console.log(arguments);//这是我的一个习惯，拿到一个函数之后，管他是什么东西，先看看里面有什么参数
//             if(arguments[0] === "logout"){
//                 console.log("logout,session timeout?")
//                 //window.location.href = "../../index.ftl";
//                 window.top.location = "../../index.ftl";
//             }else{
//                 return arguments;
//             }
//         }
//         ,
        error: function (XMLHttpRequest, textStatus, errorThrown){
            if(XMLHttpRequest.status==499){
                window.top.location = "login.ftl";
                return false;
            }
        }
        // ,
        //这个方法是目前适应easyui和普通jquery ajax请求的唯一方法，上面的都有各种问题
        // complete:function(XMLHttpRequest,textStatus){
        //     var sessionstatus=XMLHttpRequest.getResponseHeader("sessionstatus"); //通过XMLHttpRequest取得响应头,sessionstatus，
        //     if(sessionstatus=='logout'){
        //         //如果超时就处理 ，指定要跳转的页面
        //         window.top.location = "../../index.ftl";
        //     }
        // }
    });
}


Date.prototype.format=function(fmt) {
    var o = {
        "M+" : this.getMonth()+1, //月份
        "d+" : this.getDate(), //日
        "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时
        "H+" : this.getHours(), //小时
        "m+" : this.getMinutes(), //分
        "s+" : this.getSeconds(), //秒
        "q+" : Math.floor((this.getMonth()+3)/3), //季度
        "S" : this.getMilliseconds() //毫秒
    };
    var week = {
        "0" : "\u65e5",
        "1" : "\u4e00",
        "2" : "\u4e8c",
        "3" : "\u4e09",
        "4" : "\u56db",
        "5" : "\u4e94",
        "6" : "\u516d"
    };
    if(/(y+)/.test(fmt)){
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
    }
    if(/(E+)/.test(fmt)){
        fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "\u661f\u671f" : "\u5468") : "")+week[this.getDay()+""]);
    }
    for(var k in o){
        if(new RegExp("("+ k +")").test(fmt)){
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
        }
    }
    return fmt;
}

//修改日历框的显示格式
function formatter(date){
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var day = date.getDate();
    var hour = date.getHours();
    month = month < 10 ? '0' + month : month;
    day = day < 10 ? '0' + day : day;
    hour = hour < 10 ? '0' + hour : hour;
    return year + "-" + month + "-" + day + "    " + hour;
}

function parser(s){
    var t = Date.parse(s);
    if (!isNaN(t)){
        return new Date(t);
    } else {
        return new Date(s + ":00:00");
    }
}


