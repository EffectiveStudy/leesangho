package com.github.sangholee.dev.effectivejavastudy.study05_item28;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ChooserUseGeneric<T> {

    private final T[] choiceArray;

    public ChooserUseGeneric(Collection<T> choices) {
        // 컴파일이 되지 않음
//        this.choiceArray = choices.toArray();
        this.choiceArray = (T[]) choices.toArray();
    }

    public Object choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceArray[rnd.nextInt(choiceArray.length)];
    }
}
