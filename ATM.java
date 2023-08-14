import java.util.*;
class Ainterface
{
    public static HashMap<Integer,ArrayList<String>>custDet =new HashMap<Integer,ArrayList<String>>();
    public static ArrayList<ArrayList<String>>transaction =new ArrayList<ArrayList<String>>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("Enter your Choice from :\n1.CustomerLogin\n2.Exit ");
            int ch=sc.nextInt();
            switch(ch)
            {
                case 1:
                    CustomerLogin();
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter a Valid Choice");
            }
        }
    }
    public static void CustomerLogin() {
        ArrayList<String> det=new ArrayList<>();
        det.add("8685");
        det.add("shwetha");
        det.add("5000");
        custDet.put(5678, det);
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your Credit Card Number");
        int cnumber=sc.nextInt();
        System.out.println("Enter your Pin Number");
        int pin=sc.nextInt();
        String pin1=String.valueOf(pin);
        if(custDet.containsKey(cnumber))
        {
            if(pin1.equals((custDet.get(cnumber).get(0))))
            {
                System.out.println("Welcome User"+(custDet.get(cnumber).get(1)));
                Transaction(cnumber);
            }
            else
            {
                System.out.println("You entered wrong! Check your pin number");
            }
        }
        else
            System.out.println("Check your card Number again");
    }
    public static void Transaction(int cnumber) {
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            System.out.println("Enter your Choice from:\n1.Check The Balance\n2.WithDraw the Money\n3.Deposit the Money\n4.Transfer\n5.Mini Statement\n6.Exit ");
            int ch=sc.nextInt();
            switch(ch)
            {
                case 1:
                    enquiry(cnumber);
                    break;
                case 2:
                    CashWithDraw(cnumber);
                    break;
                case 3:
                    Deposit(cnumber);
                    break;
                case 4:
                    Transfer(cnumber);
                    break;
                case 5:
                    Statement(cnumber);
                    break;
                case 6:
                    System.out.println("Thanks for Using!!!!!!!!!!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter correct Choice in the above menu");
            }
        }
    }
    public static void enquiry(int cnumber) {
        System.out.println("Current Balance is: "+custDet.get(cnumber).get(2));
    }
    public static void CashWithDraw(int cnumber) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Amount:");
        int cash=sc.nextInt();
        if(cash<=Integer.parseInt(custDet.get(cnumber).get(2))){
            System.out.println("Your Amount is proceded");
            String amount=custDet.get(cnumber).get(2);
            int amount1=Integer.parseInt(amount);
            amount1-=cash;
            amount=String.valueOf(amount1);
            ArrayList<String> details=custDet.get(cnumber);
            details.set(2, amount);
            custDet.put(cnumber,details);
            ArrayList<String> transactionDetails=new ArrayList<>();
            transactionDetails.add(String.valueOf(cnumber));
            transactionDetails.add("With Draw");
            transactionDetails.add(String.valueOf(cash));
            transaction.add(transactionDetails);
            System.out.println("Your Balance is: "+custDet.get(cnumber).get(2));
        }
        else{
            System.out.println("Insufficent Balance");
        }
    }
    public static void Deposit(int cnumber) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Amount: ");
        int cash=sc.nextInt();
        System.out.println("Your Amount is Deposited");
            String amount=custDet.get(cnumber).get(2);
            int amount1=Integer.parseInt(amount);
            amount1+=cash;
            amount=String.valueOf(amount1);
            ArrayList<String> details=custDet.get(cnumber);
            details.set(2, amount);
            custDet.put(cnumber,details);
            ArrayList<String> transactionDetails=new ArrayList<>();
            transactionDetails.add(String.valueOf(cnumber));
            transactionDetails.add("Deposit");
            transactionDetails.add(String.valueOf(cash));
            transaction.add(transactionDetails);
            System.out.println("Your Balance is: "+custDet.get(cnumber).get(2));
    }
    public static void Statement(int cnumber) {

        for(ArrayList<String> i:transaction)
        {
            if(Integer.parseInt(i.get(0))==cnumber){
                for(String j:i){
                    System.out.print(j+" ");
                }
                System.out.println();
            }
        }
    }
    public static void Transfer(int cnumber) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Account Number of transfer account ");
        int acc1=sc.nextInt();
        System.out.println("Enter Amount to Transfer ");
        int cash=sc.nextInt();
        if(cash<=Integer.parseInt(custDet.get(cnumber).get(2))){
            System.out.println("Ammount of "+cash+"Rs"+"Transfered to "+acc1);
            String amount=custDet.get(cnumber).get(2);
            int amount1=Integer.parseInt(amount);
            amount1-=cash;
            amount=String.valueOf(amount1);
            ArrayList<String> details=custDet.get(cnumber);
            details.set(2, amount);
            custDet.put(cnumber,details);
            ArrayList<String> transactionDetails=new ArrayList<>();
            transactionDetails.add(String.valueOf(cnumber));
            transactionDetails.add("Transfer");
            transactionDetails.add(String.valueOf(cash));
            transaction.add(transactionDetails);
            System.out.println("The Balance Amount: "+custDet.get(cnumber).get(2)+"Rs");
        }
        else{
            System.out.println("Sorry Insufficent Balance.");
        }
    }
}