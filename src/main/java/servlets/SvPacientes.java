package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Paciente;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "SvPacientes", urlPatterns = {"/SvPacientes"})
public class SvPacientes extends HttpServlet {

    Controladora control = new Controladora();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Paciente> listaPacientes = control.traerPacientes();
        Map<Integer, String> fechasFormateadas = new HashMap<>();
        SimpleDateFormat formateo = new SimpleDateFormat("yyyy-MM-dd");
        for(Paciente pac : listaPacientes){
            String fechaFormateada;
            if(pac.getFecha_nac() != null){
                fechaFormateada = formateo.format(pac.getFecha_nac());
            } else {
                fechaFormateada = "Fecha no disponible";
            }
            
            fechasFormateadas.put(pac.getId(), fechaFormateada);
        }
        
        
        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaPacientes", listaPacientes);
        misesion.setAttribute("fechasFormateadas", fechasFormateadas);
        response.sendRedirect("verPacientes.jsp");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cedula = request.getParameter("cedula");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String fecha_nac = request.getParameter("fecha_nac");
        String tiene_seguro = request.getParameter("tiene_seguro");
        String tipoSangre = request.getParameter("tipoSangre");
        String resp = request.getParameter("responsable");
        
        control.crearPaciente(cedula, nombre, apellido, telefono, direccion, fecha_nac, tiene_seguro, tipoSangre, resp);
        response.sendRedirect("altaPaciente.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
