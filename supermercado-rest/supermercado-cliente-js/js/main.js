console.log('empiza script');

// http://localhost:8080/supermecado-rest/productos/
// http://localhost:3000/productos/

const ENDPOINT = 'http://localhost:8080/supermecado-rest/productos/';
document.getElementById('endpoint').innerHTML = ENDPOINT;

//selecionar elementos EL por id
let inputEL = document.getElementById('id_producto'); // input box id
let botonEL = document.getElementById('boton'); // boton buscar
let resultadoEL = document.getElementById('resultado'); // text area resultado
let imagenCardEL = document.getElementById('imagenCard'); // imagen tarjeta
let tituloCardEL = document.getElementById('tituloCard'); // titulo tarjeta
let descripcionCardEL = document.getElementById('descripcionCard'); // descripcion tarjeta
let listaEL = document.getElementById('listaProductos'); // ul lista de productos

// al cargar todo llama a cargarProductos
window.onload = function () {
    console.trace('DOM Ready, hemos esperado a que carge todo el HTML, CSS y JS !!!!');
    cargarProductos();
};

// carga los productos por ajax
function cargarProductos() {
    console.log('cargarProductos');

    // new xhr, .onreadystatechange(), .open(), .send()
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            let productos = JSON.parse(xhr.responseText);
            console.debug("producto en json %o", productos);
            listaEL.innerHTML = ""; // limpiar lista
            for (let p of productos) {
                listaEL.innerHTML += `<li class="list-group-item">id: ${p.id}, ${p.nombre}</li>`;
            }
        }
    }
    xhr.open('Get', `${ENDPOINT}`);
    xhr.send();
    console.debug(`GET ${ENDPOINT}`);



}


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