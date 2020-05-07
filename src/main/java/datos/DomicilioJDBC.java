/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Domicilio;

public class DomicilioJDBC {
    
    private static final String SQL_SELECT = "SELECT * FROM domicilio";
    private static final String SQL_SELECT_BY_ID_PERSONA = "SELECT * FROM domicilio WHERE persona_id = ? AND estatus = 'activo'";    
    private static final String SQL_SELECT_BY_ID_DOMICILIO = "SELECT * FROM domicilio WHERE domicilio_id = ?";   
    private static final String SQL_INSERT  = "INSERT INTO domicilio (persona_id, calle, numero, colonia, cp, estado_mex_id, alcaldia_municipio_id, tipo, tel, estatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE domicilio SET persona_id=?, calle=?, numero=?, colonia=?, cp=?, estado_mex_id=?, alcaldia_municipio_id=?, tipo=?, tel=?, estatus=? WHERE domicilio_id=?";
    private static final String SQL_UPDATE_ESTATUS = "UPDATE domicilio SET estatus = 'anterior' WHERE persona_id = ? AND estatus='activo'";
    private static final String SQL_DELETE = "DELETE FROM domicilio WHERE persona_id=?";
    
    public List<Domicilio> listar(){
        Connection conn =null;
        PreparedStatement stmt= null;
        ResultSet rs= null;        
        List<Domicilio> domicilios = new ArrayList();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);              
            //stmt.setInt(1, idPersona);
            rs = stmt.executeQuery();        
            while(rs.next()){
                Domicilio domicilio = new Domicilio(rs.getInt("domicilio_id"),
                        rs.getInt("persona_id"),rs.getString("calle"),rs.getString("numero"),
                        rs.getString("colonia"),rs.getString("cp"),rs.getInt("estado_mex_id"),
                        rs.getInt("alcaldia_municipio_id"), rs.getString("tipo"),
                        rs.getString("tel"),rs.getString("estatus"));
                domicilios.add(domicilio);
            }
        } catch (SQLException e) {
            System.out.println("ERROR DE LISTAR DOMICILIO");
            System.out.println(e.getErrorCode() + " " + e.getMessage());
            System.out.println(e.getSQLState());            
            e.printStackTrace(System.out);
        }  
        finally{
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return domicilios;
    }
    
    public Domicilio encontrar(Domicilio domicilio) {
        Connection conn =null;
        PreparedStatement stmt= null;
        ResultSet rs= null; 
         try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID_PERSONA);  
            stmt.setInt(1, domicilio.getIdPersona());
            rs = stmt.executeQuery();                    
            rs.absolute(1);//nos pocionamos en el primer registro devuelto
            domicilio.setIdDomicilio(rs.getInt("domicilio_id"));
            domicilio.setCalle(rs.getString("calle"));
            domicilio.setNumero(rs.getString("numero"));
            domicilio.setColonia(rs.getString("colonia"));
            domicilio.setCP(rs.getString("cp"));
            domicilio.setIdEstado(rs.getInt("estado_mex_id"));
            domicilio.setIdMunDel(rs.getInt("alcaldia_municipio_id"));
            domicilio.setTelefono(rs.getString("tel"));
            domicilio.setTipo(rs.getString("tipo"));
            domicilio.setEstatus(rs.getString("estatus"));
        } catch (SQLException e) {
            System.out.println("ERROR DE ENCONTRAR DOMICILIO");
            System.out.println(e.getErrorCode() + " " + e.getMessage());
            System.out.println(e.getSQLState());            
            e.printStackTrace(System.out);
        }  
        finally{
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }         
        return domicilio;
    }
    
    public int insert(Domicilio domicilio){
        Connection conn =null;
        PreparedStatement stmt= null;        
        int rows = 0;
         try {
            //persona_id, calle, numero, colonia, cp, estado_mex_id, alcaldia_municipio_id, tipo, telefono, estatus
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT); 
            
            stmt.setInt(1, domicilio.getIdPersona());
            stmt.setString(2, domicilio.getCalle());
            stmt.setString(3, domicilio.getNumero());
            stmt.setString(4, domicilio.getColonia());
            stmt.setString(5, domicilio.getCP());
            stmt.setInt(6, domicilio.getIdEstado());
            stmt.setInt(7, domicilio.getIdMunDel());
            stmt.setString(8, domicilio.getTipo());
            stmt.setString(9, domicilio.getTelefono());
            stmt.setString(10, domicilio.getEstatus());
            
            rows = stmt.executeUpdate();  
        } catch (SQLException e) {
            System.out.println("ERROR DE INSERT DOMICILIO");
            System.out.println(e.getErrorCode() + " " + e.getMessage());
            System.out.println(e.getSQLState());            
            e.printStackTrace(System.out);
        }  
        finally{
            Conexion.close(conn);
            Conexion.close(stmt);            
        }
         return rows;
    }
    
    public int updateEstatus(int idPersona){
        System.out.println("Entro a UPDATE ESTATUS");
        Connection conn = null; 
        PreparedStatement stmt = null;
        int row = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE_ESTATUS);
            stmt.setInt(1, idPersona);
            row = stmt.executeUpdate();                        
        } catch (SQLException e) {
            System.out.println("ERROR DE UPDATE ESTATUS");
            System.out.println(e.getErrorCode() + " " + e.getMessage());
            System.out.println(e.getSQLState());
            Logger.getLogger(DomicilioJDBC.class.getName()).log(Level.SEVERE, null, e);
        }        
        return row;
    }
    
    public int update(Domicilio domicilio){
        Connection conn =null;
        PreparedStatement stmt= null;        
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);  
            
            stmt.setInt(1, domicilio.getIdPersona());
            stmt.setString(2, domicilio.getCalle());
            stmt.setString(3, domicilio.getNumero());
            stmt.setString(4, domicilio.getColonia());
            stmt.setString(5, domicilio.getCP());
            stmt.setInt(6, domicilio.getIdEstado());
            stmt.setInt(7, domicilio.getIdMunDel());
            stmt.setString(8, domicilio.getTipo());
            stmt.setString(9, domicilio.getTelefono());
            stmt.setString(10, domicilio.getEstatus());
            
            rows = stmt.executeUpdate();  
        } catch (SQLException e) {
            System.out.println("ERROR DE UPDATE DOMICILIO");
            System.out.println(e.getErrorCode() + " " + e.getMessage());
            System.out.println(e.getSQLState());            
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
            System.out.println("ERROR DE DELETE DOMICILIO");
            System.out.println(e.getErrorCode() + " " + e.getMessage());
            System.out.println(e.getSQLState());            
            e.printStackTrace(System.out);
        }  
        finally{
            Conexion.close(conn);
            Conexion.close(stmt);            
        }
        return rows;
    }
    
}
