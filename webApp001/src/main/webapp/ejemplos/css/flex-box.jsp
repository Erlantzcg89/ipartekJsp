<%
	String titulo = "Flex-box";
%>

<%@include file="/includes/cabecera.jsp" %>

   <style>
        .container {
            border: 5px solid black;
            margin: auto;

            /* flex-box */
            display: flex;
            flex-direction: row;
            flex-wrap: wrap;
        }

        .container div {
            border: 5px solid teal;
            background-color: pink;
            width: 50%;
            min-height: 80px;
            text-align: center;

            /* flex-box */
        }
    </style>

    <nav class="menu" id="menu">
        <a href="index.jsp">Inicio</a>
        <a href="ejemplos/css/index.jsp">Volver</a>
    </nav>

    <main>
        <h1 class="blanco">Flex-box</h1>

        <section>
            <h2>Guias de Flex-box</h2>
            <p>Flex es una nueva forma e <code>display</code> de css3, para que las cajas no sean inline o block. Se
                comportaran una nueva forma mucho más flexible</p>
            <p>Sirve para distribuir los elementos contenidos (hijos) en una etiqueta (contenedor) con
                <code>display:flex</code></p>
            <div class="blockAuto width600">
                <ul>
                    <li><a target="_blank" href="https://css-tricks.com/snippets/css/a-guide-to-flexbox/">Guía
                            flex-box</a>
                    </li>
                    <li><a target="_blank"
                            href="http://www.falconmasters.com/web-design/sitio-web-layout-flexbox/">Maquetar con
                            flex-box</a></li>
                    <li><a target="_blank" href="https://flexboxfroggy.com/#es">Juego flex-box</a></li>
                </ul>
            </div>
            <div class="container">
                <div>
                    <p>hijo 1</p>
                </div>
                <div>
                    <p>hijo 2</p>
                </div>
                <div>
                    <p>hijo 3</p>
                </div>
                <div>
                    <p>hijo 4</p>
                </div>
                <div>
                    <p>hijo 5</p>
                </div>
                <div>
                    <p>hijo 6</p>
                </div>
            </div>
        </section>

        <section>
            <h2>Flex axis</h2>
            <div class="blockAuto width600"><img src="images/flex-axes.png" alt="flex-axis"></div>
        </section>
        
        		<button onclick="topFunction()" id="botonIrTop" title="Go to top">Top</button>
    </main>

    <%@include file="/includes/footer.jsp" %>
    <%@include file="/includes/pie.jsp" %>