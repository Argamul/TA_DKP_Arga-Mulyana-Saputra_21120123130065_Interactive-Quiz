package quiz_ta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Score extends JFrame {
    Score(String name, int score) {

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(""));
        Image i2 = i1.getImage().getScaledInstance(200, 150, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(60, 200, 200, 150);
        add(image);

        JLabel heading = new JLabel("Terimakasih " + name + " telah mengikuti Kuis ini! ");
        heading.setBounds(90, 80, 700, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 26));
        add(heading);

        JLabel Score = new JLabel("Nilaimu adalah " + score);
        Score.setBounds(90, 200, 300, 30);
        Score.setFont(new Font("Tahoma", Font.BOLD, 26));
        add(Score);

        JButton retry = new JButton("Ulangi");
        retry.setBounds(90, 270, 120, 30);
        retry.setBackground(Color.GREEN);
        retry.setForeground(Color.WHITE);
        add(retry);

        JButton exit = new JButton("keluar");
        exit.setBounds(250, 270, 120, 30);
        exit.setBackground(Color.GREEN);
        exit.setForeground(Color.WHITE);
        add(exit);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

            }
        });
        retry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();
            }
        });

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("Icons/piala.png"));
        Image i22 = i11.getImage().getScaledInstance(750, 550, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imagee = new JLabel(i33);
        imagee.setBounds(0, 0, 750, 550);
        add(imagee);

        setSize(750, 550);
        setLocation(400, 150);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Score("Tamu", 0);
    }
}
