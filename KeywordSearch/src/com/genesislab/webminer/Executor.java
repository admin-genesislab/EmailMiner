package com.genesislab.webminer;

public class Executor 
{
	public static void main(String args[])
	{
		CoreBase executeScript = new CoreBase();
		try 
		{
			executeScript.GoogleSearch("selenium", 1);
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}