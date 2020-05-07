package modelos;

import java.util.Date;

public class Persona {
    private int idPersona;
    private String nombre;
    private String apPaterno;
    private String apMaterno;    
    private String fechaNac;
    private String sexo;
    private String rfc;
    private String foto;
    private String celular;
    private String tipo;
    private String nacionalidad;
    private String estatus; 
    private Domicilio domi;
    

    public Persona() {
    }

    public Persona(int idPersona, String nombre, String apPaterno, String apMaterno, String fechaNac, String sexo, String rfc, String foto, String celular, String tipo, String nacionalidad, String estatus, Domicilio domi) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.fechaNac = fechaNac;
        this.sexo = sexo;
        this.rfc = rfc;
        this.foto = foto;
        this.celular = celular;
        this.tipo = tipo;
        this.nacionalidad = nacionalidad;
        this.estatus = estatus;
        this.domi = domi;
    }

    public Persona(int idPersona) {
        this.idPersona = idPersona;
    }

    public Persona(String nombre, String apPaterno, String apMaterno, String fechaNac, String sexo, String rfc, String foto, String celular, String tipo, String nacionalidad, String estatus) {
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.fechaNac = fechaNac;
        this.sexo = sexo;
        this.rfc = rfc;
        this.foto = foto;
        this.celular = celular;
        this.tipo = tipo;
        this.nacionalidad = nacionalidad;
        this.estatus = estatus;
        
    }

    public Persona(int idPersona, String nombre, String apPaterno, String apMaterno, String fechaNac, String sexo, String rfc, String foto, String celular, String tipo, String nacionalidad, String estatus) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.fechaNac = fechaNac;
        this.sexo = sexo;
        this.rfc = rfc;
        this.foto = foto;
        this.celular = celular;
        this.tipo = tipo;
        this.nacionalidad = nacionalidad;
        this.estatus = estatus;        
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
    public Domicilio getDomi(){
        return this.domi; 
    }
    
    public void setDomi(Domicilio domi){
        this.domi = domi;
    }
    
    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", apPaterno=" + apPaterno + ", apMaterno=" + apMaterno + ", fechaNac=" + fechaNac + ", sexo=" + sexo + ", rfc=" + rfc + ", foto=" + foto + ", celular=" + celular + ", tipo=" + tipo + ", nacionalidad=" + nacionalidad + ", estatus=" + estatus + ", domi=" + domi;
    }

              
}
