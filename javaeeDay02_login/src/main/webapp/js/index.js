$(() => {
    let empString = sessionStorage.getItem("emp")
    if (empString != null) {
        let emp = JSON.parse(empString)
        $("#opt").text(emp.nickname)
    } else {
        window.location.replace("login04.html")
    }
})