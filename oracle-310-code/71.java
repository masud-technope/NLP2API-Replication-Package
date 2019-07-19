import java.lang.reflect.Method;
 
/**
 *
 * @author javadb.com
 */
public class Main {
    
    /**
     * Lists the methods of a class using the Reflection api.
     */
    public void listMethodsUsingReflection() {
 
        //Obtain the Class instance
        Class personClass = Person.class;
        
        //Get the methods
        Method[] methods = personClass.getDeclaredMethods();
        
        //Loop through the methods and print out their names
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main().listMethodsUsingReflection();
    }
    
    
    class Person {
        
        private String firstname;
        private String lastname;
        private String age;
 
        public String getFirstname() {
            return firstname;
        }
 
        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }
 
        public String getLastname() {
            return lastname;
        }
 
        public void setLastname(String lastname) {
            this.lastname = lastname;
        }
 
        public String getAge() {
            return age;
        }
 
        public void setAge(String age) {
            this.age = age;
        }
    }
}