/*
 * Course extends AnyEntity
 * Shares get commands from it.
 * Using SSM pattern
 */
package Lab6;

public class Course extends AnyEntity {

    public Course(String name, String id, String time, String Department) {
        super(name, id, time, Department);
        // TODO Auto-generated constructor stub
    }

    public String getName() {
        return super.getname();

    }

    public String getNumber() {
        return super.getId();
    }

    public String getTime() {
        return super.getTime();
    }

    public String getDep() {
        return super.getDep();
    }

    public String toString() {
        return super.toString();
    }

}
