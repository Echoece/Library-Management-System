import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ViewBookAdmin extends JFrame {
    private Container c;
    private JButton jb;
    private JTextArea j;
    private FileReader fr;
    private BufferedReader br;

    ViewBookAdmin(){
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

        j=new JTextArea();
        JScrollPane jp = new JScrollPane(j);
        jp.setBounds(70,80,450,250);
        c.add(jp,BorderLayout.CENTER);

        try {
            fr=new FileReader("book.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        br=new BufferedReader(fr);
        String Line=null;
        int count=1;
        while(true){
            try {
                if ((Line = br.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] arr=Line.split("#");
            j.append(count+" .  "+"Book name = "+arr[0]+"   Writer= "+arr[1]+"\r\n");
            count++;
        }

        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
