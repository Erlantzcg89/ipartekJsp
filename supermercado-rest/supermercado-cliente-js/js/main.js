console.log('empiza script');

//selecionar elementos por id
let inputEL = document.getElementById('id_producto');
let botonEL = document.getElementById('boton');
let resultadoEL = document.getElementById('resultado');

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

                //convetir de texto a json
                let producto = JSON.parse(xhr.responseText);

                if (xhr.status === 200) {

                    //pintamos en texarea
                    //resultadoEL.innerHTML = "id= " + producto.id + " nombre=" + producto.nombre;
                    resultadoEL.innerHTML = `id= ${producto.id} nombre=${producto.nombre}`;
                }

                if (xhr.status === 404) {
                    resultadoEL.innerHTML = `No encontrado`;
                }

            }

        }

        xhr.open('Get', `http://localhost:8080/supermecado-rest/productos/${inputEL.value}`);
        xhr.send(); // Cuidado es ASINCRONO !!!!!


    }


});