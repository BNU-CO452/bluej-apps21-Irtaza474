import java.util.ArrayList;
/**
 * This class stores information about a course
 * that enrolled students may want to complete
 *
 * @author Derek Peacock and Nicholas Day
 * irtaza
 * @version 0.1 11/Sep/2020
 */
public class Course
{
    public final static int MAXN_MODULES = 4;
    
    public ArrayList<Module> modules;
    
    private String code;
    private String title;
    
    private Grades finalGrade;
     
    public Course()
    {
        this("G400", "BSc Computing");
    }
    
    /**
     * Constructor for objects of class Course
     */
    public Course(String code, String title)
    {
        // initialise instance variables
        this.code = code;
        this.title = title;
        
        modules  = new ArrayList<Module>();
        
        createModules();
    }

    /**
     * Create four modules and add them to the
     * modules list for testing purposes.  These
     * must be your four modules.
     */
    public void createModules()
    {
        Module sub1= new Module("co452", "Programming Concepts");
        Module sub2= new Module("co453", "Operating System");
        Module sub3= new Module("co454", "Computer Architecture");
        Module sub4= new Module("co455", "Networking Concepts");
        addModule(sub1);
        addModule(sub2);
        addModule(sub3);
        addModule(sub4);
        //System.out.println("Module working");
    }
    
    public void addModule(Module module)
    {
        if(modules.size() < MAXN_MODULES)
        {
            modules.add(module);
        }
    }
    
    /**
     * 
     */
    public Grades convertToGrade(int mark)
    {
        if(mark >= 1 && mark <= 39)
        {
            return Grades.F;
        }
        else if(mark >= 40 && mark <= 49)
        {
            return Grades.D;
        }
        else if(mark >= 50 && mark <= 59)
        {
            return Grades.C;
        }
        else if(mark >= 60 && mark <= 69)
        {
            return Grades.B;
        }
        else if(mark >= 70 && mark <= 100)
        {
            return Grades.A;
        }
        return Grades.NS;
    }
    
    /**
     * Calculate the average mark from the four module marks
     * and convert that into a final grade.
     */
    public Grades calculateGrade(ArrayList<ModuleMark> marks)
    {
        if (marks.size() >= 1 || marks.size()<=4)
        {
            int sum=0;
            for(int i=0; i< marks.size(); i++)
            {
                sum+= marks.get(i).getValue();
            }
            sum= sum/marks.size();
            Grades avgGrade = convertToGrade(sum);
            return avgGrade;
        }
        return Grades.NS;
    }
    
    /**
     * Prints out the details of a course and the
     * four modules
     */
    public void print()
    {
        System.out.println();
        System.out.println(" Course " + code + ": " + title);
        //System.out.println();
        
        printModules();
    }
    
    /**
     * Print the course's four modules
     */
    public void printModules()
    {
        System.out.println();
        for(int i=0; i< this.modules.size(); i++)
        {
            System.out.println(" "+ this.modules.get(i).getTitle());
        }
    }
}
