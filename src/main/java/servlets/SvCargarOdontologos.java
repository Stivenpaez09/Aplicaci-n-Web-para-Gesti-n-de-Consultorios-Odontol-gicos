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
import logica.Odontologo;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "SvCargarOdontologos", urlPatterns = {"/SvCargarOdontologos"})
public class SvCargarOdontologos extends HttpServlet {

    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List <Odontologo> listaOdontologos = control.buscarOdontologos();
        
        Map<Integer, String> fechasFormateadas = new HashMap<>();
        SimpleDateFormat formateo = new SimpleDateFormat("yyyy-MM-dd");
        for(Odontologo odonto : listaOdontologos){
            String fechaFormateada;
            if(odonto.getFecha_nac() != null){
                fechaFormateada = formateo.format(odonto.getFecha_nac());
            } else {
                fechaFormateada = "Fecha no disponible";
            }
            
            fechasFormateadas.put(odonto.getId(), fechaFormateada);
        }
        
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("listaOdontologos", listaOdontologos);
        miSesion.setAttribute("fechasFormateadas", fechasFormateadas);
        response.sendRedirect("verOdontologos.jsp");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
