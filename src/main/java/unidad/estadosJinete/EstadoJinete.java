package unidad.estadosJinete;

import ErroresYExcepciones.RangoMuyCercano;
import ErroresYExcepciones.RangoMuyLejano;
import unidad.accion.Accion;
import unidad.Unidad;

public abstract class EstadoJinete {

    Accion accion;

    public abstract EstadoJinete cambiarEstado();

    public void atacar(Unidad unidad, int distancia) throws RangoMuyLejano, RangoMuyCercano {

        accion.interactuar(unidad, distancia);
    }
}
