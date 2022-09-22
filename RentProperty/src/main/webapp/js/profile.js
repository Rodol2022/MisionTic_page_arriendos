var usuario = new URL(location.href).searchParams.get("usuario");
var user;

$(document).ready(function () {


    fillUsuario().then(function () {

      //  $("#user-saldo").html("$" + user.saldo.toFixed());

        getAlquiladas(user.usuario);
    });

    $("#reservar-btn").attr("href", `home.html?usuario=${usuario}`);

    $("#form-modificar").on("submit", function (event) {

        event.preventDefault();
        modificarUsuario();
    });

    $("#aceptar-eliminar-cuenta-btn").click(function () {

        eliminarCuenta().then(function () {
            location.href = "index.html";
        })
    })

});

async function fillUsuario() {
    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            usuario: usuario,
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;

                $("#input-id").val(parsedResult.username);
                $("#input-usuario").val(parsedResult.usuario);
                $("#input-contrasena").val(parsedResult.contrasena);
                $("#input-nombre").val(parsedResult.nombre);
                $("#input-apellidos").val(parsedResult.apellido);
                $("#input-telefono").val(parsedResult.telefono);
                $("#input-email").val(parsedResult.email);
               // $("#input-premium").prop("checked", parsedResult.premium);
                $("#input-ciudad").val(parsedResult.ciudad);

            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });
}

function getAlquiladas(usuario) {


    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletAlquilerListar",
        data: $.param({
            usuario: usuario,
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {

                mostrarHistorial(parsedResult)

            } else {
                console.log("Error recuperando los datos de las reservas");
            }
        }
    });
}

function mostrarHistorial(inmuebles) {
    let contenido = "";
    if (inmuebles.length >= 1) {
        $.each(inmuebles, function (index, inmueble) {
            inmueble = JSON.parse(inmueble);

            contenido += '<tr><th scope="row">' + inmueble.id + '</th>' +
                    '<td>' + inmueble.tipo + '</td>' +
                    '<td>' + inmueble.ciudad + '</td>' +
                    '<td><input type="checkbox" name="disponible" id="disponible' + inmueble.id 
                    + '" disabled ';
            if (inmueble.disponible) {
                contenido += 'checked'
            }
            contenido += '></td><td>' + inmueble.fechaAlquiler + '</td>' +
                    '<td><button id="devolver-btn" onclick= "devolverinmueble(' + inmueble.id 
                    + ');" class="btn btn-danger">Devolver inmueble</button></td></tr>';

        });
        $("#historial-tbody").html(contenido);
        $("#historial-table").removeClass("d-none");
        $("#historial-vacio").addClass("d-none");

    } else {
        $("#historial-vacio").removeClass("d-none");
        $("#historial-table").addClass("d-none");
    }
}


function devolverInmueble(id) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletPeliculaDevolver",
        data: $.param({
            usuario: usuario,
            id: id,
        }),
        success: function (result) {

            if (result != false) {

                location.reload();

            } else {
                console.log("Error devolviendo el Pelicula");
            }
        }
    });

}

function modificarUsuario() {

    let usuario = $("#input-username").val();
    let contrasena = $("#input-contrasena").val();
    let nombre = $("#input-nombre").val();
    let apellido = $("#input-apellidos").val();
    let telefono = $("#input-telefono").val();
    let email = $("#input-email").val();
    let ciudad = $("#input-ciudad").val();
    
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioModificar",
        data: $.param({
            usuario: usuario,
            contrasena: contrasena,
            nombre: nombre,
            apellido: apellido,
            telefono: telefono,
            email: email,
            ciudad: ciudad
           
        }),
        success: function (result) {

            if (result != false) {
                $("#modificar-error").addClass("d-none");
                $("#modificar-exito").removeClass("d-none");
            } else {
                $("#modificar-error").removeClass("d-none");
                $("#modificar-exito").addClass("d-none");
            }

            setTimeout(function () {
                location.reload();
            }, 3000);

        }
    });

}

async function eliminarCuenta() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioEliminar",
        data: $.param({
            usuario: usuario
        }),
        success: function (result) {

            if (result != false) {

                console.log("Usuario eliminado")

            } else {
                console.log("Error eliminando el usuario");
            }
        }
    });
}