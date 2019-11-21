<%
	String titulo = "Especificidad de los estilos css";
%>

<%@include file="/includes/cabecera.jsp" %>

      <style>
        p {
            color: teal;
        }

        .container p span {
            background-color: purple;
        }

        code {
            background-color: lightgrey;
            color: green;
        }

        p .especial {
            font-size: 2em;
            font-weight: 600;
        }

        p.especial {
            color: purple;
            background-color: white;
        }
    </style>

 <div class="menuWrapper">
     <nav class="menu" id="menu">
          <a href="index.jsp">Inicio</a>
        <a href="ejemplos/css/index.jsp">Volver</a>
    </nav>
</div>

    <main>
        <h1 class="blanco">Especificidad</h1>

        <section>
            <h2>Ejemplo de especificidad de los css</h2>
            <p>el orden es !important>id>class, y el último en definirse es el que sobreescribe</p>
            <p style="color:red; font-size:20px;">Lorem ipsum, dolor sit amet consectetur adipisicing elit. Pariatur
                ipsa
                blanditiis similique repellendus natus? Asperiores dolorem nesciunt beatae velit neque, placeat nulla
                numquam
                aliquam quisquam! Velit necessitatibus minus quos illum!</p>
            <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Mollitia quam dolorum aliquid vel quidem quod
                iure
                et
                suscipit id deserunt quae consectetur, facere tempore doloremque. Odio molestiae cumque voluptas itaque!
            </p>
            <p>Necessitatibus itaque quisquam perferendis recusandae consequatur ut doloremque! Obcaecati nulla voluptas
                alias
                reprehenderit voluptatum corrupti ratione, culpa harum ipsam quia labore illo quas similique architecto
                voluptates laborum sequi velit consequatur?</p>
            <p>Aspernatur inventore, eveniet odio itaque voluptas quasi aliquid culpa assumenda quaerat, quas eligendi
                omnis
                velit quia asperiores reiciendis fugit commodi amet aliquam libero nisi! Repellendus tempore ullam
                architecto
                praesentium illo.</p>
            <p>Eligendi quas <span>explicabo</span> provident vel, quaerat doloribus aut minima amet dolor a saepe ut
                ratione temporibus
                suscipit sunt ex atque perspiciatis? Dicta voluptatibus reprehenderit aliquam aspernatur? Rem tempora
                vero
                quisquam?</p>
        </section>

        <button onclick="topFunction()" id="botonIrTop" title="Go to top">Top</button>
    </main>
<%@include file="/includes/footer.jsp" %>
<%@include file="/includes/pie.jsp" %>