package JUnit.Geometria;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import JUnit.Junit09_Geometria.dto.Geometria;

class Geometría {

	Geometria geometria;

	
	@Test
	void testConstructorVacio() {
		geometria = new Geometria();
		assertEquals(geometria.getId(), 9);
		assertEquals("Default",geometria.getNom());
	}
	
	@Test
	void testConstructorCuadrado() {
		int id = 1;
		geometria = new Geometria(id);
		assertEquals("cuadrado",geometria.getNom());
	}
	
	@Test
	void testConstructorCirculo() {
		int id = 2;
		geometria = new Geometria(id);
		assertEquals("Circulo",geometria.getNom());
	}
	
	@Test
	void testConstructorTriangulo() {
		int id = 3;
		geometria = new Geometria(id);
		assertEquals("Triangulo",geometria.getNom());
	}
	
	@Test
	void testConstructorRectangulo() {
		int id = 4;
		geometria = new Geometria(id);
		assertEquals("Rectangulo",geometria.getNom());
	}
	
	@Test
	void testConstructorPentagono() {
		int id = 5;
		geometria = new Geometria(id);
		assertEquals("Pentagono",geometria.getNom());
	}
	
	@Test
	void testConstructorRombo() {
		int id = 6;
		geometria = new Geometria(id);
		assertEquals("Rombo",geometria.getNom());
	}
	
	@Test
	void testConstructorRomboide() {
		int id = 7;
		geometria = new Geometria(id);
		assertEquals("Romboide",geometria.getNom());
	}
	
	@Test
	void testConstructorTrapecio() {
		int id = 8;
		geometria = new Geometria(id);
		assertEquals("Trapecio",geometria.getNom());
	}
	
	@Test
	void testConstructorParametrosIncorrectos() {
		geometria = new Geometria(15);
		assertEquals("Default",geometria.getNom());
	}

	@Test
	void testAreaCuadrado() {
		geometria = new Geometria();
		int lado = 8;
		int resultado = geometria.areacuadrado(lado);
		int esperado = lado * lado;
		assertEquals(esperado,resultado);
		
	}
	@Test
	void testAreaCirculo() {
		geometria = new Geometria();
		int variable = 8;
		double resultado = geometria.areaCirculo(variable);
		double esperado =  Math.PI * Math.pow(variable,2);
		assertEquals(esperado,resultado,0.001);
	}
	@Test
	void testAreaTriangulo() {
		geometria = new Geometria();
		int a = 8;
		int b = 4;
		double resultado = geometria.areatriangulo(a,b);
		double esperado = (a*b)/2;
		assertEquals(esperado,resultado,0.001);
		
	}
	@Test
	void testAreaRectangulo() {
		geometria = new Geometria();
		int a = 10;
		int h = 6;
		double resultado = geometria.arearectangulo(a,h);
		double esperado = a*h;
		assertEquals(esperado,resultado);
	}
	@Test
	void testAreaPentagono() {
		geometria = new Geometria();
		int p = 7;
		int a = 10;
		double resultado = geometria.areapentagono(p,a);
		double esperado = (p*a) / 2;
		assertEquals(esperado,resultado);
	}
	@Test
	void testAreaRombo() {
		geometria = new Geometria();
		int D = 12;
		int d = 6;
		double resultado = geometria.arearombo(D,d);
		double esperado = (D*d)/2;
		assertEquals(esperado,resultado);
	}
	@Test
	void testAreaRomboide() {
		geometria = new Geometria();
		int b = 4;
		int h = 10;
		double resultado = geometria.arearomboide(b,h);
		double esperado = b*h;
		assertEquals(esperado,resultado);
	}
	@Test
	void testAreaTrapecio() {
		geometria = new Geometria();
		int B = 10;
		int b = 3;
		int h = 6;
		double resultado = geometria.areatrapecio(B,b,h);
		double esperado =((B+b)/2)*h;
		assertEquals(esperado,resultado);
	}
	
	@Test
	void testGetSetId() {
		int numero = 5;
		geometria = new Geometria();
		geometria.setId(numero);
		assertEquals(numero, geometria.getId());
	}
	@Test
	void testGetSetArea() {
		double numero = 8.84;
		geometria = new Geometria();
		geometria.setArea(numero);
		assertEquals(numero, geometria.getArea());
	}
	@Test
	void testToString() {
		geometria = new Geometria();
		int id = 1;
		String nom = "Cuadrado";
		double area = 8;
		geometria.setId(1);
		geometria.setNom(nom);
		geometria.setArea(area);
		String esperado = "Geometria [id=" + id + ", nom=" + nom + ", area=" + area + "]";
		assertEquals(esperado, geometria.toString());
	}
}
