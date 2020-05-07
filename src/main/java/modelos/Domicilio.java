package modelos;

public class Domicilio {
    
    private int idDomicilio;
    private int idPersona;
    private String calle;
    private String numero;
    private String colonia;        
    private String CP;
    private int idEstado;
    private int idMunDel;
    private String tipo;
    private String telefono;
    private String estatus;

    public Domicilio() {
    }

    public Domicilio(int idPersona) {
        this.idPersona = idPersona;
    }
    
    public Domicilio(int idPersona, String calle, String numero, String colonia, String CP, int idEstado, int idMunDel, String tipo, String telefono, String estatus) {
        this.idPersona = idPersona;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.CP = CP;
        this.idEstado = idEstado;
        this.idMunDel = idMunDel;
        this.tipo = tipo;
        this.telefono = telefono;
        this.estatus = estatus;
    }
    
    public Domicilio(int idDomicilio, int idPersona, String calle, String numero, String colonia, String CP, int idEstado, int idMunDel, String tipo, String telefono, String estatus) {
        this.idDomicilio = idDomicilio;
        this.idPersona = idPersona;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.CP = CP;
        this.idEstado = idEstado;
        this.idMunDel = idMunDel;
        this.tipo = tipo;
        this.telefono = telefono;
        this.estatus = estatus;
    }

    public int getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(int idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCP() {
        return CP;
    }

    public void setCP(String CP) {
        this.CP = CP;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public int getIdMunDel() {
        return idMunDel;
    }

    public void setIdMunDel(int idMunDel) {
        this.idMunDel = idMunDel;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "Domicilio{" + "idDomicilio=" + idDomicilio + ", idPersona=" + idPersona + ", calle=" + calle + ", numero=" + numero + ", colonia=" + colonia + ", CP=" + CP + ", idEstado=" + idEstado + ", idMunDel=" + idMunDel + ", tipo=" + tipo + ", telefono=" + telefono + ", estatus=" + estatus + '}';
    }
    
}
