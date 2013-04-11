package com.ismart.util;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

	

public class LoggerFactory
{
	   private static final String CONF_FILE = "conf/log4j.xml";
	   private static final long TIME = 5000;
	   static Logger logger = Logger.getRootLogger();

	   static
	   {
	      DOMConfigurator.configureAndWatch(CONF_FILE, TIME);
	      //DOMConfigurator.configure("conf/logconfig.xml");
	   }

	   public static Logger getLogger(Class clazz)
	   {
	      return logger.getLogger(clazz);
	   }

	   public static Logger getLogger(String name)
	   {
	      return logger.getLogger(name);
	   }
}


