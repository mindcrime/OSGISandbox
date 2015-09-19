package org.example.osgi7a;

import java.util.Dictionary;
import java.util.Hashtable;

import org.example.osgi7a.impl.HelloServiceImpl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class SayHelloServiceActivator implements BundleActivator
{
	
	ServiceRegistration<?> registration;

	@Override
	public void start( BundleContext context ) throws Exception 
	{
		String[] interfaces = new String[] { IHello.class.getName() };
		
		Dictionary<String, String> metadata = new Hashtable<String, String>();
		
		metadata.put( "name", "IHello" );
		
		registration = context.registerService( interfaces, 
												new HelloServiceImpl(), metadata);
		
		System.out.println( "Service registered!" );
		
	}

	@Override
	public void stop(BundleContext arg0) throws Exception 
	{
		registration.unregister();
	}
	
}
