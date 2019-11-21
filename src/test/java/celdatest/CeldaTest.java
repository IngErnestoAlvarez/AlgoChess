package celdatest;

import modelo.ErroresYExcepciones.CeldaNoTieneUnidad;
import modelo.ErroresYExcepciones.CeldaYaTieneUnidad;
import modelo.unidad.Unidad;
import modelo.celda.Celda;
import junit.framework.TestCase;

import static org.mockito.Mockito.mock;

public class CeldaTest extends TestCase {

    public void test00CeldaNoEstaVaciaAlSerCreada(){
        Celda celda = new Celda();

        assertNotNull(celda);
    }

    public void test01CeldaEstaVaciaRecienCreada(){
        Celda celda = new Celda();


        try{
            celda.verUnidad();
            fail("No se ĺanzó la excepcion que la modelo.celda no tiene modelo.unidad");
        } catch (CeldaNoTieneUnidad celdaNoTieneUnidad) {
        }
    }

    public void test02CeldaEstaOcupadaAlInsertarUnaUnidad() throws CeldaYaTieneUnidad {
        Celda celda = new Celda();

        Unidad unidad = mock(Unidad.class);

        celda.colocarUnidad(unidad);

        try{
            celda.verUnidad();
        } catch (CeldaNoTieneUnidad celdaNoTieneUnidad) {
            fail();
        }
    }


    public void test03CeldaEstaVaciaDespuesDeQuitarLaUnidad() throws CeldaYaTieneUnidad{
        try {
            Celda celda = new Celda();

            Unidad unidad = mock(Unidad.class);

            celda.colocarUnidad(unidad);

            celda.quitarUnidad();

            try{
                celda.verUnidad();
                fail();
            } catch (CeldaNoTieneUnidad celdaNoTieneUnidad) {
            }
        }
        catch (CeldaNoTieneUnidad  e){
            fail("Lanzada la excepcion: CeldaNoTieneUnidad");
        }
    }

    public void test04CeldaTiraExcepcionSiQuitoUnidadCuandoNoTiene(){
        Celda celda = new Celda();
        try{
            celda.quitarUnidad();
            fail("No se lanzo la excepcion");
        }catch (CeldaNoTieneUnidad e){}

    }

    public void test05CeldaOcupadaTiraExcepcionSiIntentoColocarOtraUnaUnidad(){
        Celda celda = new Celda();

        Unidad unidad1 = mock(Unidad.class);

        try {
            celda.colocarUnidad(unidad1);
        }
        catch(CeldaYaTieneUnidad e){
            fail("No se pudo colocar la primer modelo.unidad");
        }
        Unidad unidad2 = mock(Unidad.class);

        try{
            celda.colocarUnidad(unidad2);
            fail("Se colocaron 2 unidades en una modelo.celda. No tiro excepcion");
        }
        catch (CeldaYaTieneUnidad e){
        }
    }

    public void test06CeldaOcupadaGuardaBienLaUnidadQueSeLeColoca() throws CeldaYaTieneUnidad {
        Celda celda = new Celda();

        Unidad unidad = mock(Unidad.class);
        celda.colocarUnidad(unidad);

        try {
            assertEquals(unidad, celda.verUnidad());
        }
        catch(CeldaNoTieneUnidad e){
            fail("Se lanzo la expcecion: CeldaNoTieneUnidad");
        }
    }

    public void test07CeldaEstaADistanciaUnoDeOtraCelda(){
        Celda celda1 = new Celda( 1, 2);
        Celda celda2 = new Celda( 1, 1);

        assertEquals(1, celda1.medirDistacia(celda2));
    }
    

}