import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemberMenu extends JFrame {
    private Container c;
    private JButton jb1,jb2;

    MemberMenu(){
        super();
        setTitle("Library Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setBounds(10,10,600,400);
        c=new Container();
        setContentPane(c);
        c.setBackground(Color.DARK_GRAY);

        jb1=new JButton("Back to Menu");
        jb1.setBounds(225,15,150,20);
        c.add(jb1);
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WelcomeScreen m=new WelcomeScreen();
                dispose();
            }
        });

        jb2=new JButton("View Book List");
        jb2.setBounds(225,100,150,100);
        c.add(jb2);
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewBookList v1=new ViewBookList();
                dispose();
            }
        });


    }

}
