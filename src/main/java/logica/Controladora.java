package logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.ControladoraPersistencia;

public class Controladora {
    private ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void crearUsuario(String nombreUsuario, String contra, String rol) {
        Usuario usu = new Usuario();
        usu.setNombreUsuario(nombreUsuario);
        usu.setContrasenia(contra);
        usu.setRol(rol);
        
        this.controlPersis.crearUsuario(usu);
    }

    public List<Usuario> traerUsuarios() {
        return this.controlPersis.buscarUsuarios();
    }

    public void borrarUsuario(int id) {
        controlPersis.borrarUsuario(id);
    }

    public Usuario buscarUsuario(int id) {
        return controlPersis.buscarUsuario(id);
    }
    
    public Usuario buscarUnUsuario(String unUsuario) {
        int id = Integer.parseInt(unUsuario);        
        return controlPersis.buscarUsuario(id);
    }

    public void editarUsuario(Usuario usu, String nombreUsu, String contrasenia, String rol) {
        usu.setNombreUsuario(nombreUsu);
        usu.setContrasenia(contrasenia);
        usu.setRol(rol);
        controlPersis.editarUsuario(usu);
    }

    public void crearResponsable(String cedula, String nombre, String apellido, String telefono, String direccion, String fecha_nac, String tipo_resp) {
        Responsable resp = new Responsable();
        resp.setCedula(cedula);
        resp.setNombre(nombre);
        resp.setApellido(apellido);
        resp.setTelefono(telefono);
        resp.setDireccion(direccion);
        
        Date fecha = convFechaString(fecha_nac);
        resp.setFecha_nac(fecha);
        resp.setTipo_resp(tipo_resp);
        
        this.controlPersis.crearResponsable(resp);
    }
    
    public Responsable buscarResponsable(String resp){
        int id = Integer.parseInt(resp);
        return controlPersis.buscarResponsable(id);
        
    }

    public List<Responsable> buscarResponsables() {
        return controlPersis.buscarResponsables();
    }
    
    public void crearPaciente(String cedula, String nombre, String apellido, String telefono, String direccion, String fecha_nac, String tiene_seguro, String tipoSangre, String resp) {
        Paciente pac = new Paciente();
        pac.setCedula(cedula);
        pac.setNombre(nombre);
        pac.setApellido(apellido);
        pac.setTelefono(telefono);
        pac.setDireccion(direccion);
        Date fecha = convFechaString(fecha_nac);
        pac.setFecha_nac(fecha);
        if (tiene_seguro.equalsIgnoreCase("Si")){
            pac.setTiene_seguro(true);
        } else {
            pac.setTiene_seguro(false);
        }
        
        pac.setTipoSangre(tipoSangre);
        Responsable responsable = buscarResponsable(resp);
        pac.setUnResponsable(responsable);
        
        controlPersis.crearPaciente(pac);
        
        
    }

    public List<Paciente> traerPacientes() {
        return controlPersis.traerPacientes();
    }
    
    public Paciente buscarPaciente(int id) {
        return this.controlPersis.buscarPacientes(id);
    }

    public void borrarPaciente(int id) {
        this.controlPersis.borrarPacientes(id);
    }
    
    public void editarPaciente(Paciente pac, String cedula, String nombre, String apellido, String telefono, String direccion, String fecha_nac, String tiene_seguro, String tipoSangre, String resp) {
        pac.setCedula(cedula);
        pac.setNombre(nombre);
        pac.setApellido(apellido);
        pac.setTelefono(telefono);
        pac.setDireccion(direccion);
        
        Date fecha = convFechaString(fecha_nac);
        pac.setFecha_nac(fecha);
        
        if (tiene_seguro.equalsIgnoreCase("Si")){
            pac.setTiene_seguro(true);
        } else {
            pac.setTiene_seguro(false);
        }
        
        pac.setTipoSangre(tipoSangre);
        
        Responsable responsable = buscarResponsable(resp);
        pac.setUnResponsable(responsable);
        
        controlPersis.editarPaciente(pac);
    }

    public List<Horario> traerHorarios() {
        return controlPersis.traerHorarios();
    }
    
