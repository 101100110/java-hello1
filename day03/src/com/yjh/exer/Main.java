package com.yjh.exer;

import java.util.Scanner;
/**
 * @author yjh 1600063206@qq.com
 * @version 2022/12/12 9:46
 * @since JDK8
 */

public class Main {

    final static int M=(int) (1e6+6);
    final static int mod=(int) (1e9+7);
    static long fac[] = new long[M];
    static long facinv[] = new long[M];
    public static long ksm(long x,long y) {
        long t=1;
        while(y!=0) {
            if((y&1)==1)
                t=(t*x)%mod;
            x=(x*x)%mod;
            y>>=1;
        }
        return t;
    }
    public static long inv(long x) {
        return ksm(x,mod-2);
    }
    public static void init() {
        fac[0]=1;
        for(int i=1;i<M;i++)
            fac[i]=(long)fac[i-1]*i%mod;
        facinv[M-1]=ksm(fac[M-1],mod-2);
        for(int i=M-2;i>=0;i--) {
            facinv[i]=facinv[i+1]*(i+1)%mod;
        }
    }
    public static long C(long x,long y) {
        if(y>x||x<0||y<0)
            return 0;
        if(y==0||x==0)
            return 1;
        return fac[(int) x]*facinv[(int) (x-y)]%mod*facinv[(int) y]%mod;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        init();
        for(int T=sc.nextInt();T>0;T--) {
            long n=sc.nextLong();
            long m=sc.nextLong();
            long k=sc.nextLong();
            long ans=0;
            for(int i=0,dis=1;i<k;i++,dis=-dis) {
                ans=(ans+dis*C(k,k-i)*(k-i)%mod*ksm(k-i-1,n-1)%mod+mod)%mod;
            }
            for(int i=0;i<k;i++)
                ans=ans*(m-i)%mod*inv(k-i)%mod;
            System.out.printf("%d",ans);
            System.out.println();
        }
    }
}