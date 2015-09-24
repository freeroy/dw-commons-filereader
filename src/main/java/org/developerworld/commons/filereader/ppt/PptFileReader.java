package org.developerworld.commons.filereader.ppt;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hslf.HSLFSlideShow;
import org.apache.poi.hslf.model.Slide;
import org.apache.poi.hslf.model.TextRun;
import org.apache.poi.hslf.usermodel.SlideShow;
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
		StringBuilder rst = new StringBuilder();
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			SlideShow ss = new SlideShow(new HSLFSlideShow(inputStream));
			Slide[] slides = ss.getSlides();
			if (slides != null) {
				for (int i = 0; i < slides.length; i++) {
					TextRun[] textRuns = slides[i].getTextRuns();
					if (textRuns != null) {
						for (int j = 0; j < textRuns.length; j++)
							rst.append(textRuns[j].getText());
					}
				}
			}
		} finally {
			if (inputStream != null)
				inputStream.close();
		}
		rst.trimToSize();
		return rst.toString();
	}

}
