package cl.jrios.utility.impl;

import cl.jrios.utility.IChequeoMargen;

public class ChequeoSimple implements IChequeoMargen{

	@Override
	public String validar(Double precio_venta, Double costo) {
		String status;
		Double margen = ((precio_venta - costo)/precio_venta);
		if(margen >= 0.1 ) {
			status = "MARGEN OK";
		}
		else if( margen < 0.1){
			status = "MARGEN BAJO MINIMO";
		}
		else {
			System.out.println(margen);
			status = "Indefinido";
		}
		return status;
	}

}
