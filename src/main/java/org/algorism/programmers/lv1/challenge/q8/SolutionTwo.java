package org.algorism.programmers.lv1.challenge.q8;

public class SolutionTwo {
    /*
    1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
    2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
    3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
    4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
    5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
    6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
    7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
     */

    public static String solution(String new_id) {

        return new KakaoId(new_id)
                .replaceLowerCase()
                .filter()
                .replaceDoubleDot()
                .filterDot()
                .replaceEmpty()
                .filterLength()
                .noLessThan2()
                .getId();
    }

    private static class KakaoId {
        private String id;

        public KakaoId(String id) {
            this.id = id;
        }

        public String getId() {
            return this.id;
        }

        public KakaoId replaceLowerCase() {
            this.id = this.id.toLowerCase();
            return this;
        }

        public KakaoId filter() {
            this.id = id.replaceAll("[^a-z0-9-_.]", "");//[^] 대괄호 안 ^ 부정을 의미. 대괄호 안 문자들이 아닌 문자 의미함.
            return this;
        }

        public KakaoId replaceDoubleDot() {
            this.id = id.replaceAll("[.]{2,}", ".");
            return this;
        }

        public KakaoId filterDot() {
            this.id = id.replaceAll("^[.]|[.]$", "");//마침표를 \\. 아니면 [.]으로 문자 그대로의 마침표라는걸 의미하게 해야 한다.
            return this;
        }

        public KakaoId replaceEmpty() {
            this.id = this.id.isEmpty() ? "a" : this.id;
            return this;
        }

        public KakaoId filterLength() {
            if (this.id.length() >= 16) {
                this.id = this.id.substring(0, 15);
            }
            this.id = this.id.replaceAll("[.]$", "");//앞에서 끝의 마침표 다 제거하긴 했지만, 요구사항이 길이 맞추고 나서 마침표 있으면 제거해라니까 if문 밖으로 명시해주자
            return this;
        }

        public KakaoId noLessThan2() {
            StringBuilder sb = new StringBuilder();
            sb.append(id);
            if (id.length() <= 2) {
                char c = id.charAt(id.length() - 1);
                while (sb.length() < 3) {
                    sb.append(c);
                }
            }
            this.id = sb.toString();
            return this;
        }
    }

    public static void main(String[] args) {
        String new_id = "...!@BaT#*..y.abcdefghijklm";
//        String new_id = "z-+.^";
//        String new_id = "=.=";
//        String new_id = "123_.def";
//        String new_id = "abcdefghijklmn.p";
        String answer = solution(new_id);
        System.out.println(answer);
    }
}
