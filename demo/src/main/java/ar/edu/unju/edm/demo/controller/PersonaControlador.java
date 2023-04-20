package ar.edu.unju.edm.demo.controller;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.demo.model.Persona;

@Controller
public class PersonaControlador {
    
    @GetMapping("/persona")
    public ModelAndView formularioPersona() {
        ModelAndView vista = new ModelAndView("persona");
        Persona objeto = new Persona();
        vista.addObject("clave_persona", objeto);
        return vista;
    }

    @PostMapping("/persona/resultado")
    public ModelAndView verPersona(@ModelAttribute("clave_persona") Persona objeto) {
        ModelAndView vista = new ModelAndView("verPersona");
        LocalDate fecha = LocalDate.parse(objeto.getFecha());
        String edad = calcularEdad(fecha);
        String signoDelZodiaco = obtenerSignoDelZodiaco(fecha);
        String estacionDelAño = obtenerEstacion(fecha);
        objeto.setEdad(edad);
        objeto.setSignoDelZodiaco(signoDelZodiaco);
        objeto.setEstacion(estacionDelAño);
        vista.addObject("clave_persona", objeto);
        return vista;
    }

    private String calcularEdad(LocalDate fecha) {
        int años = Period.between(fecha, LocalDate.now()).getYears();
        int meses = Period.between(fecha, LocalDate.now()).getMonths();
        int dias = Period.between(fecha, LocalDate.now()).getDays();
        String edad = "";
        if (años != 0) 
            edad = años + " Años";
        else if (meses != 0) 
            edad = meses + " Meses";
        else if (dias != 0) 
            edad = dias + " Días";
        return edad;
    }

    public String obtenerSignoDelZodiaco(LocalDate fecha) {
        String signoDelZodiaco = "";
        switch (fecha.getMonth()) {
            case JANUARY:
                if (fecha.getDayOfMonth() >= 20) {
                    signoDelZodiaco = "Acuario";
                } else {
                    signoDelZodiaco = "Capricornio";
                }
                break;
            case FEBRUARY:
                if (fecha.getDayOfMonth() >= 19) {
                    signoDelZodiaco = "Piscis";
                } else {
                    signoDelZodiaco = "Acuario";
                }
                break;
            case MARCH:
                if (fecha.getDayOfMonth() >= 21) {
                    signoDelZodiaco = "Aries";
                } else {
                    signoDelZodiaco = "Piscis";
                }
                break;
            case APRIL:
                if (fecha.getDayOfMonth() >= 20) {
                    signoDelZodiaco = "Tauro";
                } else {
                    signoDelZodiaco = "Aries";
                }
                break;
            case MAY:
                if (fecha.getDayOfMonth() >= 21) {
                    signoDelZodiaco = "Geminis";
                } else {
                    signoDelZodiaco = "Tauro";
                }
                break;
            case JUNE:
                if (fecha.getDayOfMonth() >= 21) {
                    signoDelZodiaco = "Cancer";
                } else {
                    signoDelZodiaco = "Geminis";
                }
                break;
            case JULY:
                if (fecha.getDayOfMonth() >= 23) {
                    signoDelZodiaco = "Leo";
                } else {
                    signoDelZodiaco = "Cancer";
                }
                break;
            case AUGUST:
                if (fecha.getDayOfMonth() >= 23) {
                    signoDelZodiaco = "Virgo";
                } else {
                    signoDelZodiaco = "Leo";
                }
                break;
            case SEPTEMBER:
                if (fecha.getDayOfMonth() >= 23) {
                    signoDelZodiaco = "Libra";
                } else {
                    signoDelZodiaco = "Virgo";
                }
                break;
            case OCTOBER:
                if (fecha.getDayOfMonth() >= 23) {
                    signoDelZodiaco = "Escorpio";
                } else {
                    signoDelZodiaco = "Libra";
                }
                break;
            case NOVEMBER:
                if (fecha.getDayOfMonth() >= 22) {
                    signoDelZodiaco = "Sagitario";
                } else {
                    signoDelZodiaco = "Escorpio";
                }
                break;
            case DECEMBER:
                if (fecha.getDayOfMonth() >= 22) {
                    signoDelZodiaco = "Capricornio";
                } else {
                    signoDelZodiaco = "Sagitario";
                }
                break;
        };
        return signoDelZodiaco;
    }

    public String obtenerEstacion(LocalDate fecha) {
        String estacionDelAño = "";
        if (fecha.getDayOfYear() >= 355 || fecha.getDayOfYear() < 79) {
            estacionDelAño = "Verano";
        }
        if (fecha.getDayOfYear() >= 78 && fecha.getDayOfYear() < 172) {
            estacionDelAño = "Otoño";
        }
        if (fecha.getDayOfYear() >= 172 && fecha.getDayOfYear() < 266) {
            estacionDelAño = "Invierno";
        }
        if (fecha.getDayOfYear() >= 266 && fecha.getDayOfYear() < 355) {
            estacionDelAño = "Primavera";
        }
        return estacionDelAño;
    }

}