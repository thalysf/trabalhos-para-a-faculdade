
package Ex01;

public class Distancia {
    public static double calcularDistancia(double x1, double x2, double y1, double y2)
    {
        return Math.sqrt((Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }
}
