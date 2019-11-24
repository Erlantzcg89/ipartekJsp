<%
	String titulo = "Font-awesome";
%>

<%@include file="/includes/cabecera.jsp" %>  
<%@include file="/includes/navegacion.jsp" %> 
 
   <style>
        .divIcono {
            text-align: center;
        }

        .huellaPerro {
            font-size: 120px;
        }

        .plumaBlanca {
            font-size: 80px;
            color: white;
        }
    </style>

    <main>
        <h1 class="blanco"><span class=".plumaBlanca fas fa-feather"></span> Font-awesome</h1>
        <section>
            <h2>Ejemplos</h2>
            <p>Aquí encontrarás ejemplos de como utilizar las imágenes vectoriales en las aplicaciones web</p>
            <div><span class="huellaPerro fas fa-paw"></span></div>
            <p><code>fas fa-feather | fas fa-paw</code></p>
            <pre><code>
                    .huellaPerro {
                        font-size: 120px;
            
                    }
            
                    .plumaBlanca {
                        font-size: 80px;
                        color: white;
                    }
                </code></pre>

        </section>
        <button onclick="topFunction()" id="botonIrTop" title="Go to top">Top</button>
    </main>
<%@include file="/includes/footer.jsp" %>
<%@include file="/includes/pie.jsp" %>