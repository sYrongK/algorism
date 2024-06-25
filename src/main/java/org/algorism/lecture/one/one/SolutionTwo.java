package org.algorism.lecture.one.one;


public class SolutionTwo {

    private String source;
    private char keyword;

    public SolutionTwo(String source, char keyword) {
        this.source = source;
        this.keyword = keyword;
    }

    public long search() {
        long count = 0;
        this.source = source.toUpperCase();
        this.keyword = Character.toUpperCase(this.keyword);

        for (int i = 0; i < this.source.length(); i++) {
            char c = this.source.charAt(i);
            if (c == this.keyword) {
                count++;
            }
        }
        return count;
    }
}
