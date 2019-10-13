$(() => {
    $('#loginBtn').click(() => {
        let $account = $('#account').val()
        let $password = $('#password').val()
        $.ajax({
            type: "post",
            url: "ServletDemo03.action",
            async: true,
            dataType: "json",
            data: { account: $account, password: $password },
            success: (responseText) => {
                window.console.log(responseText)
                switch (responseText.status) {
                    case "success":
                        sessionStorage.setItem("emp", JSON.stringify(responseText.emp))
                        window.location.replace("index.html")
                        break;
                    case "failed":
                        $("#loginInfo").text("账号或者密码错误")
                        $('#password').val("")
                        $('#password').focus()
                        break;
                    default:
                        break;
                }
            }
        })
    })
})