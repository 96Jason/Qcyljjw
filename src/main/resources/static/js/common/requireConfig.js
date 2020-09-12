/**
 * 全局require config
 */
require.config({
    map: {//map告诉requirejs在载入任何模块之前 ，都先载入这个css模块
        "*": {
            "css": "/js/common/css.js"
        }
    },
    paths: {
        "jquery": "/js/common/jquery-3.4.1.min",
        "tip": "/js/common/tip",
        "bootstrap": "/bootstrap/js/bootstrap.min",
        <!--用于解决手机端点一下返回键就退出的问题 让它返回上一页面-->
        "resolveAppBack": "/js/common/resolveAppBack",
        "address": "/address/js/ydui",
        "flexible": "/address/js/ydui.flexible",
        // "citys": "/address/js/ydui.citys",
        "defaultInvoke": "/address/js/defaultInvoke",
        "crypto-js": "/js/common/crypto-js",
    },
    shim: {
        "bootstrap": {//载入bootstrap模块前会载入以下内容
            deps: [
                'css!/bootstrap/css/bootstrap.min.css', //css!声明样式依赖
                'jquery' //插件依赖jquery
            ]
        },
        "defaultInvoke": {
            deps: [
                "css!/address/css/ydui.css?rev=@@hash",
                "jquery",
                "flexible",
                // "citys",
                "address",
            ]
        }
    }
});