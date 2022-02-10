import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MemberLogin extends JFrame{
    private Container c;
    private JLabel l1,l2;
    private JTextField jt1;
    private JPasswordField p1;
    private JButton jb1,jb2;
    FileReader fr=null;
    BufferedReader br=null;

    MemberLogin(){
        super();
        setTitle("Library Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setBounds(10,10,600,400);
        c=new Container();
        setContentPane(c);
        c.setBackground(Color.DARK_GRAY);

        jb2=new JButton("Back to Menu");
        jb2.setBounds(240,15,150,20);
        c.add(jb2);
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WelcomeScreen m=new WelcomeScreen();
                dispose();
            }
        });

        l1=new JLabel("Name");
        l1.setBounds(100,100,100,70);
        c.add(l1);

        l2=new JLabel("Password");
        l2.setBounds(100,180,100,70);
        c.add(l2);

        jt1=new JTextField();
        jt1.setBounds(210,120,200,30);
        c.add(jt1);

        p1=new JPasswordField(20);
        p1.setBounds(210,200,200,30);
        c.add(p1);

        jb1=new JButton("Submit");
        jb1.setBounds(250,280,100,50);
        c.add(jb1);
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=jt1.getText();
                String pass=String.valueOf(p1.getPassword());
                jt1.setText("");
                p1.setText("");
                try {
                    fr=new FileReader("account.txt");
                } catch (IOException ef) {
                    ef.printStackTrace();
                }
                br=new BufferedReader(fr);
                String Line = null;
                Boolean flag=true;

                while(true){
                    try {
                        if (!((Line=br.readLine())!=null)) break;
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    String[] arr=Line.split("#");
                    if(arr[0].equalsIgnoreCase(name)){
                        flag=false;
                        if(arr[1].equalsIgnoreCase(pass)){
                            JOptionPane.showMessageDialog(null,"Login success");
                            MemberMenu m=new MemberMenu();
                            dispose();
                        }
                        else
                            JOptionPane.showMessageDialog(null,"wrong password");
                    }
                }
                if(flag==true)
                    JOptionPane.showMessageDialog(null,"username not found");

                try {
                    br.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                try {
                    fr.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });



    }
}
