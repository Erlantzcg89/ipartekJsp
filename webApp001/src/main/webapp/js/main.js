// comentario de linea

/* commentario
    de 
    bloque
*/

/**
 * comentario de bloque para documentar
 */

//alert('Esto funciona');

var a = 2;

console.trace('Esto es una traza de log');
console.info('para informar sobre cosas');
console.debug('la variable a=' + a);
//console.warn('houston tenemos un problema');
//console.error('Error en la conexion al servidor rest');

///////////////////////////////////////////////////////////////////////////////////////////
/*              función para buscar un voluntario aleatorio de un array                  */
///////////////////////////////////////////////////////////////////////////////////////////

function buscarVoluntario() {

    console.trace('click buscarVoluntario');
    var elemento = document.getElementById('nombre');

    var alumnos = [{
            "nombre": "Aitor"
        },
        {
            "nombre": "Endika"
        },
        {
            "nombre": "Iñigo"
        },
        {
            "nombre": "Juan Carlos"
        },
        {
            "nombre": "Alejandro"
        },
        {
            "nombre": "Cristian"
        },
        {
            "nombre": "Raul"
        },
        {
            "nombre": "Joseba"
        },
        {
            "nombre": "Iker"
        },
        {
            "nombre": "Kiryl"
        },
        {
            "nombre": "María"
        },
        {
            "nombre": "Ana"
        },
        {
            "nombre": "Erlantz"
        },
        {
            "nombre": "Mikel"
        }
    ];
    var numAleatorio = Math.floor(Math.random() * alumnos.length);

    elemento.style.color = 'black';
    var voluntario = alumnos[numAleatorio];
    elemento.innerHTML = `<span>
                            ${voluntario.nombre};
                          </span>
                        `;



}

///////////////////////////////////////////////////////////////////////////////////////////
/*              función para cambiar de color a un elento                                */
///////////////////////////////////////////////////////////////////////////////////////////

function cambiarColor() {

    console.trace('click cambiarColor');
    var elemento = document.getElementById('colorCambiar');

    var colores = [{
            "nombre": "rojo",
            "valor": "red"
        },
        {
            "nombre": "naranja",
            "valor": "orange"
        },
        {
            "nombre": "morado",
            "valor": "purple"
        }
    ];
    var numAleatorio = Math.floor(Math.random() * colores.length);

    var color = colores[numAleatorio];
    elemento.style.color = color.valor;
}

///////////////////////////////////////////////////////////////////////////////////////////
/*              un par de funciones para el botón scroll-top                             */
///////////////////////////////////////////////////////////////////////////////////////////

var mybutton = document.getElementById("botonIrTop");

// When the user scrolls down 20px from the top of the document, show the button
window.onscroll = function () {
    scrollFunction()
};

window.onresize = function () {
    scrollFunction()
};

function scrollFunction() {
	
//	para tablets y mobiles el boton scrollTop
	if (window.matchMedia('screen and (max-width: 768px)').matches) {
		if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
			mybutton.style.display = "block";
		}
    } else {
        mybutton.style.display = "none";
    }
}

// When the user clicks on the button, scroll to the top of the document
function topFunction() {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
}

///////////////////////////////////////////////////////////////////////////////////////////
/*              función para ver texto de la contraseña                                  */
///////////////////////////////////////////////////////////////////////////////////////////

function verTexto() {
    console.trace('entrando');
    let iContrasena = document.getElementById('contrasena');
    if (iContrasena.type == "text") {
        iContrasena.type = "password";
        event.target.innerHTML = "Ver";
    } else {
        iContrasena.type = "text";
        event.target.innerHTML = "Ocultar";
    }
}

///////////////////////////////////////////////////////////////////////////////////////////
/*              función para el menu responsive                                          */
///////////////////////////////////////////////////////////////////////////////////////////


function menuResponsive() {
    var x = document.getElementById("myTopnav");
    if (x.className === "topnav") {
        x.className += " responsive";
    } else {
        x.className = "topnav";
    }
}