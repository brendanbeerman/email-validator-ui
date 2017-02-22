package com.example.myapplication;

public class Validator
{
	private String emailAddress;
	private boolean isValidEmail;
	
	public Validator(String emailAddress)
	{
		this.emailAddress = emailAddress;
		
		isValidEmail = validateDriver();
	}
	
	public String getEmailAddress()
	{
		return emailAddress;
	}
	
	public boolean getIsValidEmail()
	{
		return isValidEmail;
	}
	
	private boolean validateDriver()
	{
		return onlyOneAtSymbol() && atLeastOnePeriod() && shorterThanMaxLength() && onlyLettersNumbersHyphens();
	}
	
	private boolean onlyOneAtSymbol()
	{
    	int atCount = 0;
    	
    	for (int i = 0; i < emailAddress.length(); i++)
    	{
    		if (emailAddress.charAt(i) == '@')
    			atCount++;
    	}
    	
    	if (atCount == 1)
    		return true;
    	else
    		return false;
	}
	
	private boolean atLeastOnePeriod()
	{
		for (int i = 0; i < emailAddress.length(); i++)
		{
			if (emailAddress.charAt(i) == '.')
				return true;
		}
		
		return false;
	}
	
	private boolean shorterThanMaxLength()
	{
		return emailAddress.length() > 2 && emailAddress.length() < 256;
	}
	
	private boolean onlyLettersNumbersHyphens()
	{
		char [] illegalChars = new char[]{' ', '\'', '/', '[', ']', '{', '}', ':', ';', '<', '>', 
										  '?', '!', '#', '$', '%', '^', '&', '*', '(', ')', '|',
										  '_', '+', '=', '~', '`'};
		
		for (int i = 0; i < emailAddress.length(); i++)
		{
			for (int j = 0; j < illegalChars.length; j++)
			{
				if (emailAddress.charAt(i) == illegalChars[j])
					return false;
			}
		}
		
		return true;
	}
}
