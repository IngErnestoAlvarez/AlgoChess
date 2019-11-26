package modelo.unidad.accion;

import modelo.ErroresYExcepciones.RangoMuyCercano;
import modelo.ErroresYExcepciones.RangoMuyLejano;
import modelo.unidad.Unidad;

import java.util.*;


public class AtaqueCatapulta extends Accion{

    public AtaqueCatapulta(int danioInicial){
        puntosVida = danioInicial;
        rango = new Rango(6, 40);
    }

    @Override
    public void interactuar(Unidad unidad, int distancia, double incremento) throws RangoMuyLejano, RangoMuyCercano {

        rango.perteneceAlRango(distancia);

        HashSet<Unidad> atacados = new HashSet<>();
        Stack<Unidad> pila = new Stack<>();


        pila.add(unidad);

        while (! (pila.isEmpty())){  //Recorrido estilo BFS
            Unidad unidadAAtacar = pila.pop();

            if (!(atacados.contains(unidadAAtacar))){
                unidadAAtacar.recibirDanio(puntosVida*incremento);
                atacados.add(unidadAAtacar);

                pila.addAll(unidadAAtacar.verUnidadesAdyacentes());
            }

        }
    }

}
