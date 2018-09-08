layui.use(['element', 'form', 'layer', 'carousel'], function () {
    var salt = '1a2b3c4d';
    var e = layui.element,
        layer = layui.layer,
        carousel = layui.carousel,
        form = layui.form;

    carousel.render({
        elem: '#login-carousel',
        width: 700,
        height: 360,
        anim: 'updown',
        interval: 5000,
        arrow: 'hover'
    });

    $('#login-carousel').css('margin', '20px 0 0 30px');


    form.verify({
        username: function (value, item) { //value：表单的值、item：表单的DOM对象
            if ("" == value) {
                return '用户名不能为空';
            }
            /*				if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)) {
                                return '用户名不能有特殊字符';
                            }
                            if(/(^\_)|(\__)|(\_+$)/.test(value)) {
                                return '用户名首尾不能出现下划线\'_\'';
                            }
                            if(/^\d+\d+\d$/.test(value)) {
                                return '用户名不能全为数字';
                            }
            */
        },
        pass: [
            /^[\S]{3,12}$/
            , '密码必须3到12位，且不能出现空格'
        ]
    });

    $(document).keypress(function (e) {
        //回车事件
        if (e.which == 13) {
            $('#loginBtn').click();
        }
    });
    form.on('submit(loginForm)', function (data) {
        layer.msg('正在登录', {
            icon: 16,
            shade: 0.1,
            time: 10000
        });
        $.ajax({
            method: 'POST',
            data: {
                mobile: data.field.username,
                password: md5(data.field.password)
            },
            url: '/login/do_login',
            success: function (result) {
                if (result.code != "0") {
                    layer.msg(result.msg, {
                        icon: 2,
                        anim: 6
                    });
                    for (var i = 0; i < $(':input').length - 1; i++) {
                        $(':input')[i].value = "";
                    }
                    $(':input')[0].focus();

                }
                else {
                    layer.msg("登录成功.")
                }
            }
        });
    });
});