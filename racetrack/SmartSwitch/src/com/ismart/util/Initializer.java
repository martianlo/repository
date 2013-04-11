package com.ismart.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class Initializer {

	private final static String SERVICE_FILE = "conf/service.xml";

	public static Map initServer(String section)
	{
	      Map map = new HashMap();

	      try
	      {
	         Document doc = new SAXBuilder().build(SERVICE_FILE);
	         List elements = doc.getRootElement().getChildren(section);

	         for (int i = 0; i < elements.size(); i++)
	         {
	            List params = ((Element) elements.get(i)).getChildren("param");

	            for (int j = 0; j < params.size(); j++)
	            {
	               Element param = ((Element) params.get(j));

	               String name = param.getAttributeValue("name");
	               String value = param.getAttributeValue("value");

	               map.put(name, value);
	            }
	         }
	      }
	      catch (IOException ioe)
	      {
	         ioe.printStackTrace();
	      }
	      catch (JDOMException jde)
	      {
	         jde.printStackTrace();
	      }

	      return map;
	}
}
