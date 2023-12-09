import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Main implements ActionListener{
	JFrame window;
	JTextField textField;
	JButton[] numberButtons = new JButton[10]; // 10 buttons for each digit
	JButton addBtn, subtractBtn, multiplyBtn, divideBtn; 
	JButton decimalBtn, equalsBtn, deleteBtn, clearBtn;
	JPanel panel; // holds the buttons
	
	String rege = "";// regexP to hold the operator
	
	Font myFont = new Font("Arial", Font.CENTER_BASELINE, 25);
	
	double num1 = 0;
	double num2 = 0; 
	double result = 0;
	char operator;
	
	Main(){
		window = new JFrame("Calculator");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(420, 550);
		window.setLayout(null);
		window.setResizable(false);
		
		/*Set the frame transparent*/
//		window.setUndecorated(true);
		window.getContentPane().setBackground(new Color(41,45,41));
	 
		
		/* Set up the text field*/
		textField = new JTextField();
		textField.setBounds(20, 20, 365, 60);
		textField.setFont(myFont);
		textField.setBackground(new Color(248, 248, 250));
		textField.setHorizontalAlignment(JTextField.RIGHT);
		textField.setEditable(false);// prevents the text field to be editable
		
		/*Set up the operator buttons*/
		addBtn = new JButton("+");
		subtractBtn = new JButton("-");
		multiplyBtn = new JButton("*");
		divideBtn = new JButton("/");
		decimalBtn = new JButton(".");
		equalsBtn = new JButton("=");
		deleteBtn = new JButton("X");
		clearBtn = new JButton("Clear");
		
		JButton[] operatorBtns = {addBtn, subtractBtn, 
				multiplyBtn, divideBtn, 
				decimalBtn, equalsBtn, 
				deleteBtn, clearBtn};
		
		for(int x = 0; x < 8; x++) {
			operatorBtns[x].addActionListener(this);
			operatorBtns[x].setFont(myFont);
			operatorBtns[x].setFocusable(false);
			operatorBtns[x].setBackground(new Color(255, 140, 0));
			operatorBtns[x].setForeground(Color.white);
			operatorBtns[x].setBorder(null);
		} 
		
		/*Set up number buttons*/
		for(int x = 0; x < 10; x++) {
			numberButtons[x] = new JButton(String.valueOf(x)); 
			numberButtons[x].addActionListener(this);
			numberButtons[x].setFont(myFont);
			numberButtons[x].setFocusable(false);
			numberButtons[x].setBorder(null);
			numberButtons[x].setBackground(new Color(250, 250, 250));
		}
		
		deleteBtn.setBounds(20, 430, 145, 50);
		deleteBtn.setBackground(Color.red);
		
		clearBtn.setBounds(240, 430, 145, 50);
		clearBtn.setBackground(Color.red); 
		
		equalsBtn.setBackground(Color.gray); 
		decimalBtn.setBackground(Color.gray);
		
		/*Set up the panel*/
		panel = new JPanel(); 
		panel.setBackground(new Color(41,45,41));
		panel.setBounds(20, 100, 365, 300);
		panel.setLayout(new GridLayout(4, 4, 15, 15)); 
		
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addBtn); 
		
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subtractBtn);
		
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(multiplyBtn); 
		
		panel.add(decimalBtn);
		panel.add(numberButtons[0]);
		panel.add(equalsBtn);
		panel.add(divideBtn);
		
		window.add(panel);
		window.add(deleteBtn);
		window.add(clearBtn);
		window.add(textField);
		window.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		Main calculator = new Main();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String currentTextValue = textField.getText();
		
		for(int x = 0; x < 10; x++) {
			if(e.getSource() == numberButtons[x]) {
				String currentNum = String.valueOf(x);
				textField.setText(currentTextValue.concat(currentNum));
			}
		} 
		
		/*Decimal*/
		if(e.getSource() == decimalBtn) {
			if(!currentTextValue.isEmpty()) {
				textField.setText(currentTextValue.concat("."));				
			}
		} 
		
		/*Clear*/
		if(e.getSource() == clearBtn) {
			textField.setText("");
		} 
		
		/*Delete*/
		if(e.getSource() == deleteBtn) {
			int lngt = currentTextValue.length();
			String myStr = currentTextValue;
			textField.setText("");
			
			for(int x = 0; x < lngt - 1; x++) {
				textField.setText(textField.getText() + myStr.charAt(x));
			}
		}
		
		/*Add*/
		if(e.getSource() == addBtn) {
			if(!currentTextValue.isEmpty()) {
				rege = "\\+";
				operator = '+';
				textField.setText(currentTextValue.concat("+"));				
			}
		}
		
		/*Subtract*/
		if(e.getSource() == subtractBtn) {
			operator = '-';
			textField.setText(currentTextValue.concat("-"));
		} 
		
		/*Multiply*/
		if(e.getSource() == multiplyBtn) {
			if(!currentTextValue.isEmpty()) {
				rege = "\\*";
				operator = '*';
				textField.setText(currentTextValue.concat("*"));				
			}
		} 
		
		/*Divide*/
		if(e.getSource() == divideBtn) {
			if(!currentTextValue.isEmpty()) {
				rege = "/";
				operator = '/';
				textField.setText(currentTextValue.concat("/"));				
			}
		} 
		
		/*Equals*/
		if(e.getSource() == equalsBtn) {
			if(!currentTextValue.isEmpty()) {
				num1 = Double.parseDouble(currentTextValue.split(rege, 2)[0]);
				num2 = Double.parseDouble(currentTextValue.split(rege, 2)[1]);
				
				try {
				calc();
				
				}catch(NumberFormatException err) {
					textField.setText("Wrong input!");
				}
			}
		}
	}

	public void calc() throws NumberFormatException{
		switch(operator) {
		case '+':
			result = num1 + num2; 
			break; 
		case '-':
			result = num1 - num2; 
			break; 
		case '*':
			result = num1 * num2; 
			break; 
		case '/': 
			
			if(num2 == 0) {
				textField.setText("One does not simply divide by zero!");
				break;
			} 
			
			result = num1 / num2; 
			break;
		} 
		
		if((operator != '/') || (num2 != 0)) {
			textField.setText(String.valueOf(result));
		}
	}
}
