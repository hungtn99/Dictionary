/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.event.KeyEvent;
import dictionarymanagement.DictionaryManagement;
import graphics.MainPanel;
public class OptionFrame {
     JFrame Fadd;
     JFrame Fedit;
     JFrame Fdelete;
     public void setFadd(DictionaryManagement D){
         Fadd=new JFrame();
         Fadd.setSize(500,500);
         Fadd.setLayout(null);
         Fadd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JTextField txtadd=new JTextField();
        txtadd.setBounds(10,10,300,20);
        JTextArea txtradd=new JTextArea();
        txtradd.setBounds(10,80,300,100);
        JButton bsaveadd=new JButton("Save");
        bsaveadd.setBounds(200,400,80,50);
        bsaveadd.addActionListener(new ActionListener() {
        
         @Override
         public void actionPerformed(ActionEvent e) {     
             if(bsaveadd==e.getSource()){
            
             
                 String target=txtadd.getText();
                 String explain=txtradd.getText();
                 D.dictionaryAdd(target, explain);
                 try {
                     D.exportToFile();
                 } catch (IOException e1) {
                     e1.printStackTrace();
                 }
             }
                 
             
            }    
        });
        Fadd.add(txtadd);
        Fadd.add(txtradd);
        Fadd.add(bsaveadd);
        Fadd.setVisible(true);
     }
    
    
}
