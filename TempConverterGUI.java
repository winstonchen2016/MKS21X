import javax.swing.*;
import java.awt.*;//NEW STUFF!
import java.awt.event.*;

public class TempConverterGUI extends JFrame implements ActionListener{
    private Container pane;
    private JLabel j;
    private JTextField t;

    public TempConverterGUI() {
	this.setTitle("Temperature Converter");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
	JButton b = new JButton("Celsius to Fahrenheit");
	b.addActionListener(this);
	b.setActionCommand("CtoF");
	JButton b2 = new JButton("Fahrenheit to Celsius");
	b2.addActionListener(this);
	b2.setActionCommand("FtoC");
	t = new JTextField(10);
	//JCheckBox c = new JCheckBox("OverClock");
	j = new JLabel("Imput tempertature in the text box. Integers only please!");
	//pane.add(c);
	pane.add(t);
	pane.add(b);
	pane.add(b2);
	pane.add(j);
    }

    public void actionPerformed(ActionEvent e){
	String event = e.getActionCommand();
	if(event.equals("CtoF")){
	    String s = t.getText();
	    try{
		s = "" + TemperatureConversion.CtoF(Integer.parseInt(t.getText()));
	    }catch(NumberFormatException x){
		s = "invalid input";
	    }catch(NullPointerException x){
		s = "invalid input";
	    }
	    j.setText(s);
	}
	if(event.equals("FtoC")){
	    String s = t.getText();
	    try{
		s = "" + TemperatureConversion.FtoC(Integer.parseInt(t.getText()));
	    }catch(NumberFormatException x){
		s = "invalid input";
	    }catch(NullPointerException x){
		s = "invalid input";
	    }
	    j.setText(s);	    
	}
    }
    public static void main(String[]args){
	TempConverterGUI tc = new TempConverterGUI();
	tc.setVisible(true);
    }
}
