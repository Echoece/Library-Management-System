import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ReturnBook extends JFrame {
    private Container c;
    JLabel jl1,jl2,jl3;
    JTextField jt1,jt2,jt3;
    JButton jb,jb1;
    private FileReader fr=null ;
    private BufferedReader br=null;
    private FileWriter fw,fw1;
    private PrintWriter pw,pw1;

    ReturnBook(){
        super();
        setTitle("Library Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setBounds(10,10,600,400);
        c=new Container();
        setContentPane(c);
        c.setLayout(null);
        c.setBackground(Color.DARK_GRAY);

        jl1=new JLabel("Book Name");
        jl1.setBounds(100,60,100,70);
        c.add(jl1);

        jt1=new JTextField();
        jt1.setBounds(210,80,200,30);
        c.add(jt1);

        jl2=new JLabel("Memeber Name");
        jl2.setBounds(100,140,100,70);
        c.add(jl2);

        jt2=new JTextField();
        jt2.setBounds(210,160,200,30);
        c.add(jt2);

        jl3=new JLabel("Author name");
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

        jb=new JButton("return Book");
        jb.setBounds(250,300,90,40);
        c.add(jb);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    fr=new FileReader("IssuedBook.txt");
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                br=new BufferedReader(fr);
                int flag=0;
                String Line=null;
                String temp="";

                while(true){
                    try {
                        if ((Line = br.readLine()) == null) break;
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    String[] arr=Line.split("#");

                    if(!( arr[0].equalsIgnoreCase(jt2.getText())&& arr[1].equalsIgnoreCase( jt1.getText() ) )){
                        temp=temp+Line+"\r\n";
                    }

                    if( arr[0].equalsIgnoreCase(jt2.getText() ) && arr[1].equalsIgnoreCase( jt1.getText() )  ){
                        flag=1;
                        try {
                            fw=new FileWriter("book.txt",true);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        pw=new PrintWriter(fw);
                        pw.println(jt1.getText()+"#"+jt3.getText()+"#");
                        JOptionPane.showMessageDialog(null,"Book received successfully");
                        pw.flush();
                        pw.close();
                        try {
                            fw.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
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

                if(flag==0){
                    JOptionPane.showMessageDialog(null,"wrong member/book name");
                    jt1.setText("");
                    jt2.setText("");
                    jt3.setText("");
                }
                if(flag==1){
                    try {
                        fw1=new FileWriter("IssuedBook.txt",false);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    pw1=new PrintWriter(fw1);
                    pw1.print(temp);
                    pw1.flush();
                    pw1.close();
                    try {
                        fw1.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

            }
        });


    }
}
