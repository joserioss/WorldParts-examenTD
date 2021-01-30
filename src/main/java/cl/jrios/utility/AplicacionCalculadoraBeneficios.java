package cl.jrios.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cl.jrios.utility.impl.CalculadoraCompleja;
import cl.jrios.utility.impl.CalculadoraSimple;

public class AplicacionCalculadoraBeneficios {

	public static void aplicacionCB() {
		List<Integer> listaIngreso = new ArrayList<>();

		System.out.println("*******************************************");
		System.out.println(" Calculadora de beneficios para VENDEDORES");
		System.out.println("*******************************************");
		System.out.println("\nLos montos aleatorios generados son: \n");
		
		Random r = new Random();
		for(int i = 0; i < 10; i++)		
		  listaIngreso.add((int) r.nextInt(2000-100 +1 )+100);
		
		for(Integer valor:listaIngreso)
			System.out.print( valor + " " );

		System.out.println("(US$)");
		
//		Calculo beneficios simples
		ICalculadoraBeneficios iCalculadoraSimple = new CalculadoraSimple();
		iCalculadoraSimple.calcula(listaIngreso);

//		Calculo beneficios complejos
		ICalculadoraBeneficios iCalculadoraCompleja = new CalculadoraCompleja();
		iCalculadoraCompleja.calcula(listaIngreso);
	}
}
