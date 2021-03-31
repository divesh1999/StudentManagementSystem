import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

class UpdateFrame extends JFrame{
	Container c;
	JLabel lblRno,lblName,lblPhy,lblChem,lblMaths,lblError;
	JTextField txtRno,txtName,txtPhy,txtChem,txtMaths;
	JButton btnBack,btnSave;

	public static boolean isNumeric(String str) { 
  		try {  
    		Integer.parseInt(str);  
    		return true;
  		} 
  		catch(NumberFormatException e){  
    		return false;  
  		}  
	}

	

public static boolean isStringOnlyAlphabet(String str) 
{ 
    if (str == null || str.equals("")) { 
        return false; 
    } 
    for (int i = 0; i < str.length(); i++) { 
        char ch = str.charAt(i); 
        if (   (!(ch >= 'A' && ch <= 'Z')) && (!(ch >= 'a' && ch <= 'z')) && (!(ch==32)) && (!(ch==39)) ) { 
            return false; 
        } 
    } 
    return true; 
} 

	UpdateFrame(){
		c = getContentPane();
		c.setLayout(new FlowLayout());

		lblRno = new JLabel("Roll No.:");
		lblName = new JLabel("Name:");
		lblPhy = new JLabel("Marks of Physics:");
		lblChem = new JLabel("Marks of Chemistry:");
		lblMaths = new JLabel("Marks of Maths:");
		lblError = new JLabel("");
		txtRno = new JTextField(12);
		txtName = new JTextField(15);
		txtPhy = new JTextField(15);
		txtChem = new JTextField(15);
		txtMaths = new JTextField(15);
		btnBack = new JButton("Back");
		btnSave = new JButton("Save");

		lblError.setForeground(new Color(255, 0, 0));

		add(lblRno);
		add(txtRno);
		add(lblName);
		add(txtName);
		add(lblPhy);
		add(txtPhy);
		add(lblChem);
		add(txtChem);
		add(lblMaths);
		add(txtMaths);
		add(btnSave);
		add(btnBack);
		add(lblError);

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

		txtName.addKeyListener(new KeyListener(){
		public void keyPressed(KeyEvent e)
		{
  			//code  	
		}
		public void keyReleased(KeyEvent e)
		{
  			String value = txtName.getText().trim();
  			//System.out.println(value);
    		int l = value.length();
    		if(!isStringOnlyAlphabet(value) && l>0){
    			txtName.setEditable(true);
        		JOptionPane.showMessageDialog(c,"You need to enter Valid Name","ERROR",JOptionPane.ERROR_MESSAGE);
        		txtName.requestFocus();
        		txtName.setText("");
       			txtName.setEditable(true);
        		lblError.setText("");
    		} 
    		else {
        		txtName.setEditable(true);
        		lblError.setText("");
    		}
		}
		public void keyTyped(KeyEvent e)
		{
  			//code
		}
	});


		txtPhy.addKeyListener(new KeyListener(){
		public void keyPressed(KeyEvent e)
		{
  			//code  	
		}
		public void keyReleased(KeyEvent e)
		{
  			String value = txtPhy.getText();
  			//System.out.println(value);
    		int l = value.length();
    		if(l>0){
    			if(isNumeric(value)){

    				if(Integer.parseInt(value) >= 0 && Integer.parseInt(value) <= 100){
    					txtPhy.setEditable(true);
        				lblError.setText("");
        			}	
    				else {
    				
        				JOptionPane.showMessageDialog(c,"Marks must be between 0 to 100","ERROR",JOptionPane.ERROR_MESSAGE);
        				txtPhy.requestFocus();
        				txtPhy.setText("");
       					txtPhy.setEditable(true);
        				lblError.setText("");
    				}
    			}
    			else{
    			
        			JOptionPane.showMessageDialog(c,"You need to enter number","ERROR",JOptionPane.ERROR_MESSAGE);
        			txtPhy.requestFocus();
        			txtPhy.setText("");
       				txtPhy.setEditable(true);
        			lblError.setText("");
    			}
    		}
    		else{
    		    txtPhy.setEditable(true);
        		lblError.setText("");
    		}
		}
		public void keyTyped(KeyEvent e)
		{
  			//code
		}
	});
		txtChem.addKeyListener(new KeyListener(){
		public void keyPressed(KeyEvent e)
		{
  			//code  	
		}
		public void keyReleased(KeyEvent e)
		{
  			String value = txtChem.getText();
  			//System.out.println(value);
    		int l = value.length();
    		if(isNumeric(value) && l>0){

    			if(Integer.parseInt(value) >= 0 && Integer.parseInt(value) <= 100){
    				txtChem.setEditable(true);
        			lblError.setText("");
        		}	
    			else {
    				
        			JOptionPane.showMessageDialog(c,"Marks must be between 0 to 100","ERROR",JOptionPane.ERROR_MESSAGE);
        			txtChem.requestFocus();
        			txtChem.setText("");
       				txtChem.setEditable(true);
        			lblError.setText("");
    			}
    		}
    		else{
    			
        		JOptionPane.showMessageDialog(c,"You need to enter number","ERROR",JOptionPane.ERROR_MESSAGE);
        		txtChem.requestFocus();
        		txtChem.setText("");
       			txtChem.setEditable(true);
        		lblError.setText("");
    			}
    		}
		public void keyTyped(KeyEvent e)
		{
  			//code
		}
	});
		txtMaths.addKeyListener(new KeyListener(){
		public void keyPressed(KeyEvent e)
		{
  			//code  	
		}
		public void keyReleased(KeyEvent e)
		{
  			String value = txtMaths.getText();
  			//System.out.println(value);
    		int l = value.length();
    		if(isNumeric(value) && l>0){

    			if(Integer.parseInt(value) >= 0 && Integer.parseInt(value) <= 100){
    				txtMaths.setEditable(true);
        			lblError.setText("");
        		}	
    			else {
    
        			JOptionPane.showMessageDialog(c,"Marks must be between 0 to 100","ERROR",JOptionPane.ERROR_MESSAGE);
        			txtMaths.requestFocus();
        			txtMaths.setText("");
       				txtMaths.setEditable(true);
        			lblError.setText("");
    			}
    		}
    		else{
    			
        		JOptionPane.showMessageDialog(c,"You need to enter number","ERROR",JOptionPane.ERROR_MESSAGE);
        		txtMaths.requestFocus();
        		txtMaths.setText("");
       			txtMaths.setEditable(true);
        		lblError.setText("");
    			}
    		
    		
		}
		public void keyTyped(KeyEvent e)
		{
  			//code
		}
	});


		ActionListener a2 = (ae)->{
			if(txtRno.getText().isEmpty() && txtName.getText().isEmpty() && txtPhy.getText().isEmpty() && txtChem.getText().isEmpty()&& txtMaths.getText().isEmpty()){
				lblError.setText("Field(s) are empty"); 
			}
			else if (txtRno.getText().isEmpty()) {
				lblError.setText("Roll Number field cannot be empty");
			}
			else if (txtName.getText().isEmpty()) {
				lblError.setText("Name field cannot be empty");
			}
			else if(txtPhy.getText().isEmpty() && txtChem.getText().isEmpty() && txtMaths.getText().isEmpty()){
				lblError.setText("Enter All Marks"); 
			}
			
			else if (txtPhy.getText().isEmpty()) {
				lblError.setText("Enter Physics Marks");
			}
			else if (txtChem.getText().isEmpty()) {
				lblError.setText("Enter Chemistry Marks");
			}
			else if (txtMaths.getText().isEmpty()) {
				lblError.setText("Enter Maths Marks");
			}
			else{

				
				int srno = Integer.parseInt(txtRno.getText());
				String sname = txtName.getText();
				int mphy = Integer.parseInt(txtPhy.getText());
				int mchem = Integer.parseInt(txtChem.getText());
				int mmaths = Integer.parseInt(txtMaths.getText());
				DbHandler db = new DbHandler();
				db.updateStudent(srno,sname,mphy,mchem,mmaths);

				txtRno.setText("");
				txtName.setText("");
				txtPhy.setText("");
				txtChem.setText("");
				txtMaths.setText("");
				txtRno.requestFocus();
			}
		};
		btnSave.addActionListener(a2); 




		setTitle("Update St.");
		setPreferredSize(new Dimension(230, 300));
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);





	}
}