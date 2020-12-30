package item30;

import java.util.*;
import java.util.function.UnaryOperator;

public class Main30 {
    // 항등함수 만들기, 제네릭 싱글턴 패턴 => 요걸 여러개 만들 필요가 없어서 따로 빼서 실체화(Object) 시켜준거를 사용함
    private static UnaryOperator<Object> IDENTITY_FN = t -> t;

    public static void main(String[] args) {
        Set<String> guy = Set.of("톰", "딕", "해리");
        Set<String> stooges = Set.of("래리", "모에", "컬리");
        Set<String> alcio = union(guy, stooges);
        System.out.println(alcio);

        // 제네릭 싱글턴, 재귀적 타입 한정
        String[] strings = {"삼베", "대마", "나일론"};
        UnaryOperator<String> sameString = identityFunction();
        for (String s : strings) {
            System.out.println(sameString.apply(s));
        }

        Number[] numbers = {1, 2.0, 3L};
        UnaryOperator<Number> sameNumber = myIdentityFunction();
        for (Number n : numbers) {
            System.out.println(sameNumber.apply(n));
        }

        // 재귀적 타입 한정 사용
        List<Integer> comparableList = new ArrayList<>(); // Integer가 컴페러블 구현함
        Integer max = max(comparableList); // 봤냐 Integer 바로 나온다.
//        List<Object> notComparableList = new ArrayList<>();
//        E max1 = max(notComparableList); // 컴파일 에러


    }

    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    @SuppressWarnings("unchecked") // 형변환 경고 발생하는데 T가 어떤 타입이든 그대로 나오니깐 안전하므로 그냥 사용
    public static <T> UnaryOperator<T> identityFunction() {
        return (UnaryOperator<T>) IDENTITY_FN;
    }

    // 싱글턴이 아니면?
    public static <T> UnaryOperator<T> myIdentityFunction() {
        return new UnaryOperator<T>() { // 줄이면 람다인데 익명 객체 만들긴 한다.
            @Override
            public T apply(T t) {
                return t;
            }
        };
    } // 걍 새로 만드는게 편하네..

    // 재귀적 타입 한정이란 어려운 말을 한번 구현한 예제
    // 그래서 재귀적 한정타입이 뭐냐? 자기자신이 들어간 표현식을 사용해 타입 매개변수 허용범위를 한정... 밑에 같이 쓰는걸 말하는 듯
    public static <E extends Comparable<E>> E max(Collection<E> c) {
        if (c.isEmpty()) {
            throw new IllegalArgumentException("컬랙션 빔");
        }
        E result = null;
        for (E e : c) {
            if (result == null || e.compareTo(result) > 0) {
                result = Objects.requireNonNull(e);
            }
        }
        return result;
    } // 자 이게 먼소리냐? Comparable을 구현한 E 는 E를 써먹는다 이말이지
}
