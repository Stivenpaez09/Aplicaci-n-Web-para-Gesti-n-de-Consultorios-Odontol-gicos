package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Horario;
import logica.Odontologo;
import logica.Usuario;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "SvEditOdontologos", urlPatterns = {"/SvEditOdontologos"})
public class SvEditOdontologos extends HttpServlet {

    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Odontologo odonto = control.buscarOdontologo(id);
        String fecha = control.convFechaDate(odonto.getFecha_nac());
        List<Horario> listaHorarios = control.traerHorarios();
        List<Usuario> listaUsuarios = control.traerUsuarios();
        
        HttpSession misesion = request.getSession();
        misesion.setAttribute("fecha", fecha);
        misesion.setAttribute("odonto", odonto);
        misesion.setAttribute("listaHorarios", listaHorarios);
        misesion.setAttribute("listaUsuarios", listaUsuarios);
        
        response.sendRedirect("editarOdontologos.jsp");
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Odontologo odonto = (Odontologo) request.getSession().getAttribute("odonto");
        String cedula = request.getParameter("cedula");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String fecha_nac = request.getParameter("fecha_nac");
        String especialidad = request.getParameter("especialista");
        String unUsuario = request.getParameter("unUsuario");
        String unHorario = request.getParameter("unHorario");
        
        control.editarOdontologo(odonto, cedula, nombre, apellido, telefono, direccion, fecha_nac, especialidad, unUsuario, unHorario);
        response.sendRedirect("SvCargarOdontologos");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
