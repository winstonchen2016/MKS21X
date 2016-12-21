import javax.swing.*;
import java.awt.*;
public class TempConverterGUI extends JFrame {
    private Container pane;

    private JButton b1, b2;
    private JTextField t1, t2;
 
    //CONSTRUCTOR SETS EVERYTHING UP
    public TempConverterGUI() {
	this.setTitle("Temperature Converter");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());  //NOTE!! THIS CAN BE CHANGED (see below)
    
	b1 = new JButton("Celsius to Fahrenheit");
	b2 = new JButton("Fahrenheit to Celsius");
	t1 = new JTextField(12);
	t2 = new JTextField(12);
	pane.add(b1);
	pane.add(b2);
	pane.add(t1);
	pane.add(t2);
    }

    //MAIN JUST INSTANTIATES + MAKE VISIBLE
    public static void main(String[] args) {
	Window2 g = new Window2();
	g.setVisible(true);
    }
}
