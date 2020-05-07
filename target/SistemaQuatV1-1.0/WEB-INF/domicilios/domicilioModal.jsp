
<div class="modal fade" id="editarDomicilioModal">
    <div class="modal-dialog modal-md">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Editar Domicilio</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            <form action="${pageContext.request.contextPath}/DomicilioServlet?accion=editar" method="post" class="was-validated">
                <div class="modal-body">                    
                    <section id="actions" class="py-4 mb-4 bg-light" >
                        <h4>Datos Domicilio</h4>
                        <input type="text" hidden="true" name="idPersona" value="${domicilio.idPersona}"/>                        
                        <div class="container">                            
                            <div class="form-group">    
                                <label for="calle">Calle</label>
                                <input type="text" class="form-control" name="calle" value="${domicilio.calle}"/>      
                            </div>
                            <div class="form-group">    
                                <label for="numero">Numero</label>
                                <input type="number" class="form-control" name="numero" value="${domicilio.numero}"/>      
                            </div>
                            <div class="form-group">    
                                <label for="colonia">Colonia</label>
                                <input type="text" class="form-control" name="colonia" value="${domicilio.colonia}"/>      
                            </div>
                            <div class="form-group">    
                                <label for="cp">Codigo Postal</label>
                                <input type="text" class="form-control" name="cp" value="${domicilio.CP}"/>      
                            </div>
                            <div class="form-group">    
                                <label for="edo">Estado</label>
                                <input type="number" class="form-control" name="edo" value="${domicilio.idEstado}"/>      
                            </div>
                            <div class="form-group">    
                                <label for="muni">Alcaldia/Municipio</label>
                                <input type="number" class="form-control" name="muni" value="${domicilio.idMunDel}"/>      
                            </div>
                            <div class="form-group">    
                                <label for="tipo">Tipo</label>
                                <input type="text" class="form-control" name="tipo" value="${domicilio.tipo}"/>      
                            </div>
                            <div class="form-group">    
                                <label for="tel">Telefono</label>
                                <input type="tel" class="form-control" name="tel" value="${domicilio.telefono}"/>      
                            </div>                                                          
                        </div>
                        
                    </section>  
                    <button type="submit" class="btn btn-success">Guargar</button>                     
                </div>                                
            </form>
        </div>
    </div>
</div>