    public void crearOdontologo(String cedula, String nombre, String apellido, String telefono, String direccion, String fecha_nac, String especialista, String unUsuario, String unHorario) {
        Odontologo odonto = new Odontologo();
        odonto.setCedula(cedula);
        odonto.setNombre(nombre);
        odonto.setApellido(apellido);
        odonto.setTelefono(telefono);
        odonto.setDireccion(direccion);
        
        Date fecha = convFechaString(fecha_nac);
        odonto.setFecha_nac(fecha);
        
        odonto.setEspecialista(especialista);
        
        int idUsu = Integer.parseInt(unUsuario);
        Usuario usuario = buscarUsuario(idUsu);
        odonto.setUnUsuario(usuario);

        int idHora = Integer.parseInt(unHorario);
        Horario horario = buscarHorario(idHora);
        odonto.setUnHorario(horario);
        controlPersis.crearOdontologo(odonto);
        
    }
    
    public List<Odontologo> buscarOdontologos() {
        return this.controlPersis.buscarOdontologos();
    }
    
    public Odontologo buscarOdontologo(int id){
        return controlPersis.buscarOdontologo(id);
    }
    
    private Horario buscarHorario(int id) {
        return controlPersis.buscarHorarios(id);
    }

    private Horario buscarUnHorario(String unHorario) {
        int id = Integer.parseInt(unHorario);
        return controlPersis.buscarHorarios(id);
    }

    public Date convFechaString(String fecha_nac) {
        Date fechaFinal = null;
        try {
            SimpleDateFormat formEntrada = new SimpleDateFormat("yyyy-MM-dd");
            formEntrada.setLenient(false);  // Asegura que el parseo sea estricto con el formato
            fechaFinal = formEntrada.parse(fecha_nac);
            
            
        } catch (ParseException ex) {
            // Si ocurre un error, manejarlo y crear una fecha formateada para la fecha actual
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
            
            Date fecha = new Date();  // Fecha actual
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            try {
                fechaFinal = formato.parse(formato.format(fecha)); // Formatea y asigna la fecha actual
            } catch (ParseException e) {
                // Este bloque catch es necesario para manejar la posible ParseException
                Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        
        return fechaFinal;
    }
    
    public String convFechaDate(Date fecha_nac) {
        String fechaString = null;
        try {
            // Formato compatible con input type="date"
            SimpleDateFormat formSalida = new SimpleDateFormat("yyyy-MM-dd");
            formSalida.setLenient(false); // Asegura que el formato sea estricto
            fechaString = formSalida.format(fecha_nac);
        } catch (Exception ex) {
            // Manejar cualquier posible error
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
            // Devolver una fecha predeterminada en caso de error
            SimpleDateFormat formSalida = new SimpleDateFormat("yyyy-MM-dd");
            fechaString = formSalida.format(new Date()); // Fecha actual como alternativa
        }
        return fechaString;
    }

    public void borrarOdontologo(int id) {
        controlPersis.borrarOdontologo(id);
    }

    public void editarOdontologo(Odontologo odonto, String cedula, String nombre, String apellido, String telefono, String direccion, String fecha_nac, String especialidad, String unUsuario, String unHorario) {
        odonto.setCedula(cedula);
        odonto.setNombre(nombre);
        odonto.setApellido(apellido);
        odonto.setTelefono(telefono);
        odonto.setDireccion(direccion);
        
        Date fecha = convFechaString(fecha_nac);
        odonto.setFecha_nac(fecha);
        
        odonto.setEspecialista(especialidad);
        
        Usuario usuario = buscarUnUsuario(unUsuario);
        odonto.setUnUsuario(usuario);
        
        Horario horario = buscarUnHorario(unHorario);
        odonto.setUnHorario(horario);
        
        controlPersis.editarOdontologo(odonto);
    }

    public boolean comprobarIngreso(String usuario, String contrasenia) {
        boolean ingreso = false;
        List <Usuario> listaUsuarios = new ArrayList<Usuario>();
        listaUsuarios = controlPersis.buscarUsuarios();
        
        for (Usuario usu: listaUsuarios){
            if (usu.getNombreUsuario().equals(usuario)){
                if (usu.getContrasenia().equals(contrasenia)){
                    ingreso = true;
                }
            }
        }
        return ingreso;
    }

    

}
