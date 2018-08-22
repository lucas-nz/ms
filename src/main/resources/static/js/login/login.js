function login() {
    $("#loginForm").validate({
        submitHandler: function (form) {
            doLogin();
        }
    });
}

function doLogin() {
    g_showLoading();
    var password = md5($('#password').val() + g_passsword_salt);
    $.ajax({
       url: "/login/do_login",
       type: "POST",
       data: {
           mobile: $('#mobile').val(),
           password: password
       },
       success: function (result) {
           if(result.code == 0) {
               window.location.href = "/login/to_login";
           }else {
               layer.closeAll();
               layer.msg(result.msg);
           }

       },
       error: function () {

       } 
        

    });


}