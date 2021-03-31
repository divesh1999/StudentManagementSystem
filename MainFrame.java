import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

class MainFrame extends JFrame{
	Container c;
	JButton btnAdd,btnView,btnUpdate,btnDelete,btnCharts;
	

	MainFrame(){
		c= getContentPane();
		c.setLayout(new FlowLayout());

		btnAdd = new JButton("ADD");
		btnView = new JButton("VIEW");
		btnUpdate = new JButton("UPDATE");
		btnDelete = new JButton("DELETE");
		btnCharts = new JButton("CHARTS");


		add(btnAdd);
		add(btnView);
		add(btnUpdate);
		add(btnDelete);
		add(btnCharts);

		ActionListener a1 = (ae) ->{
			AddFrame af =new AddFrame();
			dispose();
		};
		btnAdd.addActionListener(a1);

		ActionListener a2 = (ae) ->{
			UpdateFrame uf = new UpdateFrame();
			dispose();
		};
		btnUpdate.addActionListener(a2);

		ActionListener a3 = (ae) ->{
			DeleteFrame df = new DeleteFrame();
			dispose();
		};
		btnDelete.addActionListener(a3);

		ActionListener a4 = (ae) ->{
			ViewFrame vf = new ViewFrame();
			dispose();
		};
		btnView.addActionListener(a4);

		ActionListener a5 = (ae) ->{
			ChartFrame cf = new ChartFrame();
			dispose();
		};
		btnCharts.addActionListener(a5);

	




		setTitle("S.M.S");
		setSize(230,200);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
}