package cl.jrios.utility.impl;

import cl.jrios.utility.IChequeoMargen;

public class ChequeoComplejo implements IChequeoMargen{

	@Override
	public String validar(Double precio_venta, Double costo) {
		String status;
		Double margen = ((precio_venta - costo)/precio_venta);
		if(costo < 1000.0) {
			if(margen >= 0.1 && margen <= 0.5) {
				status = "MARGEN OK";
				System.out.println(margen);

			}
			else if( margen < 0.1 && margen >= 0){
				status = "ALERTA MARGEN BAJO MINIMO";
				System.out.println(margen);

			}
			else if( margen < 0){
				status = "ERROR MARGEN NEGATIVO";
				System.out.println(margen);

			}
			else if( margen > 0.5){
				status = "ADVERTENCIA POSIBLE ERROR COSTO";
				System.out.println(margen);

			}
			else {
				status = "INDEFINIDO";
				System.out.println(margen);

			}
		}
		else if (costo >= 1000.0) {
			if(margen >= 0.1 && margen <= 1) {
				status = "MARGEN OK";
				System.out.println(margen);

			}
			else if( margen < 0.1 && margen >= 0){
				System.out.println(margen);
				status = "ALERTA MARGEN BAJO MINIMO";
			}
			else if( margen < 0){
				status = "ERROR MARGEN NEGATIVO";
				System.out.println(margen);

			}
			else if( margen > 1.0){
				status = "ADVERTENCIA POSIBLE ERROR EN COSTO";
				System.out.println(margen);

			}
			else {
				status = "INDEFINIDO";
				System.out.println(margen);

			}
		}
		else {
			status = "INDEFINIDO";
		}
		return status;
	}

}
