/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankbalance;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Work
 */
public class BankBalance {

    public static double balance;
    public static double yearRate = 0.025;
    public static int i = 10;
    private static DecimalFormat df2 = new DecimalFormat("#.##");
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        balance = Double.parseDouble(JOptionPane.showInputDialog("What is your current balance", "0.00"));
        
        char trans;
        double amount;
        
        while (i != 12)
        {
            trans = JOptionPane.showInputDialog("Would you like to Deposit or withdraw (D/W):", "D/W").toUpperCase().charAt(0);
            amount = Double.parseDouble(JOptionPane.showInputDialog("Enter amount:", "0.00"));
            
            switch(trans) {
                case 'D':
                  deposit(amount);
                  break;
                case 'W':
                  withdraw(amount);
                  break;
                default:
                  JOptionPane.showMessageDialog(null, "Transaction type not vaild");
            }
        }
        
        System.out.println("Your balance after the year is: R" + df2.format(balance));
    }

    static void deposit(double amount) {
        balance = balance+(yearRate/12)*balance + (yearRate/12)*amount;
        i++;
    }

    static void withdraw(double amount) {
        balance = balance+(yearRate/12)*balance - (yearRate/12)*amount;
        i++;
        
    }
    
}
