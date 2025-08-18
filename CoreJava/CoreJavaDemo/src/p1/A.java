package p1;

public class A {

	private int pri;
	int def;
	protected int pro;
	public int pub;
	
	public A(){
		super();
		System.out.println(pri);
		System.out.println(def);
		System.out.println(pro);
		System.out.println(pub);
	}
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Started");
		Thread.sleep(15000);
		System.out.println("ended");
	}
	
}
