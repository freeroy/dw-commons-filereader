package org.developerworld.commons.filereader;

import java.io.File;

import org.junit.Test;

public class FileReaderTest {

	//@Test
	public void test() throws Exception {
		FileReader fileReader=FileReaderFactory.getFileReader(new File("E:\\部门架构调整方案_to_simon.pptx"));
		System.out.println(fileReader.readFileToString(new File("E:\\部门架构调整方案_to_simon.pptx")));
		//部门架构调整方案_to_simon.pptx
	}

}
