package ar.edu.unju.edm.demo.controller;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.demo.model.Fecha;

@Controller
public class FechaControlador {

    @GetMapping("/procesoFecha")
    public ModelAndView formularioFecha() {
        ModelAndView vista = new ModelAndView("fecha");
        Fecha objeto = new Fecha();
        vista.addObject("clave_fecha", objeto);
        return vista;
    }

    @PostMapping("/procesoFecha/resultado")
    public ModelAndView verFechas(@ModelAttribute("clave_fecha") Fecha objeto) {
        ModelAndView vista = new ModelAndView("verFecha");
        String mensaje1 = obtenerOrdenFechas(objeto.getFecha1(), objeto.getFecha2());
        String mensaje2 = calcularTiempoEntre(objeto.getFecha1(), objeto.getFecha2());
        objeto.setMensaje1(mensaje1);
        objeto.setMensaje2(mensaje2);
        vista.addObject("clave_fecha", objeto);
        return vista;
    }

    public String obtenerOrdenFechas(LocalDate fecha1, LocalDate fecha2) {
        if (fecha1.isBefore(fecha2)) {
            return "La Fecha1 es anterior a Fecha2";
        } else {
            return "La Fecha1 es posterior a Fecha2";
        }
    }

    public String calcularTiempoEntre(LocalDate fecha1, LocalDate fecha2) {
        int años, meses, dias;
        String tiempo = "Entre las dos fechas ha pasado: ";
        if (fecha1.isBefore(fecha2)) {
            años = Period.between(fecha1, fecha2).getYears();
            meses = Period.between(fecha1, fecha2).getMonths();
            dias = Period.between(fecha1, fecha2).getDays();
        } else {
            años = Period.between(fecha2, fecha1).getYears();
            meses = Period.between(fecha2, fecha1).getMonths();
            dias = Period.between(fecha2, fecha1).getDays();
        }
        tiempo = tiempo + años + " Años, ";
        tiempo = tiempo + meses + " Meses, ";
        tiempo = tiempo + dias + " Dias.";
        return tiempo;
    }

}