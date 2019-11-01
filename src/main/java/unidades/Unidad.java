package unidades;

public abstract class Unidad {

    protected int vida;
    protected Accion accionUnidad;

    public int getVida(){
        return vida;
    }

    void recibirCuracion(int vidaCurada) {

        vida += vidaCurada;
    }

    void recibirDanio(int danio){

        vida -= danio;
    }
}
