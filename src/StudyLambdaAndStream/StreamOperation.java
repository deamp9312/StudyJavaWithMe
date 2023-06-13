package StudyLambdaAndStream;

import java.util.stream.IntStream;

public class StreamOperation {
    public static void main(String[] args) {
        /**
         * 스트림의 연산
         * 스트림이 제공하는 기능 - 중간 연산과 최종 연산
         * 중간 연산 - 연산결과가 스트림인 연산. 반복적으로 적용가능.
         * 최종 결과 - 연산결과가 스트림이 아닌 연산 , 단 한번만 적용가능(스트림의 요소를 소모)
         */
        /**
         * 중간 연산
         * distinct() 중복을 제거
         * filter(Predicate<T> predicate) 조건에 안 맞는 요소 제외
         * limit(long maxSize) 스트림의 일부를 잘라낸다.
         * skip(long n) 스트림의 일부를 건너뛴다. ex) skip(3) -> 1~10까지의 숫자중 3개를 건너띄우고 다음게 반환된다 (4~10)반환
         * peek(Consumer<T> action) 스트림의 요소에 작업수행   //스트림요소의 기본정렬
         * sorted() , sorted(Comparator<T> comparator) 스트림의 요소를 정렬한다.       //정렬기준으로 정렬
         *
         ** 스트림의 요소를 반환한다.
         * Stream<R> DoubleStream , IntStream , LongStream
         * map(Function<T,R> mapper)
         * mapToDouble(ToDoubleFunction<T> mapper)
         * mapToInt(ToIntFunction<T> mapper)
         *
         * Stream<R> DoubleStream , IntStream , LongStream
         * flatMap(Function<T , Stream<R>> mapper)
         * flatMapToDouble(Function<T,DoubleStream> m )
         * flatMapToInt(Function<T , IntStream> m)
         * flatMapToLong(Function<T,LongStream> m)
         */
        /**
         * 스트림의 연산 - 최종 연산
         *
         * *각 요소에 지정된 작업 수행
         * void forEach(Consumer<? super T> action)
         * void forEachOrdered(Consumer<? super T> action)  //병렬스트림 사용시 순서유지가 된다
         *
         * long count() //스트림의 요소의 개수 반환
         *
         * *스트림의 최대값/최소값을 반환
         * Optional<T> max(Comparator<? super T> comparator)
         * Optional<T> min(Comparator<? super T> comparator)
         *
         * *스트림의 요소 하나를 반환
         * Optional<T> findAny()        //아무거나 하나   > 병렬 filter과 같이 쓰임
         * Optional<T> findFirst()      //첫 번째 요소   > 직렬
         *
         * *주어진 조건을 모든 요소가 만족시키는지, 만족시키지 않는지 확인
         * boolean allMatch(Predicate<T> p) //모두 만족하는지
         * boolean anyMatch(Predicate<T> p) //하나라도 만족하는지
         * boolean noneMatch(Predicate<T> p) //모두 만족하지 않는지
         *
         * *스트림의 모든 요소를 배열로 반환
         * Object[] toArray()
         * A[]      toArray(IntFunction<A[]> generator)
         *
         * *스트림의 요소를 하나씩 줄여가면서(리듀싱) 계산한다.
         * Optional<T> reduce(BinaryOperator<T> accumulator)
         * T reduce(T identity,BinaryOperator<T> accumulator)
         * U reduce(U identity,BiFunction<U,T,U> accumulator , BinaryOperator<U> combiner)
         *
         * *스트림의 요소를 수집한다. 주로 요소를 그룹화하거나 분활한 결과를 컬렉션에 담아 반환하는데 사용된다.
         * R collect(Collector<T,A,R> collector)
         * R collect(Supplier<R> supplier,BiConsumer<R,T> accumulator, BiConsumer<R,R> combiner)
         *
         */

        //[자바의 정석 - 기초편] ch14-26~29 스트림의 중간연산(1)
        IntStream intStream = IntStream.rangeClosed(1, 10);
//        intStream.filter(i->i%2==0).forEach(System.out::println);

//        intStream.filter(i->i%2!=0 && i%3!=0).forEach(System.out::println);
        intStream.filter(i->i%2!=0).filter(i->i%3!=0).forEach(System.out::println);


    }
}
