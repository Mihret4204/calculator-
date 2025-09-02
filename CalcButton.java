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
    JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    JButton buttona, buttonb, buttonc, buttond, buttone, buttonf;
    JTextField textField;

    public CalcButton() {
        // Initialize buttons
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
        buttonf = new JButton("C");

        // Set font for buttons and text field for better visibility
        Font font = new Font("Arial", Font.BOLD, 20);
        JButton[] buttons = {button0, button1, button2, button3, button4, button5, button6, button7, button8, button9,
                buttona, buttonb, buttonc, buttond, buttone, buttonf};
        for (JButton btn : buttons) {
            btn.setFont(font);
            btn.addActionListener(this);
        }

        // Set action commands
        button0.setActionCommand("0");
        button1.setActionCommand("1");
        button2.setActionCommand("2");
        button3.setActionCommand("3");
        button4.setActionCommand("4");
        button5.setActionCommand("5");
        button6.setActionCommand("6");
        button7.setActionCommand("7");
        button8.setActionCommand("8");
        button9.setActionCommand("9");
        buttona.setActionCommand("+");
        buttonb.setActionCommand("-");
        buttonc.setActionCommand("*");
        buttond.setActionCommand("/");
        buttone.setActionCommand("=");
        buttonf.setActionCommand("C");

        // Initialize text field
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.BOLD, 28));
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setBackground(Color.WHITE);

        // Use BorderLayout for main panel
        this.setLayout(new BorderLayout(5, 5));
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add text field at the top
        this.add(textField, BorderLayout.NORTH);

        // Create panel for buttons with GridLayout 4 rows x 4 columns
        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 5, 5));

        // Add buttons in order to resemble a calculator layout:
        // Row 1: 7 8 9 /
        // Row 2: 4 5 6 *
        // Row 3: 1 2 3 -
        // Row 4: C 0 = +

        buttonPanel.add(button7);
        buttonPanel.add(button8);
        buttonPanel.add(button9);
        buttonPanel.add(buttond);

        buttonPanel.add(button4);
        buttonPanel.add(button5);
        buttonPanel.add(button6);
        buttonPanel.add(buttonc);

        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(buttonb);

        buttonPanel.add(buttonf);
        buttonPanel.add(button0);
        buttonPanel.add(buttone);
        buttonPanel.add(buttona);

        this.add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if ("0123456789".contains(cmd)) {
            textField.setText(textField.getText() + cmd);
        } else if ("+-*/".contains(cmd)) {
            // Prevent multiple operators in a row
            String text = textField.getText();
            if (text.isEmpty()) return; // no operator at start
            char lastChar = text.charAt(text.length() - 1);
            if ("+-*/".indexOf(lastChar) >= 0) {
                // Replace last operator with new one
                textField.setText(text.substring(0, text.length() - 1) + cmd);
            } else {
                textField.setText(text + cmd);
            }
        } else if ("=".equals(cmd)) {
            String expression = textField.getText();
            try {
                int result = evaluateExpression(expression);
                textField.setText(String.valueOf(result));
            } catch (Exception ex) {
                textField.setText("Error");
            }
        } else if ("C".equals(cmd)) {
            textField.setText("");
        }
    }

    // Simple evaluation method for expressions with one operator
    private int evaluateExpression(String expression) throws Exception {
        if (expression.contains("+")) {
            String[] parts = expression.split("\\+");
            if (parts.length != 2) throw new Exception("Invalid");
            return Integer.parseInt(parts[0]) + Integer.parseInt(parts[1]);
        } else if (expression.contains("-")) {
            // To handle negative numbers, split carefully
            int index = expression.indexOf('-', 1); // find '-' after first char
            if (index == -1) index = expression.indexOf('-');
            if (index == -1) throw new Exception("Invalid");
            String left = expression.substring(0, index);
            String right = expression.substring(index + 1);
            return Integer.parseInt(left) - Integer.parseInt(right);
        } else if (expression.contains("*")) {
            String[] parts = expression.split("\\*");
            if (parts.length != 2) throw new Exception("Invalid");
            return Integer.parseInt(parts[0]) * Integer.parseInt(parts[1]);
        } else if (expression.contains("/")) {
            String[] parts = expression.split("/");
            if (parts.length != 2) throw new Exception("Invalid");
            int divisor = Integer.parseInt(parts[1]);
            if (divisor == 0) throw new ArithmeticException("Divide by zero");
            return Integer.parseInt(parts[0]) / divisor;
        } else {
            // No operator, just return the number
            return Integer.parseInt(expression);
        }
    }
}
