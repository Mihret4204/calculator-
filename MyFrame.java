package calculator;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
    CalcButton calc=new CalcButton();
    MyFrame(){
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Calculator");
        this.setLayout(new BorderLayout());
        this.add(calc, BorderLayout.CENTER);
        this.pack();
        this.setLocationRelativeTo(null); // Center on screen
        this.setVisible(true);
    }
}

