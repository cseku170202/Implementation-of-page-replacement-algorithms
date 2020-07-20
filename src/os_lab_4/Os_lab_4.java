/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package os_lab_4;

/**
 *
 * @author Asus
 */
import java.util.Scanner;
import javax.swing.JOptionPane;
public class Os_lab_4{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        Scanner sc=new Scanner(System.in);
        Scanner sc2=new Scanner(System.in);
        int d=Integer.parseInt(JOptionPane.showInputDialog("PAGE REPLACEMENT ALGORITHMS : \nChoose anyone of these 4 algorithms.\nNo 1 = FIFO\nNo 2 = LRU\nNo 3 = OPTIMAL\nNo 4 = NRU"));
        System.out.println("Enter the total number of pages :");
        int num_pages=sc.nextInt();
        String a[] = new String [num_pages];
        System.out.println("Enter the page sequence respectively :");
        for(int i=0;i<num_pages;i++)
        {
            a[i]=sc2.nextLine();       
        }
        System.out.println("Enter the total number of frames :");
        int num_frame= sc.nextInt(); 
        if(d==1)
        {
             Fifo f=new Fifo(a.length,a,num_frame);
             f.presentation();;
        }
        else if(d==2)
        {
             LRU l=new LRU(a.length,a,num_frame);
           l.presentation(); 
        }
        else if(d==3)
        {
              Optimal op = new Optimal(a.length,a,num_frame);
              op.presentation();
        }
        else if(d==4)
        {
            NRU n= new NRU(a.length,a,num_frame);
            n.presentation();
        }
     
    }
    
}