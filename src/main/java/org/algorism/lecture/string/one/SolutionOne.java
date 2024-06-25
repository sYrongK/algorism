package org.algorism.lecture.string.one;


public class SolutionOne {

    private final String source;
    private final char keyword;

    public SolutionOne(String source, char keyword) {
        this.source = source;
        this.keyword = keyword;
    }

    public long search() {
        return this.source.chars()
                .filter(c -> c == Character.toUpperCase(this.keyword) || c == Character.toLowerCase(this.keyword))
                .count();
    }
}
