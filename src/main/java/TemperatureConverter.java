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

    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static void printTemperatureStatus(double celsius) {
        if (isExtremeTemperature(celsius)) {
            System.out.println(celsius + "°C is an extreme temperature.");
        } else {
            System.out.println(celsius + "°C is within the normal range.");
        }
    }

    public static void main(String[] args) {
        double fahrenheit = 100.0;
        double celsius = fahrenheitToCelsius(fahrenheit);
        System.out.println(fahrenheit + "°F is " + celsius + "°C");

        celsius = 37.0;
        fahrenheit = celsiusToFahrenheit(celsius);
        System.out.println(celsius + "°C is " + fahrenheit + "°F");

        double extremeTemp = -50.0;
        printTemperatureStatus(extremeTemp);

        double kelvin = 300.0;
        celsius = kelvinToCelsius(kelvin);
        System.out.println(kelvin + "K is " + celsius + "°C");
    }
}