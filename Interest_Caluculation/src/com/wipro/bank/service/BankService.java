package com.wipro.bank.service;
import com.wipro.bank.acc.RDAccount;
import com.wipro.bank.exception.BankValidationException;

public class BankService {
	
	public boolean validateData(float principal, int tenure,int age, String gender)
	{
		try
		{
			if(principal<500)
				throw new BankValidationException("principal is less tahn 500");
			if(!(tenure==5||tenure==10))
				throw new BankValidationException("tenure should be 5 or 10");
			if(!(gender.equalsIgnoreCase("Male")||gender.equalsIgnoreCase("Female")))
				throw new BankValidationException("Gender should be male or female");
			if(age<1||age>100)
				throw new BankValidationException("Age should in between 1 to 100");
		}catch(BankValidationException ve)
		{
			return false;
		}
		return true;
	}
	
	public void calculate(float principal,int tenure, int age, String gender)
	{
		boolean val=validateData(principal,tenure,age,gender);
		System.out.println(val);
		System.out.println(principal);
		System.out.println(tenure);
		System.out.println(age);
		System.out.println(gender);
		
		if(val)
		{
			RDAccount rda=new RDAccount(tenure,principal);
			rda.setInterest(age,gender);
			float maturityInterest=rda.calculateInterest();
			float totalPrincipalDeposited=rda.calculateAmountDeposited();
			System.out.println(maturityInterest);
			System.out.println(totalPrincipalDeposited);
			
			
		}
	}

}
