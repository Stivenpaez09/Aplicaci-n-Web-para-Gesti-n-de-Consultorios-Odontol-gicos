package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Horario;
import logica.Odontologo;
import logica.Paciente;
import logica.Responsable;
import logica.Usuario;
import persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {
    
    private HorarioJpaController horarioJPA = new HorarioJpaController();
    private OdontologoJpaController odontologoJPA = new OdontologoJpaController();
    private PacienteJpaController pacienteJPA = new PacienteJpaController();
    private PersonaJpaController personaJPA = new PersonaJpaController();
    private ResponsableJpaController responsableJPA = new ResponsableJpaController();
    private SecretarioJpaController secretarioJPA = new SecretarioJpaController();
    private TurnoJpaController turnoJPA = new TurnoJpaController();
    private UsuarioJpaController usuarioJPA = new UsuarioJpaController();

    //******************USUARIO*************
    public void crearUsuario(Usuario usu) {
        this.usuarioJPA.create(usu);
    }

    public List<Usuario> buscarUsuarios() {
        return this.usuarioJPA.findUsuarioEntities();
    }

    public void borrarUsuario(int id) {
        try {
            usuarioJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario buscarUsuario(int id) {
        return usuarioJPA.findUsuario(id);
    }

    public void editarUsuario(Usuario usu) {
        try {
            usuarioJPA.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //**************RESPONSABLE*******************
    public void crearResponsable(Responsable resp) {
        this.responsableJPA.create(resp);
    }

    public List<Responsable> buscarResponsables() {
        return responsableJPA.findResponsableEntities();
    }

    public Responsable buscarResponsable(int id) {
        return responsableJPA.findResponsable(id);
    }

    //***************PACIENTE****************
    public void crearPaciente(Paciente pac) {
        this.pacienteJPA.create(pac);
    }

    public List<Paciente> traerPacientes() {
        return pacienteJPA.findPacienteEntities();
    }

    public void borrarPacientes(int id) {
        try {
            pacienteJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Paciente buscarPacientes(int id) {
        return this.pacienteJPA.findPaciente(id);
    }
    
    public void editarPaciente(Paciente pac) {
        try {
            pacienteJPA.edit(pac);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //*************HORARIO***************
    public List<Horario> traerHorarios() {
        return horarioJPA.findHorarioEntities();
    }

    public Horario buscarHorarios(int id) {
        return horarioJPA.findHorario(id);
    }

    //***************ODONTOLOGO*****************
    public void crearOdontologo(Odontologo odonto) {
        this.odontologoJPA.create(odonto);
    }

    public List<Odontologo> buscarOdontologos() {
        return this.odontologoJPA.findOdontologoEntities();
    }

    public Odontologo buscarOdontologo(int id) {
        return this.odontologoJPA.findOdontologo(id);
    }

    public void borrarOdontologo(int id) {
        try {
            this.odontologoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarOdontologo(Odontologo odonto) {
        try {
            this.odontologoJPA.edit(odonto);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
