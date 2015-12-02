/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab6;

/**
 *
 * @author yunfan
 */
public class Student extends AnyParty {
	private final int MaxUnits =15;
	private int StudentUnits;
	private Enrolling enroll;
 private Schedule schedule;
    public Enrolling getEnroll() {
        return enroll;
    }
       
public Schedule getSchedule(){
    return schedule;
}

<<<<<<< HEAD

=======
    public Student(int StudentUnits, Enrolling enroll){
 
        this.StudentUnits = StudentUnits;
        this.enroll = enroll;
    }
	
>>>>>>> origin/master
    public String getUserName(){
        return super.getUserName();
    }
    public  String getPsd(){
        return super.getPassword();
    }
    
    public int getMaxUnits(){
    	return MaxUnits;
    }
    public int getStudentUnits(){
    	return StudentUnits;
    }
    public void setStudentUnits(int StudentUnits){
    	this.StudentUnits = StudentUnits;
    }
    public String CheckUnits(){
    	if (getMaxUnits() <= getStudentUnits()){
    		return "Can't add anymore";
    	}
    	else
    		return "You have "+getStudentUnits()+" units left for fulltime";
    }
}
