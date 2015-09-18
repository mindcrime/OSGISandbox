package org.example.osgi6;

import org.example.osgi6a.IHello;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class StoppableHelloImpl implements StoppableHello
{

	boolean stopped = false;
	BundleContext context;
	
	public StoppableHelloImpl( BundleContext context )
	{
		this.context = context;
	}
	
	@Override
	public void run() 
	{
		while( !stopped )
		{
			
			// locate our service and use it to say hello...
			ServiceReference<IHello> reference = context.getServiceReference(IHello.class);
			
			IHello hello = context.getService( reference );			
			
			
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
