import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Tests3 {
    @Test(description = "Test de ruta critica suite 2",groups="RC")
    protected void testRc(){

        System.out.println("Esto es ruta critica");
        Assert.assertTrue(true,"Hola yo soy un test de ruta critica");
    }

    @Test(description = "Test de smoke suite 2",groups = "SMOKE")
    protected void testSmoke(){
        System.out.println("Esto es un smoke test");

        Assert.assertTrue(true,"Hola yo soy un smokeTest :)");
    }
}
