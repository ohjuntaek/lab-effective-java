package item13;

/**
 * @see <a href="https://javacan.tistory.com/entry/31">잘 정리된 블로그, 이거 보고 빼낌</a>
 */
public class MyNumbers implements Cloneable {

	private int[] numbers = null;

	public MyNumbers() {
		numbers = new int[10];
	}

	/**
	 * <pre>
	 * {@code
	 * 이러면 MyNumbers의 배열에 대해 새로운 배열을 공유하지 않고 원본에서 생성된 배열을 공유하게 된다.
	 * 왜냐하면 clone 은 레퍼런스 값만 복사기 때문(shallow cloning)
	 * 그래서 deep clone으로 바꿀려면
	 *
	 * public Object clone() throws CloneNotSupportedException {
	 *    MyNumber myObj = super.clone();
	 *    myObj.numbers = (int[]) numbers.clone();
	 *    return myObj;
	 * }
	 * 밑에서 설명
	 * }
	 * </pre>
	 */
//	public Object clone() throws CloneNotSupportedException {
//		return super.clone();
//
//	}


	/**
	 * <pre>
   {@code
   여기서 super는 Object의 clone, 위랑 똑같이 복사한다.
   그 다음 numbers를 수정한다.
   numbers는 collection 계열의 객체인데, 뒤에 어떻게 클론되는지는 나와있으니 지금은 된다는 것만 알자.
   여튼 이렇게 해야 deep copy 가 된다.
   }
	 </pre>
	 */
	public Object clone() throws CloneNotSupportedException {
		MyNumbers myObj = (MyNumbers) super.clone();
		myObj.numbers = numbers.clone();
		return myObj;
	}
}