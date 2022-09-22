$(document).ready(function () {
    
    $("#form-login").submit(function (event) {
        
        event.preventDefault();
        autenticarUsuario();
    });
    
    $("#form-register").submit(function (event) {
        
        event.preventDefault();
        registrarUsuario();
    });
});

function autenticarUsuario() {
    let usuario = $("#usuario").val();
    let contrasena = $("#contrasena").val();
    
    $.ajax({
        type: "GET",
        dataType: 'html',
        url: "./ServletUsuarioLogin",
        data: $.param({
            usuario: usuario,
            contrasena: contrasena
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if(parsedResult !=   false) {
                $("#login-error").addClass("d-none");
                let usuario = parsedResult['usuario'];
                document.location.href = "home.html?usuario=" + usuario;
            }else {
                $("#login-error").removeClass("d-none");
            }
        }
    });
}

function registrarUsuario() {
    let idUsuario = $("#input-id").val();
    let usuario = $("#input-usuario").val();
    let contrasena = $("#input-contrasena").val();
    let contrasenaConfirmacion = $("#input-contrasena-repeat").val();
    let nombre = $("#input-nombre").val();
    let apellido = $("#input-apellido").val();
    let telefono = $("#input-telefono").val();
    let email = $("#input-email").val();
    let ciudad = $("#input-ciudad").val();
    
    
    if(contrasena == contrasenaConfirmacion){
        
        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletUsuarioRegister",
            data: $.param({
                idUsuario: idUsuario,
                usuario: usuario,
                contrasena: contrasena,
                nombre: nombre,
                apellido: apellido,
                telefono: telefono,
                email: email,
                ciudad: ciudad
            }),
            success: function (result){
                let parsedResult = JSON.parse(result);
                
                if(parsedResult != false){
                    $("#register-error").addClass("d-none");
                    let usuario = parsedResult['usuario'];
                    document.location.href = "home.html?username=" + usuario;
                }else{
                    $("#register-error").removeClass("d-none");
                    $("#register-error").html("Error en el registro del usuario");
                }
            }
        });
    }else{
        $("#register-error").removeClass("d-none");
        $("#register-error").html("Las contraseñas no coinciden");
    }
}





