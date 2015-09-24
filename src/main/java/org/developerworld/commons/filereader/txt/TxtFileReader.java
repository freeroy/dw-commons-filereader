package org.developerworld.commons.filereader.txt;

import java.io.File;
import java.io.IOException;

import org.developerworld.commons.io.FileUtils;
import org.developerworld.commons.filereader.FileReader;

/**
 * 简单文件读取器
 * 
 * @author Roy Huang
 * @version 20130417
 * 
 */
public class TxtFileReader implements FileReader {

	/**
	 * 获取文件编码，也可通过重构修改获取文件编码方法
	 * @param file
	 * @return
	 * @throws IOException
	 */
	protected String getFileCharset(File file) throws IOException {
		return FileUtils.getFileCharset(file);
	}

	public String readFileToString(File file) throws IOException {
		String rst = null;
		String charset = getFileCharset(file);
		if (charset != null && charset.trim().length() > 0)
			rst = FileUtils.readFileToString(file, charset);
		else
			rst = FileUtils.readFileToString(file);
		return rst;
	}

}
