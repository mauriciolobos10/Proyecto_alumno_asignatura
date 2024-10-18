import org.junit.jupiter.api.Test;
import servicios.PromedioServicioImp;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PromedioServicioTest {

    @Test
    public void calcularPromedioTest() {
        PromedioServicioImp promedioserv = new PromedioServicioImp();

        //agrega valores para sumar
        List<Double> valores = new ArrayList<>();
        valores.add(2.0);
        valores.add(4.0);
        valores.add(6.0);

        //llama al metodo y almacena valor
        double resultado = promedioserv.calcularPromedio(valores);

        //valida resultado
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
