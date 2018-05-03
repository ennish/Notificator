package com.enn.FileMessager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Calendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MessageWriter {

	private Log log = LogFactory.getLog(this.getClass());

	public static void main(String[] args) {
		MessageWriter writer = new MessageWriter();
		Calendar cal = Calendar.getInstance();
		writer.writeNewFile(cal.getTime() + "hello");
	}

	public String writeNewFile(String message) {
		File file = new File("message" + System.currentTimeMillis() % 1000000);
		if (!file.exists())
			try {
				file.createNewFile();
			} catch (IOException e) {
				log.error("file"+file.getName()+" create fail!");
			}
		appendInFile(file, message);
		return file.getName();
	}

	public int appendInFile(File file, String message) {
		if (!file.exists()) {
			log.warn("file doesn't exist");
			return -1;
		}

		Writer writer = null;
		try {
			writer = new FileWriter(file);
			writer.write(message);
			writer.close();
		} catch (IOException e) {
			log.error("file write error");
		}
		return 0;
	}

}
