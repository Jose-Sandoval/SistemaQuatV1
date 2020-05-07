<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es-MX"></fmt:setLocale>

<section id="personas">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">                        
                        <form action="${pageContext.request.contextPath}/PersonaServlet?accion=buscar"class="form-inline my-2 my-lg-0" method="post" >
                            <input type="search" name="buscar" class="form-contro mr-sm-2" placeholder="Buscar Persona"/>
                            <button class="btn btn-success my-2 my-sm-0" type="submit">Buscar      
                            </button>
                        </form>                        
                    </div>
                    <table class="table table-stiped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>ID</th>
                                <th>nombre</th>
                                <th>telefono</th>
                                <th>tipo</th>
                                <th>fecha de nacimiento</th>
                                <th>Domicilio</th>
                                <th></th>
                            </tr>                            
                        </thead> 
                        <tbody>
                            <!--iteramos la lista de personas-->
                        <c:forEach var="persona" items="${personas}" varStatus="status">
                                <tr>
                                    <th>${status.count}</th>
                                    <th>${persona.idPersona}</th>
                                    <th>${persona.nombre} ${persona.apPaterno}</th>
                                    <th>${persona.celular}</th>
                                    <th>${persona.tipo}</th>
                                    <th>${persona.fechaNac}</th>    
                                    <th>${persona.domi.calle} ${persona.domi.numero} ${persona.domi.colonia}</th> 
                                    <th class="form-group">
                                        <div class="btn-group btn-group-toggle" data-toggle="buttons">                                          
                                            <a href="${pageContext.request.contextPath}/PersonaServlet?accion=info&idPersona=${persona.idPersona}"
                                               class="btn btn-info"><i class="fas fa-info-circle"></i>Info
                                            </a>
                                            <a href="${pageContext.request.contextPath}/PersonaServlet?accion=eliminar&idPersona=${persona.idPersona}"
                                               class="btn btn-danger"><i class="fas fa-trash-alt"></i>Eliminar
                                            </a>                                          
                                        </div>
                                    </th>
                                </tr>                                 
                            </c:forEach>
                        </tbody>
                    </table>
                </div>                
            </div> 
        </div>
    </div>
</section>
<!--Agregar Personas Modal-->   
<%@include file="agregarPersona.jsp"%>