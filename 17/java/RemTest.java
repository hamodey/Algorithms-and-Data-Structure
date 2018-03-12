import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RemTest {
    @Test
    public void testRem() {
        BigInt b1 = new BigInt("13");
        BigInt b2 = new BigInt("4");
        BigInt b3 = b1.Rem(b2);
        assertEquals("12/4 != 3?", 1, b3.get(0));

    }
}
