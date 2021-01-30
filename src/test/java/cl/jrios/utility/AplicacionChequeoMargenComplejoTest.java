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
	
	@Test
	public void testAlgoritmoComplejoLimiteSup() {
		Double precio_venta = 19000.0;
		Double costo = -100000.0;
		String status;
		
		IChequeoMargen testCheq = new ChequeoComplejo();
		status = testCheq.validar(precio_venta, costo);
		assertEquals("ADVERTENCIA POSIBLE ERROR EN COSTO", status);
	}

//	Test menor a 1000
	
	@Test
	public void testAlgoritmoComplejoOKMen() {
		Double precio_venta = 150.0;
		Double costo = 100.0;
		String status;
		
		IChequeoMargen testCheq = new ChequeoComplejo();
		status = testCheq.validar(precio_venta, costo);
		assertEquals("MARGEN OK", status);
	}
	
	@Test
	public void testAlgoritmoComplejoBajoMen() {
		Double precio_venta = 105.0;
		Double costo = 100.0;
		String status;
		
		IChequeoMargen testCheq = new ChequeoComplejo();
		status = testCheq.validar(precio_venta, costo);
		assertEquals("ALERTA MARGEN BAJO MINIMO", status);
	}
	
	@Test
	public void testAlgoritmoComplejoLimiteInfMen() {
		Double precio_venta = 90.0;
		Double costo = 100.0;
		String status;
		
		IChequeoMargen testCheq = new ChequeoComplejo();
		status = testCheq.validar(precio_venta, costo);
		assertEquals("ERROR MARGEN NEGATIVO", status);
	}
	
	@Test
	public void testAlgoritmoComplejoLimiteSupMen() {
		Double precio_venta = 210.0;
		Double costo = 100.0;
		String status;
		
		IChequeoMargen testCheq = new ChequeoComplejo();
		status = testCheq.validar(precio_venta, costo);
		assertEquals("ADVERTENCIA POSIBLE ERROR COSTO", status);
	}

}
