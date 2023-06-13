package StudyLambdaAndStream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStream {
    public static void main(String[] args) {
        /**
         * 스트림 만들기 - 컬렉션
         * 1. 스트림 생성
         * 2. 중간연산
         * 3. 최종연산
         */

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> intStream = list.stream();


        intStream.forEach((o)->System.out.println(o));
//        intStream.forEach(System.out::println);
//        intStream.forEach(System.out::println); 해당 스트림이 이미 종료됨


        /**
         * 객체 배열로부터 스트림 생성하기
         * Stream<T> Stream.of(T... values) // 가변인자
         * Stream<T> Stream.of(T[])
         * Stream<T> Arrays.stream(T[])
         * Stream<T> Arrays.stream(T[] array,int startInclusive, int endExclusive) >   배열,3,8 -> 3부터 7번째까지 (8미 포함)
         */

        /**
         * 기본형 배열로부터 스트림 생성하기
         * IntStream IntStream.of(int... values)    //Stream이 아니라 IntStream
         * IntStream IntStream.of(int[])
         * IntStream Arrays.stream(int[])
         * IntStream Arrays.stream(int[],int startInclusive, int endExclusive)
         *
         */

//        Stream<String> strStream = Stream.of("a", "b", "c");
        Stream<String> strStream = Stream.of(new String[]{"a", "b", "c"});
        strStream.forEach(System.out::println);

        int[] intArr = {1,2,3,4,5};
        IntStream intStream1 = Arrays.stream(intArr);       //오토박싱 언박싱을 안함.
        intStream1.forEach(System.out::print);

        System.out.println("\n###########");
        Integer[] intArr2 = {1, 2, 3, 4, 5};
        Stream<Integer> stream = Arrays.stream(intArr2);       //오토 박싱 언박싱을 하기때문에 빅테이터 처리시 문제 발생요소가 존재함
        stream.forEach(System.out::print);

        //난수
        System.out.println("\n###########");
        IntStream ints = new Random().ints(1,10);//1~9까지의 숫자중
        ints.limit(5).forEach(System.out::println); //5개의 숫자만 반환

        /**
         * 스트림 만들기 - 특정 범위의 정수
         *  IntStream intStream = IntStream.range(1,5); //1,2,3,4
         *  IntStream intStream = IntStream.rangeClosed(1,5); //1,2,3,4,5
         */

        /**
         * 스트림 만들기 - 람다식 iterate() , generate()
         * 람다식을 소스로 하는 스트림 생성하기
         * static <T> Stream<T> iterate(T seed,UnaryOperator<T> f) //이전 요소에 종속적 //초기값,무한스트릠
         * static <T> Stream<T> generate(Supplier<T> s) //이전 요소에 독립적        //람다식
         */
        //iterate(T seed,Un...) //단항 연산자
        Stream<Integer> iterate = Stream.iterate(1, n -> n + 2);
        iterate.limit(10).forEach(System.out::println);


        //generate(Supplier s) : 주기만 하는것 입력x, 출력o
        Stream<Integer> generate = Stream.generate(() -> 1);
        generate.limit(10).forEach(System.out::println);

        /**
         * 스트림 만들기 - 파일과 빈 스트림
         * 파일을 소스로 하는 스트림 생성하기
         * Stream<Path> Files.list(Path dir)    //Path는 파일 또는 디렉토리
         *
         * Stream<String> Files.lines(Path path)    //파일 내용을 라인 단위로 읽어서 String로 만듬
         * Stream<String> Files.lines(Path path,Charset cs)
         * Stream<String> lines() //BufferedReader클래스의 메서드  //15장
         */

        /**
         * 비어있는 스트림 생성하기
         * Stream emptyStream   = Stream.empty();   //empty()는 빈 스트림을 생성해서 반환한다.
         * long count = emptyStream.count();        //count 값은 0
         */

    }
}
