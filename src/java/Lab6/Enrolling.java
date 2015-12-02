/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Lab6;

import java.util.ArrayList;

/**
 *
 * @author yunfan
 */
public class Enrolling extends AnyImpact {

    ArrayList<Course> CurrentList = new ArrayList<Course>();
public void addCourse(ArrayList<Course> a){
    super.addElementLog(a);
  
  CurrentList = a;  
} 
 public ArrayList getCourseList(){
    return CurrentList;
}
}
