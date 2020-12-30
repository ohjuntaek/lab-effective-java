package item26;

import java.util.ArrayList;
import java.util.List;

public class Main26 {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();

//        unsafeAdd(strings, Integer.valueOf(42));
//        String s = strings.get(0);


    }

    // Exception in thread "main" java.lang.ClassCastException: class java.lang.Integer cannot be cast to class java.lang.String (java.lang.Integer and java.lang.String are in module java.base of loader 'bootstrap')
    // 위의 예외가 마지막에 뜬다. 이유는 당연히 Integer로 들어간게 String 으로 나오니깐
//    private static void unsafeAdd(List strings, Object valueOf) {
//        strings.add(valueOf);
//    }

    // 이러면 컴파일이 안된다. 왜? String이 들어가야 하는데 Object가 들어가니깐
    // 헷갈리는게 T extends Object 가 아니다! 제네릭은 딱 맞게 들어가야한다 자동 형변환 안되는 듯
//    private static void unsafeAdd(List<String> strings, Object valueOf) {
//        strings.add(valueOf);
//    }

    // 비한정적 와일드카드를 사용하는 콜렉션에는 (null 이외에) 아무것도 못넣는다.
    // 이럼으로써 못넣고 빼는것도 뭘 뺼지 모른다.
//    private static void unsafeAdd(List<?> strings, Object valueOf) {
//        strings.add(valueOf);
//    }
}
