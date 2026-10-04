package org.example;

public class TemperatureConverterConvertTest {

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static boolean isExtremeTemperature(double celsius) {
        return celsius < -40 || celsius > 50;
    }

    public static double convert(double value, String from, String to) {

        // Check that the input temperature is physically possible
        if (from.equalsIgnoreCase("K") && value < 0) {
            throw new IllegalArgumentException(
                    "Temperature cannot be below absolute zero"
            );
        }

        if (from.equalsIgnoreCase("C") && value < -273.15) {
            throw new IllegalArgumentException(
                    "Temperature cannot be below absolute zero"
            );
        }

        if (from.equalsIgnoreCase("F") && value < -459.67) {
            throw new IllegalArgumentException(
                    "Temperature cannot be below absolute zero"
            );
        }

        // Same unit
        if (from.equalsIgnoreCase(to)) {
            return value;
        }

        // Convert input to Celsius first
        double celsius;

        switch (from.toUpperCase()) {
            case "C":
                celsius = value;
                break;

            case "F":
                celsius = fahrenheitToCelsius(value);
                break;

            case "K":
                celsius = kelvinToCelsius(value);
                break;

            default:
                throw new IllegalArgumentException(
                        "Unknown temperature unit: " + from
                );
        }

        // Convert Celsius to target unit
        switch (to.toUpperCase()) {
            case "C":
                return celsius;

            case "F":
                return celsiusToFahrenheit(celsius);

            case "K":
                return celsiusToKelvin(celsius);

            default:
                throw new IllegalArgumentException(
                        "Unknown temperature unit: " + to
                );
        }
    }

    public static double speed(double distanceKm, double timeHours) {
        if (timeHours == 0) {
            throw new IllegalArgumentException("Time cannot be zero");
        }

        return distanceKm / timeHours;
    }

    public static void printTemperatureStatus(double celsius) {
        if (isExtremeTemperature(celsius)) {
            System.out.println(
                    celsius + "°C is an extreme temperature."
            );
        } else {
            System.out.println(
                    celsius + "°C is within the normal range."
            );
        }
    }

    public static void main(String[] args) {
        double fahrenheit = 100.0;
        double celsius = fahrenheitToCelsius(fahrenheit);
        System.out.println(
                fahrenheit + "°F is " + celsius + "°C"
        );

        celsius = 37.0;
        fahrenheit = celsiusToFahrenheit(celsius);
        System.out.println(
                celsius + "°C is " + fahrenheit + "°F"
        );

        double extremeTemp = -50.0;
        printTemperatureStatus(extremeTemp);

        double kelvin = 300.0;
        celsius = kelvinToCelsius(kelvin);
        System.out.println(
                kelvin + "K is " + celsius + "°C"
        );
    }
}
