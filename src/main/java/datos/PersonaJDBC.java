package datos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Domicilio;
import modelos.Persona;

public class PersonaJDBC {
        
    private static final String SQL_SELECT = "SELECT * FROM persona";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM persona WHERE persona_id = ?";
    private static final String SQL_SELECT_BY_RFC = "SELECT persona_id FROM persona WHERE rfc=?";
    private static final String SQL_SELECT_PERSONA_DOMICILIO = "SELECT * FROM persona AS p INNER JOIN domicilio  AS d ON p.Persona_id = d.persona_id WHERE d.estatus = 'activo'";    
    private static final String SQL_INSERT  = "INSERT INTO persona (nombre, ap_Materno, ap_Paterno, fch_nacimiento, sexo, rfc, foto, celular, tipo, nacionalidad, estatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre=?, ap_Materno=?, ap_Paterno=?, fch_nacimiento=?, sexo=?, rfc=?, foto=?, celular=?, tipo=?, nacionalidad=?, estatus=? WHERE persona_id=?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE persona_id=?";
    private static final String SQL_DELETE_DOM = "DELETE FROM domicilio WHERE persona_id=?";    
    
    public List<Persona> search(String buscar ){
        System.out.println("ENTRO A BUSCAR PALABRA PERSONA");
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs =null;
        List<Persona> personas = new ArrayList();        
        String sql_select_search = "SELECT * FROM persona WHERE (nombre LIKE '%"+buscar+"%') or  (ap_paterno like '%"+buscar+"%') or"
            + "(ap_materno LIKE '%"+buscar+"%') or (fch_nacimiento LIKE '%"+buscar+"%') or (sexo LIKE '%"+buscar+"%') or (rfc LIKE '%"+buscar+"%') "+
            "or (celular LIKE '%"+buscar+"%') or (tipo LIKE '%"+buscar+"%') or (nacionalidad LIKE '%"+buscar+"%') or (estatus LIKE '%"+buscar+"%')";
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql_select_search);
            rs = stmt.executeQuery();
            while(rs.next()){
                Persona persona = new Persona(rs.getInt("persona_id"),
                        rs.getString("nombre"),rs.getString("ap_Materno"),
                        rs.getString("ap_Paterno"),rs.getString("fch_nacimiento"),
                        rs.getString("sexo"), rs.getString("rfc"),rs.getString("foto"),
                        rs.getString("celular"),rs.getString("tipo"),rs.getString("nacionalidad"),
                        rs.getString("estatus"));
                personas.add(persona);                
            }
        } catch (SQLException e) {  
            System.out.println("ERROR DE SEARCH PERSONA");
            e.printStackTrace(System.out);
        }finally{
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return personas;
    }
    
    public int obtenerId(String rfc){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int personaId = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_RFC);
            stmt.setString(1, rfc);
            rs = stmt.executeQuery();
            rs.absolute(1);
            personaId = rs.getInt("persona_id");
            System.out.println(personaId);
        } catch (SQLException e) {
            System.out.println("ERROR DE SELECT RFC");
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
            e.printStackTrace(System.out);
        }finally{
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }        
        return personaId;
    }
    
    public List<Persona> getPerDom(){        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;        
        List <Persona> personas = new ArrayList();
        List <Domicilio> domicilios = new ArrayList();
        try {            
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_PERSONA_DOMICILIO);
            rs = stmt.executeQuery();            
            while(rs.next()){
                Domicilio domicilio = new Domicilio(rs.getInt("domicilio_id"),
                        rs.getInt("persona_id"),rs.getString("calle"),rs.getString("numero"),
                        rs.getString("colonia"),rs.getString("cp"),rs.getInt("estado_mex_id"),
                        rs.getInt("alcaldia_municipio_id"), rs.getString("tipo"),
                        rs.getString("tel"),rs.getString("estatus"));
                Persona persona = new Persona(rs.getInt("persona_id"),rs.getString("nombre"),
                        rs.getString("ap_Materno"),rs.getString("ap_Paterno"),rs.getString("fch_nacimiento"),
                        rs.getString("sexo"), rs.getString("rfc"),rs.getString("foto"),rs.getString("celular"),
                        rs.getString("tipo"),rs.getString("nacionalidad"),rs.getString("estatus"), domicilio);                        
                personas.add(persona);                
            }                                  
            
        } catch (SQLException ex) {
            Logger.getLogger(PersonaJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return personas;
    }
    
    public List<Persona> listar(){
        Connection conn =null;
        PreparedStatement stmt= null;
        ResultSet rs= null;        
        List<Persona> personas = new ArrayList();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);  
            rs = stmt.executeQuery();        
            while(rs.next()){
                Persona persona = new Persona(rs.getInt("persona_id"),
                        rs.getString("nombre"),rs.getString("ap_Materno"),
                        rs.getString("ap_Paterno"),rs.getString("fch_nacimiento"),
                        rs.getString("sexo"), rs.getString("rfc"),rs.getString("foto"),
                        rs.getString("celular"),rs.getString("tipo"),rs.getString("nacionalidad"),
                        rs.getString("estatus"));
                personas.add(persona);
            }
        } catch (SQLException e) {            
            System.out.println("ERROR DE LISTAR");
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
            e.printStackTrace(System.out);
        }  
        finally{
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return personas;
    }
    
    public Persona encontrar(Persona persona) {
        Connection conn =null;
        PreparedStatement stmt= null;
        ResultSet rs= null; 
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);  
            stmt.setInt(1, persona.getIdPersona());
            rs = stmt.executeQuery();                    
            rs.absolute(1);//nos pocionamos en el primer registro devuelto
            persona.setNombre(rs.getString("nombre"));
            persona.setApMaterno(rs.getString("ap_materno"));
            persona.setApPaterno(rs.getString("ap_paterno"));            
            persona.setEstatus(rs.getString("estatus"));
            persona.setFechaNac(rs.getString("fch_nacimiento"));
            persona.setFoto(rs.getString("foto"));
            persona.setNacionalidad(rs.getString("nacionalidad"));
            persona.setRfc(rs.getString("rfc"));
            persona.setSexo(rs.getString("sexo"));
            persona.setCelular(rs.getString("celular"));
            persona.setTipo(rs.getString("tipo"));
        } catch (SQLException e) {
            System.out.println("ERROR DE ENCONTRAR");
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
            e.printStackTrace(System.out);
        }  
        finally{
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }         
        return persona;
    }
    
    public int insert(Persona persona){
        Connection conn =null;
        PreparedStatement stmt= null;        
        int rows = 0;
         try {
            //nombre, ap_Materno, ap_Paterno, fch_nacimiento, sexo, rfc, foto, celular, tipo, nacionalidad, estatus, email            
            conn = Conexion.getConnection();
            if(persona.getFechaNac().equals("")){
                persona.setFechaNac(null);
            }
            stmt = conn.prepareStatement(SQL_INSERT);                
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApMaterno());
            stmt.setString(3, persona.getApPaterno());
            stmt.setString(4,  persona.getFechaNac());
            stmt.setString(5, persona.getSexo());
            stmt.setString(6, persona.getRfc());
            stmt.setString(7, persona.getFoto());
            stmt.setString(8, persona.getCelular());
            stmt.setString(9, persona.getTipo());
            stmt.setString(10, persona.getNacionalidad());
            stmt.setString(11, persona.getEstatus());
            
            
            rows = stmt.executeUpdate();  
        } catch (SQLException e) {
            System.out.println("ERROR DE INSERTAR");
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
            e.printStackTrace(System.out);
        }  
        finally{
            Conexion.close(conn);
            Conexion.close(stmt);            
        }
         return rows;
    }
    
    public int update(Persona persona){
        Connection conn =null;
        PreparedStatement stmt= null;        
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);  
            
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApMaterno());
            stmt.setString(3, persona.getApPaterno());
            stmt.setString(4,  persona.getFechaNac());
            stmt.setString(5, persona.getSexo());
            stmt.setString(6, persona.getRfc());
            stmt.setString(7, persona.getFoto());
            stmt.setString(8, persona.getCelular());
            stmt.setString(9, persona.getTipo());
            stmt.setString(10, persona.getNacionalidad());
            stmt.setString(11, persona.getEstatus());            
            stmt.setInt(13, persona.getIdPersona());
            
            rows = stmt.executeUpdate();  
        } catch (SQLException e) {
            System.out.println("ERROR DE UPDATE");
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
            e.printStackTrace(System.out);
        }  
        finally{
            Conexion.close(conn);
            Conexion.close(stmt);            
        }
         return rows;
    }
    
    public int delete(int personaId){
        Connection conn =null;
        PreparedStatement stmt= null;        
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);                        
            stmt.setInt(1, personaId);
            rows = stmt.executeUpdate();  
        } catch (SQLException e) {
            System.out.println("ERROR DE DELETE");
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
            e.printStackTrace(System.out);
        }  
        finally{
            Conexion.close(conn);
            Conexion.close(stmt);            
        }
         return rows;
    }    
}
