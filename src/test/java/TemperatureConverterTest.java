import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TemperatureConverterTest {

    private static final double DELTA = 0.001;

    @Test
    void testFahrenheitToCelsius() {
        assertEquals(100.0, TemperatureConverter.fahrenheitToCelsius(212.0), DELTA);
    }

    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(98.6, TemperatureConverter.celsiusToFahrenheit(37.0), DELTA);
    }

    @Test
    void testIsExtremeTemperatureTrue() {
        assertTrue(TemperatureConverter.isExtremeTemperature(-50.0));
    }

    @Test
    void testIsExtremeTemperatureFalse() {
        assertFalse(TemperatureConverter.isExtremeTemperature(20.0));
    }

    @Test
    void testKelvinToCelsius() {
        assertEquals(26.85, TemperatureConverter.kelvinToCelsius(300.0), DELTA);
    }

    @Test
    void testKelvinToCelsiusAbsoluteZero() {
        assertEquals(-273.15, TemperatureConverter.kelvinToCelsius(0.0), DELTA);
    }

    @Test
    void testKelvinToCelsiusWaterFreezing() {
        assertEquals(0.0, TemperatureConverter.kelvinToCelsius(273.15), DELTA);
    }

    @Test
    void testConstructor() {
        new TemperatureConverter();
    }

    @Test
    void testMain() {
        TemperatureConverter.main(new String[]{});
    }

    @Test
    void testIsExtremeTemperature_onlySecondConditionTrue() {
        assertTrue(TemperatureConverter.isExtremeTemperature(100.0));
    }

    @Test
    void testPrintTemperatureStatus_normal() {
        TemperatureConverter.printTemperatureStatus(20.0);
    }
}