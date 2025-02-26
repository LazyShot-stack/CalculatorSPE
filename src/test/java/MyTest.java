import com.dhruvik.Main;
import org.junit.jupiter.api.*;

class MyTest {

    @Test
    @DisplayName("Power function working for positive values.")
    void testPositiveNumbers() {
        Assertions.assertEquals(8.0, Main.pow(2, 3));
        Assertions.assertEquals(27.0, Main.pow(3, 3));
    }

}
