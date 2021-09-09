package calc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Peter Veres
 */
public class CalculatorTest {
    
	Calculator underTest;
	
	@BeforeEach
	public void setUp() {
		underTest = new Calculator();
	}
	
    /**
     * Test of add method, of class Calculator.
     */
    @Test
    public void testAdd() {
    	
    	//Given
        System.out.println("add");
        int a = 12;
        int b = 30;
        int expResult = 42;
        
        //When
        int result = underTest.add(a, b);
        
        //Then
        Assertions.assertEquals(expResult, result);
    }
    
}
