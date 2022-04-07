package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;

public class Main implements ActionListener {
    JFrame f=new JFrame("cryptage");
    JPanel p=new JPanel();
    JButton b=new JButton("crypt");
    JButton b1=new JButton("decrypt");
    JLabel l1=new JLabel("mot");
    JLabel l2=new JLabel("resultat");
    JTextField t1=new JTextField(10);
    JTextField t2=new JTextField(10);
    String result;
    String z;
    char x;
    int i,y;
    String[] t=new String[10];
    public Main(){
        f.pack();
        f.add(p);
        f.setVisible(true);
        f.setSize(300, 300);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        p.setLayout(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=0;
        p.add(l1,gbc);
        gbc.gridx=0;
        gbc.gridy=1;
        p.add(t1,gbc);
        gbc.gridx=1;
        gbc.gridy=0;
        p.add(b,gbc);
        gbc.gridx=1;
        gbc.gridy=1;
        p.add(b1,gbc);
        gbc.gridx=2;
        gbc.gridy=0;
        p.add(l2,gbc);
        gbc.gridx=2;
        gbc.gridy=1;
        p.add(t2,gbc);
        b.addActionListener(this);
        b1.addActionListener(this);
    }

    public int convertBinaryToDecimal(String ch) {
        int decimalNumber = 0, i = 0;
        long remainder;
        long num= Long.parseLong(String.valueOf(ch));
        while (num != 0) {
            remainder = num % 10;
            num /= 10;
            decimalNumber += remainder * Math.pow(2, i);
            ++i;
        }
        return decimalNumber;
    }
    public static void main(String[] args) {
	new Main();
    }


    public static String inverse(String ch){
        int i;
        String ch1 = "";
        for (i = 0; i < ch.length(); i++)
            ch1 =ch1+ ch.charAt(ch.length() - i - 1);
        return ch1;
    };
    public String crypt(String ch){
        result ="";
        i=0;
        char[] tab= ch.toCharArray();
        String alphabet="<>,;:!ù*^$=)àç_è-('é&1234567890°+}@]/.azertyuiopqsdfghjklmwxcvbnAZERTYUIOPQSDFGHJKLMWXCVBN";
        for (char c:tab){
            int a= alphabet.indexOf(c);
            z=Integer.toBinaryString(a);
            t[i]=inverse(z);
            y = convertBinaryToDecimal(t[i]);
            System.out.println(y);
            y = y % (alphabet.length()-1);
            x = alphabet.charAt(y);
            result+=x;
            i++;
        }
        return result;
    }





    public String decrypt(String ch){
            result ="";
            char[] tab= ch.toCharArray();
            String alphabet="azertyuiopqsdfghjklmwxcvbn AZERTYUIOPQSDFGHJKLMWXCVBN<>,;:!ù*^$=)àç_è-('é&1234567890°+}@]/.";
            for (char c:tab){
                int a= alphabet.indexOf(c);
                x = alphabet.charAt(a);
                result+=x;
            }
            return result;
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b) {
           t2.setText(crypt(t1.getText())) ;
        }
        if(e.getSource()==b1) {
            t2.setText(decrypt(t1.getText())) ;
        }
    }

}
