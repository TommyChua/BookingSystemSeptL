
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {
    
    public LoginTest() {
    }
    
    @Test
    public void testBusinessLogin() {
        System.out.println("getLoginDetails");
        Login instance = new Login();
        String data = "CandyLand,Mr.Smith,68-Lunar Street,0529865665,smith,1";
        String[] expResult = data.split(",");
        String[] result = instance.login("smith", "1", "business.txt");
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testCustomerLogin() {
        System.out.println("getLoginDetails");
        Login instance = new Login();
        String data = "Tom,a,012321,fvsdsvfd,Tom,Tomm";
        String[] expResult = data.split(",");
        String[] result = instance.login("Tom", "Tomm", "customerinfo.txt");
        assertArrayEquals(expResult, result);
    }
}
