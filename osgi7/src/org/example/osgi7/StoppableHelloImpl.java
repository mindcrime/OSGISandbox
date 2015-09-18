package org.example.osgi7;

import org.osgi.service.log.LogService;

public class StoppableHelloImpl implements StoppableHello
{

	boolean stopped = false;
	OSGI7ServiceListener logListener;
	
	public StoppableHelloImpl( OSGI7ServiceListener listener )
	{
		this.logListener = listener;
	}
	
	@Override
	public void run() 
	{
		while( !stopped )
		{
			
			// locate our service and use it to say hello...			
			// IHello hello = null; // ???? // context.getService( reference );			
			// hello.sayHello();
			
			
			LogService logger = logListener.getLogService();
			
			if( logger != null )
			{
				logger.log(LogService.LOG_ERROR, "Hello, OSGI7 World!\n" );
			}
			else
			{
				System.out.println( "SOP: " + "Hello, OSGI7 World!\n" );
			}
			
			try
			{
				Thread.sleep( 7000 );
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
