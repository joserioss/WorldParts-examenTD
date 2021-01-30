package cl.jrios.utility;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import cl.jrios.utility.impl.ChequeoSimple;

public class AplicacionChequeoMargenTest {
	
	@Test
	public void testAlgoritmoSimpleOK() {
		Double precio_venta = 150.0;
		Double costo = 100.0;
		String status;
		
		IChequeoMargen testCheq = new ChequeoSimple();
		status = testCheq.validar(precio_venta, costo);
		assertEquals("MARGEN OK", status);
	}
	
	@Test
	public void testAlgoritmoSimpleBajo() {
		Double precio_venta = 110.0;
		Double costo = 100.0;
		String status;
		
		IChequeoMargen testCheq = new ChequeoSimple();
		status = testCheq.validar(precio_venta, costo);
		assertEquals("MARGEN BAJO MINIMO", status);
	}
	
	@Test
	public void testAlgoritmoSimpleLimite() {
		Double precio_venta = 100.0;
		Double costo = 100.0;
		String status;
		
		IChequeoMargen testCheq = new ChequeoSimple();
		status = testCheq.validar(precio_venta, costo);
		assertEquals("MARGEN BAJO MINIMO", status);
	}

}
