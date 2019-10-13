## jQuery AJAX 方法

AJAX 是一种与服务器交换数据的技术，可以在不重新载入整个页面的情况下更新网页的一部分。

下面的表格列出了所有的 jQuery AJAX 方法：

| 方法                                                         | 描述                                                         |
| :----------------------------------------------------------- | :----------------------------------------------------------- |
| [$.ajax()](https://www.runoob.com/jquery/ajax-ajax.html)     | 执行异步 AJAX 请求                                           |
| $.ajaxPrefilter()                                            | 在每个请求发送之前且被 $.ajax() 处理之前，处理自定义 Ajax 选项或修改已存在选项 |
| [$.ajaxSetup()](https://www.runoob.com/jquery/ajax-ajaxsetup.html) | 为将来的 AJAX 请求设置默认值                                 |
| $.ajaxTransport()                                            | 创建处理 Ajax 数据实际传送的对象                             |
| [$.get()](https://www.runoob.com/jquery/ajax-get.html)       | 使用 AJAX 的 HTTP GET 请求从服务器加载数据                   |
| [$.getJSON()](https://www.runoob.com/jquery/ajax-getjson.html) | 使用 HTTP GET 请求从服务器加载 JSON 编码的数据               |
| [$.getScript()](https://www.runoob.com/jquery/ajax-getscript.html) | 使用 AJAX 的 HTTP GET 请求从服务器加载并执行 JavaScript      |
| [$.param()](https://www.runoob.com/jquery/ajax-param.html)   | 创建数组或对象的序列化表示形式（可用于 AJAX 请求的 URL 查询字符串） |
| [$.post()](https://www.runoob.com/jquery/ajax-post.html)     | 使用 AJAX 的 HTTP POST 请求从服务器加载数据                  |
| [ajaxComplete()](https://www.runoob.com/jquery/ajax-ajaxcomplete.html) | 规定 AJAX 请求完成时运行的函数                               |
| [ajaxError()](https://www.runoob.com/jquery/ajax-ajaxerror.html) | 规定 AJAX 请求失败时运行的函数                               |
| [ajaxSend()](https://www.runoob.com/jquery/ajax-ajaxsend.html) | 规定 AJAX 请求发送之前运行的函数                             |
| [ajaxStart()](https://www.runoob.com/jquery/ajax-ajaxstart.html) | 规定第一个 AJAX 请求开始时运行的函数                         |
| [ajaxStop()](https://www.runoob.com/jquery/ajax-ajaxstop.html) | 规定所有的 AJAX 请求完成时运行的函数                         |
| [ajaxSuccess()](https://www.runoob.com/jquery/ajax-ajaxsuccess.html) | 规定 AJAX 请求成功完成时运行的函数                           |
| [load()](https://www.runoob.com/jquery/ajax-load.html)       | 从服务器加载数据，并把返回的数据放置到指定的元素中           |
| [serialize()](https://www.runoob.com/jquery/ajax-serialize.html) | 编码表单元素集为字符串以便提交                               |
| [serializeArray()](https://www.runoob.com/jquery/ajax-serializearray.html) | 编码表单元素集为 names 和 values 的数组                      |