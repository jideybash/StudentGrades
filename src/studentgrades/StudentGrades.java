
package studentgrades;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Babajide Bashiru
 */
public class StudentGrades {

   static Scanner sc = new Scanner(System.in);
   public static boolean goodval = false;
    
    public static void main(String[] args) {
        // TODO code application logic here
        double q1, q2, q3, q4, q5, qm, mt, fe, pr;
        String sid;
        String quit;
        
        System.out.println("Welcome to the Grading program.");
        System.out.println("Please enter Student information: ");
        
        getStudentID();

        
        q1 = getValue("Quiz 1");
        q2 = getValue("Quiz 2");
        q3 = getValue("Quiz 3");
        q4 = getValue("Quiz 4");
        q5 = getValue("Quiz 5");
        qm = getValue("Quiz Make-Up Score");
        mt = getValue("Mid-Term exam Score");
        pr = getValue("Problems Score");
        fe = getValue("Final Exam Score");
        
       
        double[] vals = { q1, q2, q3, q4, q5, qm};
        Arrays.sort(vals);
        int sum = 0;
        for (int i=0; 1<6; i++) {
           double qavg = (vals[2] + vals[3] + vals[4] + vals[5]) / 4.0;
//           if (qavg >= 90 || mt >= 90 || pr >= 90) {
//              
//           }
           double cavg = (qavg * .5) + (mt * .15) + (pr * .1) + (fe * .25);
           String lgrade;
           if (cavg >= 90){
             System.out.print("A");
           }
           else if (cavg < 89 && cavg > 80){
            System.out.print("B");
           }
           else if (cavg < 79 && cavg > 70){
            System.out.print("C");
           }
           else if (cavg < 69 && cavg > 60) {
             System.out.print("D");
           }
           else if (cavg < 60){
            System.out.print("F");
           }
        System.out.println("Student earned a quiz average of " + qavg + 
                " , a course average of " + cavg + 
                " , and a letter grade of: " + lgrade);  
      
        System.out.print("Thanks for using the grade calculator!");
        System.exit(0);
        }
        
            }// end of main
    
    public static double getValue(String prompt) {
        double q = 0;
        goodval = false;
        while(!goodval){
            
                    try {
            System.out.print(prompt + ": ");
            Scanner nb = new Scanner(System.in);
            q = nb.nextDouble();
            if(q > 125 || q < 0){
                System.out.println("Error: " + prompt + "score is out of bounds: 0-125 only.  Please re-enter.");
                goodval = false;
            }
            else {
                goodval = true;
            }
       } catch (Exception e) {
             System.out.println ("Error: " + prompt + "score must be numeric.  Please re-enter.");
           goodval = false;
        }
        
        }

        return q;
    }
    
    public static void getStudentID(){
        String sid;
        long snum;
        String quit;
        goodval = false;
        while(!goodval){
            
            System.out.println("Student ID(enter 'quit' to exit): ");
        sid = sc.nextLine();
         if (sid.equals("quit")) {
            System.out.println("Thank you for using the Grade caculator Program"); 
         System.exit(0);
         } 
         else if (!sid.toUpperCase().startsWith("A"))
             
        {
            System.out.println("Error: student number must begin with an 'A'");
            goodval = false;
        }
        else if (sid.length() != 9)
        {
           System.out.println ("Error: student number must have 8 digits after the 'A'");
           goodval = false;
        } 
        else if (sid.equals("A00000000"))
        {
          System.out.println("Error: student number cannot be all zeros after the 'A'");
          goodval = false;
        }
        else{
            
            try {
        snum = Integer.parseInt(sid.substring(1));
        goodval = true;
        } catch (NumberFormatException e) {
            System.out.println ("Error: student number must have 8 digits after the 'A'");
           goodval = false;
        }
            
        }
    
        }

    
}
 
}
