package Calculator;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Calculate extends JFrame implements ActionListener
{
	private JPanel JP1,JP2;
	private JPanel JPA1,JPA2;
	private JButton Button[] = new JButton[20];
	private JButton B2;
	private JTextArea TA1,TA2;
	private Icon I1 = new ImageIcon(this.getClass().getResource("./History.png"));
	private String S1,S2,S3,S4,S5;
	private double D1;
	
	public void Save() 
	{
		try 
		{
			FileWriter FW = new FileWriter("C:/Users/SO/Desktop/Compiler/Java/Calculator/src/Calculator/History.txt",true);
			PrintWriter PW = new PrintWriter(FW);
			PW.println(S1+" "+S2+" "+S4+" = "+S5);
			PW.close();
		} 
		catch (IOException E) 
		{
			E.printStackTrace();
		}
	}
	
	public void History()
	{
		JFrame JF = new JFrame("History");
		JPanel JPA3 = new JPanel();
		JTextArea TA3 = new JTextArea();
		JF.setSize(300,365);
		JF.setLocation(1100,400);
		JF.setVisible(true);
		JF.add(JPA3);
		JPA3.add(TA3);
		JF.add(TA3,FlowLayout.LEFT);
		try 
		{
			File F = new File("C:/Users/SO/Desktop/Compiler/Java/Calculator/src/Calculator/History.txt");
			FileReader FR = new FileReader(F);
			Scanner S = new Scanner(F);
			while(S.hasNext())
			{
				TA3.append(S.nextLine()+"\n");
			}
		} 
		catch (FileNotFoundException E) 
		{
			E.printStackTrace();
		}
	}
	
	public Calculate()
	{
		super("Hesap Makinesi");
		setLayout(new BorderLayout());
		
		JP1 = new JPanel();
		JP2 = new JPanel();
		JPA1 = new JPanel();
		JPA2 = new JPanel();
		
		JP1.setLayout(new GridLayout(2,1));
		JPA1.setLayout(new GridLayout(1,1));
		JPA2.setLayout(new BorderLayout());
		JP2.setLayout(new GridLayout(5,4));
		
		Button[0] = new JButton("Sin");
		Button[1] = new JButton("X^2");
		Button[2] = new JButton("Cos");
		Button[3] = new JButton("/");
		Button[4] = new JButton("7");
		Button[5] = new JButton("8");
		Button[6] = new JButton("9");
		Button[7] = new JButton("x");
		Button[8] = new JButton("4");
		Button[9] = new JButton("5");
		Button[10] = new JButton("6");
		Button[11] = new JButton("-");
		Button[12] = new JButton("1");
		Button[13] = new JButton("2");
		Button[14] = new JButton("3");
		Button[15] = new JButton("+");
		Button[16] = new JButton("C");
		Button[17] = new JButton("0");
		Button[18] = new JButton("CE");
		Button[19] = new JButton("=");
		for (int i = 0; i < Button.length; i++) 
		{
			JP2.add(Button[i]);
			Button[i].addActionListener(this);
		}
		
		B2 = new JButton(I1);
		B2.addActionListener(this);
		
		TA1 = new JTextArea();
		TA1.setFont(new Font("Arial",Font.BOLD,15));
		TA1.setRows(3);
		
		TA2 = new JTextArea();
		TA2.setFont(new Font("Arial",Font.ITALIC,12));
		TA2.setRows(2);
		
		JPA1.add(TA1);
		JPA2.add(TA2);
		JPA2.add(B2,BorderLayout.EAST);
		JP1.add(JPA1);
		JP1.add(JPA2);
		
		add(JP1,BorderLayout.NORTH);
		add(JP2,BorderLayout.CENTER);
		setSize(300,500);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		new Calculate();
		
	}

	@Override
	public void actionPerformed(ActionEvent Event)
	{
		if(Event.getSource()==Button[0])
		{
			S1 = TA1.getText();
			double S5 = Double.parseDouble(S1);
			S5 = Math.toRadians(S5);
			TA1.setText(Math.sin(S5)+"");
		}
		if(Event.getSource()==Button[1])
		{
			S1 = TA1.getText();
			int S5 = Integer.parseInt(S1);
			TA1.setText(S5*S5+"");
		}
		if(Event.getSource()==Button[2])
		{
			S1 = TA1.getText();
			double S5 = Double.parseDouble(S1);
			S5 = Math.toRadians(S5);
			TA1.setText(Math.cos(S5)+"");
		}
		if(Event.getSource()==Button[3])
		{
			S1 = TA1.getText();
			TA1.setText(TA1.getText()+" / ");
			S2 = "/";
		}
		if(Event.getSource()==Button[4])
		{
			TA1.setText(TA1.getText()+"7");
		}
		if(Event.getSource()==Button[5])
		{
			TA1.setText(TA1.getText()+"8");
		}
		if(Event.getSource()==Button[6])
		{
			TA1.setText(TA1.getText()+"9");
		}
		if(Event.getSource()==Button[7])
		{
			S1 = TA1.getText();
			TA1.setText(TA1.getText()+" x ");
			S2 = "x";
		}
		if(Event.getSource()==Button[8])
		{
			TA1.setText(TA1.getText()+"4");
		}
		if(Event.getSource()==Button[9])
		{
			TA1.setText(TA1.getText()+"5");
		}
		if(Event.getSource()==Button[10])
		{
			TA1.setText(TA1.getText()+"6");
		}
		if(Event.getSource()==Button[11])
		{
			S1 = TA1.getText();
			TA1.setText(TA1.getText()+" - ");
			S2 = "-";
		}
		if(Event.getSource()==Button[12])
		{
			TA1.setText(TA1.getText()+"1");
		}
		if(Event.getSource()==Button[13])
		{
			TA1.setText(TA1.getText()+"2");
		}
		if(Event.getSource()==Button[14])
		{
			TA1.setText(TA1.getText()+"3");
		}
		if(Event.getSource()==Button[15])
		{
			S1 = TA1.getText();
			TA1.setText(TA1.getText()+" + ");
			S2 = "+";
		}
		if(Event.getSource()==Button[16])
		{
			if(TA1.getText().length()!=0)
				TA1.setText("");
		}
		if(Event.getSource()==Button[17])
		{
			TA1.setText(TA1.getText()+"0");
		}
		if(Event.getSource()==Button[18])
		{
			if(TA1.getText().length()!=0)
				TA1.setText(TA1.getText().substring(0,TA1.getText().length()-1));
		}
		if(Event.getSource()==Button[19])
		{
			S3 = TA1.getText();
			S4 = S3.substring(S1.length()+3,S3.length());
			if(S2.equals("+"))
			{
				D1 = Integer.parseInt(S1)+Integer.parseInt(S4);
				TA1.setText((int)D1+"");
				S5 = TA1.getText();
				Save();
			}
			if(S2.equals("-"))
			{
				D1 = Integer.parseInt(S1)-Integer.parseInt(S4);
				TA1.setText((int)D1+"");
				S5 = TA1.getText();
				Save();
			}
			if(S2.equals("x"))
			{
				D1 = Integer.parseInt(S1)*Integer.parseInt(S4);
				TA1.setText((int)D1+"");
				S5 = TA1.getText();
				Save();
			}
			if(S2.equals("/"))
			{
				if(S4.equals("0"))
				{
					TA1.setText("");
					JOptionPane.showMessageDialog(null,"Bolen 0 olamaz");
				}
				else
				{
					D1 = Double.parseDouble(S1)/Double.parseDouble(S4);
					TA1.setText(D1+"");
					S5 = TA1.getText();
					Save();
				}
			}
		}
		if(Event.getSource()==B2)
		{
			History();
		}
	}
}
