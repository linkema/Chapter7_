package Chapter7_1;

import java.io.IOException;

public class AServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        double r1=Double.parseDouble(request.getParameter("r1"));
        double i1=Double.parseDouble(request.getParameter("i1"));
        String option=request.getParameter("option");
        double r2=Double.parseDouble(request.getParameter("r2"));
        double i2=Double.parseDouble(request.getParameter("i2"));
        Jisuanfushu c=new Jisuanfushu(r1,i1);
        Jisuanfushu d=new Jisuanfushu(r2,i2);
        String result="";
        if(option.equals("+")){
            result=c.add(d).formart();
        }else if(option.equals("-")){
            result=c.sub(d).formart();
        }else if(option.equals("*")){
            result=c.mul(d).formart();
        }else {
            result=c.div(d).formart();
        }
        request.setAttribute("output",result);
        request.getRequestDispatcher("/Chapter7_1/output2.jsp").forward(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
