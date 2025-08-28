package calculator;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
    CalcButton calc=new CalcButton();
    MyFrame(){
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        calc.setBounds(10, 10, 400, 400); // Set bounds for the CalcButton panel
        this.add(calc);
        
        this.setSize(450, 450); 
       //setSize(width, height)-if layout is null
        this.setVisible(true);
    }
}
