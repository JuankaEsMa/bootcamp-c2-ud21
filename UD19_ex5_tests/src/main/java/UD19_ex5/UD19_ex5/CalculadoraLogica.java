package UD19_ex5.UD19_ex5;

public class CalculadoraLogica {
	public String lastResult;
	public String operator;
	public boolean lastWasOperation;
	
	public CalculadoraLogica() {
		
	}
	
	public void hacerOperacion(double digito) {
		double solucion;
		if(lastResult == null || lastResult.isEmpty()) {
			lastResult = digito+"";
		}else {
			double num1 = Double.parseDouble(lastResult);
			switch(operator) {
			case "+":
				solucion = num1 + digito;
				break;
			case "-":
				solucion = num1 - digito;
				break;
			case "/":
				solucion = num1 / digito;
				break;
			case "*":
				solucion = num1 * digito;
				break;
			default:
				solucion = 0;
			}
			lastWasOperation = true;
			lastResult = solucion + "";
		}
		
	}
	public void guardarSigno(String signo, String digito) {
		if(operator == null || operator.isEmpty() || lastResult == null || lastResult.isEmpty()) {
			this.operator = signo;		
			lastResult = digito;
		}else {
			hacerOperacion(Double.parseDouble(digito));
			this.operator = signo;
		}

	}
	public void reset() {
		lastResult="";
		operator = "";
	}
	public String cambiarSigno(String text) {
		if(!text.isEmpty() && text.charAt(0) == '-') {
			text = text.substring(1);
		}else {
			text = "-" + text;
		}
		return text;
	}

}
