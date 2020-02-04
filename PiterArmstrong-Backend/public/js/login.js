var base_url="file:///C:/Users/Bernardo/Desktop/WEB/html/login.html"

$(document).ready(function(){

    $("#login").click(function(){
        var nombre = $(".username").val();
        console.log(username);
        var contra = $(".password").val();
        console.log(password);
        console.log("Estoy en login script");
        
        var usuario = {nombre:"nombre", contraseña:"contra"};
              

    });
    console.log(usuario);

    usuario.name = function() {
        return this.nombre + " " + this.contra;
      };
});