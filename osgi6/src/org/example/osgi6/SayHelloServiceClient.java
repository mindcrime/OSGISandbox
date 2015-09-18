package org.example.osgi6;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class SayHelloServiceClient implements BundleActivator 
{

	StoppableThread ourThread;
	
	@Override
	public void start( BundleContext context ) throws Exception 
	{
		
		StoppableHello stoppableHello = new StoppableHelloImpl( context );
		ourThread = new StoppableThread( stoppableHello );
		
		ourThread.start();
		
	}

	
	@Override
	public void stop(BundleContext arg0) throws Exception 
	{	
		ourThread.destroy();
	}
	
}