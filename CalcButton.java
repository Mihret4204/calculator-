package calculator;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcButton extends JPanel implements ActionListener {
    JLabel label;

    JButton button0;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JButton button8;
    JButton button9;
    JButton buttona; // Addition
    JButton buttonb; // Subtraction
    JButton buttonc; // Multiplication
    JButton buttond; // Division
    JButton buttone;  // Equals
    JButton buttonf;  // Option (could be for clear or other function)

    JTextField textField;

    CalcButton() {
        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        buttona = new JButton("+");
        buttonb = new JButton("-");
        buttonc = new JButton("*");
        buttond = new JButton("/");
        buttone = new JButton("=");
        buttonf = new JButton("C"); // Clear Button

          //Add action listeners
        button0.addActionListener(this);
        button0.setActionCommand("0");
        button1.addActionListener(this);
        button1.setActionCommand("1");
        button2.addActionListener(this);
        button2.setActionCommand("2");
        button3.addActionListener(this);
        button3.setActionCommand("3");
        button4.addActionListener(this);
        button4.setActionCommand("4");
        button5.addActionListener(this);
        button5.setActionCommand("5");
        button6.addActionListener(this);
        button6.setActionCommand("6");
        button7.addActionListener(this);
        button7.setActionCommand("7");
        button8.addActionListener(this);
        button8.setActionCommand("8");
        button9.addActionListener(this);
        button9.setActionCommand("9");
        buttona.addActionListener(this);
        buttona.setActionCommand("+");
        buttonb.addActionListener(this);
        buttonb.setActionCommand("-");
        buttonc.addActionListener(this);
        buttonc.setActionCommand("*");
        buttond.addActionListener(this);
        buttond.setActionCommand("/");
        buttone.addActionListener(this);
        buttone.setActionCommand("=");
        buttonf.addActionListener(this);
        buttonf.setActionCommand("C");

        label = new JLabel();
        label.setText("Calculator");
        label.setBounds(10, 10, 100, 20); // Set size and position of the label



        textField = new JTextField();
        textField.setBackground(Color.LIGHT_GRAY);
        textField.setBounds(10, 10, 400, 40); // Set size and position of the text field
        textField.setEditable(true); // Make the text field non-editable
        label.setLabelFor(textField); // Associate the label with the text field
        this.add(label);
        this.add(textField);

        this.setLayout(new GridLayout(5, 4, 10, 10)); // Adjusted layout to fit buttons and text field
        this.add(button0);
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(button5);
        this.add(button6);
        this.add(button7);
        this.add(button8);
        this.add(button9);
        this.add(buttona);
        this.add(buttonb);
        this.add(buttonc);
        this.add(buttond);
        this.add(buttone);
        this.add(buttonf);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        switch (e.getActionCommand()) {
            case "0":
            textField.setText(textField.getText() + "0");
                
                break;
            case "1":
            textField.setText(textField.getText() + "1");
                break;
            case "2":
            textField.setText(textField.getText() + "2");
                break;
            case "3":
            textField.setText(textField.getText() + "3");         
                break;
            case "4":
            textField.setText(textField.getText() + "4");
                break;
            case "5":
            textField.setText(textField.getText() + "5");
                break;
            case "6":
            textField.setText(textField.getText() + "6");
                break;      
            case "7":
            textField.setText(textField.getText() + "7");       
                break;
            case "8":
            textField.setText(textField.getText() + "8");
                break;
            case "9":
            textField.setText(textField.getText() + "9");
                break;
                
            case "+":
            textField.setText(textField.getText() + "+");
                break;
            case "-":
            textField.setText(textField.getText() + "-");    
                break;
            case "*":
            textField.setText(textField.getText() + "*");
                break;
            case "/":
            textField.setText(textField.getText() + "/");
                break;  
            case "=":
            int result = 0;
            String expression = textField.getText();
            try {
                // Simple evaluation logic (only handles single operations)
                if (expression.contains("+")) {
                    String[] parts = expression.split("\\+");
                    result = Integer.parseInt(parts[0]) + Integer.parseInt(parts[1]);
                } else if (expression.contains("-")) {
                    String[] parts = expression.split("-");
                    result = Integer.parseInt(parts[0]) - Integer.parseInt(parts[1]);
                } else if (expression.contains("*")) {
                    String[] parts = expression.split("\\*");
                    result = Integer.parseInt(parts[0]) * Integer.parseInt(parts[1]);
                } else if (expression.contains("/")) {
                    String[] parts = expression.split("/");
                    result = Integer.parseInt(parts[0]) / Integer.parseInt(parts[1]);
                }
                textField.setText(String.valueOf(result));
            } catch (Exception ex) {
                textField.setText("Error");
            }
                break;
            case "C":
            textField.setText("");
                break;
            default:
                break;
        }
    }
}