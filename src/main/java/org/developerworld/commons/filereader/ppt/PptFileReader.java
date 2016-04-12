package org.developerworld.commons.filereader.ppt;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hslf.extractor.QuickButCruddyTextExtractor;
import org.developerworld.commons.filereader.FileReader;

/**
 * ppt文件内容读取器
 * 
 * @author Roy Huang
 * @version 20121030
 * 
 */
public class PptFileReader implements FileReader {

	public String readFileToString(File file) throws IOException {
		String rst = null;
		InputStream inputStream = null;
		QuickButCruddyTextExtractor extractor = null;
		try {
			inputStream = new FileInputStream(file);
			extractor = new QuickButCruddyTextExtractor(inputStream);
			rst = extractor.getTextAsString();
		} finally {
			try {
				if (extractor != null)
					extractor.close();
			} finally {
				if (inputStream != null)
					inputStream.close();
			}
		}
		return rst;
	}

}
