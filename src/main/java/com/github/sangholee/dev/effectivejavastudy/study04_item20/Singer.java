package com.github.sangholee.dev.effectivejavastudy.study04_item20;


public interface Singer {

    /**
     *
     * @implSpec
     * 노래를 부릅니다.
     *
     * @param s 노래
     * @return 오디오클립
     *
     */
    AudioClip sing(Song s);

}
