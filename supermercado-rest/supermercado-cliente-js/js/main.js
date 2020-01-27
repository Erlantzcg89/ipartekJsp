console.log('empiza script');

// http://localhost:8080/supermecado-rest/productos/
// http://localhost:3000/productos/

const ENDPOINT = 'http://localhost:8080/supermecado-rest/productos/';
document.getElementById('endpoint').innerHTML = ENDPOINT;

//selecionar elementos por id
let inputEL = document.getElementById('id_producto');
let botonEL = document.getElementById('boton');
let resultadoEL = document.getElementById('resultado');
let imagenCardEL = document.getElementById('imagenCard');
let tituloCardEL = document.getElementById('tituloCard');
let descripcionCardEL = document.getElementById('descripcionCard');


// registrar evento click para el boton
botonEL.addEventListener("click", () => {

    console.debug('click boton');
    if (inputEL.value === "") {
        resultadoEL.innerHTML = 'Escribe algo por favor';
    } else {

        // llamada Ajax
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {

            /*
            console.debug( "state:" + xhr.readyState  );
            console.debug( "status:" + xhr.status  );
            console.debug( "responseText:" + xhr.responseText  );
            */

            if (xhr.readyState === 4) { // esperar a completar la peticion



                if (xhr.status === 200) {

                    //convetir de texto a json
                    let producto = JSON.parse(xhr.responseText);

                    //pintamos en texarea
                    //resultadoEL.innerHTML = "id= " + producto.id + " nombre=" + producto.nombre;
                    resultadoEL.innerHTML = `id= ${producto.id} nombre=${producto.nombre}`;

                    imagenCardEL.src = `${
                        producto.imagen
                    }`;

                    tituloCardEL.innerHTML = `${
                        producto.nombre
                    }`;

                    descripcionCardEL.innerHTML = `${
                        producto.descripcion
                    }`;

                }

                if (xhr.status === 404) {
                    resultadoEL.innerHTML = `No encontrado`;
                }

            }

        } // onreadystatechange

        xhr.open('Get', `${ENDPOINT}${inputEL.value}`);
        xhr.send(); // Cuidado es ASINCRONO !!!!!


    } // botonEL.addEventListener


});