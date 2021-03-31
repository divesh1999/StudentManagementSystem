import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class ChartFrame extends JFrame{
	Container c;
	JButton btnBack;
	JFreeChart chart;
	ChartPanel panel;
	
	


	ChartFrame(){
		c = getContentPane();
		c.setLayout(new FlowLayout());

	DefaultCategoryDataset d1 = new DefaultCategoryDataset();

    Configuration cfg = new Configuration();
    cfg.configure("hibernate.cfg.xml");

    SessionFactory sfact = cfg.buildSessionFactory();
    Session session = null;

	try{
        session = sfact.openSession();
        //System.out.println("connected");
        session.beginTransaction();

        List<Student> slist = new ArrayList<>();
        slist = session.createQuery("from Student").list();
        Collections.sort(slist);
        
        for(Student b : slist)
        {
            d1.setValue(b.getMphy(), b.getSname(), "Physics");
			d1.setValue(b.getMchem(), b.getSname(), "Chemistry");
			d1.setValue(b.getMmaths(), b.getSname(), "Maths");
        }
    }
        
    
    catch(Exception e)
    {
        System.out.println(e.getMessage());
    }
    finally
    {
        if (session !=null)
        {
            session.close();
            //System.out.println("disconnected");
        }
    }

		chart = ChartFactory.createBarChart("Student's Performance","Subjects","Marks",d1,PlotOrientation.VERTICAL,true,false,false);

		ChartPanel panel = new ChartPanel(chart);
		JButton btnBack = new JButton("Back");

		add(panel);
		add(btnBack);



	


		ActionListener a1 = (ae) ->{
			MainFrame mf =new MainFrame();
			dispose();
		};
		btnBack.addActionListener(a1);

		try{
			File P = new File("Performance.jpeg");
			ChartUtilities.saveChartAsJPEG(P,chart,600,400);

		}
		catch(IOException e){
			System.out.println("Issue" + e);
		}


		setTitle("Marks Chart");
		setSize(700,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
} 
