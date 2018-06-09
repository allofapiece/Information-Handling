package com.epam.task2.service.reader;

import org.apache.log4j.Logger;

import java.io.*;

/**
 * Class can be used for getting of whole text
 * from file.
 *
 * @author Listratsenka Stanislau
 * @version 1.0
 */
public class WholeTextFileReader {
    private static Logger log = Logger.getLogger(WholeTextFileReader.class);

    private File file;
    private FileReader fileReader;
    private BufferedReader bufferedReader;

    /**
     * Default constructor is private, because
     * when this file reader creating, make sure
     * use {@link BufferedReader}, {@link String},
     * {@link FileReader}, {@link InputStreamReader} or
     * {@link File} types passed to constructors.
     */
    private WholeTextFileReader() {}

    /**
     * Constructor
     *
     * @param fileReader Passed in {@link BufferedReader} class wrapper
     */
    public WholeTextFileReader(FileReader fileReader) {
        this.fileReader = fileReader;
        this.bufferedReader = new BufferedReader(this.fileReader);
    }

    /**
     * Constructor
     *
     * @param bufferedReader
     */
    public WholeTextFileReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    /**
     * Constructor
     *
     * Creates {@link File} object
     *
     * @param filePath path to readed file
     */
    public WholeTextFileReader(String filePath) {
        this.file = new File(filePath);
    }

    /**
     * Constructor
     *
     * @param inputStreamReader
     */
    public WholeTextFileReader(InputStreamReader inputStreamReader) {
        this.bufferedReader = new BufferedReader(inputStreamReader);
    }

    /**
     * Constructor
     *
     * @param file {@link File} object for reading file
     */
    public WholeTextFileReader(File file) {
        this.file = file;
        try {
            this.bufferedReader = new BufferedReader(this.fileReader = new FileReader(file));
        } catch (IOException ex) {
            log.error("Can't load file");
        }
    }

    /**
     * Uses for byte reading and getting whole text
     * of target file
     *
     * @return String
     */
    public String readAll() {
        StringBuilder text = new StringBuilder(512);
        try(Reader r = new InputStreamReader(new FileInputStream(this.file), "UTF-8")) {
            int c;
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
