import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AdminMenu extends JFrame {
    private Container c;
    private JButton j2,j3,j4,j5,j6,j7,j8,j9;

    AdminMenu(){
        super();
        setTitle("Library Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setBounds(10,10,600,200);
        c=new Container();
        setContentPane(c);
        c.setLayout(new FlowLayout());
        c.setBackground(Color.DARK_GRAY);

        j2=new JButton("Create Member");
        c.add(j2);
        j2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateMember c=new CreateMember();
                dispose();
            }
        });

        j3=new JButton("Issue book");
        c.add(j3);
        j3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IssueBook i=new IssueBook();
                dispose();
            }
        });

        j5=new JButton("Return book");
        c.add(j5);
        j5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReturnBook r=new ReturnBook();
                dispose();
            }
        });

        j9=new JButton("Add Book");
        c.add(j9);
        j9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddBook a=new AddBook();
                dispose();
            }
        });

        j4=new JButton("View Issued book");
        c.add(j4);
        j4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewIssuedBook v=new ViewIssuedBook();
                dispose();
            }
        });

        j7=new JButton("View Member List");
        c.add(j7);
        j7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewMember m=new ViewMember();
                dispose();
            }
        });

        j8=new JButton("ViewBookList");
        c.add(j8);
        j8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewBookAdmin v2=new ViewBookAdmin();
                dispose();
            }
        });

        j6=new JButton("logout");
        c.add(j6);
        j6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                WelcomeScreen w=new WelcomeScreen();
            }
        });
    }
}
