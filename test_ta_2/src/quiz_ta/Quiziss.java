package quiz_ta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiziss extends JFrame implements ActionListener {

    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;

    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;

    String name;

    Quiziss(String name) {
        this.name = name;
        setBounds(0, 0, 1440, 800);
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/quiz.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 350);
        add(image);

        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        // Define questions and answers
        questions[0][0] = "Manakah dibawah ini yang termasuk bilangan prima";
        questions[0][1] = "2";
        questions[0][2] = "10";
        questions[0][3] = "12";
        questions[0][4] = "15";

        questions[1][0] = "Dimanakah Ibukota negara Indonesia ?";
        questions[1][1] = "Jakarta";
        questions[1][2] = "Serang";
        questions[1][3] = "Balikpapan";
        questions[1][4] = "Yogyakarta";

        questions[2][0] = "Kota manakah yang disebut *Kota Pelajar* ?";
        questions[2][1] = "Semarang";
        questions[2][2] = "Solo";
        questions[2][3] = "Surabaya";
        questions[2][4] = "Yogyakarta";

        questions[3][0] = "Apa nama transportasi yang berjalan di air ?";
        questions[3][1] = "Kapal laut";
        questions[3][2] = "Kapal terbang";
        questions[3][3] = "Kereta";
        questions[3][4] = "Dokar";

        questions[4][0] = "Siapakah nama Presiden pertama Republik Indonesia ?";
        questions[4][1] = "Soekarno";
        questions[4][2] = "Soesilo Bambang Y.";
        questions[4][3] = "Soeharto";
        questions[4][4] = "Jokowi";

        questions[5][0] = "Siapakah nama Bapak Pendidikan Indonesia ?";
        questions[5][1] = "Ki Hadjar Dewantara";
        questions[5][2] = "Moh. Hatta";
        questions[5][3] = "Bung Tomo";
        questions[5][4] = "Tan Malaka";

        questions[6][0] = "Dimanakah letak Ibukota negara Russia ?";
        questions[6][1] = "Canberra";
        questions[6][2] = "Ngawi";
        questions[6][3] = "Moscow";
        questions[6][4] = "Jember";

        questions[7][0] = "Kemanakah Soekarno diculik ?";
        questions[7][1] = "Cirebon";
        questions[7][2] = "Karawang";
        questions[7][3] = "Cikarang";
        questions[7][4] = "Rengasdengklok";

        questions[8][0] = "Bahasa apa yang dijadikan sebagai bahasa resmi Negara Indonesia ?";
        questions[8][1] = "Bahasa Indonesia";
        questions[8][2] = "Bahasa Sunda";
        questions[8][3] = "Bahasa Jawa";
        questions[8][4] = "Bahasa Cina";

        questions[9][0] = "Huruf pertama dari alfabet adalah ?";
        questions[9][1] = "A";
        questions[9][2] = "Y";
        questions[9][3] = "D";
        questions[9][4] = "G";

        // Define correct answers
        answers[0][1] = "2";
        answers[1][1] = "Jakarta";
        answers[2][1] = "Yogyakarta";
        answers[3][1] = "Kapal laut";
        answers[4][1] = "Soekarno";
        answers[5][1] = "Ki Hadjar Dewantara";
        answers[6][1] = "Moscow";
        answers[7][1] = "Rengasdengklok";
        answers[8][1] = "Bahasa Indonesia";
        answers[9][1] = "A";

        // Add options
        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next = new JButton("Selanjutnya");
        next.setBounds(700, 700, 200, 30);
        next.setFont(new Font("Tahoma", Font.PLAIN, 18));
        next.setBackground(new Color(22, 99, 54));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        lifeline = new JButton("Bantuan");
        lifeline.setBounds(930, 700, 200, 30);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lifeline.setBackground(new Color(22, 99, 54));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);

        submit = new JButton("Kumpulkan");
        submit.setBounds(1150, 700, 200, 30);
        submit.setForeground(Color.BLACK);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 18));
        submit.setBackground(new Color(255, 215, 0));
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        start(count);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);
        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                }
            }
            setVisible(false);
            new Score(name, score);
        }
    }


    public void paint(Graphics g) {
        super.paint(g);

        String time = "Time left - " + timer + " seconds"; // 15
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));

        if (timer > 0) {
            g.drawString(time, 1000, 500);
        } else {
            g.drawString("Times up!!", 1000, 500);
        }


        timer--; // 14

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(false);
            opt2.setEnabled(false);
            opt3.setEnabled(false);
            opt4.setEnabled(false);
            setVisible(false);

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            if (count == 9) { // submit button
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }

                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    }
                }
                setVisible(false);
                new Score(name, score);
            } else { // next button
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }
        }
    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupoptions.clearSelection();
    }

    public static void main(String[] args) {
        new Quiziss("Tamu");
    }
}

