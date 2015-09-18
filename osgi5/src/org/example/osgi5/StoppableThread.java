package org.example.osgi5;

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
