package unidades;

import ErroresYExcepciones.*;

public abstract class Unidad {

    int vida;
    static int precio;

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
