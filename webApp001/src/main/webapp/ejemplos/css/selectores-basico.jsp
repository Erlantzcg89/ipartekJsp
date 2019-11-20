<%
	String titulo = "Selectores básicos css";
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

    <nav class="menu" id="menu">
          <a href="index.jsp">Inicio</a>
        <a href="ejemplos/css/index.jsp">Volver</a>
    </nav>
    
    <main>

        <h1 class="blanco">Selectores Css Básico</h1>

        <section>
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
            <h2>Pseudoclases</h2>
            <ul>
                <li>active</li>
                <li>hover</li>
                <li>link</li>
                <li>visited</li>
                <li>nth-child()</li>
                <li>first/last-child</li>
            </ul>
        </section>

        <section>
            <h2>Selectores</h2>

            <p><code>Lorem ipsum dolor</code>, sit <span>consectetur adipisicing</span> elit. Cumque neque adipisci
                similique eaque
                ex esse atque beatae sunt nobis alias. Cumque ea aspernatur illo sapiente sint magnam quae aperiam
                alias.
            </p>
            <p>Eligendi quas <span>explicabo</span> provident vel, quaerat doloribus aut minima amet dolor a saepe ut
                ratione temporibus
                suscipit sunt ex atque perspiciatis? Dicta voluptatibus reprehenderit aliquam aspernatur? Rem tempora
                vero
                quisquam?</p>
            <p>Corporis soluta at, ex expedita nobis voluptates eaque quasi rerum saepe, ipsam sit omnis accusamus
                blanditiis
                in, tempore suscipit. <span class="especial">fugiat hic</span> quos ut dolore nisi aliquam a ad quas.
            </p>
            <p class="especial">Eaque doloremque unde magnam esse voluptate molestiae explicabo repellendus quod
                necessitatibus!
                Qui officia
                aspernatur et quibusdam corrupti illo impedit autem veritatis, consectetur optio sed. Veniam voluptates
                et
                maxime neque. Minima?</p>
            </div>
        </section>

        <section>
            <h2>Css Cheat-Sheet</h2><img src="images/csschuleta.png" alt="Chuleta de selectores css">
        </section>

        <button onclick="topFunction()" id="botonIrTop" title="Go to top">Top</button>
    </main>
<%@include file="/includes/footer.jsp" %>
<%@include file="/includes/pie.jsp" %>