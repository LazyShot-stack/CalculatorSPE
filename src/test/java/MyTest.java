import com.dhruvik.Main;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class MyTest {

    @Test
    @DisplayName("Power function working for positive values.")
    public void testPositiveNumbers() {
        assertEquals(8.0, Main.pow(2, 3));
        assertEquals(27.0, Main.pow(3, 3));
    }
}
