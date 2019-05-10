package com;

public class Factors
{
	public static void main(String[] args)
	{
		String input = args[0];
		  int n=Integer.parseInt(input);
		  for (int k=1;k<=n;k++)
		    if (n%k==0)
		        System.out.print(k+"   ");
		  System.out.println("");     
	}
}