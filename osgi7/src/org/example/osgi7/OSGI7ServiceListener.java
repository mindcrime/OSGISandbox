package org.example.osgi7;

import java.util.SortedSet;
import java.util.TreeSet;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.service.log.LogService;

public class OSGI7ServiceListener implements ServiceListener 
{

	BundleContext context;
	SortedSet<ServiceReference> logServiceRefs = new TreeSet<ServiceReference>();

	public OSGI7ServiceListener( BundleContext context )
	{
		this.context = context;
	}
	
	@Override
	public synchronized void serviceChanged( ServiceEvent event ) 
	{
		switch( event.getType() )
		{
			case ServiceEvent.REGISTERED:
				logServiceRefs.add( event.getServiceReference() );
				break;
				
			case ServiceEvent.MODIFIED:
				// NOP for now
				break;
				
			case ServiceEvent.UNREGISTERING:
				logServiceRefs.remove( event.getServiceReference() );
				break;
				
			default:
				break;
		
		}
	}
	
	
	public synchronized LogService getLogService()
	{
		if( logServiceRefs.size() > 0 )
		{
			return (LogService)context.getService( logServiceRefs.last() );
		}
		else
		{
			return null;
		}
	}
}