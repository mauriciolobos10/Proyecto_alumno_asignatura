package servicios;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PromedioServicioImp {
    public Double calcularPromedio (List<Double> valores){
        Double promedio = 0.0;
        int contador = 0;
        for (Double valor : valores) {
            promedio += valor;
            contador++;
        }
        if (contador == 0){
            return 0.0;
        }
        return promedio / contador;
    }


}
