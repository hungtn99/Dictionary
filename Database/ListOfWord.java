/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.ArrayList;
import java.util.List;

public class ListOfWord {
    public ArrayList<Word> ListWord = new ArrayList<>() ;
    public void addWord(String target, String explain){
        Word w=new Word();
        w.setWord_target(target);
        w.setWord_explain(explain);
        this.ListWord.add(w);
    }
}
