package models;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Utilidades {
    public static double redondearNota(double n){
        BigDecimal m = new BigDecimal(n).setScale(1, RoundingMode.HALF_UP);

        return m.doubleValue();
    }
}
