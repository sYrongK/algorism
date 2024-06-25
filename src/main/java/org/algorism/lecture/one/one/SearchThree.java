package org.algorism.lecture.one.one;


public class SearchThree {

    private final String source;
    private final char keyword;

    public SearchThree(String source, char keyword) {
        this.source = source;
        this.keyword = keyword;
    }

    public long search() {
        String upperExclude = this.source.replaceAll(String.valueOf(Character.toUpperCase(this.keyword)), "");
        String lowerExclude = upperExclude.replaceAll(String.valueOf(Character.toLowerCase(this.keyword)), "");
        return this.source.length() - lowerExclude.length();
    }
}
