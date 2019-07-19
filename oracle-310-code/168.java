import java.io.Serializable;
 
/**
 *
 * @author javadb.com
 */
public class Person implements Serializable {
    
    private String firstName;
    private String lastName;
    private int age; 
    
    /**
     * Creates a new instance of Person
     */
    public Person() {
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    public int getAge() {
        return age;
    }
 
    public void setAge(int age) {
        this.age = age;
    }
    
    //Overriding toString to be able to print out the object in a readable way
    //when it is later read from the file.
    public String toString() {
        
        StringBuffer buffer = new StringBuffer();
        buffer.append(firstName);
        buffer.append("\n");
        buffer.append(lastName);
        buffer.append("\n");
        buffer.append(age);
        buffer.append("\n");
        
        return buffer.toString();
    }
    
    
}


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
 
/**
 *
 * @author javadb.com
 */
public class Main {
    
    /**
     * Example method for using the ObjectOutputStream class
     */
    public void writePersons(String filename) {
        
        ObjectOutputStream outputStream = null;
        
        try {
            
            //Construct the LineNumberReader object
            outputStream = new ObjectOutputStream(new FileOutputStream(filename));
            
            Person person = new Person();
            person.setFirstName("James");
            person.setLastName("Ryan");
            person.setAge(19);
            
            outputStream.writeObject(person);
            
            person = new Person();
            
            person.setFirstName("Obi-wan");
            person.setLastName("Kenobi");
            person.setAge(30);
            
            outputStream.writeObject(person);
            
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            //Close the ObjectOutputStream
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main().writePersons("myFile.txt");
    }
}