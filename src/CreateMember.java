import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class CreateMember extends JFrame {
    private Container c;
    JLabel jl1,jl2,jl3;
    JTextField jt1,jt2,jt3;
    JButton jb,jb1;
    FileWriter fw = null;
    PrintWriter pw;
    FileReader fr;
    BufferedReader br;

    CreateMember(){
        super();
        setTitle("Library Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setBounds(10,10,600,400);
        c=new Container();
        setContentPane(c);
        c.setBackground(Color.DARK_GRAY);

        jl1=new JLabel("User Name");
        jl1.setBounds(100,60,100,70);
        c.add(jl1);

        jt1=new JTextField();
        jt1.setBounds(210,80,200,30);
        c.add(jt1);

        jl2=new JLabel("password");
        jl2.setBounds(100,140,100,70);
        c.add(jl2);

        jt2=new JTextField();
        jt2.setBounds(210,160,200,30);
        c.add(jt2);

        jl3=new JLabel("Contact info");
        jl3.setBounds(100,220,100,70);
        c.add(jl3);

        jt3=new JTextField();
        jt3.setBounds(210,240,200,30);
        c.add(jt3);

        jb1=new JButton("Back to Menu");
        jb1.setBounds(240,15,150,20);
        c.add(jb1);
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminMenu m=new AdminMenu();
                dispose();
            }
        });

        jb=new JButton("submit");
        jb.setBounds(250,300,90,40);
        c.add(jb);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    fw=new FileWriter("account.txt",true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                try {
                    fr=new FileReader("account.txt");
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                br=new BufferedReader(fr);
                pw=new PrintWriter(fw);
                String Line = null;
                int flag=0;

                try {
                    while((Line=br.readLine())!=null){
                        String[] arr=Line.split("#");
                        if(arr[0].equalsIgnoreCase(jt1.getText())){
                            flag=1;
                            JOptionPane.showMessageDialog(null,"UserName Already exists");
                            jt1.setText("");
                            jt2.setText("");
                            jt3.setText("");
                            break;
                        }
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                if(flag==0){
                    pw.println(jt1.getText()+"#"+jt2.getText()+"#"+jt3.getText()+"#");
                    JOptionPane.showMessageDialog(null,"Account Created SuccessFUlly");
                    pw.flush();
                    pw.close();
                    try {
                        fw.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                   dispose();
                   AdminMenu m=new AdminMenu();
                }
            }
        });

    }
}
