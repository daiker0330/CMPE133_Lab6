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

    private final int MaxUnits = 15;
    private int StudentUnits;

    public int getMaxUnits() {
        return MaxUnits;
    }

    public int getStudentUnits() {
        return StudentUnits;
    }

    public String getUserName() {
        return super.getUserName();
    }

    public String getPsd() {
        return super.getPassword();
    }
}
