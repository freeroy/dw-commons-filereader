package org.developerworld.commons.filereader.pptx;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.xslf.extractor.XSLFPowerPointExtractor;
import org.apache.xmlbeans.XmlException;
import org.developerworld.commons.filereader.FileReader;

/**
 * pptx文件内容读取器
 * 
 * @author Roy Huang
 * @version 20121030
 * 
 */
public class PptxFileReader implements FileReader {

	public String readFileToString(File file) throws XmlException,
			OpenXML4JException, IOException {
		String rst = "";
		OPCPackage opcPackage = null;
		XSLFPowerPointExtractor extractor =null;
		try {
			opcPackage = OPCPackage.open(file.getPath(), PackageAccess.READ);
			extractor = new XSLFPowerPointExtractor(
					opcPackage);
			rst = extractor.getText();
		} finally {
			if(extractor!=null)
				extractor.close();
			if (opcPackage != null)
				opcPackage.close();
		}
		return rst;
	}
}
