$(() => {
    $('#btn').click(() => {
        $.ajax({
            // 请求方式
            type: "GET",
            // 请求资源
            url: "./res/demo06.json",
            // 是否异步
            async: true,
            // 返回数据类型
            dataType: "text",
            // 成功返回
            success: (responseText) => {
                window.console.log(responseText)
                window.console.log(responseText.account)
            }
        });
    });
});