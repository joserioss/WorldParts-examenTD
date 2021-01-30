package cl.jrios.utility;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import cl.jrios.utility.impl.ChequeoComplejo;

public class AplicacionChequeoMargenComplejoTest {
	
//	Test mayor a 1000
	
	@Test
	public void testAlgoritmoComplejoOK() {
		Double precio_venta = 15000.0;
		Double costo = 10000.0;
		String status;
		
		IChequeoMargen testCheq = new ChequeoComplejo();
		status = testCheq.validar(precio_venta, costo);
		assertEquals("MARGEN OK", status);
	}
	
	@Test
	public void testAlgoritmoComplejoBajo() {
		Double precio_venta = 10500.0;
		Double costo = 10000.0;
		String status;
		
		IChequeoMargen testCheq = new ChequeoComplejo();
		status = testCheq.validar(precio_venta, costo);
		assertEquals("ALERTA MARGEN BAJO MINIMO", status);
	}
	
	@Test
	public void testAlgoritmoComplejoLimiteInf() {
		Double precio_venta = 9000.0;
		Double costo = 10000.0;
		String status;
		
		IChequeoMargen testCheq = new ChequeoComplejo();
		status = testCheq.validar(precio_venta, costo);
		assertEquals("ERROR MARGEN NEGATIVO", status);
	}

}
