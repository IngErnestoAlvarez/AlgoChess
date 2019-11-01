package unidades;


import ErroresYExcepciones.CatapultaNoPuedeAtacarDeCerca;
import ErroresYExcepciones.CuranderoNoPuedeCurarUnaCatapulta;

public class Catapulta extends Unidad {

    public Catapulta(){
        vida = 50;
    }


    @Override
    public void recibirCuracion(int vidaCurada) throws CuranderoNoPuedeCurarUnaCatapulta{
        throw new CuranderoNoPuedeCurarUnaCatapulta();
    }


    public void ataqueLejano(Unidad unidad) {

        unidad.recibirDanio(20);

    }

    public void ataqueCercano(Unidad unidad) throws CatapultaNoPuedeAtacarDeCerca {
        throw new CatapultaNoPuedeAtacarDeCerca();
    }
}
