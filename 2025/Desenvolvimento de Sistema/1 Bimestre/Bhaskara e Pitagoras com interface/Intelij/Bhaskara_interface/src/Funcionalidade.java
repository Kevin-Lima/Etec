public class Funcionalidade {

    // Metodo para calcular o valor de Delta (b² - 4ac)
    public double calcularDelta(double a, double b, double c) {
        return Math.pow(b, 2) - (4 * a * c);
    }

    // Metodo para calcular as raízes da equação, se existirem
    // A gente colocou [] pra transformar o retorno em um array, assim dá pra devolver dois ou mais valores de uma vez
    public double[] calcularRaizes(double a, double b, double delta) {
        if (delta < 0) {
            return null; // Retorna null se não houver raízes reais
        }
        double raizX1 = (-b + Math.sqrt(delta)) / (2 * a);
        double raizX2 = (-b - Math.sqrt(delta)) / (2 * a);
        return new double[]{raizX1, raizX2};// Retorna um array com as duas raizes
    }
}
