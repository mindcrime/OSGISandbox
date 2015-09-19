package org.example.osgi5;

import org.example.osgi5a.IHello;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class SayHelloServiceClient implements BundleActivator 
{

	StoppableThread ourThread;
	
	@Override
	public void start( BundleContext context ) throws Exception 
	{
		// locate our service and use it to say hello...
		ServiceReference reference = context.getServiceReference(IHello.class);
		
		IHello hello = (IHello)context.getService( reference );
		
		StoppableHello stoppableHello = new StoppableHelloImpl( hello );
		ourThread = new StoppableThread( stoppableHello );
		
		ourThread.start();
		
	}

	
	@Override
	public void stop(BundleContext arg0) throws Exception 
	{	
		ourThread.destroy();
	}
	
}