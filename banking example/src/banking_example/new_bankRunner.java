package banking_example;

import java.util.Formatter;
import java.util.Scanner;

public class new_bankRunner {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("No. of Customers you want to enter: ");
        int n = sc.nextInt();
        new_bank C[] = new new_bank[n];
        for (int i=0;i<C.length;i++){
            C[i] = new new_bank();
            C[i].openAccount();
        }

        int ch;
        do{
            System.out.println("************************* MyBank Demo **************************");
            System.out.println("1. Display Account details 2. Search Account No. 3. Deposit 4. Withdrawal 5. Exit");
            System.out.println("Enter your choice");
            ch = sc.nextInt();

            switch (ch){
                case 1:
                    Formatter f1=new Formatter();
                    f1.format("%10s %10s %10s %10s","name","accno","acc_type","balance");
                    System.out.println(f1);
                    for (int i=0;i<C.length;i++){
                    C[i].showAccount();
                    }
                    break;

                case 2:
                    System.out.println("Enter account no. you want to search: ");
                    String ac_no = sc.next();
                    boolean found = false;
                    Formatter f2=new Formatter();
                    f2.format("%10s %10s %10s %10s","name","accno","acc_type","balance");
                    System.out.println(f2);
                    for (int i=0; i<C.length; i++){
                        found = C[i].search(ac_no);
                        if (found){
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("Search failed, Account doesnt exist");
                    }
                    break;

                case 3:
                    System.out.println("Enter Account no.");
                    ac_no = sc.next();
                    found = false;
                    for(int i=0;i<C.length;i++){
                        found = C[i].search(ac_no);
                        if (found){
                            C[i].deposit();
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("Search failed, Account doesnt exist");
                    }
                    break;

                case 4:
                    System.out.println("Enter Account no.");
                    ac_no = sc.next();
                    found = false;
                    for(int i=0;i<C.length;i++){
                        found=C[i].search(ac_no);
                        if(found){
                            C[i].withdrawal();
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("Search failed,Account doesnt exist");
                    }
                    break;

                case 5:
                    System.out.println("Thanks for visiting MyBank");
                    break;
            }
        }
        while (ch!=5);
    }
}