package org.developerworld.commons.filereader;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.developerworld.commons.filereader.doc.DocFileReader;
import org.developerworld.commons.filereader.docx.DocxFileReader;
import org.developerworld.commons.filereader.htm.HtmFileReader;
import org.developerworld.commons.filereader.html.HtmlFileReader;
import org.developerworld.commons.filereader.pdf.PdfFileReader;
import org.developerworld.commons.filereader.ppt.PptFileReader;
import org.developerworld.commons.filereader.pptx.PptxFileReader;
import org.developerworld.commons.filereader.rtf.RtfFileReader;
import org.developerworld.commons.filereader.shtml.ShtmlFileReader;
import org.developerworld.commons.filereader.txt.TxtFileReader;
import org.developerworld.commons.filereader.xls.XlsFileReader;
import org.developerworld.commons.filereader.xlsx.XlsxFileReader;

/**
 * 文件读取器工厂
 * 
 * @author Roy Huang
 * @version 20130417
 * 
 */
public class FileReaderFactory {

	private final static Log log = LogFactory.getLog(FileReaderFactory.class);

	private final static Map<String, FileReader> fileReaders = new HashMap<String, FileReader>();
	private final static FileReader DEFAULT_FILE_READER = new TxtFileReader();

	static {
		fileReaders.put("txt", DEFAULT_FILE_READER);
		fileReaders.put("rtf", new RtfFileReader());
		fileReaders.put("doc", new DocFileReader());
		fileReaders.put("docx", new DocxFileReader());
		fileReaders.put("htm", new HtmFileReader());
		fileReaders.put("html", new HtmlFileReader());
		fileReaders.put("shtml", new ShtmlFileReader());
		fileReaders.put("pdf", new PdfFileReader());
		fileReaders.put("ppt", new PptFileReader());
		fileReaders.put("pptx", new PptxFileReader());
		fileReaders.put("xls", new XlsFileReader());
		fileReaders.put("xlsx", new XlsxFileReader());
	}

	public static FileReader getSpecializedFileReader(File file) {
		String ext = FilenameUtils.getExtension(file.getName()).toLowerCase();
		if (fileReaders.containsKey(ext))
			return fileReaders.get(ext);
		else
			return null;
	}

	public static FileReader getFileReader(File file) {
		String ext = FilenameUtils.getExtension(file.getName()).toLowerCase();
		if (fileReaders.containsKey(ext))
			return fileReaders.get(ext);
		else {
			log.debug("FileReaderFactory unknow file ext:" + ext
					+ ",use default FileReader:"
					+ DEFAULT_FILE_READER.getClass());
			return DEFAULT_FILE_READER;
		}
	}

}
