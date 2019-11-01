package unidades;

public class Catapulta extends Unidad {

    public Catapulta(){
        vida = 50;
    }


    @Override
    public void recibirCuracion(int vidaCurada){
        vida += 0;
    }


    public void ataqueLejano(Unidad unidad) {

        unidad.recibirDanio(20);

    }
}
