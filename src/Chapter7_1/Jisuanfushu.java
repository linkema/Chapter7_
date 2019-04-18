package Chapter7_1;

public class Jisuanfushu {
    public Jisuanfushu(){}
    private double real;//实数部分
    private double ima;//虚数部分
    public Jisuanfushu(double r,double i){this.real=r;this.ima=i;}

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getIma() {
        return ima;
    }

    public void setIma(double ima) {
        this.ima = ima;
    }

    public Jisuanfushu add(Jisuanfushu c){
        return new Jisuanfushu(this.real+c.real,this.ima+c.ima);
    }
    public Jisuanfushu sub(Jisuanfushu c){
        return new Jisuanfushu( this.real-c.real,this.ima-c.ima);
    }
    public Jisuanfushu div(Jisuanfushu c){
        double z=c.real*c.real+c.ima*c.ima;
        double x=(real*c.real-ima*c.ima)/z;
        double y=(ima*c.real-real*c.ima)/z;
        return new Jisuanfushu(x,y);
    }
    public Jisuanfushu mul(Jisuanfushu c){
        double x=real*c.real-ima*c.ima;
        double y=real*c.ima+ima*c.real;
        return new Jisuanfushu(x,y);
    }
    public String formart(){
        if(ima>=0.0) return real+"+"+ima+"*i";
        else return real+"-"+ima+"*i";
    }
}
