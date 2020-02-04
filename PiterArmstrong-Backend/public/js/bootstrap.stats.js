var BASE_URI="http://localhost:8080/dsaApp/"

$(document).ready(function(){
             $("#login").click(function(){
                 $('table').empty();
                 $.get("http://localhost:8080/dsaApp/usermanager/users/" + $(".username").val() +, function(data, status) {
                     for (var i = 0; i < data.length; i++) {
                         $("table").append("<tr><td>"+data[i].attack+ "</td><td>"+data[i].defense+"</td><td>"+data[i].health+"</td><td>"+data[i].money+"</td><td>"+data[i].pieces+"</td><td>"+data[i].screen+"</td><td>"+data[i].username+"</td></tr>");
                         }
                 });
             });
         });

