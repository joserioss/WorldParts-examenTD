package cl.jrios.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cl.jrios.utility.impl.ChequeoComplejo;
import cl.jrios.utility.impl.ChequeoSimple;

public class AplicacionChequeoMargen {

	public static void aplicacionCheck() {
		List<Integer> listaPrecio = new ArrayList<>();
		List<Integer> listaCosto = new ArrayList<>();
		IChequeoMargen cheqSimple = new ChequeoSimple();
		IChequeoMargen cheqComplejo = new ChequeoComplejo();

		System.out.println("*******************************************");
		System.out.println(" Demostracion algoritmo VErificacion MArgen");
		System.out.println("*******************************************");
		System.out.println("\nLos montos aleatorios generados son: \n");
		
		Random r = new Random();
		for(int i = 0; i < 5; i++)		
		  listaPrecio.add((int) r.nextInt(2000-200 +1 )+200);
		for(int i = 0; i < 5; i++)		
			  listaCosto.add((int) r.nextInt(2000-200 +1 )+200);
		
		for(int i = 0; i < 5; i++) {
			Double x = Double.valueOf(listaPrecio.get(i));
			Double y = Double.valueOf(listaCosto.get(i));
			System.out.println("Precio " + x + "y Costo "+ y );
			System.out.println("Algoritmo Simple: " +cheqSimple.validar(x, y));
			System.out.println("Algoritmo Complejo: " +cheqComplejo.validar(x, y));
		}
			
	}
}
