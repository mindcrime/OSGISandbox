package org.example.osgi.launcher;

import java.util.HashMap;
import java.util.Map;

import org.apache.felix.framework.FrameworkFactory;
import org.apache.felix.main.AutoProcessor;
import org.osgi.framework.launch.Framework;


public class LauncherMain 
{

	private static Framework osgiFramework = null;

	public static void main(String[] args) 
	{
		// launch felix, and install out bundles, and
		// start everything up...

		try 
		{
			FrameworkFactory factory = new FrameworkFactory();
			osgiFramework = factory.newFramework(null);
			osgiFramework.init();
			
			Map configMap = new HashMap();
			
			configMap.put("felix.auto.deploy.action", "install,start");
			
			AutoProcessor.process(configMap, osgiFramework.getBundleContext());
			osgiFramework.start();
		
			System.out.println( "started");
			
			osgiFramework.waitForStop(0);
			System.exit(0);
		} 
		catch (Exception ex) 
		{
			System.err.println("Could not create framework: " + ex);
			ex.printStackTrace();
			System.exit(-1);
		}

	}

}
