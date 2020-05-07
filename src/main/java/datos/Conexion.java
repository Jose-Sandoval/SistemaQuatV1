
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {
    
    private static final String JDBC_URL="jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_760f3588224c0a3?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true&reconnect=true";    
    private static final String JDBC_USER="bc33c866872aae";
    private static final String JDBC_PASS="bf5df359";
    private static BasicDataSource ds;
    
    public static DataSource getDataSource(){
        if(ds==null){
            ds = new BasicDataSource();
            ds.setUrl(JDBC_URL);
            ds.setUsername(JDBC_USER);
            ds.setPassword(JDBC_PASS);        
            //esta linea a veces es necesarioa, con versiones del driver de sql mas antiguas
            //ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
            ds.setInitialSize(50); 
        }
        return ds;
    }
    
    public static Connection getConnection() throws SQLException{
        return getDataSource().getConnection();
    }  
    
    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
    
    public static void close(PreparedStatement pstm){
        try {
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
    
    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
    
}
