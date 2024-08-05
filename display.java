
import java.util.*;

public class display {

    private static String[] customer = new String[0];
    private static double[] charges = new double[0];

    static void calculatingParking(String choice, Scanner myObj) {

        double park_3hr = 2.0;
        double after3rdHr = 0.5;
        double park_24hr = 10.0;
        String user = "";
        double numHr = 0.0;
        double totalCharge = 0.0;

        if (choice.equals("1")) {
            System.out.print("Name: ");
            user = myObj.nextLine();

            System.out.print("Hours Parked: ");
            numHr = Double.parseDouble(myObj.nextLine());

            if (numHr % 24 == 0) {
                totalCharge = park_24hr * (numHr / 24);
                System.out.println(user + " you must pay $" + totalCharge);
            } else if (numHr > 3) {
                totalCharge = park_3hr + (Math.ceil(numHr - 3) * after3rdHr);
                System.out.println(user + " you must pay $" + totalCharge);
            } else {
                totalCharge = park_3hr;
                System.out.println(user + " you must pay $" + totalCharge);
            }

            // Add the user information to the customer array
            customer = Arrays.copyOf(customer, customer.length + 1);
            customer[customer.length - 1] = user + " paid for " + numHr + " hours";

            // Add the charge information to the charges array
            charges = Arrays.copyOf(charges, charges.length + 1);
            charges[charges.length - 1] = totalCharge;
        } else if (choice.equals("2")) {
            for (String cust : customer) {
                System.out.println(cust);
            }

            double totalChargesSum = 0.0;
            for (double ch : charges) {
                totalChargesSum += ch;
            }
            System.out.println("Total charges for all customers: $" + totalChargesSum);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to Pay your Parking");
            System.out.println("----------------------");
            System.out.println("1. Pay Now");
            System.out.println("2. View Yesterday's receipts");
            System.out.println("3. Exit");

            System.out.print("Pick an option to proceed>> ");
            String choice = input.nextLine();
            if (!choice.equals("2") && !choice.equals("1")) {
                System.out.println("Exiting...");
                break;
            }
            calculatingParking(choice, input);
        }

        input.close();
    }
}
