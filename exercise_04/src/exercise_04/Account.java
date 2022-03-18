package exercise_04;

import java.util.Date;
import java.util.Scanner;

public class Account {

    private int id=0;        

    private double balance=0;     

    private double annualInterestRate=0;     

    private Date dataCreated;

    public Account()
    {
      super();
      this.dataCreated=new Date();
    }
    public Account(int id, double balance)
    {
      super();
      this.id = id;
      this.balance = balance;
      this.dataCreated=new Date();
    }
    public int getId()
    {
      return id;
    }
    public void setId(int id)
    {
      this.id = id;
    }
    public double getBalance()
    {
      return balance;
    }
    public void setBalance(double balance)
     {
      this.balance = balance;
     }
    public double getAnnualInterestRate()
     {
      return annualInterestRate;
     }
    public Date getDataCreated()
     {
      return dataCreated;
     }
    public void setAnnualInterestRate(double annualInterestRate)
     {
      this.annualInterestRate = annualInterestRate;
     } 

 
     public double getMinthlyInterestRate() throws Exception
     {
      if(this.annualInterestRate==0)
      {
       throw new Exception("δ������Ϣ");
      }else {
       return annualInterestRate/12;
      }
     }


     public void withDraw(double MoneyNum) throws Exception
     {
      if(MoneyNum>this.balance)
      {
       throw new Exception("����");
      }else 
      {
       this.balance-=MoneyNum;
      }
     }

     public void deposit(double MoneyNum)
     {
      this.balance+=MoneyNum;
     }

     public static void  main(String[] args) throws Exception
     {
      Account myAccount=new Account(1122, 20000);
      myAccount.setAnnualInterestRate(4.5/100);
      Scanner sc=new Scanner(System.in);
      System.out.println("ѡ����ȡ��a�����Ǵ��루b����");
      String index=sc.next();
      System.out.println("������ȡ�����Ľ�");
      double money=sc.nextDouble();
      switch(index) {
      case "a": myAccount.withDraw(money);break;
      case "b": myAccount.deposit(money);break;
      default:System.out.println("�������");break;
      }

      System.out.println("��"+myAccount.getBalance());
      System.out.println("����Ϣ��"+myAccount.getMinthlyInterestRate());
      System.out.println("�������ڣ�"+myAccount.getDataCreated());
     }

}
