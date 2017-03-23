
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Login {

    private boolean flag;
    private boolean OwnerFlag;
    private String File = "";
    private String UserName, Password;

    public Login() {
        this.OwnerFlag = false;
        this.flag = false;
    }

    public String[] getLoginDetails() {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose Login Type");
        System.out.println("1- Bussiness Owner");
        System.out.println("2- Customer");
        do {
            flag = false;
            switch (in.nextInt()) {
                case 1: {
                    File = "business.txt";
                    OwnerFlag = true;         //false due to owner entry
                    break;
                }
                case 2: {
                    File = "customerinfo.txt";
                    OwnerFlag = false;            //false due to non owner
                    break;
                }
                default: {
                    flag = true;
                    System.out.println("Enter Valid Input");
                }
            }
        } while (flag);
        int count = 1;

        flag = false;
        do {
            System.out.println("UserName :");
            UserName = in.next();     //get input username from user
            System.out.println("Password :");
            Password = in.next();        //get input password from user
            boolean authenticFlag = false;

            String[] returnValue = login(UserName, Password, File);

            if (returnValue != null) {
                authenticFlag = true;
                return returnValue;
            }

            if (!authenticFlag) {
                if (count == 3) //check count (how many time user input wrong input
                {
                    System.out.println("You entered Wrong Wresname or password 3 times Good Bye! ");
                    System.exit(0);
                }
                flag = true;
                System.out.println("Wrong User name or passwrod Try Again!");
                count++;    //count ++ if user enter wrong username or password
            }
        } while (flag);

        return null;
    }

    /**
     * function to login user either it is Owner or customer
     *
     * @return Login Data as String[] array
     */
    public String[] login(String UserName, String Password, String File) {

        try {
            String line = "", arr[];
            FileReader fr = new FileReader(File);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                arr = line.split(",");        //make array of data split on , from file (each line)
                if (arr[4].equals(UserName)) //compare username with username in file
                {
                    if (arr[5].equals(Password)) //compare password with password in file
                    {
                        return arr;         //return data of user
                    }
                }
            }

        } catch (IOException e) //handling excetion
        {
            System.out.println("Ther is an exception in File Handling: " + e);
            return null;
        }

        return null;
    }
}
