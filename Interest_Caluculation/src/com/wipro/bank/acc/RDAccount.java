package com.wipro.bank.acc;

public class RDAccount extends Account {
	
	public RDAccount(int tenure, float principal)
	{
		this.tenure=tenure;
		this.principal=principal;
	}
	
	@Override
	public float calculateAmountDeposited()
	{
		return principal*tenure*12;
	}
	
	@Override
	public float calculateInterest()
	{
		
		float r=rateOfInterest/100;
		int n=4;
		//float t=(tenure*12)/12f;
		float p=0.0f;
		int tn=tenure*12;
		for(int i=0;i<tn;i++)
		{
			principal+=principal*(float)(Math.pow(1+(r/n), n*((tn-i)/12.0))-1);
		}
		
		return p;
	}

}
