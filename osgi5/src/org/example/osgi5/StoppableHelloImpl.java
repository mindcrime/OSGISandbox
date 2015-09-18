package org.example.osgi5;

import org.example.osgi5a.IHello;

public class StoppableHelloImpl implements StoppableHello
{

	boolean stopped = false;
	IHello hello;
	
	public StoppableHelloImpl( IHello hello )
	{
			this.hello = hello;
	}
	
	@Override
	public void run() 
	{
		while( !stopped )
		{
			hello.sayHello();
			
			
			try
			{
				Thread.sleep( 10000 );
			}
			catch( InterruptedException ie )
			{
				if( stopped )
				{
					break;
				}
			}
			
			
		}
	}

	@Override
	public void stop() 
	{
		this.stopped = true;
	}

}
