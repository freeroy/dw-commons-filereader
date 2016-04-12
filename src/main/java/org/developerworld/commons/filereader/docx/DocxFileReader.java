package org.developerworld.commons.filereader.docx;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.xmlbeans.XmlException;
import org.developerworld.commons.filereader.FileReader;

/**
 * docx文件内容读取器
 * 
 * @author Roy Huang
 * @version 20130417
 * 
 */
public class DocxFileReader implements FileReader {

	public String readFileToString(File file) throws XmlException, OpenXML4JException, IOException {
		String rst = null;
		OPCPackage opcPackage = null;
		XWPFWordExtractor docx = null;
		try {
			opcPackage = OPCPackage.open(file.getPath(), PackageAccess.READ);
			// 获取执行器
			docx = new XWPFWordExtractor(opcPackage);
			// 获取内容
			rst = docx.getText();
		} finally {
			try {
				if (docx != null)
					docx.close();
			} finally {
				if (opcPackage != null)
					opcPackage.close();
			}
		}
		return rst;
	}

}
