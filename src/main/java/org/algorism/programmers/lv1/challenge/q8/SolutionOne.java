package org.algorism.programmers.lv1.challenge.q8;

public class SolutionOne {
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
        String id = convertToLowerCase(new_id);
        id = filteringCharacter(id);
        id = id.replaceAll("\\.{2,}", ".");
        id = id.replaceAll("^\\.|\\.$", "");
        if (id.isBlank()) id = "a";
        if (id.length() > 15) {
            id = id.substring(0, 15).replaceAll("\\.$", "");
        }
        id = checkLength(id);
        return id;
    }

    private static String checkLength(String id) {
        StringBuilder sb = new StringBuilder();
        if (id.length() <= 2) {
            char c = id.charAt(id.length() - 1);
            sb.append(id, 0, id.length() - 1);
            while (sb.length() < 3) {
                sb.append(c);
            }
        } else {
            sb.append(id);
        }
        return sb.toString();
    }

    private static String filteringCharacter(String id) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < id.length(); i++) {
            char c = id.charAt(i);
            if (Character.isLowerCase(c) || Character.isDigit(c) || c == '-' || c == '_' || c == '.') {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static String convertToLowerCase(String id) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < id.length(); i++) {
            char c = id.charAt(i);
            if (64 < c && 91 > c) {//대문자 65 ~ 90
                c += 32;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        String new_id = "...!@BaT#*..y.abcdefghijklm";
//        String new_id = "z-+.^";
//        String new_id = "=.=";
//        String new_id = "123_.def";
        String new_id = "abcdefghijklmn.p";
        String answer = solution(new_id);
        System.out.println(answer);
    }
}
