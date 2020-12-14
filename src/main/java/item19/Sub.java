package item19;

import java.time.Instant;

public class Sub extends Super {
    private final Instant instant;

    Sub() {
        instant = Instant.now();
    }

    @Override public void overrideMe() {
        System.out.println(instant);
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();
        // 이러면 Instance.now()가 두번 찍힐거라 생각하겠지만 null이 찍히고 Instance.now()가 찍힌다고 한다..
        // 왜냐하면 잘 따라가 보면 안다.
        // 어쨌든 생성자가 재정의가능한 메소드를 호출하면 이렇게 오해할 수 있는게 생긴단다.
    }
}
