package celda;


public class Posicion {

    private int fila;
    private int columna;

    public Posicion(){
        fila = 0;
        columna = 0;
    }
    public Posicion(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
    }


    public int medirDistancia(Posicion aComparar) {
        int distancia = 0;
        distancia += Math.abs(this.fila - aComparar.fila);
        distancia += Math.abs(this.columna - aComparar.columna);

        return distancia;
    }
}
