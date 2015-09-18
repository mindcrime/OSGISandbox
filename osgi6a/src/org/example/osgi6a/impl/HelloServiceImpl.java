package org.example.osgi6a.impl;

import org.example.osgi6a.IHello;

public class HelloServiceImpl implements IHello 
{
	
	@Override
	public void sayHello() 
	{
		System.out.println( "Hello" );
	}

}
