import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DivTest {
    @Test
    public void testDiv() {
        BigInt b1 = new BigInt("12");
        BigInt b2 = new BigInt("4");
        BigInt b3 = b1.Div(b2);
        assertEquals("12/4 != 3?", 3, b3.get(0));

    }
}
