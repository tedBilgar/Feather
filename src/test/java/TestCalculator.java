import junit.framework.TestCase;
import mainSystem.service.userService.Calculator;

public class TestCalculator extends TestCase {
    public void testAdd(){
        Calculator calculator = new Calculator();
        int result = calculator.add(2,5);
        assertEquals(7,result);
    }
}
