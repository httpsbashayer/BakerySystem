import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class TestClass{
  public static void main(String[]ars) throws IOException{
    Scanner scan = new Scanner(System.in);
    String name; boolean correct = true;
    
    Bakery diplomat = new Bakery("Diplomat", "King Abdullah road", 200, 1000);
    try{
    Sweet first = new Sweet("Cookies", 4);
    Bread second = new Bread("Arabic", 2);
    Bread third = new Bread("Toast", 4);
    
    //The addition of items into the bakery's menu
    diplomat.addItem((Item) first);
    diplomat.addItem((Item) second);
    diplomat.addItem((Item) third);
    } catch (IllegalNameException n) {
      System.out.println(n.getMessage());
    }
    
    name = "Eclair";
    
    while(correct){
    try{
      diplomat.addItem((Item) (new Sweet(name, 8)));
      correct = false;
    } catch (IllegalNameException n) {
      System.out.println(n.getMessage());
      System.out.println("\rPlease re-enter the name of item correctly | Because there is no such item like that\rMenu:\r1) Doughnut\r2) English Cake\r3) Cookies");
      name = scan.next();
    }}
    
    //Preform daily check
    diplomat.DailyCheck();
    
    //Storing sweet info from bakery's menu
    String sweetData = diplomat.storeAllSweet();
    
    //GUI Part
    //Frame creation
    JFrame window = new JFrame();
    window.setTitle("Bakery Application");
    window.setSize(480,420);
    window.setResizable(false);
    ImageIcon icon = new ImageIcon("roller.png");
    window.setIconImage(icon.getImage());
    window.getContentPane().setBackground(new Color(235, 135, 113));
    
    //Label creation
    JLabel label = new JLabel();
    label.setText("Welcome to Our Bakery");
    window.add(label);
    Image logo = icon.getImage();
    Image editedLogo = logo.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
    icon = new ImageIcon(editedLogo);
    label.setIcon(icon);
    label.setHorizontalTextPosition(JLabel.CENTER);
    label.setVerticalTextPosition(JLabel.BOTTOM);
    label.setForeground(new Color(191, 63, 40));
    label.setFont(new Font("Century Gothic", Font.PLAIN, 27));
    label.setVerticalAlignment(JLabel.TOP);
    label.setHorizontalAlignment(JLabel.CENTER);
    label.setIconTextGap(20);
    
    //Text Area creation
    Container box = new Container();
    box.setLayout(new FlowLayout());
    JTextArea text = new JTextArea(sweetData);
    text.setBounds(50, 1000, 200, 200);
    text.setLineWrap(true);
    text.setWrapStyleWord(true);
    text.setEditable(false);
    text.setBackground(new Color(224, 220, 218));
    text.setForeground(new Color(46, 46, 46));
    text.setFont(new Font("Century Gothic", Font.PLAIN, 14));
    box.add(label);
    box.add(text);
    window.add(box);
    
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);
    
    //Deletion of item at index 1 (item no. 2)
    System.out.print((diplomat.removeItem(1))? "The itam no. 2 is succesfully deleted!\r" : "Unfortunately the itam no. 2 does not exist\r");
  }
}