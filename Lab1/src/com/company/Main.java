package com.company;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
public class Main {
    String GenerateWord(int length,String[] charArray )
    {
        String s=new String();
        while(s.length()<length)
        {
            int index= (int) (Math.random() * charArray.length);
            String c = charArray[index];
            s+=c; //compunem litera cu litera cuvantul
        }
        return s;
    }
    boolean HasCommonLetters(String s1,String s2)
    {
        for(int i=0;i< s1.length() ;i++)//presupnunem ca lungimea e egala
        {
            if(s1.charAt(i)==s2.charAt(i))
                return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException
    {
        Main obj=new Main();
        int n, k, m;
        //read from keyboard stuff
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        k = scan.nextInt();
        m = scan.nextInt();

        String letters[]=new String[m];
        scan.nextLine();//for some reason la citire imi inregistra si un newline
        for(int i=0;i<m;i++)
        {

            letters[i]=scan.nextLine();
        }
        String words[]=new String[n];
        for(int i=0;i<n;i++)
        {
            String s=obj.GenerateWord(k,letters);
            words[i]=s;
            System.out.printf( "%s ",words[i]);
        }
        boolean A[][]=new boolean[n][n];
        //m[x][y]=m[x*width+y]
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
            {
                A[i][j]=obj.HasCommonLetters(words[i],words[j]);
            }
        for(int i=0;i<n;i++)
        {       for(int j=0;j<n;j++)
        {
            System.out.print(A[i][j]);
            System.out.print(" ");

        }
            System.out.println();
        }
    }

}
