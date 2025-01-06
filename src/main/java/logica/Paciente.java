package logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Paciente extends Persona implements Serializable{
    //private int id_paciente;
    private boolean tiene_seguro;
    private String tipoSangre;
    @OneToOne
    private Responsable unResponsable;
    @OneToMany (mappedBy = "pacien")
    private List<Turno> listaTurnos;

    public Paciente() {
    }

    public Paciente(boolean tiene_seguro, String tipoSangre, Responsable unResponsable, List<Turno> listaTurnos, int id, String cedula, String nombre, String apellido, String telefono, String direccion, Date fecha_nac) {
        super(id, cedula, nombre, apellido, telefono, direccion, fecha_nac);
        this.tiene_seguro = tiene_seguro;
        this.tipoSangre = tipoSangre;
        this.unResponsable = unResponsable;
        this.listaTurnos = listaTurnos;
    }

    

    public boolean isTiene_seguro() {
        return tiene_seguro;
    }

    public void setTiene_seguro(boolean tiene_seguro) {
        this.tiene_seguro = tiene_seguro;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public Responsable getUnResponsable() {
        return unResponsable;
    }

    public void setUnResponsable(Responsable unResponsable) {
        this.unResponsable = unResponsable;
    }

    public List<Turno> getListaTurnos() {
        return listaTurnos;
    }

    public void setListaTurnos(List<Turno> listaTurnos) {
        this.listaTurnos = listaTurnos;
    }

    public void agregarTurno(Turno turno){
        this.listaTurnos.add(turno);
    }
    
    public void eliminarTurno(Turno turno){
        this.listaTurnos.remove(turno);
    }
}
