package ar.edu.unju.edm.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.demo.model.Cadena;

@Controller
public class CadenaControlador {
    
    @GetMapping("/procesoString")
    public ModelAndView formularioCadena() {
        ModelAndView vista = new ModelAndView("cadena");
        Cadena objeto = new Cadena();
        vista.addObject("clave_cadena", objeto);
        return vista;
    }

    @PostMapping("/procesoString/resultado")
    public ModelAndView verCadenas(@ModelAttribute("clave_cadena") Cadena objeto) {
        ModelAndView vista = new ModelAndView("verCadena");
        String cadenaInvertida = invertir(objeto.getCadena());
        String mensaje1 = obtenerLongitudYVocales(objeto.getCadena());
        String mensaje2 = obtenerCantidadPalabras(objeto.getCadena());
        objeto.setCadenaInvertida(cadenaInvertida);
        objeto.setMensaje1(mensaje1);
        objeto.setMensaje2(mensaje2);
        vista.addObject("clave_cadena", objeto);
        return vista;
    }

    public String obtenerLongitudYVocales(String cadena) {
        String resultado = "La cadena tiene ";
        int vocales = 0;
        cadena = cadena.toLowerCase();
        for (int x = 0; x < cadena.length(); x++) 
            if ((cadena.charAt(x)=='a') || (cadena.charAt(x)=='e') || (cadena.charAt(x)=='i') || (cadena.charAt(x)=='o') || (cadena.charAt(x)=='u'))
                vocales++;
        resultado = resultado + cadena.length() + " caracteres";
        resultado = resultado + " y " + vocales + " vocales.";
        return resultado;
    }

    public String obtenerCantidadPalabras(String cadena) {
        String resultado = "";
        int contador = 1;
        for (int i = 0; i < cadena.length(); i++) 
            if (cadena.charAt(i) == ' ')
                contador++;
        resultado = "La Cadena tiene " + contador + " Palabras"; 
        return resultado;
    }

    public String invertir(String cadena) {
        String cadenaInvertida = "";
        for (int i = cadena.length(); i > 0; i--) 
            if (cadena.charAt(i - 1) != ' ')
                cadenaInvertida = cadenaInvertida + cadena.charAt(i - 1);
        return cadenaInvertida;
    }

}