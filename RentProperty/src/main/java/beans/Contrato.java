
package beans;

import java.sql.Date;


public class Contrato {
    
    private int idUsuario;
    private int idInmueble;
    private int idContrato;
    private Date fechaContrato;

    public Contrato(int idUsuario, int idInmueble, int idContrato, Date fechaContrato) {
        this.idUsuario = idUsuario;
        this.idInmueble = idInmueble;
        this.idContrato = idContrato;
        this.fechaContrato = fechaContrato;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(int idInmueble) {
        this.idInmueble = idInmueble;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public Date getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(Date fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    @Override
    public String toString() {
        return "Contrato{" + "idUsuario=" + idUsuario + ", idInmueble=" + idInmueble + ", idContrato=" + idContrato + ", fechaContrato=" + fechaContrato + '}';
    }
    
    
    
}
