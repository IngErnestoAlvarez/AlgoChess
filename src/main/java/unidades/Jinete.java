package unidades;

public class Jinete extends Unidad {

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

