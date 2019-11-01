package TableroTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class TableroTest extends TestCase {

	public void test00SeCreaTableroYLaReferenciaNoEsVacia(){
		Tablero nuevoTablero = new Tablero( 20,20 );
		Assert.assertNoNull( nuevoTablero );
	}

}