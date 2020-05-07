package controladores;

import datos.DomicilioJDBC;
import datos.PersonaJDBC;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelos.Domicilio;
import modelos.Persona;

@WebServlet("/PersonaServlet")
public class PersonasServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{   
        String accion = request.getParameter("accion");
        if(accion!=null){
            switch(accion){                       
                case "eliminar":
                    System.out.println("ENTRANDO A ELIMINAR PERSONA");
                    eliminarPersona(request, response);                    
                break;                                              
                case "info":       
                    System.out.println("ENTRANDO A DESPLEGAR INFO");
                    showInfo(request, response);
                break;
                default:
                    listarPersonas(request, response); 
                break;
            }                
        }else{
            listarPersonas(request, response); 
        }
    }    
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{   
        String accion = request.getParameter("accion");
        switch(accion){
            case "insertar":                
                System.out.println("ENTRANDO A INSERTAR PERSONA");
                insertarPersona(request, response);
            break; 
            case "editar":
                System.out.println("ENTRANDO A EDITAR PERSONA");
                editar(request, response);                
            break;            
            case "buscar":
                System.out.println("ENTRANDO A BUSCAR PERSONA");
                search(request, response);                
            break; 
        }        
    }  
    
    public void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession sesion = request.getSession();
        String palabra = request.getParameter("buscar");
        List<Persona> personas = new PersonaJDBC().search(palabra);
        sesion.setAttribute("personas", personas);        
        request.getRequestDispatcher("/WEB-INF/personas/personas.jsp").forward(request, response);
    }
    public void editar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        HttpSession sesion = request.getSession();
        int idPersona = Integer.parseInt(request.getParameter("idPersona"));
        Persona persona = getParamsPer(request, response);
        persona.setIdPersona(idPersona);        
        System.out.println("persona = " + persona);
        sesion.setAttribute("persona", persona);
        request.getRequestDispatcher("/WEB-INF/personas/personaInfo.jsp").forward(request, response);        
    }
    
    public void eliminarPersona(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String id = request.getParameter("idPersona");
        int idCliente = Integer.parseInt(id);        
        int rowsD = new DomicilioJDBC().delete(idCliente);
        int rowsP = new PersonaJDBC().delete(idCliente);        
        response.sendRedirect("index.jsp");
    }
    
    public void insertarPersona(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{                   
        Persona persona = getParamsPer(request, response);        
        int rowsP = new PersonaJDBC().insert(persona);  
        Domicilio domicilio = getParamsDom(request, response);
        int rowsD = new DomicilioJDBC().insert(domicilio);
        response.sendRedirect("index.jsp");        
    }
        
    private void listarPersonas(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{                 
        List<Persona> personasDom = new PersonaJDBC().getPerDom();              
        request.setAttribute("personas", personasDom);                
        request.getRequestDispatcher("/WEB-INF/personas/personas.jsp").forward(request, response);        
    }    
    
    public void showInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession sesion = request.getSession();
        int idPersona = Integer.parseInt(request.getParameter("idPersona"));
        Persona per = new PersonaJDBC().encontrar(new Persona(idPersona));
        Domicilio dom = new DomicilioJDBC().encontrar(new Domicilio(idPersona));
        sesion.setAttribute("persona", per);
        sesion.setAttribute("domicilio", dom);
        request.getRequestDispatcher("/WEB-INF/personas/personaInfo.jsp").forward(request, response);        
    }
    
    public Persona getParamsPer(HttpServletRequest request, HttpServletResponse response){
        String nombre = request.getParameter("nombre");
        String apPaterno = request.getParameter("apMaterno");
        String apMaterno = request.getParameter("apPaterno");
        String fn = request.getParameter("fch_nacimiento");
        String sexo = request.getParameter("genero");
        String rfc = request.getParameter("rfc");
        String foto = request.getParameter("foto");
        String celular = request.getParameter("celular");
        String tipo = request.getParameter("tipo");        
        String nac = request.getParameter("nacionalidad");     
        String estatus = request.getParameter("estatus");        
        Persona persona= new Persona(nombre, apMaterno, apPaterno, fn, sexo, rfc, foto, celular, tipo, nac, estatus);
        return persona;
    }
    
    public Domicilio getParamsDom(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int personaId = new PersonaJDBC().obtenerId(request.getParameter("rfc")); 
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
        return domicilio;
    }
}
