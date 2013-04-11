package com.ismart.core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcHandlerMapping;
import org.apache.xmlrpc.webserver.XmlRpcServlet;

import com.ismart.util.LoggerFactory;

public class GatewayServlet extends XmlRpcServlet {

	private static Logger log = LoggerFactory.getLogger(GatewayServlet.class);
	private static String handler = "";
	
	public void init() throws ServletException
	{
	      try
	      {
	         super.init();
	         log.info("servlet init");
	      }
	      catch (ServletException se)
	      {
	         throw se;
	      }
	}
	
	public GatewayServlet(String name)
	{
		this.handler = name;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws
	       ServletException, IOException
	{
	   super.doPost(request, response);
	}

	protected XmlRpcHandlerMapping newXmlRpcHandlerMapping() throws
	       XmlRpcException
	{
		PropertyHandlerMapping mapping = new PropertyHandlerMapping();
	        
	    mapping.addHandler(handler, RequestHandler.class);
	      
	    return mapping;
	}
}
