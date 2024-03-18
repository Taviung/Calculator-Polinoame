package org.example;

import org.example.Business_Logic.Mul;
import org.example.Business_Logic.Sub;
import org.example.Business_Logic.*;
import org.example.Data_Models.Monomial;
import org.example.Data_Models.Polynomial;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class OperationsTest {
    private Monomial m0;
    private Monomial m01;
    private Monomial m1;
    private Monomial m11;

    private Monomial m2;
    private Monomial m21;
    private Monomial m3;
    private Polynomial p1;
    private Polynomial p2;
    private Polynomial p3;

    @Test
    public void addTest()
    {
        m1= new Monomial(0,4);
        m0= new Monomial(0,2);
        p1=new Polynomial();
        p2=new Polynomial();
        p3=new Polynomial();
        p1.addMonomial(m0);
        p2.addMonomial(m0);
        p3.addMonomial(m1);
        assertEquals(Sum.SumOfMaps(p1.getMap(),p2.getMap()),p3.getMap());
    }

    @Test
    public void subTest()
    {
        m1= new Monomial(0,2);
        m0= new Monomial(0,3);
        m2= new Monomial(0,1);
        p1=new Polynomial();
        p2=new Polynomial();
        p3=new Polynomial();
        p1.addMonomial(m0);
        p2.addMonomial(m1);
        p3.addMonomial(m2);
        assertEquals(Sub.SubOfMaps(p1.getMap(),p2.getMap()),p3.getMap());
    }

    @Test
    public void mulTest()
    {
        m0= new Monomial(0,2);
        m01= new Monomial(0,2);

        m1= new Monomial(1,2);
        m11= new Monomial(1,2);

        m2= new Monomial(2,1);
        m21= new Monomial(2,1);


        p1=new Polynomial();
        p2=new Polynomial();
        p3=new Polynomial();
        p1.addMonomial(m0);
        p2.addMonomial(m01);
        p1.addMonomial(m1);
        p2.addMonomial(m11);
        p1.addMonomial(m2);
        p2.addMonomial(m21);
        p3.setMap(Mul.MulOfMaps(p1.getMap(),p2.getMap()));
        assertEquals("4.0+8.0x+8.0x^2+4.0x^3+x^4", p3.printer());
    }


    @Test
    public void divTest()
    {
        m0= new Monomial(0,2);
        m01= new Monomial(0,2);
        m1= new Monomial(1,2);
        m11= new Monomial(1,2);
        m2= new Monomial(2,1);
        m21= new Monomial(2,1);
        p1=new Polynomial();
        p2=new Polynomial();
        p3=new Polynomial();
        p1.addMonomial(m0);
        p2.addMonomial(m01);
        p1.addMonomial(m1);
        p2.addMonomial(m11);
        p1.addMonomial(m2);
        p2.addMonomial(m21);
        ArrayList<Map<Integer,Double>> arr= new ArrayList<>();
        arr = Div.DivOfMaps(p1.getMap(),p2.getMap());
        Polynomial p4 = new Polynomial();
        p3.setMap(arr.get(0));
        p4.setMap(arr.get(1));
        assertEquals("1.0 , 0",p3.printer() + " , " +p4.printer());
    }

    @Test
    public void derivatesTest()
    {
        m0= new Monomial(0,2);
        m1= new Monomial(1,2);
        m2= new Monomial(2,1);
        p1=new Polynomial();
        p3=new Polynomial();
        p1.addMonomial(m0);
        p1.addMonomial(m1);
        p1.addMonomial(m2);
        p3.setMap(Derivates.DerivateOfMaps(p1.getMap()));
        assertEquals("2.0+2.0x",p3.printer());
    }

    @Test
    public void IntegrateTest()
    {
        m0= new Monomial(0,2);
        m1= new Monomial(1,2);
        m2= new Monomial(2,1);
        p1=new Polynomial();
        p3=new Polynomial();
        p1.addMonomial(m0);
        p1.addMonomial(m1);
        p1.addMonomial(m2);
        p3.setMap(Integrate.IntegrateOfMaps(p1.getMap()));
        assertEquals("2.0x+x^2+0.3333333333333333x^3",p3.printer());
    }
/*

    @Test
    public void addTest_Fail()
    {
        m1= new Monomial(0,3);
        m0= new Monomial(0,2);
        p1=new Polynomial();
        p2=new Polynomial();
        p3=new Polynomial();
        p1.addMonomial(m0);
        p2.addMonomial(m0);
        p3.addMonomial(m1);
        assertEquals(Sum.SumOfMaps(p1.getMap(),p2.getMap()),p3.getMap());
    }

    @Test
    public void subTest_Fail()
    {
        m1= new Monomial(0,3);
        m0= new Monomial(0,2);
        p1=new Polynomial();
        p2=new Polynomial();
        p3=new Polynomial();
        p1.addMonomial(m0);
        p2.addMonomial(m0);
        p3.addMonomial(m1);
        assertEquals(Sum.SumOfMaps(p1.getMap(),p2.getMap()),p3.getMap());
    }

    @Test
    public void mulTest_Fail()
    {
        m0= new Monomial(0,2);
        m01= new Monomial(0,2);

        m1= new Monomial(1,2);
        m11= new Monomial(1,2);

        m2= new Monomial(2,1);
        m21= new Monomial(2,1);


        p1=new Polynomial();
        p2=new Polynomial();
        p3=new Polynomial();
        p1.addMonomial(m0);
        p2.addMonomial(m01);
        p1.addMonomial(m1);
        p2.addMonomial(m11);
        p1.addMonomial(m2);
        p2.addMonomial(m21);
        p3.setMap(Mul.MulOfMaps(p1.getMap(),p2.getMap()));
        assertEquals("5.0+8.0x+8.0x^2+4.0x^3+x^4", p3.printer());
    }

    @Test
    public void divTest_Fail()
    {
        m0= new Monomial(0,2);
        m01= new Monomial(0,2);
        m1= new Monomial(1,2);
        m11= new Monomial(1,2);
        m2= new Monomial(2,1);
        m21= new Monomial(2,1);
        p1=new Polynomial();
        p2=new Polynomial();
        p3=new Polynomial();
        p1.addMonomial(m0);
        p2.addMonomial(m01);
        p1.addMonomial(m1);
        p2.addMonomial(m11);
        p1.addMonomial(m2);
        p2.addMonomial(m21);
        ArrayList<Map<Integer,Double>> arr= new ArrayList<>();
        arr = Div.DivOfMaps(p1.getMap(),p2.getMap());
        Polynomial p4 = new Polynomial();
        p3.setMap(arr.get(0));
        p4.setMap(arr.get(1));
        assertEquals("2.0 , 0",p3.printer() + " , " +p4.printer());
    }

    @Test
    public void derivatesTest_Fail()
    {
        m0= new Monomial(0,2);
        m1= new Monomial(1,2);
        m2= new Monomial(2,1);
        p1=new Polynomial();
        p3=new Polynomial();
        p1.addMonomial(m0);
        p1.addMonomial(m1);
        p1.addMonomial(m2);
        p3.setMap(Derivates.DerivateOfMaps(p1.getMap()));
        assertEquals("1.0+2.0x",p3.printer());
    }

    @Test
    public void IntegrateTest_Fail()
    {
        m0= new Monomial(0,2);
        m1= new Monomial(1,2);
        m2= new Monomial(2,1);
        p1=new Polynomial();
        p3=new Polynomial();
        p1.addMonomial(m0);
        p1.addMonomial(m1);
        p1.addMonomial(m2);
        p3.setMap(Integrate.IntegrateOfMaps(p1.getMap()));
        assertEquals("3.0x+x^2+0.3333333333333333x^3",p3.printer());
    }
*/
}
