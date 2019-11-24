<%
	String titulo = "Etiquetas Básicas Html";
%>

<%@include file="/includes/cabecera.jsp" %>
<%@include file="/includes/navegacion.jsp" %>

    <main>
        <h1 class="blanco">Etiquetas b&aacute;sicas</h1>

        <section>
            <h2>&lt;progress&gt; & &lt;meter&gt;</h2>
            <div class="blockAuto width600">
                <ul>
                    <li><progress max="100" value="80"></progress><span> progress Máx=100 value=80</span></li>
                    <li><meter value="2" min="0" max="10">2 out of 10</meter><span> Meter 2-10</span>
                    </li>
                    <li><meter value="0.6">60%</meter><span> Meter 60%</span>
                    </li>
                </ul>

            </div>
        </section>

        <section>
            <h2>Iframe Youtube</h2>
            <iframe class="blockAuto" width="560" height="315" src="https://www.youtube.com/embed/seaq4UxKNHU"
                frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
                allowfullscreen></iframe>
        </section>

        <section>
            <h2>Listas &lt;ul&gt;, &lt;ol&gt;, &lt;dl&gt;</h2>
            <div class="blockAuto width600">
                <ul>
                    <li>Item sin ordenar 1</li>
                    <li>Item sin ordenar 2</li>
                    <li>Item sin ordenar 3</li>
                </ul>
                <ol>
                    <li>Item ordenado 1</li>
                    <li>Item ordenado 2</li>
                    <li>Item ordenado 3</li>
                </ol>
                <dl>
                    <dt>Beast of Bodmin</dt>
                    <dd>A large feline inhabiting Bodmin Moor.</dd>

                    <dt>Morgawr</dt>
                    <dd>A sea serpent.</dd>

                    <dt>Owlman</dt>
                    <dd>A giant owl-like creature.</dd>
                </dl>
            </div>

        </section>

        <section>
            <h2>Enlaces</h2>
            <nav class="blockAuto width600">
            	<ul>
            		<li><a href="tel:685456544">685 456 544</a></li>
                	<li><a target="_blank" href="https://htmlcheatsheet.com/js/">Cheat Sheets</a></li>
                	<li><a target="_blank" href="https://www.rapidtables.com/web/html/html-codes.html">Carácteres en html</a></li>
                	<li><a target="_blanck" href="http://html5pattern.com/">Patterns Html5 para Forms</a></li>
                	<li><a target="_blanck" href="https://datatables.net/">Pluggin para tablas</a></li>
                	
                	
                	
                </ul>
            </nav>
        </section>

        <section>
            <h2>&lt;code&gt; + &lt;pre&gt;</h2>
            <div class="blockAuto width600">
                <pre><code>function Panel(element, canClose, closeHandler) {
                    this.element = element;
                    this.canClose = canClose;
                    this.closeHandler = function () { if (closeHandler) closeHandler() };
                  }</code></pre>
            </div>

        </section>

        <section>
            <h2>Tachar texto por css</h2>
            <p class="textoTachado">Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolorem mollitia,
                temporibus
                enim
                odit autem similique iste iusto sequi vitae itaque libero et culpa laborum repellat fuga ipsa tenetur
                nihil
                quidem!</p>
        </section>

        <section>
            <h2 id="colorCambiar">Botón que llama a javascript + &lt;noscript&gt;</h2>
            <button class="blockAuto" onclick="cambiarColor()">Cambiar color h2</button>
        </section>

        <section>
            <h2>Html5 Cheat-Sheet</h2>
            <img src="images/html5-cheat-sheet.png" alt="Cheat-Sheet de html 5">
        </section>

        <button onclick="topFunction()" id="botonIrTop" title="Go to top">Top</button>
    </main>
<%@include file="/includes/footer.jsp" %>
<%@include file="/includes/pie.jsp" %>