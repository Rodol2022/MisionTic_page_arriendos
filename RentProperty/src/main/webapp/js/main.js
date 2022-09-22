var usuario = new URL(location.href).searchParams.get("usuario");
var user;

$(document).ready(function () {

    $(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });

    getUsuario().then(function () {

        $("#mi-perfil-btn").attr("href", "profile.html?usuario=" + usuario);

       // $("#user-saldo").html(user.saldo.toFixed(2) + "$");

        getInmuebles(false, "ASC");

        $("#ordenar-genero").click(ordenarInmuebles);
    });
});

async function getUsuario() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            usuario: usuario
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;
            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });
    
    }

    function getInmuebles(ordenar, orden) {

        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletInmuebleListar",
            data: $.param({
                ordenar: ordenar,
                orden: orden
            }),
            success: function (result) {
                let parsedResult = JSON.parse(result);

                if (parsedResult != false) {
                    mostrarInmuebles(parsedResult);
                } else {
                    console.log("Error recuperando los datos de las peliculas");
                }
            }
        });
    
    }
    
    function mostrarInmuebles(inmuebles) {

        let contenido = "";

        $.each(inmuebles, function (index, inmueble) {

            inmueble = JSON.parse(inmueble);
            let precio;

          //  if (inmueble.copias > 0) {

                if (user.premium) {

                    if (inmueble.novedad) {
                        precio = (2 - (2 * 0.1));
                    } else {
                        precio = (1 - (1 * 0.1));
                    }
                } else {
                    if (inmueble.novedad) {
                        precio = 2;
                    } else {
                        precio = 1;
                    }
                }

                contenido += '<tr><th scope="row">' + inmueble.idInmueble + '</th>' +
                             '<td>' + inmueble.tipoInmueble + '</td>' +
                             '<td>' + inmueble.ciudadInmueble + '</td>' +
                             '<td>' + inmueble.zonaInmueble + '</td>' +
                             '<td>' + inmueble.descripcionInmueble + '</td>' +
                             '<td>' + inmueble.precioInmueble + '</td>' +                       
                             '<td><input type="checkbox" name="disponible" id="disponible' + inmueble.disponibleInmueble + '" disabled ';
                if (inmueble.disponibleInmueble) {
                    contenido += 'checked';
                }
                contenido += '></td>' +
                       // '<td>' + precio + '</td>' +
                        '<td><button onclick="alquilarInmueble(' + inmueble.idInmueble + ',' + precio + ');" class="btn btn-success" ';
                /*if (user.saldo < precio) {
                    contenido += ' disabled ';
                }*/

                contenido += '>Reservar</button></td></tr>';

           // }
        });
        $("#peliculas-tbody").html(contenido);
    }
    
    
    
