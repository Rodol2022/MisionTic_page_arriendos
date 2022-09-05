
package beans;

import java.sql.Date;


public class Inmueble {
    
    private int idInmueble;
    private String tipoInmueble;
    private String ciudadInmueble;
    private String zonaInmueble;
    private String descripcionInmueble;
    private int precioInmueble;
    private boolean disponibleInmueble;
    private Date reservaCita;

    public Inmueble(int idInmueble, String tipoInmueble, String ciudadInmueble, String zonaInmueble, String descripcionInmueble, int precioInmueble, boolean disponibleInmueble, Date reservaCita) {
        this.idInmueble = idInmueble;
        this.tipoInmueble = tipoInmueble;
        this.ciudadInmueble = ciudadInmueble;
        this.zonaInmueble = zonaInmueble;
        this.descripcionInmueble = descripcionInmueble;
        this.precioInmueble = precioInmueble;
        this.disponibleInmueble = disponibleInmueble;
        this.reservaCita = reservaCita;
    }

    public int getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(int idInmueble) {
        this.idInmueble = idInmueble;
    }

    public String getTipoInmueble() {
        return tipoInmueble;
    }

    public void setTipoInmueble(String tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
    }

    public String getCiudadInmueble() {
        return ciudadInmueble;
    }

    public void setCiudadInmueble(String ciudadInmueble) {
        this.ciudadInmueble = ciudadInmueble;
    }

    public String getZonaInmueble() {
        return zonaInmueble;
    }

    public void setZonaInmueble(String zonaInmueble) {
        this.zonaInmueble = zonaInmueble;
    }

    public String getDescripcionInmueble() {
        return descripcionInmueble;
    }

    public void setDescripcionInmueble(String descripcionInmueble) {
        this.descripcionInmueble = descripcionInmueble;
    }

    public int getPrecioInmueble() {
        return precioInmueble;
    }

    public void setPrecioInmueble(int precioInmueble) {
        this.precioInmueble = precioInmueble;
    }

    public boolean isDisponibleInmueble() {
        return disponibleInmueble;
    }

    public void setDisponibleInmueble(boolean disponibleInmueble) {
        this.disponibleInmueble = disponibleInmueble;
    }

    public Date getReservaCita() {
        return reservaCita;
    }

    public void setReservaCita(Date reservaCita) {
        this.reservaCita = reservaCita;
    }

    @Override
    public String toString() {
        return "Inmueble{" + "idInmueble=" + idInmueble + ", tipoInmueble=" + tipoInmueble + ", ciudadInmueble=" + ciudadInmueble + ", zonaInmueble=" + zonaInmueble + ", descripcionInmueble=" + descripcionInmueble + ", precioInmueble=" + precioInmueble + ", disponibleInmueble=" + disponibleInmueble + ", reservaCita=" + reservaCita + '}';
    }
    
    
}
