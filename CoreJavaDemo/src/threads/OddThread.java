package threads;


/**
 * 1. implements Runnable interface
 * 2. Override the run() : task that a thread will perform
 * 3. create object of your  class
 * 4. Pass this object to thread class constructor
 * 5. call start
 * 
 */
public class OddThread  implements Runnable{
	
	
	@Override
	public void run() {
		
		System.out.println(Thread.currentThread().getName()+ " in run");
		for (int i = 1; i <=20; i+=2) {
				System.out.println(Thread.currentThread().getName()+ " : "+ i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		System.out.println(Thread.currentThread().getName()+ " after run");
	}

}
