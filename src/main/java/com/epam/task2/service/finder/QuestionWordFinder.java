package com.epam.task2.service.finder;

import com.epam.task2.entity.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This class used for finding words with
 * specific length in questions. Contains
 * one method {@code find} for finding.
 *
 * @author Listratsenka Stanislau
 * @version 1.0
 */
public class QuestionWordFinder {

    /**
     * Finds the words/
     *
     * @param text Text, where words founding in
     * @param length Specific length of target words
     * @return List
     */
    public List<Word> find(Text text, int length) {
        List<Word> words = new ArrayList<>();

        for (SyntaxUnit paragraph : text.getChildren()) {
            if (!(paragraph instanceof Paragraph)) {
                continue;
            }
            for (SyntaxUnit tempSentence : ((Composite) paragraph).getChildren()) {
                if (!(tempSentence instanceof Sentence)) {
                    continue;
                }
                Sentence sentence = (Sentence) tempSentence;
                SyntaxUnit lastSentencePart = sentence.getChildren().get(sentence.count() - 1);

                if (lastSentencePart instanceof Punctuation &&
                        ((Punctuation) lastSentencePart).getPunctuation().equals("?")) {

                    for (SyntaxUnit word : sentence.getChildren()) {
                        if (word instanceof Word && ((Word) word).getWord().length() == length) {
                            words.add((Word) word);
                        }
                    }
                }
            }
        }

        return words;
    }
}
