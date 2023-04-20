package ar.edu.unju.edm.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Persona {
    
    private String nombre;
    private String apellido;
    private String fecha;
    private String edad;
    private String signoDelZodiaco;
    private String estacion;

    public Persona() {

    }

    public Persona(String nombre, String apellido, String fecha) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSignoDelZodiaco() {
        return signoDelZodiaco;
    }

    public void setSignoDelZodiaco(String signoDelZodiaco) {
        this.signoDelZodiaco = signoDelZodiaco;
    }

    public String getEstacion() {
        return estacion;
    }

    public void setEstacion(String estacion) {
        this.estacion = estacion;
    }

}