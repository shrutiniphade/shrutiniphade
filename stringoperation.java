import java.util.Scanner;
import java.lang.String;
public class stringoperation {
    public static void main(String[] args)
    {
        System.out.println("hello world");
        String s1,s2,s3,s4,s5;


        s1="hello";
        System.out.println("stirng = "+s1);
        char c[]={'a','d','d','e'};
        s2=new String(c);
        System.out.println("stirng = "+s2);
        s3=new String("exmple");
        System.out.println("stirng = "+s3);
        byte b[]={70,72,76,80,90};
        s4=new String(b);
        System.out.println("stirng = "+s4);
        String s6,s7,s8,s9,s10;
        s6="programming";
        s7="java1";

        //s7);
        s9=String.join("",s6,s7);
        System.out.println(s6.substring(3));
        String[] sen= s6.split("\\.");
        System.out.println("string = "+sen);
        System.out.println("stirng = "+s6);
        System.out.println("stirng = "+s7);
        s8=s6.concat(s7); // join two string
        System.out.println("stirng = "+s8);
        System.out.println("stirng1="+s9);
        
        boolean result1=s6.equals(s7);
        System.out.println("stirng s6 and s7 are "+ result1);
        System.out.println("stirng s6 and s7 are "+s6.compareTo(s7));
        boolean result2=s7.equals(s6);
        System.out.println("stirng s7 and s6 are "+result2);
        System.out.println("length of the string = "+s6.length());
        System.out.println("the index of p at s6 =" +s6.indexOf('p'));
        String s11=s6.replace('p','z');
        System.out.println("the modified string ="+s11);
        s10=s11.trim();
        System.out.println(s10);
        System.out.println(s11.toUpperCase());
}
}
