package org.developerworld.commons.filereader.htm;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.developerworld.commons.filereader.txt.TxtFileReader;

/**
 * htm文件读取器
 * @author Roy Huang
 * @version 20130417
 *
 */
public class HtmFileReader extends TxtFileReader {

	public String readFileToString(File file) throws IOException {
		return htmToText(super.readFileToString(file));
	}

	/**
	 * htm转文本
	 * @param htmStr
	 * @return
	 */
	private String htmToText(String htmStr) {
		// 过滤script标签
		htmStr=fixStr(htmStr,"<[//s]*?script[^>]*?>[//s//S]*?<[//s]*?///[//s]*?script[//s]*?>");
		// 过滤style标签
		htmStr=fixStr(htmStr,"<[//s]*?style[^>]*?>[//s//S]*?<[//s]*?///[//s]*?style[//s]*?>");
		// 过滤htm标签
		htmStr=fixStr(htmStr,"<[^>]+>");
		// 过滤htm标签
		htmStr=fixStr(htmStr,"<[^>]+");
		return htmStr.trim();
	}
	
	/**
	 * 修正字符
	 * @param htm
	 * @param regEx
	 * @return
	 */
	private String fixStr(String str,String regEx){
		Pattern p = Pattern
				.compile(regEx, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(str);
		return m.replaceAll("");
	}

}
