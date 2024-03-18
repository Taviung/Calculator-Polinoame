package org.example.GUI;

import org.example.Business_Logic.*;
import org.example.Data_Models.Polynomial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

public class Screen extends JFrame {
    private int width=300;
    private JTextField number3;
    private JButton add;
    private JButton sub;
    private JButton mul;
    private JButton div;
    private JButton integrate;
    private JButton derivate;
    private JButton clear;
    private JTextField number1;
    private JTextField number2;
    public Screen(){

        //create the objects
        this.clear=new JButton("cl");
        this.add=new JButton("+");
        this.sub=new JButton("-");
        this.mul=new JButton("*");
        this.div=new JButton("/");
        this.integrate=new JButton("∫");
        this.derivate=new JButton("'");
        this.number1=new JTextField(1);
        this.number2=new JTextField(1);
        this.number3=new JTextField(1);

        //elements parameters
        number3.setEditable(false);

        //element size
        number1.setBounds(0,0,width,50);
        number2.setBounds(0,50,width,50);
        number3.setBounds(0,100,300,50);
        add.setBounds(width/2-100,150,50,50);
        sub.setBounds(width/2-50,150,50,50);
        mul.setBounds(width/2,150,50,50);
        div.setBounds(width/2-100,200,50,50);
        integrate.setBounds(width/2-50,200,50,50);
        derivate.setBounds(width/2,200,50,50);
        clear.setBounds(width/2,250,50,50);
        //add elements to screen
        add(add);
        add(sub);
        add(mul);
        add(div);
        add(integrate);
        add(derivate);
        add(clear);
        add(number1);
        add(number2);
        add(number3);

        //screen parameters
        setSize(width,400);
        setLayout(null);
        setVisible(true);
        setactionPerformed();
    }

    public void setactionPerformed()
    {
        ActionListener buttons = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Object button = e.getSource();
                String str1=number1.getText();
                String str2=number2.getText();
                Polynomial p1=Parsing.parsing(str1);
                Polynomial p2=Parsing.parsing(str2);
                Polynomial p3=new Polynomial();
                if(p1==null || p2 == null)
                {
                    number3.setText("Polinom invalid");
                }
                if(button == add)
                {
                    p3.setMap(Sum.SumOfMaps(p1.getMap(),p2.getMap()));
                    number3.setText(p3.printer());
                }
                else if(button == sub)
                {
                    p3.setMap(Sub.SubOfMaps(p1.getMap(),p2.getMap()));
                    number3.setText(p3.printer());
                }
                else if(button == mul)
                {
                    p3.setMap(Mul.MulOfMaps(p1.getMap(),p2.getMap()));
                    number3.setText(p3.printer());
                }
                else if(button == div)
                {
                    ArrayList<Map<Integer,Double>> arr= new ArrayList<>();
                    arr = Div.DivOfMaps(p1.getMap(),p2.getMap());
                    Polynomial p4 = new Polynomial();
                    p3.setMap(arr.get(0));
                    p4.setMap(arr.get(1));
                    number3.setText(p3.printer() + " , " +p4.printer());
                }
                else if(button == integrate)
                {
                    p3.setMap(Integrate.IntegrateOfMaps(p1.getMap()));
                    number3.setText(p3.printer());
                }
                else if(button == derivate)
                {
                    p3.setMap(Derivates.DerivateOfMaps(p1.getMap()));
                    number3.setText(p3.printer());
                }
                else
                {
                    number1.setText("");
                    number2.setText("");
                    number3.setText("");
                }
            }
        };
        add.addActionListener(buttons);
        sub.addActionListener(buttons);
        mul.addActionListener(buttons);
        div.addActionListener(buttons);
        derivate.addActionListener(buttons);
        integrate.addActionListener(buttons);
        clear.addActionListener(buttons);
    }
}