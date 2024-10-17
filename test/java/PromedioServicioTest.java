import org.junit.jupiter.api.Test;
import servicios.PromedioServicioImp;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PromedioServicioTest {

    @Test
    public void calcularPromedioTest() {
        // Crear una instancia real de la clase PromedioServicioImp
        PromedioServicioImp promedioserv = new PromedioServicioImp();

        // Datos de prueba
        List<Double> valores = new ArrayList<>();
        valores.add(2.0);
        valores.add(4.0);
        valores.add(6.0);

        // Llamada al método real y verificación
        double resultado = promedioserv.calcularPromedio(valores);

        // Validación del resultado
        assertEquals(4.0, resultado, 0.001);
    }


//    public void calcularPromedioTest (){
//        PromedioServicioImp promedioserv = Mockito.mock(PromedioServicioImp.class);
//
//        List<Double> valores = new ArrayList<Double>();
//        valores.add(2.0);
//        valores.add(4.0);
//        valores.add(6.0);
//
//        Mockito.when(promedioserv.calcularPromedio(valores)).thenReturn(6.0);
//
//        assertEquals(6.0, promedioserv.calcularPromedio(valores));
//    }

}
