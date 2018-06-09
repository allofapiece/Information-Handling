package com.epam.task2.main;

import com.epam.task2.entity.Text;
import com.epam.task2.entity.Word;
import com.epam.task2.service.finder.*;
import com.epam.task2.service.parser.TextParser;
import com.epam.task2.service.reader.WholeTextFileReader;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.List;

/**
 * Class where application start from
 *
 * @author Listratsenka Stanislau
 * @version 1.0
 */
public class Start {
    private static Logger log = Logger.getLogger(Start.class);

    public static void main(String[] args) {
        WholeTextFileReader reader = new WholeTextFileReader(new File("test.txt"));
        Text text = (Text) new TextParser().parse(reader.readAll());
        Word word = new UniqueWordFinder().find(text);
        if (word != null) {
            log.info(word);
        } else {
            log.error("First sentence does not has unique word.");
        }

        List<Word> words = new QuestionWordFinder().find(text, 5);
        if (words != null) {
            printWords(words);
        } else {
            log.error("Words of specific length did not find.");
        }
    }

    /**
     * Print list of words in console
     *
     * @param words
     */
    public static void printWords(List<Word> words) {
        for (Word word : words) {
            log.info(word.toString());
        }
    }
}
