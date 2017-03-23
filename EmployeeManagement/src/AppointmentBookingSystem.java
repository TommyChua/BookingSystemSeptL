
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author apex
 */
public class AppointmentBookingSystem {

    private static Scanner in = new Scanner(System.in);           //scanner objext to input from user in console
    private static boolean OwnerFlag;       //owner flag user to determine either login user is owner or not
    private static String data2[];

    /**
     * function to register the new customers
     */
    private static void Register() {
        try {
            FileWriter fw = new FileWriter("customerinfo.txt", true);          //open text file in writer append mode
            BufferedWriter bw = new BufferedWriter(fw);       //gave access of file to buffer writer
            System.out.println("Enter First Name");
            bw.write(in.next());        //write string input from console directly to file
            bw.write(",");              //append , for easiness n data extraction
            System.out.println("Enter Last Name");
            bw.write(in.next());        //write string input from console directly to file
            bw.write(",");              //append , for easiness n data extraction
            System.out.println("Enter Phone");
            bw.write(in.next());
            bw.write(",");
            System.out.println("Enter Address");
            bw.write(in.next());
            bw.write(",");
            System.out.println("Enter UserName");
            bw.write(in.next());
            bw.write(",");
            System.out.println("Enter Password");
            bw.write(in.next());
            bw.newLine();       //after all data inserted an endline to make file redy for next registration
            bw.close();
        } catch (IOException e) //catch any exception occur durring this process
        {
            System.out.println("Ther is an exception in File Handling: " + e);
        }
    }

    /**
     * function to add new employee
     */
    private static void AddEmployee() {
        
    }

    public static void AddWorkingTime() {
        
    }

    public static void ShowSummaries() {
        
    }

    public static void showWorkingTimeTable() {
        
    }

    public static void showBookingTimeTable() {
        
    }

    public static void BookSlot() {
        
    }

    public static void BookAppointment() {
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Login login = new Login();
        boolean flag = false, terminate = false;
        while (!terminate) {
            System.out.println("Wellcome to Appointment Booking System");
            System.out.println("1-Login");
            System.out.println("2-Register");
            System.out.println("3-Terminate");
            do {
                flag = false;
                switch (in.nextInt()) {
                    case 1: {
                        data2 = login.getLoginDetails();
                        //if login data is owner's data
                        if (OwnerFlag) {
                            boolean flag1;
                            System.out.println("Wellcome to Owner's Panel");
                            System.out.println("1- Add new Employee");
                            //real functionality will be in in part 2
                            System.out.println("2- Add Working Time/Date");
                            System.out.println("3- Look Summaries of Bookings");
                            System.out.println("4- Show All Worker's avalaibility next week");
                            //till here
                            do {
                                flag1 = false;
                                switch (in.nextInt()) {
                                    case 1: {
                                        AddEmployee();  //add new employee access only available to Owner
                                        break;
                                    }
                                    case 2: {
                                        AddWorkingTime();
                                        break;
                                    }
                                    case 3: {
                                        ShowSummaries();
                                        break;
                                    }
                                    case 4: {
                                        showWorkingTimeTable();
                                        break;
                                    }
                                }
                            } while (flag1);
                        } else //else its customer's login data
                        {
                            System.out.println("Customer Successfully Loged in");
                            for (int i = 0; i < data2.length; i++) {
                                System.out.println(data2[i]);
                            }
                            System.out.println("\nBooking Time Slots\n");

                            boolean flag1;
                            System.out.println("Wellcome to Customer's Panel");
                            System.out.println("1- Show Booking Time Slots");
                            System.out.println("2- book appointment");
                            do {
                                flag1 = false;
                                switch (in.nextInt()) {
                                    case 1: {
                                        showBookingTimeTable();
                                        break;
                                    }
                                    case 2: {
                                        BookAppointment();
                                        break;
                                    }

                                }
                            } while (flag1);

                        }
                        break;

                    }
                    case 2: {
                        //register new customer
                        Register();
                        break;
                    }
                    case 3: {
                        terminate = true;     //terminate flag will true so it will terminate main while loop
                        break;
                    }
                    default: {
                        flag = true;
                        System.out.println("Enter Valid Input");
                    }
                }

            } while (flag);    //if user enter wrong input it will try make him again 
        }
    }

}
