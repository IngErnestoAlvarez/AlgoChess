package unidades;


import ErroresYExcepciones.CatapultaNoPuedeAtacarDeCerca;
import ErroresYExcepciones.CuranderoNoPuedeCurarUnaCatapulta;

public abstract class Unidad {

    protected int vida;

    public int getVida(){
        return vida;
    }

    void recibirCuracion(int vidaCurada) throws CuranderoNoPuedeCurarUnaCatapulta {

        vida += vidaCurada;
    }

    void recibirDanio(int danio){

        vida -= danio;
    }
}
