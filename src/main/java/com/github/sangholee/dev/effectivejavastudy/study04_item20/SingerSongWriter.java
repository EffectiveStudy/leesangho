package com.github.sangholee.dev.effectivejavastudy.study04_item20;

public interface SingerSongWriter extends Singer, SongWriter {

    AudioClip strum();

    void actSensitive();

}
