package com.dev_elf.seoul.seoulgarbage.models;

/**
 * Created by dnay2 on 2016-09-05.
 */
public class GarbageTip {
    public String title;
    public String contents;

    public GarbageTip(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    @Override
    public String toString() {
        return "GarbageTip{" +
                "title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }
}
