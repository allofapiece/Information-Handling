package com.epam.task2.service.finder;

import com.epam.task2.entity.*;

/**
 * This class provide only one {@code find} method,
 * that looks for a unique word in first sentence
 * for whole text.
 *
 * @author Listratsenka Stanislau
 * @version 1.0
 */
public class UniqueWordFinder {

    /**
     * This method looks for a unique word.
     *
     * @param text
     * @return Word
     */
    public Word find(Text text) {
        Word targetWord = null;
        Sentence firstSentence = null;
        boolean isFind;
        int sentenceCount;

        for (SyntaxUnit paragraph : text.getChildren()) {
            if (!(paragraph instanceof CodeBlock)) {
                firstSentence = (Sentence) ((Composite) paragraph).getChildren().get(0);
                break;
            }
        }

        for (SyntaxUnit tempWord : firstSentence.getChildren()) {
            if (!(tempWord instanceof Word)) {
                continue;
            }
            isFind = false;
            sentenceCount = 0;

            for (SyntaxUnit paragraph : text.getChildren()) {
                if (!(paragraph instanceof Paragraph)) {
                    continue;
                }

                for (SyntaxUnit sentence : ((Composite) paragraph).getChildren()) {
                    sentenceCount++;

                    if (sentenceCount == 1) {
                        continue;
                    }

                    for (SyntaxUnit word : ((Composite) sentence).getChildren()) {
                        if (!(word instanceof Word)) {
                            continue;
                        }
                        if (word.toString().equals(tempWord.toString())) {
                            isFind = true;
                            break;
                        }
                    }
                    if (isFind) {
                        break;
                    }
                }
                if (isFind) {
                    break;
                }
            }
            if (!isFind) {
                targetWord = (Word) tempWord;
                break;
            }
        }

        return targetWord;
    }
}
