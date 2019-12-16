<%@ page errorPage="errores/error500.jsp" %>

<%
	String titulo = "CMS Jsp y Bootstrap";
%>

<%@include file="/includes/cabecera.jsp"%>
<%@include file="/includes/enlacesDatatable.jsp"%>
<%@include file="/includes/enlacesCustom.jsp"%>
<%@include file="/includes/menuIndex.jsp"%>
<%@include file="/includes/submenu.jsp"%>

 <!-- sección principal con 12 tarjetas de productos -->
    <main class="container-fluid pb-4">

        <!-- La distribución de los items se hace mediante display flex:
            - en formato movil se muestran los items en una columna de 1
            - en formato tablet y pc los items se muestran en líneas de 5 -->
        <div class="contenedor-flex">
            <div class="item">
                <!-- Las tarjetas con la clase descuento tienen una variación en el diseño -->
                <div class="tarjeta descuento">
                    <div class="tarjeta-descuento-porcentaje">20%</div>
                    <div class="tarjeta-imagen">
                        <img src="images/befeater.jpg" alt="Producto Beefeater">
                    </div>
                    <div class="tarjeta-precio">
                        <span>13,35&#8364;</span><span>12,95&#8364;</span>
                        <span>(18,59&#8364;/Litro)</span>
                    </div>
                    <div class="tarjeta-descripcion">
                        <p>BEEFEATER ginebra inglesa botella 70 cl</p>
                    </div>
                    <div class="tarjeta-cantidad">
                        <div class="tarjeta-cantidad-controls">
                            <span><a href="#">-</a></span>
                            <span>1</span>
                            <span><a href="#">+</a></span>
                        </div>
                    </div>
                    <div class="tarjeta-boton">
                        <a href="#"><span>AÑADIR AL CARRO</span></a>
                    </div>
                </div>
            </div>

            <div class="item">
                <div class="tarjeta">
                    <div class="tarjeta-imagen">
                        <img src="images/befeater.jpg" alt="Producto Beefeater">
                    </div>
                    <div class="tarjeta-precio">
                        <span>7.90&#8364;</span>
                        <span>(18,59&#8364;/Litro)</span>
                    </div>
                    <div class="tarjeta-descripcion">
                        <p>BEEFEATER ginebra inglesa botella 70 cl</p>
                    </div>
                    <div class="tarjeta-cantidad">
                        <div class="tarjeta-cantidad-controls">
                            <span><a href="#">-</a></span>
                            <span>1</span>
                            <span><a href="#">+</a></span>
                        </div>
                    </div>
                    <div class="tarjeta-boton">
                        <a href="#"><span>AÑADIR AL CARRO</span></a>
                    </div>
                </div>
            </div>

            <div class="item">
                <div class="tarjeta">
                    <div class="tarjeta-imagen">
                        <img src="images/befeater.jpg" alt="Producto Beefeater">
                    </div>
                    <div class="tarjeta-precio">
                        <span>7.90&#8364;</span>
                        <span>(18,59&#8364;/Litro)</span>
                    </div>
                    <div class="tarjeta-descripcion">
                        <p>BEEFEATER ginebra inglesa botella 70 cl</p>
                    </div>
                    <div class="tarjeta-cantidad">
                        <div class="tarjeta-cantidad-controls">
                            <span><a href="#">-</a></span>
                            <span>1</span>
                            <span><a href="#">+</a></span>
                        </div>
                    </div>
                    <div class="tarjeta-boton">
                        <a href="#"><span>AÑADIR AL CARRO</span></a>
                    </div>
                </div>
            </div>

            <div class="item">
                <div class="tarjeta descuento">
                    <div class="tarjeta-descuento-porcentaje">20%</div>
                    <div class="tarjeta-imagen">
                        <img src="images/befeater.jpg" alt="Producto Beefeater">
                    </div>
                    <div class="tarjeta-precio">
                        <span>13,35&#8364;</span><span>12,95&#8364;</span>
                        <span>(18,59&#8364;/Litro)</span>
                    </div>
                    <div class="tarjeta-descripcion">
                        <p>BEEFEATER ginebra inglesa botella 70 cl</p>
                    </div>
                    <div class="tarjeta-cantidad">
                        <div class="tarjeta-cantidad-controls">
                            <span><a href="#">-</a></span>
                            <span>1</span>
                            <span><a href="#">+</a></span>
                        </div>
                    </div>
                    <div class="tarjeta-boton">
                        <a href="#"><span>AÑADIR AL CARRO</span></a>
                    </div>
                </div>
            </div>

            <div class="item">
                <div class="tarjeta descuento">
                    <div class="tarjeta-descuento-porcentaje">20%</div>

                    <div class="tarjeta-imagen">
                        <img src="images/befeater.jpg" alt="Producto Beefeater">
                    </div>
                    <div class="tarjeta-precio">
                        <span>13,35&#8364;</span><span>12,95&#8364;</span>
                        <span>(18,59&#8364;/Litro)</span>
                    </div>
                    <div class="tarjeta-descripcion">
                        <p>BEEFEATER ginebra inglesa botella 70 cl</p>
                    </div>
                    <div class="tarjeta-cantidad">
                        <div class="tarjeta-cantidad-controls">
                            <span><a href="#">-</a></span>
                            <span>1</span>
                            <span><a href="#">+</a></span>
                        </div>
                    </div>
                    <div class="tarjeta-boton">
                        <a href="#"><span>AÑADIR AL CARRO</span></a>
                    </div>
                </div>
            </div>

            <div class="item">
                <div class="tarjeta">
                    <div class="tarjeta-imagen">
                        <img src="images/befeater.jpg" alt="Producto Beefeater">
                    </div>
                    <div class="tarjeta-precio">
                        <span>7.90&#8364;</span>
                        <span>(18,59&#8364;/Litro)</span>
                    </div>
                    <div class="tarjeta-descripcion">
                        <p>BEEFEATER ginebra inglesa botella 70 cl</p>
                    </div>
                    <div class="tarjeta-cantidad">
                        <div class="tarjeta-cantidad-controls">
                            <span><a href="#">-</a></span>
                            <span>1</span>
                            <span><a href="#">+</a></span>
                        </div>
                    </div>
                    <div class="tarjeta-boton">
                        <a href="#"><span>AÑADIR AL CARRO</span></a>
                    </div>
                </div>
            </div>

            <div class="item">
                <div class="tarjeta descuento">
                    <div class="tarjeta-descuento-porcentaje">20%</div>
                    <div class="tarjeta-imagen">
                        <img src="images/befeater.jpg" alt="Producto Beefeater">
                    </div>
                    <div class="tarjeta-precio">
                        <span>13,35&#8364;</span><span>12,95&#8364;</span>
                        <span>(18,59&#8364;/Litro)</span>
                    </div>
                    <div class="tarjeta-descripcion">
                        <p>BEEFEATER ginebra inglesa botella 70 cl</p>
                    </div>
                    <div class="tarjeta-cantidad">
                        <div class="tarjeta-cantidad-controls">
                            <span><a href="#">-</a></span>
                            <span>1</span>
                            <span><a href="#">+</a></span>
                        </div>
                    </div>
                    <div class="tarjeta-boton">
                        <a href="#"><span>AÑADIR AL CARRO</span></a>
                    </div>
                </div>
            </div>

            <div class="item">
                <div class="tarjeta">
                    <div class="tarjeta-imagen">
                        <img src="images/befeater.jpg" alt="Producto Beefeater">
                    </div>
                    <div class="tarjeta-precio">
                        <span>7.90&#8364;</span>
                        <span>(18,59&#8364;/Litro)</span>
                    </div>
                    <div class="tarjeta-descripcion">
                        <p>BEEFEATER ginebra inglesa botella 70 cl</p>
                    </div>
                    <div class="tarjeta-cantidad">
                        <div class="tarjeta-cantidad-controls">
                            <span><a href="#">-</a></span>
                            <span>1</span>
                            <span><a href="#">+</a></span>
                        </div>
                    </div>
                    <div class="tarjeta-boton">
                        <a href="#"><span>AÑADIR AL CARRO</span></a>
                    </div>
                </div>
            </div>

            <div class="item">
                <div class="tarjeta">
                    <div class="tarjeta-imagen">
                        <img src="images/befeater.jpg" alt="Producto Beefeater">
                    </div>
                    <div class="tarjeta-precio">
                        <span>7.90&#8364;</span>
                        <span>(18,59&#8364;/Litro)</span>
                    </div>
                    <div class="tarjeta-descripcion">
                        <p>BEEFEATER ginebra inglesa botella 70 cl</p>
                    </div>
                    <div class="tarjeta-cantidad">
                        <div class="tarjeta-cantidad-controls">
                            <span><a href="#">-</a></span>
                            <span>1</span>
                            <span><a href="#">+</a></span>
                        </div>
                    </div>
                    <div class="tarjeta-boton">
                        <a href="#"><span>AÑADIR AL CARRO</span></a>
                    </div>
                </div>
            </div>

            <div class="item">
                <div class="tarjeta">
                    <div class="tarjeta-imagen">
                        <img src="images/befeater.jpg" alt="Producto Beefeater">
                    </div>
                    <div class="tarjeta-precio">
                        <span>7.90&#8364;</span>
                        <span>(18,59&#8364;/Litro)</span>
                    </div>
                    <div class="tarjeta-descripcion">
                        <p>BEEFEATER ginebra inglesa botella 70 cl</p>
                    </div>
                    <div class="tarjeta-cantidad">
                        <div class="tarjeta-cantidad-controls">
                            <span><a href="#">-</a></span>
                            <span>1</span>
                            <span><a href="#">+</a></span>
                        </div>
                    </div>
                    <div class="tarjeta-boton">
                        <a href="#"><span>AÑADIR AL CARRO</span></a>
                    </div>
                </div>
            </div>

            <div class="item">
                <div class="tarjeta">
                    <div class="tarjeta-imagen">
                        <img src="images/befeater.jpg" alt="Producto Beefeater">
                    </div>
                    <div class="tarjeta-precio">
                        <span>7.90&#8364;</span>
                        <span>(18,59&#8364;/Litro)</span>
                    </div>
                    <div class="tarjeta-descripcion">
                        <p>BEEFEATER ginebra inglesa botella 70 cl</p>
                    </div>
                    <div class="tarjeta-cantidad">
                        <div class="tarjeta-cantidad-controls">
                            <span><a href="#">-</a></span>
                            <span>1</span>
                            <span><a href="#">+</a></span>
                        </div>
                    </div>
                    <div class="tarjeta-boton">
                        <a href="#"><span>AÑADIR AL CARRO</span></a>
                    </div>
                </div>
            </div>

            <div class="item">
                <div class="tarjeta">
                    <div class="tarjeta-imagen">
                        <img src="images/befeater.jpg" alt="Producto Beefeater">
                    </div>
                    <div class="tarjeta-precio">
                        <span>7.90&#8364;</span>
                        <span>(18,59&#8364;/Litro)</span>
                    </div>
                    <div class="tarjeta-descripcion">
                        <p>BEEFEATER ginebra inglesa botella 70 cl</p>
                    </div>
                    <div class="tarjeta-cantidad">
                        <div class="tarjeta-cantidad-controls">
                            <span><a href="#">-</a></span>
                            <span>1</span>
                            <span><a href="#">+</a></span>
                        </div>
                    </div>
                    <div class="tarjeta-boton">
                        <a href="#"><span>AÑADIR AL CARRO</span></a>
                    </div>
                </div>
            </div>
        </div>

    </main>



<%@include file="/includes/footer-fixed.jsp"%>
<%@include file="/includes/scriptsMain.jsp"%>
<%@include file="/includes/scriptsDatatable.jsp"%>
<%@include file="/includes/pie.jsp"%>