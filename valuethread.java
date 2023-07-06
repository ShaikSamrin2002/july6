//////child class
public class myclass extends Thread {
	int count = 0;

	public void run() {
		for (int i = 1; i <= 100; i++) {
			count++;
		}
		System.out.println("completed thread " + Thread.currentThread().getName());
		System.out.println("its priority : " + Thread.currentThread().getPriority());
	}

}
///////super class
public class prior {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myclass obj = new myclass();
		Thread t1=new Thread(obj,"one");
		Thread t2=new Thread(obj,"two");
		t1.setPriority(2);
		t2.setPriority(Thread.NORM_PRIORITY);
		t1.start();
		t2.start();
		
	}

}
o/p:
completed thread one
its priority : 2
completed thread two
its priority : 5
