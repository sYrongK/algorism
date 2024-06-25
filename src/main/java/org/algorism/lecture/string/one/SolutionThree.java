package org.algorism.lecture.string.one;


public class SolutionThree {

    private final String source;
    private final char keyword;

    public SolutionThree(String source, char keyword) {
        this.source = source;
        this.keyword = keyword;
    }

    public long search() {
        String upperExclude = this.source.replaceAll(String.valueOf(Character.toUpperCase(this.keyword)), "");
        String lowerExclude = upperExclude.replaceAll(String.valueOf(Character.toLowerCase(this.keyword)), "");
        return this.source.length() - lowerExclude.length();
    }
}
