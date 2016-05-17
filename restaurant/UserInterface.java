/* 
 * COSC716
 * Author: Sara Ogaz
 */

package restaurant;

import java.util.Scanner;

public class UserInterface {

    public static void main(String[] args){
        SystemInterface sysInt = new SystemInterface();
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to Sushi Mountain's Interactive \n"
                + "Restaurant System.\n To exit system please use 'quit'\n");
        
        String input = "1";
        
        while (!input.equals("quit")){
            Integer tempTableNum;
            
            switch (input) {
                case "1":
                    System.out.print("Please see the following options available and \n"
                            + "use the numbers provided to chose one:\n"
                            + "1: options : see list of options\n"
                            + "2: getMenu : see printout of Menu and Menu Item IDs\n"
                            + "3: seatParty : seat party, interface will request further input\n"
                            + "4: enterOrder : enter menu order, interface will request further input\n"
                            + "5: getTab : get tab from table, interface will request further input\n"
                            + "6: payTab : enter payment onto tab, interface will request further input\n"
                            + "7: busTable : bus table, interface will request further input\n"
                            + "quit: quit application\n\n");
                    break;
                case "2":
                    sysInt.printMenu();
                    break;                    
                case "4":
                    System.out.println("Enter table number:");
                    tempTableNum = scanner.nextInt();
                    System.out.println("Enter item number:");
                    Integer itemNum = scanner.nextInt();
                    sysInt.enterOrder(tempTableNum,itemNum);
                    break; 
                case "3":
                    System.out.println("Enter table number:");
                    tempTableNum = scanner.nextInt();
                    System.out.println("Enter number of customers:");
                    Integer customers = scanner.nextInt();
                    sysInt.seatParty(tempTableNum, customers);
                    break;
                case "6":
                    System.out.println("Enter table number:");
                    tempTableNum = scanner.nextInt();
                    System.out.println("Enter amount paid:");
                    Float amountPaid = scanner.nextFloat();
                    sysInt.payTab(tempTableNum,amountPaid);
                    break;
                case "7":
                    System.out.println("Enter table number:");
                    tempTableNum = scanner.nextInt();
                    sysInt.busTable(tempTableNum);
                    break;
                case "5":
                    System.out.println("Enter table number:");
                    tempTableNum = scanner.nextInt();
                    sysInt.getTab(tempTableNum);
                    break;
                default: 
                    System.out.println("Invalid command.");
            }
            input = scanner.next();
        }
        
        System.out.println("Thank you for using Sushi Mountain's Interactive\n"
                + "Restuarant System. Goodbye.");
        
    }
    
}
