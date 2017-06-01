package com.danielreimundo.appgym.util;

import com.danielreimundo.appgym.rutinas.Abdominales;
import com.danielreimundo.appgym.rutinas.Correr;
import com.danielreimundo.appgym.rutinas.Flexiones;
import com.danielreimundo.appgym.rutinas.Rutina;
import com.danielreimundo.appgym.rutinas.Sentadillas;

/**
 * Created by daniel.reimundo on 1/06/17.
 */

public class RutinaFactory {
    public static Rutina crearRutina(String tipoDeRutina){
        if(tipoDeRutina == null){
            return null;
        }
        switch (tipoDeRutina){
            case "Abdominales":
                return new Abdominales();
            case "Flexiones" :
                return new Flexiones();
            case "Sentadillas":
                return new Sentadillas();
            case "Correr":
                return new Correr();
            default:
                throw new IllegalArgumentException("Tipo de rutina no soportada");
        }
    }

}
