package com.fih.framework.dataset.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class XmlUtils {
	
	public static Document createXmlDocumentFromString(StringBuffer sb){
		Document doc = null;
		try {
			if(!sb.substring(0, 4).equalsIgnoreCase("<?xml")){
				sb.insert(0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			}
			doc = DocumentHelper.parseText(sb.toString());
		} catch (DocumentException e) {
			e.printStackTrace();
			return doc;
		}
		
		return doc;
	}
	
	public static Element createXmlElementFromString(StringBuffer sb){
		Document doc = null;
		try {
			if(!sb.substring(0, 5).equalsIgnoreCase("<?xml")){
				sb.insert(0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			}
			doc = DocumentHelper.parseText(sb.toString());
		} catch (DocumentException e) {
			e.printStackTrace();
			return null;
		}
		
		return doc.getRootElement();
	}

}
