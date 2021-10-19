import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;


/** 
 * @Author: Thu Le & Jiamu Chen
 * @Version: Dec 2020
 */

public class CourseHistory
{
    ArrayList <CompletedCourse> courseList;

    public CourseHistory()
    {
        courseList = new ArrayList<CompletedCourse>();
        String department;
        String courseNumber;
        String semesterTaken;
        String credit;
        String grade;
        String competency;
        String distArea;

        try
        {
            FileReader file = new FileReader("finishedcourses.txt");
            BufferedReader reader = new BufferedReader(file);

            while (reader.ready())
            {
                department = reader.readLine();
                courseNumber = reader.readLine();
                semesterTaken = reader.readLine();
                credit = reader.readLine();
                grade = reader.readLine();
                competency = reader.readLine();
                distArea = reader.readLine();
                CompletedCourse theCompletedCourse = new CompletedCourse(department, 
                        courseNumber, semesterTaken, credit, grade, competency, distArea);
                courseList.add(theCompletedCourse);
            }
            reader.close();
        }
        catch (IOException exception)
        {
            System.out.println("Error processing file: " + exception);
        }
    }
    
    // To display all the course the student has done
    public void displayCourseHistory()
    {
        for (int i = 0; i < courseList.size(); i++)
        {
            courseList.get(i).displayCourse();
        }
    }
    
    // To display the GPA and total credits earned
    public void displaySummary()
    {
        double sumCredit = 0.0;
        double totalCredit = 0.0;
        double gradeCredit = 0.0;
        double GPA = 0.0;
        
        for (int i = 0; i < courseList.size(); i++)
        {
            if (courseList.get(i).getGrade() > 0)
            {
                sumCredit = sumCredit + courseList.get(i).getCredit();
                
            }
            gradeCredit = gradeCredit + (courseList.get(i).getCredit() * 
                courseList.get(i).getGrade());
            totalCredit += courseList.get(i).getCredit();
        }
        
        GPA = gradeCredit / totalCredit; 

        System.out.println("Total credits earned: " + sumCredit);
        System.out.println("Cumulative GPA: " + GPA);
    }
    
    // A function to print distArea report
    public void distAreaReport(String distArea)
    {
        System.out.println(""); 
        for (int i = 0; i < courseList.size(); i++)
        {
            if (courseList.get(i).getDistArea().equals(distArea))
            {
                    courseList.get(i).displayCourse();
            }
        }
        double credit = 0;
        
        for (int i = 0; i < courseList.size(); i++)
        {
            if (courseList.get(i).getDistArea().equals(distArea))
            {
                if(courseList.get(i).getGrade() > 0)
                    credit += courseList.get(i).getCredit();
            }
        }
        
        System.out.println("");
        System.out.println("Total number of credits successfully completed in " + distArea + " is: " + credit);
        
    }
    
    // This function is to count the credit in each competency
    public int creditcomp(String competency)
    {
        int count = 0;
        
        for (int i = 0; i < courseList.size(); i++)
        {
            
            if (courseList.get(i).getCompetency().equals(competency) && 
                courseList.get(i).getGrade() > 0)
            {
                count++;
            }
            
        }
        
        return count;
    }
    
    // To print if the student complete each competency
    public void compReport(String competency)
    {
        if (creditcomp(competency) > 0)
        {
            System.out.println(competency + " competency: Complete");
        } 
        else
        {
            System.out.println(competency + " competency: Incomplete");
        }
                
    }
    
    // To display the competency status
    public void compReport2()
    {
        if(creditcomp("W") > 0 && creditcomp("S") > 0 && creditcomp("Q") > 0)
        {
             System.out.println("All competencies completed.");
        }
        else if(creditcomp("W") > 0 || creditcomp("S") > 0 || creditcomp("Q") > 0)
        {
             System.out.println("Competencies partially completed.");
        }        
        else if(creditcomp("W") == 0 && creditcomp("S") == 0 && creditcomp("Q") == 0)
        {
             System.out.println("No competencies completed.");
        }
    }
      
    // The full report includes the summary report, the distribution area report, and the competency report.
    public void displayFullReport()
    {
        System.out.println("\n*****Summary Report*****");
        displaySummary();
        System.out.println("\n*****Distribution Area Report*****");
        distAreaReport("AH");
        distAreaReport("SS");
        distAreaReport("SM");
        distAreaReport("LA");
        System.out.println("\n*****Competency Report*****");
        compReport("W");
        compReport("S");
        compReport("Q");
        compReport2();
    }
    
    public void displaySortedGPA()
    {
        ArrayList <CompletedCourse> courseListTemp = new ArrayList<CompletedCourse>();
        courseListTemp = courseList; 
        
        for (int i = 0; i < courseListTemp.size() - 1; i++)
        {
            for (int j = 0; j < courseListTemp.size() - 1; j++)
            {
                if (courseListTemp.get(j).getGrade() < courseListTemp.get(j+1).getGrade())
                {
                    courseListTemp.set(j, courseListTemp.set(j+1, courseListTemp.get(j)));
                }
            }
        }

        for (int i = 0; i < courseListTemp.size(); i++)
        {
            courseListTemp.get(i).displayCourse();
        }
    }
}

