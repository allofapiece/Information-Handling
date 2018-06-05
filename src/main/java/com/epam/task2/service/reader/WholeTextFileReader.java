package com.epam.task2.service.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class WholeTextFileReader {
    private static final Logger log = LogManager.getLogger(WholeTextFileReader.class);

    private File file;
    private FileReader fileReader;
    private BufferedReader bufferedReader;

    public WholeTextFileReader(FileReader fileReader) {
        this.fileReader = fileReader;
        this.bufferedReader = new BufferedReader(this.fileReader);
    }

    public WholeTextFileReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public WholeTextFileReader(String filePath) {
        this.file = new File(filePath);
    }

    public WholeTextFileReader(InputStreamReader inputStreamReader) {
        this.bufferedReader = new BufferedReader(inputStreamReader);
    }

    public WholeTextFileReader(File file) {
        this.file = file;
        try {
            this.bufferedReader = new BufferedReader(this.fileReader = new FileReader(file));
        } catch (IOException ex) {
            log.error("Can't load file");
        }
    }

    public String readAll() {
        StringBuilder text = new StringBuilder(512);
        try {
            Reader r = new InputStreamReader(new FileInputStream(this.file), "UTF-8");
            int c = 0;
            while ((c = r.read()) != -1) {
                text.append((char) c);
            }
        } catch (IOException e) {
            log.error("Can't read file");
        }
        return text.toString();
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public FileReader getFileReader() {
        return fileReader;
    }

    public void setFileReader(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public void setBufferedReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }
}
