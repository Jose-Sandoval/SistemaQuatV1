
<div class="modal fade" id="agregarPersonaModal">
    <div class="modal-dialog modal-md">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agrear Persona</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            <form action="${pageContext.request.contextPath}/PersonaServlet?accion=insertar" method="post" class="was-validated">
                <div class="modal-body">
                    <section id="actions" class="py-4 mb-4 bg-light" >
                        <div class="container">
                            <h4>Datos Persona</h4>
                            <div class="form-group">

                                <label for="nombre">Nombre</label>
                                <input type="text" class="form-control" name="nombre" required/>

                                <label for="apParterno">Apellido Paterno</label>
                                <input type="text" class="form-control" name="apPaterno" required/>

                            </div>
                            <div class="form-group">

                                <label for="apMaterno">Apellido Materno</label>
                                <input type="text" class="form-control" name="apMaterno" required/>

                                <label for="fch_nacmiento">Fecha de Nacimiento</label>
                                <input type="date" class="form-control" name="fch_nacimiento"/>  

                            </div>
                            <div class="form-group">

                                <label for="sexo">Sexo</label>
                                <div name="sexo" class="form-control"> 
                                    <label>Masculino</label>
                                    <input type="radio" name="genero" value="masculino" required/>
                                    <label> Femenino</label>
                                    <input type="radio" name="genero" value="femenino" required/>                        
                                </div>

                                <div><label for="rfc">RFC</label>
                                <input type="text" class="form-control" name="rfc" required/>                              

                            </div>   
                            <div class="form-group">

                                <label for="calular">Celular</label>
                                <input type="tel" class="form-control" name="celular"/>

                                <label for="foto">Foto</label>
                                <input type="text" class="form-control" name="foto"/>  

                            </div>  
                            <div class="form-group" name="sexo">    

                                <label for="estatus ">Estatus</label>
                                <input type="text" class="form-control" name="estatus" required />                                

                            </div>  
                            <div class="form-group">

                                <label for="tipo">Tipo</label>
                                <input type="text" class="form-control" name="tipo" required/>

                                <label for="nacionalidad">Nacionalidad</label>
                                <input type="text" class="form-control" name="nacionalidad" required/>                            

                            </div>                             
                        </div>
                    </section>
                    <section id="actions" class="py-4 mb-4 bg-light" >
                        <h4>Datos Domicilio</h4>
                        <div class="container">                            
                            <div class="form-group">    
                                <label for="calle">Calle</label>
                                <input type="text" class="form-control" name="calle"/>      
                            </div>
                            <div class="form-group">    
                                <label for="numero">Numero</label>
                                <input type="number" class="form-control" name="numero"/>      
                            </div>
                            <div class="form-group">    
                                <label for="colonia">Colonia</label>
                                <input type="text" class="form-control" name="colonia"/>      
                            </div>
                            <div class="form-group">    
                                <label for="cp">Codigo Postal</label>
                                <input type="text" class="form-control" name="cp"/>      
                            </div>
                            <div class="form-group">    
                                <label for="edo">Estado</label>
                                <input type="number" class="form-control" name="edo"/>      
                            </div>
                            <div class="form-group">    
                                <label for="muni">Alcaldia/Municipio</label>
                                <input type="number" class="form-control" name="muni"/>      
                            </div>
                            <div class="form-group">    
                                <label for="tipo">Tipo</label>
                                <input type="text" class="form-control" name="tipo"/>      
                            </div>
                            <div class="form-group">    
                                <label for="tel">Telefono</label>
                                <input type="tel" class="form-control" name="tel"/>      
                            </div>                                                          
                        </div>
                        
                    </section>  
                    <button type="submit" class="btn btn-success">Guargar</button>                     
                </div>                                
            </form>
        </div>
    </div>
</div>