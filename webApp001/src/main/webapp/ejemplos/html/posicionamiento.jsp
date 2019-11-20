<%
	String titulo = "Posicionamiento Html-Css";
%>

<%@include file="/includes/cabecera.jsp" %>

	    <style>
        .box {
            display: inline-block;
            width: 100px;
            height: 100px;



            border: 2px solid teal;
            background-color: teal;
            border-radius: 10px;

            margin: 10px 5px 10px 5px;

            color: white;
            font-size: 5em;
            text-align: center;
        }

        .box-texto {
            display: inline-block;
            width: 100px;
            height: 100px;
            border: 2px solid teal;
        }

        #imagenBoxModel {
            display: block;
            width: 400px;
            margin: auto;

        }
    </style>

    <style>
        .contenedor {
            /* siempre acordarse relative el contenedor */
            position: relative;
            width: 400px;
            height: 400px;
            margin: auto;
            overflow: hidden;
        }

        .absoluto {
            /* posicionamos de forma absoluta sobre el contenedor */
            position: absolute;
            right: 15px;
            top: 15px;
            background-color: red;
            border-radius: 50px;
            padding: 10px;
            color: white;
        }

        .contenedor:hover .texto {

            bottom: 0;

        }

        .contenedor .texto {
            transition: bottom 2s ease;
            background-color: rgba(0, 0, 0, 0.301);
            position: absolute;
            bottom: -130px;
        }
    </style>

    <nav class="menu" id="menu">
        <a href="index.jsp">Inicio</a>
        <a href="ejemplos/html/index.jsp">Volver a ejercicios Html</a>
    </nav>

    <main>
        <h1 class="blanco">Posicionamiento</h1>
        <section>
            <h2>Relativo</h2>
        </section>

        <section>
            <h2>Fixed</h2>
            <p>Se queda fijo en la pantalla</p>
        </section>

        <section>
            <h2>Sticky - css3</h2>
            <div class="blockAuto width600">
                <pre><code>
                    position: sticky;
                    top: 0;</code></pre>
            </div>

        </section>

        <section>
            <h2>Absoluto</h2>
            <p> La posición de una caja se establece de forma absoluta respecto de su <mark>elemento contenedor</mark> y
                el resto de
                elementos de la página ignoran la nueva posición del elemento</p>

            <div class="contenedor">
                <span class="absoluto">1</span>
                <img src="https://picsum.photos/200" alt="Picsum">

                <div class="texto">
                    <h3>titulo</h3>
                    <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Illo labore, aliquid ullam veniam
                        officia facilis perspiciatis, repellat quia, soluta accusamus modi nostrum nihil mollitia! Qui
                        voluptas ea magnam enim rem.</p>
                </div>
            </div>
            <div class="blockAuto width600">
                <pre><code>
                        .contenedor {
                            /* siempre acordarse relative el contenedor */
                            position: relative;
                            width: 400px;
                            height: 400px;
                            margin: auto;
                            overflow: hidden;
                        }
                        .absoluto {
                            /* posicionamos de forma absoluta sobre el contenedor */
                            position: absolute;
                            right: 15px;
                            top: 15px;
                            background-color: red;
                            border-radius: 50px;
                            padding: 10px;
                            color: white;
                        }
                        .contenedor:hover .texto {
                            bottom: 0;
                        }
                        .contenedor .texto {
                            transition: bottom 2s ease;
                            background-color: rgba(0, 0, 0, 0.301);
                            position: absolute;
                            bottom: -130px;
                        }
                    </code></pre>
            </div>
        </section>

        <button onclick="topFunction()" id="botonIrTop" title="Go to top">Top</button>
    </main>
<%@include file="/includes/footer.jsp" %>
<%@include file="/includes/pie.jsp" %>