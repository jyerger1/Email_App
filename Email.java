import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private String alternateEmail;
    private String companySuffix = "jaycompany.com";
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;

    // Constructor to receive first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email Created: " + firstName + " " + lastName);

        // call a method asking for the department - return the department
        this.department = setDepartment();
        System.out.println("Department: " + this.department);

        // call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        // combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
        System.out.println("Your email is:" + email);
    }

    // Ask for the department
    private String setDepartment() {
        System.out.print("New Worker: " + firstName
                + "- DEPARTMENT CODES\n1 for sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();

        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "dev";
        } else if (depChoice == 3) {
            return "acct";
        } else {
            return "";
        }

    }

    // generate a random password
    private String randomPassword(int length) {
        // Define the characters we will choose from
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWQYZ!@#$%^&*";
        // create an array of characters / new sequence of characters for size length
        char[] password = new char[length];

        for (int i = 0; i < length; i++) {
            // make math random an integer multiple number between 0&1 default by length
            // store in rand
            int rand = (int) (Math.random() * passwordSet.length());
            // using the password array at position i = passwordSet.charAt(random number)
            // numbers will be passed into array
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // set mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    // set alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    // change the password
    public void changePassword(String password) {
        this.password = password;
    }

    // getters
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "Display Name: " + firstName + " " + lastName + "\nCompany Email: " + email + "\nMailbox Capacity: "
                + mailboxCapacity + "mb";
    }

}