//Entity pattern (BO) connected with IO Course
/*
 * @author Yehia JB
 */
package Lab6;

public class AnyEntity {
    /*
     * Attributes of Entity
     * string name and number id for Any entity
     */

    private String name;
    private String id;
    private String time;
    private String department;
    /*
     * Constructor that sets name, id for the entity
     */

    public AnyEntity(String name, String i, String time, String department) {
        this.name = name;
        this.id = i;
        this.time = time;
        this.department = department;

    }

    //Simple get methods to relate to IO class
    public String getname() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    public String getDep() {
        return department;
    }

    public String toString() {
        return name + " " + id + " " + time;
    }
}
