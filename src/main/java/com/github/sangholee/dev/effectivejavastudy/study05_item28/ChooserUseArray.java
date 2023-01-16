package com.github.sangholee.dev.effectivejavastudy.study05_item28;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ChooserUseArray {

    private final Object[] choiceArray;


    public ChooserUseArray(Collection choices) {
        this.choiceArray = choices.toArray();
    }

    public Object choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceArray[rnd.nextInt(choiceArray.length)];
    }
}
