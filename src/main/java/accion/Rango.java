package accion;

public class Rango {

    private int rangoMaximo;
    private int rangoMinimo;

    public Rango(int min, int max){
        rangoMaximo = max;
        rangoMinimo = min;
    }

    boolean perteneceAlRango(int distancia){

        return distancia <= rangoMaximo && distancia >= rangoMinimo;

    }
}
