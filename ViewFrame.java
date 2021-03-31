import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

class ViewFrame extends JFrame{
	Container c;
	JTextArea taData,temp;
	JButton btnBack;
	JScrollPane scroll;


	ViewFrame(){
		c = getContentPane();
		c.setLayout(new FlowLayout());

		String data = new DbHandler().viewStudentMarks();
		
		taData = new JTextArea(data,10,50);
		btnBack = new JButton("Back");
		scroll = new JScrollPane(taData,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		taData.setEditable(false);
		taData.setSize(10,30);

		//c.add(taData);
		c.add(scroll);
		c.add(btnBack);
		

		
		//taData.setText(data);
		

		ActionListener a1 = (ae) ->{
			MainFrame af = new MainFrame();
			dispose();
		};
		btnBack.addActionListener(a1);

		setTitle("View St.");
		setSize(550,270);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}