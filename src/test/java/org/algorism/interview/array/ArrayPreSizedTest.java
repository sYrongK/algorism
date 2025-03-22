package org.algorism.interview.array;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@BenchmarkMode(Mode.AverageTime) // 평균 실행 시간 측정
@OutputTimeUnit(TimeUnit.MICROSECONDS) // 결과 단위: 마이크로초
@State(Scope.Thread) // 쓰레드별로 상태 유지
public class ArrayPreSizedTest {

    @Param({"100", "1000", "10000"})
    private int size;

    @Benchmark
    public List<String> defaultArrayList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add("data" + i);
        }
        return list;
    }

    @Benchmark
    public List<String> preSizedArrayList() {
        List<String> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add("data" + i);
        }
        return list;
    }
}