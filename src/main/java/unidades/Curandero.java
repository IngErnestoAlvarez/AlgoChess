package unidades;

import ErroresYExcepciones.CuranderoNoPuedeCurarDeLejos;
import ErroresYExcepciones.CuranderoNoPuedeCurarUnaCatapulta;

public class Curandero extends Unidad {

    public static int precio = 2;

    public Curandero(){
        vida = 75;

    }


    public void curarCercano(Unidad unidad) throws CuranderoNoPuedeCurarUnaCatapulta {

        unidad.recibirCuracion(15);
    }

    public void curarLejano(Unidad unidad) throws CuranderoNoPuedeCurarDeLejos{
        throw new CuranderoNoPuedeCurarDeLejos();
    }
}
