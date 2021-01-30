package cl.jrios.utility.impl;

import java.util.List;

import cl.jrios.utility.ICalculadoraBeneficios;

public class CalculadoraCompleja implements ICalculadoraBeneficios{

	@Override
	public Integer calcula(List<Integer> ingreso) {
		Double porcentajeRecargoInvariable = 1.01;
		List<Integer> listaIngresos = ingreso;
		Double sumaTotal = 0.0;
		Double sumasExtras = 0.0;
		for (Integer sum : listaIngresos) {
			if(sum >= 1000) {
				sumasExtras = sum*0.05;
			}
			else if( sum>= 500 && sum < 1000){
				sumasExtras = sum*0.02;
			}
			sumaTotal = sum + sumasExtras + sumaTotal;
		}
		if(sumaTotal >= 5000) {
			sumaTotal = sumaTotal + 100;
		}
		
		Integer beneficioTotal = (int) (sumaTotal*porcentajeRecargoInvariable);
		System.out.println("Ingresos con algoritmo de beneficio complejos: " + beneficioTotal + " US$");
		return beneficioTotal;
	}

}
