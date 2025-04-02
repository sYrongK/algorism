package org.algorism.ninety.day3;

public class SolutionOne {

    public static void solution() {

    }

    public static void main(String[] args) {
        //todo 0또는 1 정수
        //todo 정수의 앞 혹은 뒤에 느낌표가 온다
        //todo 팩토리얼0! = 1, 1! = 1
        //todo 논리반전 !0 = 0 !1 = 0
        //todo 팩토리얼이 우선이다 -> 정수 0 1 왼쪽에 값이 있는지 그게 느낌표인지가 우선이다.
        int T = 0;
        boolean isFactorial = false;

        //todo 숫자를 찾고, split
        //todo 그 배열을 0 ~ Arr length-1 loop를 돌려서 다음꺼의 첫번째 char이 느낌표면~ 1

        //todo 그 다음에 또 오른쪽에 느낌표 있는지 보고 -> 있으면 1 없으면 왼쪽가서 느낌표 있는지 보고
        //todo 왼쪽에 있으면 -> 0 없으면 끝

        //todo 있다 없다는 팩토리얼로 끝나냐 아니냐로 보고 boolean 값으로..-> 마지막에 result ? 1 : 0;


//        "0!" 혹은 "1!"을 찾고 있으면 그걸 기준으로 우할 탐색, 다 찾으면 좌항의 왼쪽부터 탐색
//                           없으면  좌항의 왼쪽부터 탐색
//                분할 정복인가 정렬인가 그거아님?
    }
}
