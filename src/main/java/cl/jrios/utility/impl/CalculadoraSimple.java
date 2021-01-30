package cl.jrios.utility.impl;

import java.util.List;

import cl.jrios.utility.ICalculadoraBeneficios;

public class CalculadoraSimple implements ICalculadoraBeneficios{

	@Override
	public Integer calcula(List<Integer> ingreso) {
		Double porcentajeRecargo = 1.03;
		List<Integer> listaIngresos = ingreso;
		Integer sumaTotal = 0;
		for (Integer sum : listaIngresos) {
			sumaTotal += sum;
		}
		
		Integer beneficioTotal = (int) (sumaTotal*porcentajeRecargo);
		System.out.println("Ingresos con algoritmo de beneficio simple: " + beneficioTotal + " US$");
		return beneficioTotal;
	}

}
