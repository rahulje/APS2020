import java.awt.*;
import java.awt.event.*;
class Myframe1 extends Frame implements ActionListener
{
	Button b1=new Button("click 5");
	Button b2=new Button("click 4");
	Myframe1(String title)
	{
		super(title);
		setSize(400,400);
		setVisible(true);
		add(b1,BorderLayout.NORTH);
		add(b2,BorderLayout.SOUTH);
		b1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		this.setVisible(false);
		this.dispose();
	}
	public static void main(String[] args)
	{
		Myframe1 mf1=new Myframe1("my frame");
	}
}
