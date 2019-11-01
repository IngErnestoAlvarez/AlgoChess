package unidades;

public class Soldado extends Unidad {

    public Soldado(){

        vida = 100;

    }

    public void ataqueCercano(Unidad unidad) {

        unidad.recibirDanio(10);


    }

    public void ataqueLejano(Unidad unidad) {

        unidad.recibirDanio(0);
    }

}
