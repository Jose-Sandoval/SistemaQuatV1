package controladores;

import datos.DomicilioJDBC;
import datos.PersonaJDBC;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.Domicilio;

@WebServlet("/DomicilioServlet")
public class DomicilioServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){                
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{ 
        String accion = request.getParameter("accion");
        switch(accion){
            case "editar":
                System.out.println("ENTRANDO A EDITAR DOMI");
                insertNewDom(request, response);
            break;            
        }
    }    
    
    public void insertNewDom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{                
        int personaId = Integer.parseInt(request.getParameter("idPersona"));
        System.out.println("personaId = " + personaId);
        new DomicilioJDBC().updateEstatus(personaId);        
        int edo = 0;
        int muni = 0;
        String calle = request.getParameter("calle");
        String numero = request.getParameter("numero");
        String col = request.getParameter("colonia");
        String cp = request.getParameter("cp");
        if(!request.getParameter("edo").equals("")){
            edo = Integer.parseInt(request.getParameter("edo"));
        }
        if(!request.getParameter("muni").equals("")){
            muni = Integer.parseInt(request.getParameter("muni"));
        }        
        String tipo = request.getParameter("tipo");
        String tel = request.getParameter("tel");
        String estatus = "activo";
        Domicilio domicilio = new Domicilio(personaId, calle, numero, col, cp, edo, muni, tipo, tel, estatus);        
        System.out.println("domicilio = " + domicilio);
        new DomicilioJDBC().insert(domicilio);   
        HttpSession sesion = request.getSession();
        sesion.setAttribute("domicilio", domicilio);        
        request.getRequestDispatcher("/WEB-INF/personas/personaInfo.jsp").forward(request, response);
    }    
    
    private void listarDomicilios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession sesion = request.getSession();
        List<Domicilio> domicilios = new DomicilioJDBC().listar();
        sesion.setAttribute("domicilios", domicilios);
        request.getRequestDispatcher("/WEB-INF/domicilios/listarDomicilios.jsp").forward(request, response);
    }
}

