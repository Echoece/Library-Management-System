import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeScreen extends JFrame{
    private Container c;
    private JLabel j1;
    private JButton j2,j3;
    WelcomeScreen(){
        super();
        setTitle("Library Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setBounds(10,10,600,400);
        c=new Container();
        setContentPane(c);
        c.setBackground(Color.DARK_GRAY);


        j1=new JLabel("welcome");
        j1.setBounds(250,10,150,100);
        c.add(j1);

        j2=new JButton("Admin Login");
        j2.setBounds(200,110,150,70);
        c.add(j2);
        j2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminLogin i=new AdminLogin();
                dispose();
            }
        }
        );

        j3=new JButton("Memeber Login");
        j3.setBounds(200,250,150,70);
        c.add(j3);
        j3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MemberLogin i=new MemberLogin();
                dispose();
            }
        }
        );
    }
}
