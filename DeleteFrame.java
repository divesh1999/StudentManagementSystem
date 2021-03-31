import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

class DeleteFrame extends JFrame{
	Container c;
	JLabel lblRno;
	JTextField txtRno;
	JButton btnBack,btnDelete;
	JLabel lblError;

	public static boolean isNumeric(String str) { 
  		try {  
    		Integer.parseInt(str);  
    		return true;
  		} 
  		catch(NumberFormatException e){  
    		return false;  
  		}  
	}

	DeleteFrame(){
		c = getContentPane();
		c.setLayout(new FlowLayout());

		lblRno = new JLabel("Roll No.:");
		
		txtRno = new JTextField(12);
		
		btnBack = new JButton("Back");
		btnDelete = new JButton("Delete");

		lblError = new JLabel("");

		add(lblRno);
		add(txtRno);
		add(btnDelete);
		add(btnBack);
		add(lblError);

		lblError.setForeground(new Color(255, 0, 0));

		ActionListener a1 = (ae) ->{
			MainFrame mf =new MainFrame();
			dispose();
		};
		btnBack.addActionListener(a1);

		txtRno.addKeyListener(new KeyListener(){
		public void keyPressed(KeyEvent e)
		{
  			//code  	
		}
		public void keyReleased(KeyEvent e)
		{
  			String value = txtRno.getText();
  			//System.out.println(value);
    		int l = value.length();
    		if(!isNumeric(value) && l>0){
    			txtRno.setEditable(true);
        		JOptionPane.showMessageDialog(c,"You need to enter number","ERROR",JOptionPane.ERROR_MESSAGE);
        		txtRno.requestFocus();
        		txtRno.setText("");
       			txtRno.setEditable(true);
        		lblError.setText("");
    		} 
    		else {
        		txtRno.setEditable(true);
        		lblError.setText("");
    		}
		}
		public void keyTyped(KeyEvent e)
		{
  			//code
		}
	});

	ActionListener a2 = (ae)->{
			if(txtRno.getText().isEmpty()) {
				lblError.setText("Roll Number field cannot be empty");
				txtRno.requestFocus();
			}
			else {
				int srno = Integer.parseInt(txtRno.getText());
				txtRno.setText("");
				txtRno.requestFocus();
				DbHandler db = new DbHandler();
				db.deleteStudent(srno);
			}
			
		};
		btnDelete.addActionListener(a2);




		setTitle("Delete St.");
		setPreferredSize(new Dimension(230, 200));
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);





	}
}