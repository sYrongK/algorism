package org.algorism.lecture.one.one;


public class SearchOne {

    private final String source;
    private final char keyword;

    public SearchOne(String source, char keyword) {
        this.source = source;
        this.keyword = keyword;
    }

    public long search() {
        return this.source.chars()
                .filter(c -> c == Character.toUpperCase(this.keyword) || c == Character.toLowerCase(this.keyword))
                .count();
    }
}
