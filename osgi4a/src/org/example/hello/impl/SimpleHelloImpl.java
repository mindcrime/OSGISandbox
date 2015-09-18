package org.example.hello.impl;

import org.example.hello.IHello;

public class SimpleHelloImpl implements IHello
{
	boolean stopped = false;
	
	@Override
	public void run() 
	{
		while( !stopped )
		{
			System.out.println( "Hello!" );
			
			try
			{
				Thread.sleep( 10000 );
			}
			catch( InterruptedException e )
			{
				if( stopped == true )
				{
					break;
				}
			}
		}
		
	}
	
	@Override
	public void stop() 
	{
		stopped = true;
	}
}
