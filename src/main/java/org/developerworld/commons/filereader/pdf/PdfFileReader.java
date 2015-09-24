package org.developerworld.commons.filereader.pdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.developerworld.commons.filereader.FileReader;

/**
 * PDF文件内容读取器
 * 
 * @author Roy Huang
 * @version 20130417
 * 
 */
public class PdfFileReader implements FileReader {

	public String readFileToString(File file) throws IOException {
		String rst = null;
		PDDocument document = null;
		InputStream inputStream = null;
		try {
			// 获取输入流
			inputStream = new FileInputStream(file);
			// 加载 pdf 文档
			PDFParser parser = new PDFParser(inputStream);
			// 分析文档
			parser.parse();
			// 获取文档对象
			document = parser.getPDDocument();
			// 获取内容信息
			PDFTextStripper pts = new PDFTextStripper();
			// 获取文档中的内容
			rst = pts.getText(document);
		} finally {
			if (document != null)
				try {
					document.close();
				} finally {
					if (inputStream != null)
						inputStream.close();
				}
		}
		return rst;
	}

}
