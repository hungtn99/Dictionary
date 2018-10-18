
package graphics;
import java.awt.*;
import javax.swing.*;
public class DictionaryJFrame {
    private JFrame mainFrame;
    public DictionaryJFrame(){
       
        
        prepareGUI();
    }

    private void prepareGUI() {
        mainFrame=new JFrame();
        mainFrame.setSize(1000,700);
        mainFrame.setBackground(Color.GREEN);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainPanel m=new MainPanel();
        JPanel P=m.setMainPanel();
        mainFrame.add(P);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
    }
    public static void main(String arg[]){
        try {
    UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
    }
        catch(Exception ex) { }
  
     DictionaryJFrame F=new DictionaryJFrame();
   }
  
    
}
  