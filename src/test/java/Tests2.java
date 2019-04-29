import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import javax.xml.bind.SchemaOutputResolver;

public class Tests2 {
    @Test(description = "Test de ruta critica suite 1" ,groups="RC")
    protected void testRc(){
        System.out.println("Esto es ruta critica");
        Assert.assertTrue(true,"Hola yo soy un test que pasa :)");
    }

    @Test(description = "Test de smoke suite 1",groups="SMOKE")
    protected void testSmoke(){
        System.out.println("Esto es Smoke Test");
        Assert.assertTrue(true,"Hola yo soy un smokeTest :)");
    }




}
