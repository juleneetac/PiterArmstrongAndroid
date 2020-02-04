var BASE_URI="http://localhost:8080/dsaApp/"

$(document).ready(function(){

            $("#login").click(function(){
            var username = $(".username").val();
            var password = $(".password").val();
            var user = {"username": username, "password": password, "health": 0, "defense": 0, "attack": 0, "money": 0, "pieces": 0, "screen": 0};
            console.log(user);

$.ajax({
            url: BASE_URI.concat("usermanager/login"),
            headers: { 'content-type': 'application/json',"x-kii-appid": "XXXXX","x-kii-appkey":"XXXXX" },
            type: 'POST',
            data: JSON.stringify(user),
            dataType: 'json',
            success: function (data) {
                window.localStorage.setItem("username",username);
                var url = "http://localhost:8080/html/index2.html";
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
