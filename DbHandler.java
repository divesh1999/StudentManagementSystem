import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


class DbHandler{
	public static void addStudentMarks(int srno,String sname,int mphy,int mchem,int mmaths){

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sfact = cfg.buildSessionFactory();
		Session session = null;
		Transaction t = null;

		try{
			session = sfact.openSession();
			t=session.beginTransaction();

			Student s = new Student(srno,sname,mphy,mchem,mmaths);
			session.save(s);
			t.commit();
			JOptionPane.showMessageDialog(new JDialog(),"record added");
		}
		catch(Exception  e){
			JOptionPane.showMessageDialog(new JDialog(),"RollNo."+ srno +" is already assigned","ERROR",JOptionPane.ERROR_MESSAGE);
			
		}
		finally{
			if(session!=null)
				session.close();
		}
	}
	

	public static String viewStudentMarks(){
		String data ="";
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sfact = cfg.buildSessionFactory();
		Session session = null;
		Transaction t = null;
		try{

			session = sfact.openSession();

			List<Student> slist = new ArrayList<>();
			slist = session.createQuery("from Student").list();
			Collections.sort(slist);
			for(Student s:slist)
				data = data + s;
				
		}
		catch(Exception e){
			System.out.println("Issue " + e);
		}
		finally{
			if(session!=null)
				session.close();
				
		}
	return data;
	}

	public static void deleteStudent(int srno){
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sfact = cfg.buildSessionFactory();
		Session session = null;
		Transaction t = null;
		
		try{
			session = sfact.openSession();
			//System.out.println("connected ");
			
			t=session.beginTransaction();
			Student s = (Student)session.get(Student.class,srno);
			if(s==null){
				JOptionPane.showMessageDialog(new JDialog(),"RollNo."+ srno + " does not exist","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			else{

				session.delete(s);
				t.commit();
				JOptionPane.showMessageDialog(new JDialog(),"Record of RollNo."+ srno + " has been deleted");
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(new JDialog(),"Issue" +e ,"ERROR",JOptionPane.ERROR_MESSAGE);
		}
		finally{
			if(session!=null)
				session.close();
				
		}
	}

	public static void updateStudent(int srno,String sname,int mphy,int mchem,int mmaths){
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sfact = cfg.buildSessionFactory();
		Session session = null;
		Transaction t = null;

		try{
			session = sfact.openSession();
			//System.out.println("connected ");
			
			t=session.beginTransaction();
			
			Student s = (Student)session.get(Student.class,srno);

			if(s!=null){
				s.setSname(sname);
				s.setMphy(mphy);
				s.setMchem(mchem);
				s.setMmaths(mmaths);
				session.save(s);
				t.commit();
				JOptionPane.showMessageDialog(new JDialog(),"record updated");
				
			}
			else{
				JOptionPane.showMessageDialog(new JDialog(),"RollNo."+ srno + " does not exist","ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(new JDialog(),"Issue" +e ,"ERROR",JOptionPane.ERROR_MESSAGE);
		}
		finally{
			if(session!=null)
				session.close();
		}
	}

}