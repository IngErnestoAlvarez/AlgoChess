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

    @Override
    public boolean equals(Object otraPosicion){
        Posicion unaPosicion = (Posicion) otraPosicion;
        return this.medirDistancia(unaPosicion) == 0;
    }

    @Override
    public int hashCode(){
        return 1;
    }

    public Posicion abajo(){
        return new Posicion(fila+1, columna);
    }
    public Posicion arriba(){
        return new Posicion(fila-1, columna);
    }
    public Posicion izquierda(){
        return new Posicion(fila, columna-1);
    }
    public Posicion derecha(){
        return new Posicion(fila, columna+1);
    }

}
