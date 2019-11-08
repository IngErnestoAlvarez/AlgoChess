package unidad;

import ErroresYExcepciones.*;

public class FabricaUnidad {

    public FabricaUnidad() {

    }

    public Unidad fabricar(String claseUnidad) throws EquipoQuiereCrearUnidadInvalida {

        if (claseUnidad.equalsIgnoreCase("SOLDADO")) {
            return new Soldado();
        } else if (claseUnidad.equalsIgnoreCase("JINETE")) {
            return new Jinete();
        } else if (claseUnidad.equalsIgnoreCase("CURANDERO")) {
            return new Curandero();
        } else if (claseUnidad.equalsIgnoreCase("CATAPULTA")) {
            return new Catapulta();
        }
        throw new EquipoQuiereCrearUnidadInvalida();
    }
}
