import java.util.*;
class Student implements Comparable<Student> 
{
	private int srno,mphy,mchem,mmaths;
	private String sname;

	Student(){}


	public Student(int srno,String sname,int mphy,int mchem,int mmaths){
		this.srno = srno;
		this.sname = sname;
		this.mphy = mphy;
		this.mchem = mchem;
		this.mmaths = mmaths;
	}

	public void setSrno(int srno){
		this.srno = srno;
	}
	public int getSrno(){
		return srno;
	}
	//-----------------------------
	public void setSname(String sname){
		this.sname = sname;
	}
	public String getSname(){
		return sname;
	}
	//-----------------------------
	public void setMphy(int mphy){
		this.mphy = mphy;
	}
	public int getMphy(){
		return mphy;
	}
	//-----------------------------
	public void setMchem(int mchem){
		this.mchem = mchem;
	}
	public int getMchem(){
		return mchem;
	}
	//-----------------------------
	public void setMmaths(int mmaths){
		this.mmaths = mmaths;
	}
	public int getMmaths(){
		return mmaths;
	}

	@Override
	public int compareTo(Student comparestu){
		int comparerno = ((Student)comparestu).getSrno();
		return this.srno-comparerno;
	}

	@Override
	public String toString(){
		return " RNO: "+ getSrno()+"\t"+" NAME: "+ getSname()+"\t"+" PHY: "+ getMphy()+"\t"+" CHEM: "+ getMchem()+"\t"+" MATHS: "+ getMmaths() + "\n";
	}
	

}