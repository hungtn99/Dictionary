
package dictionarymanagement;
import java.io.*;
import database.*;
import java.util.Scanner;
public class DictionaryManagement extends ListOfWord {
    public void insertFormFile(){
        try{
            File f=new File("C:\\Users\\Asus\\Dictionary\\src\\database\\fileout.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF8"));
            String s;
            while((s=in.readLine())!=null){

                String ln[]= s.split("\t");
                this.addWord(ln[0], ln[1]);
            }
            in.close();
        }
        catch (UnsupportedEncodingException e)
	    {
			System.out.println(e.getMessage());
	    }
	    catch (IOException e)
	    {
			System.out.println(e.getMessage());
	    }
	    catch (Exception e)
	    {
			System.out.println(e.getMessage());
	    }
    }
    public void exportToFile() throws IOException { 
		File file = new File("C:\\Users\\Asus\\Dictionary\\src\\database\\DataDiction.txt");
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
		for (Word word : this.ListWord) {
                    out.write(word.getWord_target()+"\t"+word.getWord_explain()+"\r\n");
                }
		out.close();
	}
    public String dictionaryLookup(String s){
        String result=" ";
        boolean check=true;
        for(Word w: this.ListWord){
            if(w.getWord_target().equals(s)){
                result=w.getWord_explain();
                
                check=false;
            }
        }
        if(check==true){
            result="Khong co tu nay";
        }
        
        return result;
    }
    public void dictionaryDelete(String target){
        boolean check=true;
        for(Word w: this.ListWord){
            if(w.getWord_target().equals(target)){
                this.ListWord.remove(w);
                check=false;
            }
        }       
        if(check==true){
            System.out.println("Khong co tu nay");
        }
    }
     public void DictionarySearcher(){
        String s=new Scanner(System.in).nextLine();
        for(Word w : this.ListWord){
            if(w.getWord_target().startsWith(s, 0)){
                System.out.println(w.getWord_target());
            }
        }
    }
    public void dictionaryAdd(String target, String explain){
        this.addWord(target, explain);
    }
    public void dictionaryEdit(String target, String explain){
        boolean check=true;
        for(Word w: this.ListWord){
            if(w.getWord_target().equals(target)){
                w.setWord_explain(explain);
                check=false;
            }
        }
        if(check==true){
            System.out.println("Khong co tu nay");
        }
    }
  
    public void insertFromCommanLine(){
        int n=new Scanner(System.in).nextInt();
        try{
            for(int i=0; i<n; i++){
                String target=new Scanner(System.in).nextLine();
                String explain=new Scanner(System.in).nextLine();
                this.addWord(target, explain);
            }
        }
        catch(Exception e){
            
        }
    }
}