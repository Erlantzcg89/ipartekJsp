<%
	String titulo = "Selectores Html Avanzados";
%>

<%@include file="/includes/cabecera.jsp" %>

    <style>
        p.prueba {
            border: 1px solid teal;
            padding: 20px;
        }

        p {
            /* border: 1px solid teal; */
            padding: 10px;
        }

        span {
            border: 3px dotted red;
            padding: 5px;
        }

        dl {
            margin: 50px 0px;
        }

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

    <nav class="menu" id="menu">
        <a href="index.jsp">Inicio</a>
        <a href="ejemplos/html/index.jsp">Volver a ejercicios Html</a>
    </nav>

    <main>
        <h1 class="blanco">Visualización</h1>
        <section>
            <h2>Box Model</h2>
            <p class="prueba">Toda etiqueta de html tiene una estructura de caja</p>
            <img id="imagenBoxModel" src="images/box-model.PNG" alt="Box-model">

        </section>

        <section>
            <h2>Display</h2>
            <p>Display es el atributo para gestionar si es linea o bloque</p>
            <p>* usar inspector para ver los atributos</p>
            <dl>
                <div class="dl">
                    <dt>Block</dt>
                    <dd>Elemento que ocupa todo el ancho del elemento padre</dd>
                </div>
                <div class="dl">
                    <dt>Inline</dt>
                    <dd>Elemento que ocupa todo lo que tenga su contenido</dd>
                </div>
                <div>
                    <dt>Inline block</dt>
                    <dd>Hibrido de los dos anteriores</dd>
                </div>
            </dl>
            <p>Lorem ipsum <span>sit amet consectetur adipisicing</span> elit. Tempora tempore commodi accusantium!
                Dolores
                nisi
                similique dolore animi molestias, porro aperiam inventore cupiditate, a optio asperiores quos reiciendis
                commodi, repudiandae praesentium.</p>
            <div class="box">1</div>
            <div class="box">2</div>
        </section>

        <section>
            <h2>Visibility</h2>
            <p>Existen dos formas de ocultar elementos de html</p>
            <p>Usando <code>visibility: hidden</code></p>
            <div class="box">1</div>
            <div class="box" style="visibility: hidden;">2</div>
            <div class="box">3</div>
            <p>Usando <code>display: none</code></p>
            <div class="box">1</div>
            <div class="box" style="display: none;">2</div>
            <div class="box">3</div>
        </section>

        <section>
            <h2>Overflow</h2>
            <p>Como se muestra cuando no entra en el contenedor padre <code>visible | hidden | scroll | auto</code></p>
            <p>Tambien se puede usar <code>overflow-x | overflow-y</code></p>
            <div class="box-texto" style="overflow: hidden;">
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Illum earum, odio cum dolorem assumenda
                    aspernatur minus quia, deserunt natus voluptatem vero a laudantium possimus impedit? Facilis libero
                    eligendi nam cumque?</p>
            </div>
            <div class="box-texto" style="overflow:scroll;">
                <p>Iure autem sunt enim, unde itaque quae suscipit aperiam! Tenetur consequuntur, praesentium minima at
                    aperiam expedita officiis doloremque vitae dolorum quo, reprehenderit fugit earum asperiores. Sequi
                    eveniet ex at dolores.</p>
            </div>
            <div class=" box-texto" style="overflow:auto;">
                <p>Eveniet, adipisci libero iste non ullam molestias inventore impedit veniam, ipsam tenetur reiciendis
                    deleniti possimus officiis quo velit fugit dolores eligendi? Quia aliquid officiis iusto accusamus
                    laudantium fugit, eius minus?</p>
            </div>
            <div class="box-texto" style="overflow:visible;">
                <p>Exercitationem saepe libero delectus sapiente, optio laboriosam mollitia repellat quam consequuntur
                    sunt enim sed blanditiis et doloribus itaque id recusandae commodi autem, quo consequatur
                    voluptatibus quisquam officiis necessitatibus adipisci? Repellat?</p>
            </div>
        </section>

        <section>
            <h2>Z-Index</h2>
            <p>Se encarga de la profundidad de los elementos cuando se solapan</p>
            <div class="box">1</div>
            <div class="box" style="z-index:5; position:relative; left:50px; top: -20px; background-color:red;">2</div>
            <div class="box" style="z-index:10; position: relative;">3</div>
        </section>

        <button onclick="topFunction()" id="botonIrTop" title="Go to top">Top</button>
    </main>
<%@include file="/includes/footer.jsp" %>
<%@include file="/includes/pie.jsp" %>