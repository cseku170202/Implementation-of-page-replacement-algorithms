/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os_lab_4;

/**
 *
 * @author N.S
 */

import java.awt.Color;
import java.util.Vector;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.*;
public class Fifo {
    
    int num_pages,num_frame,page_fault=0;
    String a[],inframe[];
    Fifo(int num_pages, String a[],int num_frame)
    {
        this.num_frame=num_frame;
        this.a=a;
        this.num_pages=num_pages;
        inframe=new String[this.num_frame];
        for(int i=0;i<num_frame;i++)
        {
            inframe[i]=null;
        }
    }
    
    boolean iscontain(String s)
    {
       
        String s1=s;
        for(int i=0;i<num_frame;i++)
        {
             String s2=(String)inframe[i];
             if(s1.equals(s2)==true)
             {
                return true;
             }
        }
        return false;
    }
    
     int index(String a[],String s)
     {
        
         String s1=s;
         for(int i=0;i< num_frame;i++)
         {
             String s2=inframe[i];
             if(s2.equals(s1)==true)
             {
                 return i;
             }
             
         }
         return -1;
     }
    void presentation()
    {
        JFrame f=new JFrame();
        int i,j,column,g=0;
        String k;
        JLabel l;
        JButton button;
        Queue<String> q=new LinkedList();
        for(i=0;i<num_pages;i++) // i is column
        {
            boolean b=iscontain(a[i]);
            if(b==true)
            {
                 l=new JLabel(""+a[i]);
                 l.setBounds(20+60*i, 20, 50, 200);
                 f.add(l);
                 continue; // print only label 
            }
            else
            {
                page_fault++;
                for(j=0;j<num_frame;j++)
                {
                    if(inframe[j]==null)//if frame is empty then execute
                    {
                        inframe[j]=a[i];
                        q.add(a[i]);
                        break;
                    }
                }
                if(j==num_frame)//if frame is not empty then execute
                {
                    k=(String)q.peek();
                    int in=index(inframe,k);
                    q.poll();
                    inframe[in]=a[i];
                    q.add(a[i]);
                }
            }
            l=new JLabel(""+a[i]);
            l.setBounds(20+60*i, 20, 50, 200);
            f.add(l);
            int c = 60*i;
            int d = 150;
            
            for(j=0;j<num_frame;j++)
            {
                if(inframe[j]!=null)
                {
                    button=new JButton(""+inframe[j]);
                    button.setBackground(Color.GREEN);
                }
                else
                {
                    button=new JButton();
                }
                button.setBounds(c, d, 50, 50);
                d=d+50;
                f.add(button);
                g = d;
            }
        }
        JLabel label = new JLabel("Total Number of Page fault : "+page_fault);
        label.setSize(500, 500);
        label.setBounds(100, g, 600, 200);
        f.add(label);
        
        f.setBounds(0, 0, 1000, 1000);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        System.out.println("Number of page fault "+page_fault);
    }
}
