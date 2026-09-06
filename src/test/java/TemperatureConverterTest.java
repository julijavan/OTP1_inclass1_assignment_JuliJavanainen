import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TemperatureConverterTest {

    @Test
    public void testFahrenheitToCelsius() {
        assertEquals(0.0, TemperatureConverter.fahrenheitToCelsius(32), 0.001);
        assertEquals(100.0, TemperatureConverter.fahrenheitToCelsius(212), 0.001);
        assertEquals(-17.78, TemperatureConverter.fahrenheitToCelsius(0), 0.01);
        assertEquals(37.0, TemperatureConverter.fahrenheitToCelsius(98.6), 0.01);
    }

    @Test
    public void testCelsiusToFahrenheit() {
        assertEquals(32.0, TemperatureConverter.celsiusToFahrenheit(0), 0.001);
        assertEquals(212.0, TemperatureConverter.celsiusToFahrenheit(100), 0.001);
        assertEquals(98.6, TemperatureConverter.celsiusToFahrenheit(37), 0.01);
    }

    @Test
    public void testIsExtremeTemperature() {
        assertFalse(TemperatureConverter.isExtremeTemperature(-40));  // boundary
        assertFalse(TemperatureConverter.isExtremeTemperature(50));   // boundary
        assertTrue(TemperatureConverter.isExtremeTemperature(-40.1));
        assertTrue(TemperatureConverter.isExtremeTemperature(50.1));
        assertTrue(TemperatureConverter.isExtremeTemperature(-100));
        assertTrue(TemperatureConverter.isExtremeTemperature(100));
        assertFalse(TemperatureConverter.isExtremeTemperature(25));
    }
}