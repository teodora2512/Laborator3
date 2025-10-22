package exercitiul1;

import java.util.Arrays;

public class Parabola {
    private int a;
    private int b;
    private int c;

    public Parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }


    @Override
    public String toString() {
        String bStr=(b>=0 ? "+" : "")+b+"x";
        String cStr=(c>=0 ? "+" : "")+c;

        float[] v=this.varfParabola();
        String V= Arrays.toString(v);

        return "f(x)= "+a+"x^2"+ bStr+cStr +" V= "+V;
    }

    public float[] varfParabola()
    {
        float vx=(float)(-b)/(2*a);
        float vy = (float)(4 * a * c - b * b) / (4 * a);

        return new float[] {vx,vy};
    }
    public float[] mijlocIntreVarfuri(Parabola p){
       float[] v1=this.varfParabola();
       float[] v2=p.varfParabola();
       float xm=(v1[0]+v2[0])/2;
       float ym=(v1[1]+v2[1])/2;
       return new float[]{xm,ym};
    }
    public static float[] mijlocIntreVarfuri(Parabola p1,Parabola p2)
    {
        float[] v1= p1.varfParabola();
        float[] v2= p2.varfParabola();
        float xm=(v1[0]+v2[0])/2;
        float ym=(v1[1]+v2[1])/2;
        return new float[] {xm,ym};
    }
    public double lungimeIntreVarfuri(Parabola p)
    {
        float[] v1=this.varfParabola();
        float[] v2=p.varfParabola();
        return Math.hypot(v2[0]-v1[0],v2[1]-v1[1]);
     }
    public static double lungimeIntreVarfuri(Parabola p1, Parabola p2)
    {
        float[] v1=p1.varfParabola();
        float[] v2=p2.varfParabola();
        return Math.hypot(v2[0]-v1[0],v2[1]-v1[1]);
    }


}
