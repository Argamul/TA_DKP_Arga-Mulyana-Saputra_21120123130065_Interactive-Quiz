package quiz_ta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

        JTextField text;
        JButton Next, Back;

        Login(){
            getContentPane().setBackground(Color.WHITE);
            setLayout(null);

            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/"));
            Image i = i1.getImage().getScaledInstance(400,500,Image.SCALE_DEFAULT);
            ImageIcon i2 = new ImageIcon(i);
            JLabel image = new JLabel(i2);
            image.setBounds(450,0,400,500);
            add(image);

            JLabel heading = new JLabel("Kuis Mudah dan Menyenangkan");
            heading.setBounds(100,60,300,45);
            heading.setFont(new Font("Baskerville", Font.BOLD, 18));
            heading.setForeground(Color.DARK_GRAY);
            add(heading);

            JLabel name = new JLabel("Masukkan Nama Anda !");
            name.setBounds(140,150,300,20);
            name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
            name.setForeground(new Color(22,99,54));
            add(name);


            text = new JTextField();
            text.setBounds(90,170,300,25);
            text.setFont(new Font("Times New Roman", Font.BOLD,18));
            add(text);


            Next = new JButton("Selanjutnya");
            Next.setBounds(250,300,120,25);
            Next.setBackground(new Color(22,99,54));
            Next.setForeground(Color.WHITE);
            Next.addActionListener(this);
            add(Next);

            Back = new JButton("Kembali");
            Back.setBounds(100,300,120,25);
            Back.setBackground(new Color(22,99,54));
            Back.setForeground(Color.WHITE);
            Back.addActionListener(this);
            add(Back);

            setSize(500,400);
            setLocation(200,150);
            setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == Next) {
                String name = text.getText();
                this.setVisible(false);
                new Quiziss(name);
            } else if (e.getSource() == Back) {
                System.exit(50);
            }
        }

        public static void main(String[] args) {
            new quiz_ta.Login();
        }
    }

