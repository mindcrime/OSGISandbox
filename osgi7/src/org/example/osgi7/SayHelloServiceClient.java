package org.example.osgi7;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.service.log.LogService;

public class SayHelloServiceClient implements BundleActivator 
{

	StoppableThread ourThread;
	
	@Override
	public void start( BundleContext context ) throws Exception 
	{
		OSGI7ServiceListener listener = new OSGI7ServiceListener( context );	
		
		String filter = "(" + Constants.OBJECTCLASS + "=" + LogService.class.getName() + ")";
		
		context.addServiceListener(listener, filter );
		
		
		StoppableHello stoppableHello = new StoppableHelloImpl( listener );
		ourThread = new StoppableThread( stoppableHello );
		
		ourThread.start();
		
	}

	
	@Override
	public void stop(BundleContext arg0) throws Exception 
	{	
		ourThread.destroy();
	}
	
}