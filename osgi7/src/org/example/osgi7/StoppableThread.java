package org.example.osgi7;

public class StoppableThread extends Thread 
{
	StoppableHello hello;
	
	
	public StoppableThread( StoppableHello hello )
	{
		super( hello );
		this.hello = hello;
	}
	
	@Override
	public void destroy() 
	{
		hello.stop();
	}
	
}
