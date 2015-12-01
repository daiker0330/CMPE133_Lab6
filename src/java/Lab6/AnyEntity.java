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
		/*
		 * Constructor that sets name, id for the entity
		 */
		public AnyEntity(String name, String i, String time){
			this.name = name;
			this.id = i;
			this.time = time;
			
		
		}
		//Simple get methods to relate to IO class
		public String getname(){
			return name;
		}
		
		public String getId(){
			return id;
		}
		
		public String getTime(){
			return time;
		}
		public String toString(){
			return name+" "+id+" "+time;
		}
	}


