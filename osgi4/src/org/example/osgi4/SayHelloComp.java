package org.example.osgi4;

import org.example.hello.IHello;
import org.example.hello.impl.SimpleHelloImpl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class SayHelloComp implements BundleActivator
{
	Thread ourThread = null;
	
	@Override
	public void start( BundleContext context ) throws Exception 
	{
		// start saying hello...
		final IHello hello = new SimpleHelloImpl();
		ourThread = new Thread( hello ) 
		{
			
			public void destroy() 
			{
				hello.stop();
			}
		};
		
		ourThread.start();
	}
	
	@Override
	public void stop( BundleContext context ) throws Exception 
	{
		ourThread.destroy();
	}
}