package com.github.sangholee.dev.effectivejavastudy.study05_item28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ChooserUseList<T> {

    private final List<T> choiceList;


    public ChooserUseList(Collection<T> choiceList) {
        this.choiceList = new ArrayList<>(choiceList);
    }

    public T choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }
}
