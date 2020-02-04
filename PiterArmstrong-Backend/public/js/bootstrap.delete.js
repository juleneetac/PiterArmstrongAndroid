var BASE_URI="http://localhost:8080/dsaApp/"

$(document).ready(function(){

            $("#aceptar").click(function(){
            var username = $(".username").val();
            var password = $(".password").val();
            var user = {"username": username, "password": password};
            console.log(user);
            alert("La cuenta ha sido eliminada correctamente, para volver a iniciar sesión, primero deberás registrarte");
$.ajax({
            url: BASE_URI.concat("usermanager/users/"+window.localStorage.getItem("username")+"/delete"),
            headers: { 'content-type': 'application/json',"x-kii-appid": "XXXXX","x-kii-appkey":"XXXXX" },
            type: 'POST',
            data: JSON.stringify(user),
            dataType: 'json',
            success: function (data) {
                window.localStorage.setItem("username",username);
                var url = "http://localhost:8080/html/index.html";
                window.open(url, "_self");
                alert(data)
            },
            error: function (e) {
                 // log error in browser
                console.log(e.message);
            }
        });
    });
});