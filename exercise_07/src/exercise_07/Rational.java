package exercise_07;

import java.util.*;

public class Rational extends Number implements Comparable{
	
	private long numerator;
	private long denominator;

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the first rational number:");
		long a=sc.nextLong();
		long b=sc.nextLong();
		System.out.println("Enter the second rational number:");
		long c=sc.nextLong();
		long d=sc.nextLong();
		Rational rational1 = new Rational(a, b);
		Rational rational2 = new Rational(c, d);
		System.out.println(rational1+" + "+rational2+" = "+rational1.add(rational2));
		System.out.println(rational1+" - "+rational2+" = "+rational1.subtract(rational2));
		System.out.println(rational1+" * "+rational2+" = "+rational1.multiple(rational2));
		System.out.println(rational1+" / "+rational2+" = "+rational1.divide(rational2));
		System.out.println(rational2+" is "+(double)c/d);
	}

	public Rational() {
		this(0,1);
	}
	
	public Rational(long numerator, long denominator) {
        // TODO Auto-generated constructor stub
        long gcd=gcd(numerator,denominator);
        this.numerator=((denominator>0)?1:-1)*numerator/gcd;
        this.denominator=Math.abs(denominator)/gcd;
    }

    private static long gcd(long n, long d) {
        // TODO Auto-generated method stub
        long n1=Math.abs(n);
        long n2=Math.abs(d);
        int gcd=1;
        
        for(int k=1;k<=n1&&k<=n2;k++){
            if(n1%k==0&&n2%k==0)
                gcd=k;
        }
        return gcd;
    }
    
    public long getNumerator(){
        return numerator;
    }
    public long getDenominator(){
        return denominator;
    }
    
    public Rational add(Rational secondRational){
        long n=numerator*secondRational.getDenominator()+
                denominator*secondRational.getNumerator();
        long d=denominator*secondRational.getDenominator();
        return new Rational(n,d);
    }
    
    public Rational subtract(Rational secondRational){
        long n=numerator*secondRational.getDenominator()-
                denominator*secondRational.getNumerator();
        long d=denominator*secondRational.getDenominator();
        return new Rational(n,d);
    }
    
    public Rational multiple(Rational sR){
        long n=numerator*sR.getNumerator();
        long d=denominator*sR.getDenominator();
        return new Rational(n,d);
    }
    
    public Rational divide(Rational sR){
        long n=numerator*sR.denominator;
        long d=denominator*sR.numerator;
        return new Rational(n,d);
    }
    
    public String toString(){
        if(denominator==1)
            return numerator+"";
        else
            return numerator+"/"+denominator;
    }
    
    public boolean equals(Object parm1){
        if((this.subtract((Rational)(parm1))).getNumerator()==0)
            return true;
        else 
            return false;
    }

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if((this.subtract((Rational)o)).getNumerator()>0)
            return 1;
		else if((this.subtract((Rational)o)).getNumerator()<0)
			return -1;
		else
			return 0;

	}

	@Override
	public double doubleValue() {
		// TODO Auto-generated method stub
		return numerator*1.0/denominator;
	}

	@Override
	public float floatValue() {
		// TODO Auto-generated method stub
		return (float)doubleValue();
	}

	@Override
	public int intValue() {
		// TODO Auto-generated method stub
		return (int)doubleValue();
	}

	@Override
	public long longValue() {
		// TODO Auto-generated method stub
		return (long)doubleValue();
	}

}
