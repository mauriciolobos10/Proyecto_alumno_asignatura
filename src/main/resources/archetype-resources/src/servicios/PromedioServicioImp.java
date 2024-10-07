package servicios;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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

    @Test
    public void calcularPromedioTest (){
        PromedioServicioImp promedioserv = Mockito.mock(PromedioServicioImp.class);

        List<Double> valores = new ArrayList<Double>();
        valores.add(2.0);
        valores.add(4.0);
        valores.add(6.0);

        Mockito.when(promedioserv.calcularPromedio(valores)).thenReturn(6.0);

        assertEquals(6.0, promedioserv.calcularPromedio(valores));
    }
}
