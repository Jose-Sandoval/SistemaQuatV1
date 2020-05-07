
<div class="modal fade" id="editarPersonaModal">
    <div class="modal-dialog modal-md">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Edditar Persona</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            <form action="${pageContext.request.contextPath}/PersonaServlet?accion=editar" method="post" class="was-validated">
                <div class="modal-body">
                    <section id="actions" class="py-4 mb-4 bg-light" >
                        <div class="container">
                            <h4>Datos Persona</h4>
                            <input type="text"value="${persona.idPersona}" name="idPersona" hidden="true"/>
                            <div class="form-group">
                                <label for="nombre">Nombre</label>
                                <input type="text" class="form-control" name="nombre" value="${persona.nombre}"required/>

                                <label for="apParterno">Apellido Paterno</label>
                                <input type="text" class="form-control" name="apPaterno" value="${persona.apPaterno}"required/>

                            </div>
                            <div class="form-group">

                                <label for="apMaterno">Apellido Materno</label>
                                <input type="text" class="form-control" name="apMaterno" value="${persona.apMaterno}" required/>

                                <label for="fch_nacmiento">Fecha de Nacimiento</label>
                                <input type="date" class="form-control" name="fch_nacimiento" value="${persona.fechaNac}"/>  

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
                                <input type="text" class="form-control" name="rfc"value="${persona.rfc}" required/>                              

                            </div>   
                            <div class="form-group">

                                <label for="calular">Celular</label>
                                <input type="tel" class="form-control" name="celular"value="${persona.celular}"/>

                                <label for="foto">Foto</label>
                                <input type="text" class="form-control" name="foto"value="${persona.foto}"/>  

                            </div>  
                            <div class="form-group" name="sexo">    

                                <label for="estatus ">Estatus</label>
                                <input type="text" class="form-control" name="estatus" value="${persona.estatus}"required />                                

                            </div>  
                            <div class="form-group">

                                <label for="tipo">Tipo</label>
                                <input type="text" class="form-control" name="tipo" value="${persona.tipo}"required/>

                                <label for="nacionalidad">Nacionalidad</label>
                                <input type="text" class="form-control" name="nacionalidad"value="${persona.nacionalidad}" required/>                            

                            </div>                             
                        </div>
                    </section>
                    <button type="submit" class="btn btn-success">Guargar</button>                     
                </div>                                
            </form>
        </div>
    </div>
</div>