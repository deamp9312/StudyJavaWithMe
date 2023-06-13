package StudyLambdaAndStream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        Stream<Integer> sList = list.stream();
        for (Integer integer : list) {
            System.out.println("integer = " + integer);
        }

            //병렬스트림.

        int intStream = sList.parallel().mapToInt(Integer::intValue).sum();

//        sList.forEach();

        /**
         * https://www.youtube.com/watch?v=7Kyf4mMjbTQ
         * 자바의 정석 - 기초편] ch14-15,16 스트림, 스트림의 특징
         * 기본형 스트림 -IntStream , LongStream , DoubleStream
         *  오토박싱 & 언박싱의 비효율이 제거됨 Stream<Integer> 대신 IntStream을 사용해서 해결됨.
         *  숫자와 관련된 유용한 메서드를 Stream<T>보다 더 많이 제공.
         */

        System.out.println("intStream = " + intStream);
    }
}
