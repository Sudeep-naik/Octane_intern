import java.util.*;
class ATM { // This class is for the handling the atm operations
    Scanner s = new Scanner(System.in);
    int balance = 0; // to store the balance amount each time the operation is performed
    int pin = 1234; // pin initially set to some number
    ArrayList<String> transactions = new ArrayList<>(); // arrayList to handle all the transaction

    public void Check() { //method to check the balance

        System.out.println("Current Balance: " + balance);
        transactions.add("Checked Balance: " + balance);
    }

    public void Deposit() { // method to deposit the amount
        System.out.println("Enter amount to be deposited: ");
        int dep = s.nextInt();
        balance += dep;
        System.out.println("After Deposit, the Balance is: " + balance);
        transactions.add("Deposited: " + dep + " | New Balance: " + balance);
    }

    public void Withdraw() { //method to withdraw the amount
        System.out.println("Enter amount to Withdraw: ");
        int with = s.nextInt();
        if (with > balance) {
            System.out.println("Insufficient Balance");
            transactions.add("Failed Withdrawal of: " + with + " | Insufficient Balance");
        } else {
            balance -= with;
            System.out.println("Amount Withdrawn Successfully");
            transactions.add("Withdrew: " + with + " | New Balance: " + balance);
        }
    }

    public void ChangePin() { //method to change the pin when required
        System.out.println("Enter new PIN: ");
        int newPin = s.nextInt();
        pin = newPin;
        System.out.println("PIN changed successfully");
        transactions.add("PIN changed");
    }

    public void ViewTransactions() { // this method is to view the transaction that is being carried out
        if (transactions.isEmpty()) {
            System.out.println("No transactions found");
        } else {
            System.out.println("Transaction History:");
            for (String transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }

    public int getPin() {
        return pin;
    } // this is the method to get the pin
}

public class octaneJava { // class to display all the operations
    public static void main(String args[]) {
        int option = 0;
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM();

        System.out.println("Enter Pin: ");
        int input_pin = sc.nextInt();
        if (input_pin != atm.getPin()) {
            System.out.println("Incorrect Pin");
        } else {
            while (option != 5) {
                System.out.println("\n1. Check Balance");
                System.out.println("2. Withdraw Money");
                System.out.println("3. Deposit Money");
                System.out.println("4. Change PIN");
                System.out.println("5. View Transactions");
                System.out.println("6. Quit");
                System.out.println("Enter Option: ");
                option = sc.nextInt();
                switch (option) {
                    case 1:
                        atm.Check();
                        break;
                    case 2:
                        atm.Withdraw();
                        break;
                    case 3:
                        atm.Deposit();
                        break;
                    case 4:
                        atm.ChangePin();
                        break;
                    case 5:
                        atm.ViewTransactions();
                        break;
                    case 6:
                        break;
                    default:
                        System.out.println("Invalid option, please try again.");
                        break;
                }
            }
        }
    }
}