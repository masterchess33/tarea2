
import Paquetes.Archivos;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;


public class archivosTest {
    @Test
    public void leerArchivoTest() {
        ArrayList<String> resultado=new ArrayList(Archivos.leerArchivo("listado.csv"));
        ArrayList<String> esperado=new ArrayList(5);
        esperado.add("polyester,S,false");
        esperado.add("algodon,M,true");
        esperado.add("spandex,XL,true");
        esperado.add("algodon,L,false");
        esperado.add("polyester,M,true");
        assertEquals(esperado.get(0),resultado.get(0));
    }
    
    
}
