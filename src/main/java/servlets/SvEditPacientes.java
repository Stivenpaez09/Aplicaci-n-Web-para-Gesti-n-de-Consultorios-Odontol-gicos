package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Paciente;
import logica.Responsable;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "SvEditPacientes", urlPatterns = {"/SvEditPacientes"})
public class SvEditPacientes extends HttpServlet {

    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        Paciente paciente = control.buscarPaciente(id);
        List<Responsable> listaResponsables = control.buscarResponsables();
        String fecha_nac = control.convFechaDate(paciente.getFecha_nac());
        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaResponsables", listaResponsables);
        misesion.setAttribute("paciente", paciente);
        misesion.setAttribute("fecha_nac", fecha_nac);
        System.out.println(fecha_nac);
        response.sendRedirect("editarPacientes.jsp");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Paciente pac = (Paciente) request.getSession().getAttribute("paciente");
        String cedula = request.getParameter("cedula");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String fecha_nac = request.getParameter("fecha_nac");
        String tiene_seguro = request.getParameter("tiene_seguro");
        String tipoSangre = request.getParameter("tipoSangre");
        String resp = request.getParameter("responsable");
        
        control.editarPaciente(pac, cedula, nombre, apellido, telefono, direccion, fecha_nac, tiene_seguro, tipoSangre, resp);
        
        response.sendRedirect("SvPacientes");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
