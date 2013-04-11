package com.ismart.core;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.xmlrpc.webserver.ServletWebServer;
import org.apache.xmlrpc.webserver.XmlRpcServlet;

import com.ismart.util.LoggerFactory;
import com.ismart.util.Initializer;

public class ISmartGWConnection {
	private static String address="";
	static Logger log = LoggerFactory.getLogger(ISmartGWConnection.class);

	   public static void main(String args[])
	   {
	      try
	      {
	         Map map = Initializer.initServer("gateway"); 
	         String name = map.get("Name").toString();
	         String host = map.get("Host").toString();
	         String port = map.get("Port").toString();
	         String paranoid = map.get("Paranoid").toString();
	         String allow = map.get("Allow").toString();
	         address = map.get("Address").toString();
	         
	         log.info("------------------------------------------");
	         log.info("          GATEWAY CONFIGURATION           ");
	         log.info("------------------------------------------");
	         log.info(" Server Name : " + name);
	         log.info(" Listen Host : " + host);
	         log.info(" Listen Port : " + port);
	         log.info(" Paranoid    : " + paranoid);
	         log.info(" Accept Host : " + allow);
	         log.info("==========================================");
	         log.info("");

	         ClassLoader loader = Thread.currentThread().getContextClassLoader();
	         XmlRpcServlet servlet = new GatewayServlet(name);
	         ServletWebServer webServer = new ServletWebServer(servlet,
	             Integer.parseInt(port));
	         webServer.setParanoid(Boolean.getBoolean(paranoid));
	         webServer.start();
	      }
	      catch (Exception e)
	      {
	         log.fatal("Exception at Gateway", e);
	      }
	   }
	   
	   public static String getAddress(){
		   return address;
	   }
}
