package modelo.unidad;

import java.util.HashMap;

public class FabricaUnidad {

    private HashMap<String, Unidad> fabricaUnidades;

    public FabricaUnidad() {

        this.fabricaUnidades = new HashMap<>(4,2);

        fabricaUnidades.put("SOLDADO", new Soldado());
        fabricaUnidades.put("JINETE", new Jinete());
        fabricaUnidades.put("CATAPULTA", new Catapulta());
        fabricaUnidades.put("CURANDERO", new Curandero());

    }

    public Unidad fabricar(String clave){

        return this.fabricaUnidades.get(clave.toUpperCase());
    }
}
