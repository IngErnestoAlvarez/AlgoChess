package unidades;

public class Curandero extends Unidad {

    public Curandero(){
        vida = 75;
    }


    public void curar(Unidad unidad) {

        unidad.recibirCuracion(15);
    }
}
