package UD19_ex5.UD19_ex5;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTextField textField;
	int heighBotones = 40;
	int widthBotones = 50;
	JButton[] numeros; 
	JButton[] operadores; 
	CalculadoraLogica logica;
	ActionListener numListener;
	ActionListener operadoresListener;
	ActionListener equalListener;
	/**
	 * Create the frame.
	 */
	public Vista(CalculadoraLogica logica) {
		this.logica = logica;
		operadores = new JButton[4];
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 33, 215, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		crearListeners();
		createNumButtons();
		createBotonesVarios();
		
		repaint();
		
	}
	
	public void crearListeners() {	
		operadoresListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!textField.getText().isEmpty()) {
					JButton signo = (JButton)e.getSource();
					logica.guardarSigno(signo.getText(), textField.getText());
					if(logica.operator == null) {
						textField.setText(logica.lastResult);	
					}else {
						textField.setText("");
						logica.lastWasOperation = false;
					}
				}
			}
		};
		numListener = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton numero = (JButton)e.getSource();
				if(logica.lastWasOperation) {
					textField.setText("");
					logica.lastWasOperation = false;
				}
				textField.setText(textField.getText()+numero.getText());

			}
		};
		equalListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!textField.getText().isEmpty()) {
					logica.hacerOperacion(Double.parseDouble(textField.getText()));
					textField.setText(logica.lastResult);
					logica.lastResult = "";
				}
			}
		};
	}
	
	public void createNumButtons() {
		int xNum = 10;
		int yNum = 95;
		int contadorNums = 1;

		for (int i = 7; i >= 0; i++) {
			JButton btnNewButton = new JButton(i+"");
			btnNewButton.setBounds(xNum, yNum, widthBotones, heighBotones);
			btnNewButton.addActionListener(numListener);
			contentPane.add(btnNewButton);
			xNum += 55;
			if(contadorNums % 3 == 0) {
				yNum += 45;
				xNum = 10;
				i -= 6;
			}
			contadorNums ++;
		}
		JButton btnNewButton = new JButton("0");
		btnNewButton.setBounds((10+55), (95+45+45+45), widthBotones, heighBotones);
		btnNewButton.addActionListener(numListener);
		contentPane.add(btnNewButton);
	}

	public void createBotonesVarios() {
		JButton comaBtn = new JButton(",");
		comaBtn.setBounds(120, 230, widthBotones, heighBotones);
		contentPane.add(comaBtn);
		comaBtn.addActionListener(a->putComa());
		JButton cambiarSigno = new JButton("+/-");
		cambiarSigno.setBounds(10, 230, widthBotones, heighBotones);
		contentPane.add(cambiarSigno);
		cambiarSigno.addActionListener(a->cambiarSigno());
		
		JButton resetBtn = new JButton("C");
		resetBtn.setBounds(175, 95, widthBotones, heighBotones);
		contentPane.add(resetBtn);
		resetBtn.addActionListener(a->reset());
		
		JButton eraseBtn = new JButton("<");
		eraseBtn.setBounds(175, 140, widthBotones, heighBotones);
		contentPane.add(eraseBtn);
		eraseBtn.addActionListener(a->eraseLastNum());
		
		JButton sumaBtn = new JButton("+");
		sumaBtn.setBounds(10, 275, widthBotones, heighBotones);
		contentPane.add(sumaBtn);
		sumaBtn.addActionListener(operadoresListener);
		
		JButton equalBtn = new JButton("=");
		equalBtn.setBounds(175, 230, widthBotones, heighBotones);
		contentPane.add(equalBtn);
		equalBtn.addActionListener(equalListener);
		
		JButton restaBtn = new JButton("-");
		restaBtn.setBounds(65, 275, widthBotones, heighBotones);
		contentPane.add(restaBtn);
		restaBtn.addActionListener(operadoresListener);

		JButton multiplicarBtn = new JButton("*");
		multiplicarBtn.setBounds(120, 275, widthBotones, heighBotones);
		contentPane.add(multiplicarBtn);
		multiplicarBtn.addActionListener(operadoresListener);

		JButton dividirBtn = new JButton("/");
		dividirBtn.setBounds(175, 275, widthBotones, heighBotones);
		contentPane.add(dividirBtn);
		dividirBtn.addActionListener(operadoresListener);
	}

	public void putComa() {
		if(textField.getText().isEmpty()) {
			textField.setText("0.");
		}else if(!textField.getText().contains(".")){
			textField.setText(textField.getText()+".");
		}
	}
	public void eraseLastNum() {
		if(logica.lastWasOperation) {
			reset();
		}else{
			if(!textField.getText().isEmpty()) {
				textField.setText(textField.getText().substring(0, textField.getText().length()-1));
			}
		}
	}
	
	public void reset() {
		textField.setText("");
		logica.reset();
	}
	public void cambiarSigno() {
		textField.setText(logica.cambiarSigno(textField.getText()));
	}
}
