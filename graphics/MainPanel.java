
package graphics;
import database.ListOfWord;
import dictionarymanagement.DictionaryManagement;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.event.KeyEvent;
 
public final class MainPanel extends JPanel {
    private JPanel mainpnl;
    private JPanel pnl1;
    private JPanel pnl2;
    private JPanel pnl3;
    private JPanel pnlsreach;
    private JPanel pnloption;
    private JPanel pnlhistory;
    private JButton bsreach;
    private JButton bedit;
    private JButton bdelete;
    private JButton badd;
    private JButton bsound;
    private JTextField txtsreach;
    private JTextArea txtarea;
    private JLabel lbltitle;
    private ListOfWord l;
    private JList lst;
    private static DictionaryManagement D;
    private OptionFrame OF;
    public JPanel setMainPanel(){
        mainpnl=new JPanel();
        mainpnl.setLayout(null);
        mainpnl.setSize(1000,700);
        this.setPnl1();
        this.setPnl2();
        this.setPnl3();
        
        mainpnl.add(pnl1);
        mainpnl.add(pnl2);
        mainpnl.add(pnl3);
        l=new ListOfWord();
        D=new DictionaryManagement();
        D.insertFormFile();
        OF=new OptionFrame();
        bsreach.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {     
             if(e.getSource()==bsreach){
                    String s=txtsreach.getText();
                    String mean=D.dictionaryLookup(s);
                    txtarea.setText(mean);
                    txtarea.setEditable(false);
                
                }
            }   
        });
        txtsreach.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {     
             if(txtsreach==e.getSource()){
                    String s=txtsreach.getText();
                    String mean=D.dictionaryLookup(s);
                    txtarea.setText(mean);
                    txtarea.setEditable(false);
                }
            }   
        });
        txtsreach.addCaretListener(new CaretListener(){
            @Override
            public void caretUpdate(CaretEvent e) {
                
                lst.setListData(D.DictionarySearcherBox(txtsreach.getText()));
                int t =D.DictionaryGetLSearcherBox(txtsreach.getText());
                if(t<=15){
                lst.setSize(340, t*30);
                }
                else
                {
                   lst.setSize(340, 15*30); 
                }
            }
            
        });
        txtsreach.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                if(txtsreach.getText().length()==0){
                    lst.setListData(new String[0]);
                }
                else if(txtsreach.getText().length()!=0){
                    lst.setListData(D.DictionarySearcherBox(txtsreach.getText()));
                    int t =D.DictionaryGetLSearcherBox(txtsreach.getText());
                if(t<=15){
                lst.setSize(340, t*30);
                }
                else
                {
                   lst.setSize(340, 15*30); 
                }
                }
                 else{
                     lst.setListData(new String[0]);
                     txtarea.setText("Không tìm thấy từ!");
                }
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
                    txtarea.setText("Không tìm thấy từ!");
                }
            }
        });
        lst.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount()==1){
                    String s=(String) lst.getSelectedValue();
                    txtarea.setText(D.dictionaryLookup(s));
                    txtsreach.setText(s);
                }
            }
        });
         bedit.addActionListener(new ActionListener() {
        
         @Override
         public void actionPerformed(ActionEvent e) {     
             if(bedit==e.getSource()){
             txtarea.setEditable(!txtarea.isEditable());
                 String target=txtsreach.getText();
                 String explain=txtarea.getText();
                 D.dictionaryEdit(target, explain);
                 try {
                     D.exportToFile();
                 } catch (IOException e1) {
                     e1.printStackTrace();
                 }
             }
            }    
        });
         badd.addActionListener(new ActionListener() {
        
         @Override
         public void actionPerformed(ActionEvent e) {     
             if(badd==e.getSource()){
             OF.setFadd(D);
             }
                 
             
            }    
        });
        return mainpnl;
        
         }
    public void setPnl1(){
        pnl1= new JPanel(){
            ImageIcon i=new ImageIcon("C:\\Users\\Asus\\Dictionary\\src\\database\\icon\\pnl1bg.png");
            @Override
            public void paintComponent(Graphics g){
            g.drawImage(i.getImage(), 0, 0, 350, 700, null);
            setOpaque(false);
            super.paintComponent(g);
            }
        };
        pnl1.setLocation(0, 0);
        pnl1.setBackground(Color.CYAN);
        pnl1.setSize(350, 700);
        pnl1.setLayout(null);
        pnlsreach=new JPanel();
        pnlsreach.setBounds(5,5,340,90);
        pnlsreach.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Sreach here"));
        bsreach = new JButton();
        bsreach.setPreferredSize(new Dimension(50, 50));
        bsreach.setIcon(new ImageIcon("C:\\Users\\Asus\\Dictionary\\src\\database\\icon\\search.png"));
        txtsreach=new JTextField("",15);
        txtsreach.setFont(new Font("Monaco", Font.BOLD, 20));
        txtsreach.setPreferredSize(new Dimension(59, 59));
        txtsreach.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.yellow));
        pnlsreach.add(txtsreach);
        pnlsreach.add(bsreach);        
        pnlhistory=new JPanel();
        pnlhistory.setPreferredSize((new Dimension(355, 450)));
        pnlhistory.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "History"));
        lst=new JList();
        lst.setFont(new Font("Monaco", Font.BOLD, 20));
        lst.setBounds(5, 95, 340, 0);
        
        pnl1.add(pnlsreach, BorderLayout.NORTH);
        pnl1.add(lst);
      
        
    }
    public void setPnl2(){
        pnl2=new JPanel(){
            ImageIcon i=new ImageIcon("C:\\Users\\Asus\\Dictionary\\src\\database\\icon\\pnl1bg.png");
            @Override
            public void paintComponent(Graphics g){
            g.drawImage(i.getImage(), 0, 0, 600, 700, null);
            setOpaque(false);
            super.paintComponent(g);
            }
        };
        pnl2.setSize(550,700);
        pnl2.setLocation(350, 0);
        pnl2.setLayout(null);
        txtarea=new JTextArea();
        txtarea.setPreferredSize(new Dimension(550,700));
        txtarea.setFont(new Font("Monaco", Font.BOLD, 20));
        txtarea.setEditable(false);
        txtarea.setLineWrap(true);
        txtarea.setWrapStyleWord(true);
        txtarea.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Show here"));
        JScrollPane scrolltxtarea=new JScrollPane(txtarea);
        scrolltxtarea.setBounds(10, 100, 530, 550);
        lbltitle=new JLabel("DICTIONARY");
        lbltitle.setForeground(new Color(43, 249, 239));
        lbltitle.setFont(new Font("Monaco", Font.BOLD, 68));
        lbltitle.setBounds(10, 0,550,100);
        lbltitle.setBackground(Color.red);
        pnl2.add(scrolltxtarea);
        pnl2.add(lbltitle);
        pnl2.add(scrolltxtarea, BorderLayout.SOUTH);
    }
    public void setPnl3(){
        pnl3=new JPanel();
        pnl3.setBackground(new Color(49,54,83));
        pnl3.setBounds(900, 0, 100, 700);
        pnl3.setLayout(null);
        pnloption =new JPanel();
        pnloption.setBounds(0,100, 100,450);
        pnloption.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Option"));
        pnloption.setLayout(new GridLayout(4,0,3,3));
        badd=new JButton();
        badd.setIcon(new ImageIcon("C:\\Users\\Asus\\Dictionary\\src\\database\\icon\\add8.png"));
        bedit=new JButton();
        bedit.setIcon(new ImageIcon("C:\\Users\\Asus\\Dictionary\\src\\database\\icon\\edit8.png"));
        bsound=new JButton();
        bsound.setIcon(new ImageIcon("C:\\Users\\Asus\\Dictionary\\src\\database\\icon\\sound8.png"));
        bdelete=new JButton();
        bdelete.setIcon(new ImageIcon("C:\\Users\\Asus\\Dictionary\\src\\database\\icon\\delete8.png"));
        pnloption.add(bsound);
        pnloption.add(badd);
        pnloption.add(bedit);
        pnloption.add(bdelete);
        Color c=badd.getBackground();
        pnl3.add(pnloption);
    }
    
}
