import java.util.Scanner;

public class Email {

  private final  String firstName;
  private final String lastName;
  private String password;
  private final int defaultPassword = 10;
  private final String email;
  private final String suffix= "StarkIndustries.com";
  private final String department;
  private int mailBoxCapacity = 500;
  private  String altEmail;

  // Constructor to take first and last name
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName  = lastName;
        System.out.println("Email created: " + this.firstName + " " + this.lastName);

        this.department = setDepartment();
        System.out.println("Department: " + this.department);

        //password
        this.password = setPassword(defaultPassword);
        System.out.println("Password generated: " + this.password);

        //combine to create an email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + suffix;
        System.out.println("Email generated: " + email);
    }

    private String setDepartment(){
        System.out.print("Enter department number\n1 : Sales\n2 : Accounting\n3: Dev team\n4: none of the above\n select a department: ");
        Scanner in = new Scanner(System.in);
        int departmentSelection = in.nextInt();
        if(departmentSelection == 1){return "Sales";}
        else if (departmentSelection == 2) { return "Accounting";}
        else if (departmentSelection == 3) {return "DevTeam";}
        else return "";
    }

    private String setPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!@#$%";
        char[] password = new char[length];
        for(int i = 0; i < length; i++){
          int random = (int) (Math.random() * passwordSet.length());
          password[i] = passwordSet.charAt(random);
        }
        return new String(password);
    }

    public void setMailBoxCapacity(int capacity) {
        this.mailBoxCapacity = capacity;
    }

    public void setAltEmail(String altEmail){
        this.altEmail = altEmail;
    }

    public void changePassword(String password){
        this.password = password;
    }

    public int getMailBoxCapacity() { return mailBoxCapacity;}
    public String getAltEmail(){return altEmail;}
    public String getPassword(){return password;}


public String revealAllInfo(){
        return "User info: \n" + "Name: " + firstName + " " + lastName + "\n" +
                "Company-Email: " + email + "\n" +
                "Mailbox Capacity: " + getMailBoxCapacity() + "mb";
}


}
