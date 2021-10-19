import java.awt.*;           
import java.awt.event.*;     
import javax.swing.*;        

/**
 * The Driver class presents a simple GUI that can be used to search courses. The
 * GUI allows the user to specify a department to use as a search criterion.
 * 
 * @author Computer Science Department 
 * @version November, 2009
 * @modified by Thu Le & Jiamu Chen
 * @version December, 2020
 */
public class GUIInterface implements ActionListener
{   private CourseHistory courses = new CourseHistory();
    private JFrame frame = new JFrame("DPU - Course History");
    private JButton submitButton = new JButton("SUBMIT");
    private JComboBox reportCombo = new JComboBox();  

    /*
     * The constructor for the Driver class creates the GUI and calls
     * a method to fill the report combo box with initial values. It
     * then displays this comboBox on the pane.
     */
    public GUIInterface()
    {         
        //By default a gridlayout has one row
        frame.getContentPane().setLayout(new GridLayout()); 
        fillReportCombo();

        submitButton.addActionListener(this);      //Add the search button's action    
        frame.getContentPane().add(submitButton);
        frame.pack();
        frame.setVisible(true);
    }

    /*
     * This method fills the reportCombo box with initial values.
     */
    public void fillReportCombo()
    { 
        reportCombo.addItem("COURSE HISTORY");
        reportCombo.addItem("SUMMARY");
        reportCombo.addItem("DISTAREAS");
        reportCombo.addItem("COMPETENCY");
        reportCombo.addItem("FULLREPORT");
        reportCombo.addItem("SORTEDLIST");
        frame.getContentPane().add(reportCombo);
    }

    /*
     * This method is called when the user clicks on a button in the Interface.
     * The method checks to see if the user clicked on the SUBMIT button.  If so,
     * it prints the selected report.
     *
     */
    public void actionPerformed(ActionEvent event)
    { 
        if (event.getSource().equals(submitButton))
        {   String selectedReport = reportCombo.getSelectedItem().toString();
            if (selectedReport.equals("COURSE HISTORY") )
            {   
                System.out.print("\f");
                courses.displayCourseHistory();
            }
        }
        if (event.getSource().equals(submitButton))
        {   String selectedReport = reportCombo.getSelectedItem().toString();
            if (selectedReport.equals("SUMMARY") )
            {   
                System.out.print("\f");
                System.out.println("*****Summary Report*****");
                courses.displaySummary();
            }
        }
        if (event.getSource().equals(submitButton))
        {   String selectedReport = reportCombo.getSelectedItem().toString();
            if (selectedReport.equals("DISTAREAS") )
            {   
                System.out.print("\f");
                System.out.println("*****Distribution Area Report*****");
                courses.distAreaReport("AH");
                courses.distAreaReport("SS");
                courses.distAreaReport("SM");
                courses.distAreaReport("LA");
            }
        }
        if (event.getSource().equals(submitButton))
        {   String selectedReport = reportCombo.getSelectedItem().toString();
            if (selectedReport.equals("COMPETENCY") )
            {   
                System.out.print("\f");
                System.out.println("*****Competency Report*****");
                courses.compReport("W");
                courses.compReport("S");
                courses.compReport("Q");
                courses.compReport2();
            }
        }
        if (event.getSource().equals(submitButton))
        {   String selectedReport = reportCombo.getSelectedItem().toString();
            if (selectedReport.equals("FULLREPORT") )
            {   
                System.out.print("\f");
                System.out.println("*****Full Report*****");
                courses.displayFullReport();
            }
        }
        if (event.getSource().equals(submitButton))
        {   String selectedReport = reportCombo.getSelectedItem().toString();
            if (selectedReport.equals("SORTEDLIST") )
            {   
                System.out.print("\f");
                System.out.println("*****Sorted Course List*****");
                courses.displaySortedGPA();
            }
        }
    }
}




