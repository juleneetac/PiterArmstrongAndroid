var BASE_URI="http://localhost:8080/dsaApp/"


$(document).ready(function(){



            $("#aceptar").click(function(){
            var username = $(".username").val();
            var password = $(".password").val();
            $.get("http://localhost:8080/dsaApp/usermanager/users/" + $("#username").val(), function(data, status) {

var username1;  var password1; var attack; var defense;  var health; var money; var pieces; var screen;

                              username1 =  data.username;
                              password1 = data.password;
                              attack = data.attack;
                              defense = data.defense;
                              health = data.health;
                              money = data.money;
                              pieces = data.pieces;
                              screen = data.screen;





            var user = {"username": username, "password": password, "health": health, "defense": defense, "attack": attack, "money": money, "pieces": pieces, "screen": screen};
            console.log(user);
            alert("Contraseña cambiada correctamente");
$.ajax({
            url: BASE_URI.concat("usermanager/users/" + $(".username").val() +"/update"),
            headers: { 'content-type': 'application/json',"x-kii-appid": "XXXXX","x-kii-appkey":"XXXXX" },
            method: 'POST',
            dataType: 'json',
            data: JSON.stringify(user),
            success: function (data) {
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
});