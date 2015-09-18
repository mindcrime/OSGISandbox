package org.example.osgi7a.impl;

import org.example.osgi7a.IHello;

public class HelloServiceImpl implements IHello 
{
	
	@Override
	public void sayHello() 
	{
		System.out.println( "Hello" );
	}

}
