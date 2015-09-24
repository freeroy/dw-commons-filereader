package org.developerworld.commons.filereader;

import java.io.File;

/**
 * 文件内容读取器
 * 
 * @author Roy Huang
 * @version 20121031
 * 
 */
public interface FileReader {

	/**
	 * 读取文件内容
	 * 
	 * @param file
	 * @return
	 * @throws Exception
	 */
	String readFileToString(File file) throws Exception;
}
