import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte monthsInYear =12;
        final byte Percent = 100;
        int Principal;
        float annualInterest;
        float monthlyInterest;
        int numberOfPayments;

        Scanner scanner = new Scanner(System.in);//Capturing user input

        while (true) {
            System.out.print("Principal ($1K - $1M): ");
            Principal = scanner.nextInt();//Reading an answer as integer
            if(Principal >= 1000 && Principal <= 1_000_000)
                break;
            System.out.println("Enter a value between 1,000 and 1,000,000");
        }

        while (true){
            System.out.print("Annual interest rate: ");
            annualInterest = scanner.nextFloat();
            if(annualInterest >= 1 && annualInterest <= 30) {
                monthlyInterest = annualInterest / (Percent * monthsInYear);
                break;
            }
            System.out.println("Enter a value between 1 and 30.");
        }

        while (true){
            System.out.print("Period (Years): ");
            byte Years = scanner.nextByte();
            if(Years >= 1 && Years <= 30){
            numberOfPayments = Years * monthsInYear;
            break;
            }
            System.out.println("Enter a value between 1 and 30.");
        }

        double Mortgage = Principal
                          * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                          / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(Mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}