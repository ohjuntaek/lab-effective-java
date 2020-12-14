package item18;

final class SomeService {
  public static void main(String[] args) {
    SomeService   service       = new SomeService();
    WrappedObject wrappedObject = new WrappedObject(service);
    Wrapper       wrapper       = new Wrapper(wrappedObject);
    wrapper.doSomething();
  }

  void performAsync(SomethingWithCallback callback) {
    new Thread(() -> {
      perform();
      callback.call(); // 이 때 래퍼클래스의 콜백이 아닌 래핑된 클래스의 콜백이 호출되는 것이 문제
    }).start();
  }

  void perform() {
    System.out.println("Service is being performed.");
  }
}
