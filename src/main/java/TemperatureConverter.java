public class TemperatureConverter {

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static boolean isExtremeTemperature(double celsius) {
        return celsius < -40 || celsius > 50;
    }

    public static void main(String[] args) {
        double fahrenheit = 100.0;
        double celsius = fahrenheitToCelsius(fahrenheit);
        System.out.println(fahrenheit + "°F is " + celsius + "°C");

        celsius = 37.0;
        fahrenheit = celsiusToFahrenheit(celsius);
        System.out.println(celsius + "°C is " + fahrenheit + "°F");

        double extremeTemp = -50.0;
        if (isExtremeTemperature(extremeTemp)) {
            System.out.println(extremeTemp + "°C is an extreme temperature.");
        } else {
            System.out.println(extremeTemp + "°C is within the normal range.");
        }
    }
}