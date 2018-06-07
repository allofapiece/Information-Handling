package com.epam.task2.main;

import com.epam.task2.entity.Text;
import com.epam.task2.entity.Word;
import com.epam.task2.service.finder.UniqueWordFinder;
import com.epam.task2.service.parser.TextParser;
import com.epam.task2.service.reader.WholeTextFileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class Start {
    private static Logger log = LogManager.getLogger(Start.class);

    public static void main(String[] args) {
        WholeTextFileReader reader = new WholeTextFileReader(new File("test.txt"));
        Text text = (Text) new TextParser().parse(reader.readAll());
        Word word = new UniqueWordFinder().find(text);
        if (word != null) {
            log.info(word);
        } else {
            log.error("First sentence does not has unique word");
        }
    }
}
