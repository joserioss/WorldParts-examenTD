package cl.jrios.utility.impl;

import cl.jrios.utility.IChequeoMargen;

public class ChequeoComplejo implements IChequeoMargen{

	@Override
	public String validar(Double precio_venta, Double costo) {
		String status;
		Double margen = ((precio_venta - costo)/precio_venta);
		if(precio_venta < 1000.0) {
			if(margen >= 0.1 && margen <= 0.5) {
				status = "MARGEN OK";
			}
			else if( margen < 0.1 && margen >= 0.0){
				status = "ALERTA MARGEN BAJO MINIMO";
			}
			else if( margen < 0.0){
				status = "ERROR MARGEN NEGATIVO";
			}
			else if( margen > 0.5){
				status = "ADVERTENCIA POSIBLE ERROR COSTO";
			}
			else {
				status = "INDEFINIDO";
			}
		}
		else if (precio_venta >= 1000.0) {
			if(margen >= 0.1 && margen <= 1.0) {
				status = "MARGEN OK";
			}
			else if( margen < 0.1 && margen >= 0.0){
				status = "ALERTA MARGEN BAJO MINIMO";
			}
			else if( margen < 0.0){
				status = "ERROR MARGEN NEGATIVO";
			}
			else if( margen > 1.0){
				status = "ADVERTENCIA POSIBLE ERROR EN COSTO";
			}
			else {
				status = "INDEFINIDO";
			}
		}
		else {
			status = "INDEFINIDO";
		}
		return status;
	}

}
