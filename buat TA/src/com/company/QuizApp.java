package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class QuizApp extends JFrame implements ActionListener {
    JLabel label;
    JRadioButton radioButtons[]=new JRadioButton[5];
    JButton btnNext,btnResult,btnPrevious;
    ButtonGroup bg;
    int count =0,current = 0, x=1,y=1,now=0;
    int m[]=new int[10];


    QuizApp(String s){
        super(s);
        label=new JLabel();
        add(label);
        bg=new ButtonGroup();
        for (int i=0; i<5; i++) {
            radioButtons [i] = new JRadioButton();
            add(radioButtons[i]);
            bg.add(radioButtons[i]);
        }
        btnPrevious = new JButton("Sebelumnya");
        btnNext = new JButton("Selanjutnya");
        btnResult = new JButton("Hasil");
        btnResult.setVisible(false);
        btnResult.addActionListener(this);
        btnNext.addActionListener(this);
        btnPrevious.addActionListener(this);
        add(btnNext);
        add(btnResult);
        add(btnPrevious);
        setData();
        label.setBounds(30,40,450,20);
        radioButtons[0].setBounds(50,80,450,20);
        radioButtons[1].setBounds(50,110,200,20);
        radioButtons[2].setBounds(50,140,200,20);
        radioButtons[3].setBounds(50,170,200,20);
        btnNext.setBounds(360,240,100,30);
        btnResult.setBounds(270,240,100,30);
        btnPrevious.setBounds(100,240,100,30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250,100);
        setVisible(true);
        setSize(600,350);
    }
    void setData(){
        radioButtons[4].setSelected(true);
        if(current==0) {
            label.setText("Pertanyaan  1: Warna apakah sayur sawi ?");
            radioButtons[0].setText("Merah");
            radioButtons[1].setText("Jingga");
            radioButtons[2].setText("Hijau");
            radioButtons[3].setText("Putih");
        }
        if(current==1){
            label.setText("Pertanyaan  2: Hewan apakah yang mempunyai belalai ?");
            radioButtons[0].setText("Gajah");
            radioButtons[1].setText("Jerapah");
            radioButtons[2].setText("Singa");
            radioButtons[3].setText("Bekantan");
        }
        if(current==2){
            label.setText("Pertanyaan  3: Dimanakah letak ibukota Indonesia ?");
            radioButtons[0].setText("Semarang");
            radioButtons[1].setText("Jogjakarta");
            radioButtons[2].setText("Jakarta");
            radioButtons[3].setText("Lampung");
        }
        if(current==3){
            label.setText("Pertanyaan  4: Tanjung perak adalah pelabuhan kota apa ?");
            radioButtons[0].setText("Semarang");
            radioButtons[1].setText("Cilacap");
            radioButtons[2].setText("Surabaya");
            radioButtons[3].setText("Batavia");
        }
        if(current==4){
            label.setText("Pertanyaan  5:  ?");
            radioButtons[0].setText("Merah");
            radioButtons[1].setText("Jingga");
            radioButtons[2].setText("Hijau");
            radioButtons[3].setText("Putih");
        }
        if(current==5){
            label.setText("Kuis Sudah Selesai, Silahkan Lihat Hasilmu !");
            radioButtons[0].setVisible(false);
            radioButtons[1].setVisible(false);
            radioButtons[2].setVisible(false);
            radioButtons[3].setVisible(false);
        }

        label.setBounds(30,40,450,20);
        for (int i=0,j=0; i<=90; i+=30,j++){
            radioButtons[j].setBounds(50,80+i,200,20);
        }
        btnPrevious.setEnabled(current > 0);
        btnNext.setEnabled(current < 5);
    }
    boolean checkAns(){
        if (current==0) {
            return (radioButtons[2].isSelected());
        }
        if (current==1) {
            return (radioButtons[0].isSelected());
        }
        if (current==2) {
            return (radioButtons[2].isSelected());
        }
        if (current==3) {
            return (radioButtons[2].isSelected());
        }
        if (current==4) {
            return (radioButtons[1].isSelected());
        }


        return false;
    }
    public static void main(String[] args) {
        new QuizApp ("kuis gampang dan menyenangkan");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnNext) {
            if (checkAns())
                count = count + 1;
            current++;
            setData();
            if (current == 5) {
                btnNext.setEnabled(false);
                btnPrevious.setEnabled(false);
                btnResult.setVisible(true);
                btnResult.setText("Hasil");
            }
        }
        if (e.getSource() == btnPrevious) {
            current--;
            setData();
        }
        if (e.getActionCommand().equals("Hasil")){
            if (checkAns())
                count=count+1;
            current++;
            JOptionPane.showMessageDialog(this,"Jawabanmu yang tepat adalah "+count+" soal");
            System.exit(0);

        }
    }
}

