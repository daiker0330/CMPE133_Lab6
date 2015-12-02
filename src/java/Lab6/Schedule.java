/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab6;

/**
 *
 * @author kay.pandya
 */
public class Schedule extends AnyForm{
    private Student std;
    
    public void setStudent(Student std){
        this.std = std;
    }
    
    public String print(){
        std.getEnroll().getCourseList();
        
        
    } 
}
