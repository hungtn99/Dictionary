/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionarycommanline;
import dictionarymanagement.*;
import database.*;
import java.util.Scanner;
public class DictionaryCommanline extends DictionaryManagement {
    public void showAllWord(){
        int i=0;
        System.out.println("No  |English        |VietNamese");
        for (Word w : this.ListWord) {
            System.out.println(i+"  |"+w.getWord_target()+"        |"+w.getWord_explain());
            i++;
        }
    }
    public void DictionaryBasic(){
        this.insertFromCommanLine();
        this.showAllWord();
    }
   
    public static void main(String arg[]){
        DictionaryManagement D=new DictionaryManagement();
        D.insertFormFile();
        System.out.println("Welcome to Dictionary");
        System.out.println("Choice this menu");
        System.out.println("1. Search Word");
        System.out.println("2. Add Word");
        System.out.println("3. Delete Word");
        System.out.println("4. Edit Word");
        System.out.println("5. Forget Word");
        int n=new Scanner(System.in).nextInt();
        if(n==1){
            System.out.println("Typing here");
            String s=new Scanner(System.in).nextLine();
            String s1=D.dictionaryLookup(s);
            System.out.println(s1);
        }
        else if(n==2){
            System.out.println("Typing Word_target");
            String s1=new Scanner(System.in).nextLine();
            System.out.println("Typing Word_explain");
            String s2=new Scanner(System.in).nextLine();
            D.dictionaryAdd(s1, s2);
        }
        else if(n==3){
            System.out.println("Typing Word_target");
            String s=new Scanner(System.in).nextLine();
            D.dictionaryDelete(s);
        }
        else if(n==4){
            System.out.println("Typing Word_target");
            String s1=new Scanner(System.in).nextLine();
            String s2=new Scanner(System.in).nextLine();
            D.dictionaryEdit(s1, s2);
        }
        else if(n==5){
            System.out.println("Typing Word_target");
            String s=new Scanner(System.in).nextLine();
            D.DictionarySearcher();
        }
    }
    
}
