/**
 * Created by home on 11.03.2016.
 */
public class TemperatureConvertor {
    final static double FACTOR = 1.8;
    final static int SUPPLEMENT = 32;
    public static double convertToFarenheit (double tempCelcius) {
        return tempCelcius * FACTOR + SUPPLEMENT;
    }
    public static double convertToCelcius (double tempFarenheit) {
        return (tempFarenheit -  SUPPLEMENT) / FACTOR ;
    }
}
