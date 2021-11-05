
// Created by Irtaza Qayyum

/**
 * This is a class module and is apart of the course.
 *
 * @author Irtaza Qayyum
 * @version 1.0
 */
public class Module {
    // variable
    private String code;
    private String title;
    private Module module;
    
    /**
     * Constructor for objects of class Module
     */
    public Module(String code, String title) {
        // initialise instance variables
        this.code = code;
        this.title = title;
         credit = 0;
    }
        
    /**
     * The method will printout the module code and
     * title
     */
    public String getCode() {
        return code;
    }
    
    /**
    * This method will return the title.
    * @param
    * @return code
    */
    public String getTitle() {
        return title;
    }

    public int getCredit() {
        return this.credit;
    }

    public void setCredit(int credit) 
    {
        this.credit = credit;
    }

    /**
    * The method will printout the module code and
    * title
    */
    public void print() {
        //printHeading();
        System.out.println("Module Code: " + getCode() + " : " + getTitle());
        System.out.println();
    }
    
    public static void main(String[] args) {
        Module m = new Module("abc", "def");
        m.print();
    }
}



    
    
    
        
    
    
        
      


   