package UD19_ex5.UD19_ex5;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class CalculadoraTest 
{
	CalculadoraLogica calculadora;
	
    @Test
    public void sumarTest()
    {
    	calculadora = new CalculadoraLogica();
        double num1 = 5;
        double num2 = 6;
        String signo = "+";
        double esperado = 11;
        calculadora.guardarSigno(signo, num1+"");
        calculadora.hacerOperacion(num2);
        assertEquals(esperado+"", calculadora.lastResult);
    }
    @Test
    public void restarTest() {
    	calculadora = new CalculadoraLogica();
        double num1 = 6;
        double num2 = 5;
        String signo = "-";
        double esperado = 1;
        calculadora.guardarSigno(signo, num1+"");
        calculadora.hacerOperacion(num2);
        assertEquals(esperado+"", calculadora.lastResult);
    }
    @Test
    public void multiplicarTest() {
    	calculadora = new CalculadoraLogica();
        double num1 = 6;
        double num2 = 5;
        String signo = "*";
        double esperado = 30;
        calculadora.guardarSigno(signo, num1+"");
        calculadora.hacerOperacion(num2);
        assertEquals(esperado+"", calculadora.lastResult);
    }
    @Test
    public void dividirTest() {
    	calculadora = new CalculadoraLogica();
        double num1 = 5;
        double num2 = 5;
        String signo = "/";
        double esperado = 1;
        calculadora.guardarSigno(signo, num1+"");
        calculadora.hacerOperacion(num2);
        assertEquals(esperado+"", calculadora.lastResult);
    }
    @Test
    public void dividirCeroTest() {
    	calculadora = new CalculadoraLogica();
        double num1 = 1000;
        double num2 = 0;
        String signo = "/";
        String esperado = "Infinity";
        calculadora.guardarSigno(signo, num1+"");
        calculadora.hacerOperacion(num2);
        assertEquals(esperado+"", calculadora.lastResult);
    }
    @Test
    public void signoIncorrectoTest() {
    	calculadora = new CalculadoraLogica();
        double num1 = 50;
        double num2 = 50;
        String signo = "asld";
        String esperado = "0.0";
        calculadora.guardarSigno(signo, num1+"");
        calculadora.hacerOperacion(num2);
        assertEquals(esperado, calculadora.lastResult);
    }
    @Test
    public void cambioNum1Num2() {
    	calculadora = new CalculadoraLogica();
    	double num2 = 5;
    	calculadora.hacerOperacion(num2);
    	assertEquals(num2+"",calculadora.lastResult);
    	calculadora = new CalculadoraLogica();
    	calculadora.lastResult = "";
    	num2 = 5;
    	calculadora.hacerOperacion(num2);
    	assertEquals(num2+"",calculadora.lastResult);
    }
    @Test
    public void guardarSignoNullEmpty() {
    	calculadora = new CalculadoraLogica();
        double num1 = 10;
        double num2 = 2;
        String signo = "+";
        calculadora.lastResult = num1+"";
        calculadora.operator = "*";
        double esperado = 10 * 2;
        calculadora.guardarSigno(signo, 2+"");
        assertEquals(esperado+"", calculadora.lastResult);
    }
    @Test
    public void resetTest() {
    	calculadora = new CalculadoraLogica();
    	calculadora.reset();
        assertEquals("", calculadora.lastResult);
        assertEquals("", calculadora.operator);
    }
    @Test
    public void cambiarSignoMasTest() {
    	calculadora = new CalculadoraLogica();
    	String num1 = "1";
    	assertEquals("-1", calculadora.cambiarSigno(num1));
    }
    @Test
    public void cambiarSignoMenosTest() {
    	calculadora = new CalculadoraLogica();
    	String num1 = "-1";
    	assertEquals("1", calculadora.cambiarSigno(num1));
    	calculadora = new CalculadoraLogica();
    	num1 = "";
    	assertEquals("-", calculadora.cambiarSigno(num1));
    }
    @Test
    public void crearVistaTest() {
    	calculadora = new CalculadoraLogica();
    	Vista vista = new Vista(calculadora);
    }
    @Test
    public void putComaWithoutNumberVistaTest() {
    	calculadora = new CalculadoraLogica();
    	Vista vista = new Vista(calculadora);
    	vista.putComa();
    	assertEquals("0.", vista.textField.getText());
    }
    @Test
    public void putComaWithNumberVistaTest() {
    	calculadora = new CalculadoraLogica();
    	Vista vista = new Vista(calculadora);
    	vista.textField.setText("11");
    	vista.putComa();
    	assertEquals("11.", vista.textField.getText());
    	vista.putComa();
    	assertEquals("11.", vista.textField.getText());
    }
    @Test
    public void eraseLastNumerVistaTest() {
    	calculadora = new CalculadoraLogica();
    	Vista vista = new Vista(calculadora);
    	vista.textField.setText("11");
    	vista.eraseLastNum();
    	assertEquals("1", vista.textField.getText());
    	//Si el ultimo ha sido una operación borra el número entero para que al usuario le sea mas intuitivo
    	vista.logica.lastWasOperation = true;
    	vista.textField.setText("11111");
    	vista.eraseLastNum();
    	assertEquals("", vista.textField.getText()); 	
    }
    @Test
    public void cambiarSignoVistaTest() {
    	calculadora = new CalculadoraLogica();
    	Vista vista = new Vista(calculadora);
    	vista.cambiarSigno();
    	assertEquals("-", vista.textField.getText());
    	vista.textField.setText("10");
    	vista.cambiarSigno();
    	assertEquals("-10", vista.textField.getText());
    	vista.textField.setText("-10");
    	vista.cambiarSigno();
    	assertEquals("10", vista.textField.getText());
    }
}
