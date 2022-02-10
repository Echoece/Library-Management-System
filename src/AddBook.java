import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AddBook extends JFrame {
    private Container c;
    private JLabel jl1,jl2;
    private JTextField jt1,jt2;
    private JButton jb1,jb;
    private FileWriter fw;
    private PrintWriter pw;

    AddBook(){
        super();
        setTitle("Library Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setBounds(10,10,600,400);
        c=new Container();
        setContentPane(c);
        c.setBackground(Color.DARK_GRAY);

        jb=new JButton("Back to Menu");
        jb.setBounds(240,15,150,20);
        c.add(jb);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminMenu m=new AdminMenu();
                dispose();
            }
        });

        jl1=new JLabel("Book Name");
        jl1.setBounds(100,100,100,70);
        c.add(jl1);

        jl2=new JLabel("Author Name");
        jl2.setBounds(100,180,100,70);
        c.add(jl2);

        jt1=new JTextField();
        jt1.setBounds(210,120,200,30);
        c.add(jt1);

        jt2=new JTextField();
        jt2.setBounds(210,200,200,30);
        c.add(jt2);

        jb1=new JButton("Submit");
        jb1.setBounds(250,280,100,50);
        c.add(jb1);
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    fw=new FileWriter("book.txt",true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                pw=new PrintWriter(fw);
                pw.println(jt1.getText()+"#"+jt2.getText()+"#");
                JOptionPane.showMessageDialog(null,"Book Added Successfully");
                pw.flush();
                pw.close();
                try {
                    fw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                jt1.setText("");
                jt2.setText("");
            }
        });



    }

}
