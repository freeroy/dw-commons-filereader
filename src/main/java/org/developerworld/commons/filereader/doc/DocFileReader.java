package org.developerworld.commons.filereader.doc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hwpf.extractor.WordExtractor;
import org.developerworld.commons.filereader.FileReader;

/**
 * doc文件内容阅读器
 * 
 * @author Roy Huang
 * @version 20130417
 * 
 */
public class DocFileReader implements FileReader {

	public String readFileToString(File file) throws IOException {
		String rst = null;
		InputStream inputStream = null;
		WordExtractor extractor=null;
		try {
			// 获取输入流
			inputStream = new FileInputStream(file);
			// 获取执行器
			extractor = new WordExtractor(inputStream);
			// 获取内容
			rst = extractor.getText();
		} finally {
			if(extractor!=null)
				extractor.close();
			if (inputStream != null)
				inputStream.close();
		}
		return rst;
	}

}
