var BASE_URI="http://localhost:8080/dsaApp/"


$(document).ready(function(){
var user; var nombre = window.localStorage.getItem("username");


var precio25 = 25; var vida25= 25; var precio50 = 50; var vida50= 50;
var precio75 = 75; var vida75= 75; var precio100 = 100; var vida100= 100;

var precio20 = 20; var ataque10= 10; var precio35 = 35; var ataque20= 20;
var precio70 = 70; var ataque10= 30; var precio90 = 90; var ataque50= 50;

var precio30 = 30; var defensa15= 15; var precio45 = 45; var defensa35= 35;
var precio80 = 80; var defensa80= 80; var precio150 = 150; var defensa150= 150;

            $.get("http://localhost:8080/dsaApp/usermanager/users/"+ nombre, function(data, status) {
            var username1;  var password1; var attack; var defense;  var health; var money; var pieces; var screen;

                              username1 =  data.username;
                              password1 = data.password;
                              attack = data.attack;
                              defense = data.defense;
                              health = data.health;
                              money = data.money;
                              pieces = data.pieces;
                              screen = data.screen;

           $("#precio25").click(function(){
            if (money>=25){
            health = health + vida25;
            money = money - precio25;
            var user = {"username": username1, "password": password1, "health": health, "defense": defense, "attack": attack, "money": money, "pieces": pieces, "screen": screen};
                        console.log(user);
            }
            else
            alert("No tienes suficiente money");
            });

           $("#precio50").click(function(){
           if (money>=50){
           health = health + vida50;
           money = money - precio50;
           var user = {"username": username1, "password": password1, "health": health, "defense": defense, "attack": attack, "money": money, "pieces": pieces, "screen": screen};
                       console.log(user);
           }
           else
           alert("No tienes suficiente money");
           });

           $("#precio75").click(function(){
           if (money>=75){
           health = health + vida75;
           money = money - precio75;
           var user = {"username": username1, "password": password1, "health": health, "defense": defense, "attack": attack, "money": money, "pieces": pieces, "screen": screen};
                       console.log(user);
           }
           else
           alert("No tienes suficiente money");
           });

           $("#precio100").click(function(){
           if (money>=100){
           health = health + vida100;
           money = money - precio100;
           var user = {"username": username1, "password": password1, "health": health, "defense": defense, "attack": attack, "money": money, "pieces": pieces, "screen": screen};
                       console.log(user);
           }
           else
           alert("No tienes suficiente money");
           });

           $("#precio20").click(function(){
           if (money>=20){
           attack = attack + ataque10;
           money = money - precio20;
           var user = {"username": username1, "password": password1, "health": health, "defense": defense, "attack": attack, "money": money, "pieces": pieces, "screen": screen};
                       console.log(user);
           }
           else
           alert("No tienes suficiente money");
           });


           $("#precio35").click(function(){
           if (money>=35){
           attack = attack + ataque20;
           money = money - precio35;
           var user = {"username": username1, "password": password1, "health": health, "defense": defense, "attack": attack, "money": money, "pieces": pieces, "screen": screen};
                  console.log(user);
           }
           else
           alert("No tienes suficiente money");
           });

           $("#precio70").click(function(){
           if (money>=70){
           attack = attack + ataque30;
           money = money - precio70;
           var user = {"username": username1, "password": password1, "health": health, "defense": defense, "attack": attack, "money": money, "pieces": pieces, "screen": screen};
                  console.log(user);
           }
           else
           alert("No tienes suficiente money");
           });

           $("#precio90").click(function(){
           if (money>=90){
           attack = attack + ataque50;
           money = money - precio90;
           var user = {"username": username1, "password": password1, "health": health, "defense": defense, "attack": attack, "money": money, "pieces": pieces, "screen": screen};
                console.log(user);
           }
           else
           alert("No tienes suficiente money");
           });


           $("#precio30").click(function(){
           if (money>=30){
           defense = defense + defensa15;
           money = money - precio30;
           var user = {"username": username1, "password": password1, "health": health, "defense": defense, "attack": attack, "money": money, "pieces": pieces, "screen": screen};
                 console.log(user);
           }
           else
           alert("No tienes suficiente money");
           });
            $("#precio45").click(function(){
            if (money>=45){
            defense = defense + defensa35;
            money = money - precio45;
            var user = {"username": username1, "password": password1, "health": health, "defense": defense, "attack": attack, "money": money, "pieces": pieces, "screen": screen};
                 console.log(user);
            }
            else
            alert("No tienes suficiente money");
            });
            $("#precio80").click(function(){
            if (money>=80){
            defense = defense + defensa80;
            money = money - precio80;
            var user = {"username": username1, "password": password1, "health": health, "defense": defense, "attack": attack, "money": money, "pieces": pieces, "screen": screen};
                  console.log(user);
            }
            else
            alert("No tienes suficiente money");
            });
            $("#precio150").click(function(){
            if (money>=150){
            defense = defense + defensa150;
            money = money - precio150;
            var user = {"username": username1, "password": password1, "health": health, "defense": defense, "attack": attack, "money": money, "pieces": pieces, "screen": screen};
                 console.log(user);
            }
            else
            alert("No tienes suficiente money");
            });



            alert("Tu saldo es de:" + money);
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