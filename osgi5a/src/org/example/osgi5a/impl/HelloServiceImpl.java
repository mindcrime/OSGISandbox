package org.example.osgi5a.impl;

import org.example.osgi5a.IHello;

public class HelloServiceImpl implements IHello 
{
	
	@Override
	public void sayHello() 
	{
		System.out.println( "Hello" );
	}

}
