package unidades;

public class Jinete extends Unidad {

    public static int precio = 3;

    public Jinete(){
        vida = 100;

    }


    public void ataqueCercano(Unidad unidad) {

        unidad.recibirDanio(5);
    }

    public void ataqueLejano(Unidad unidad){

        unidad.recibirDanio(15);

    }
}

