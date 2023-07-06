THREAD DEADLOCK : WHEN A THRAED HAS LOCKEDX AN OBJECT AND IT IS WAITING FOR ANOTHER OBJECT TO BE RELEASED BY ANOTHER THREAD
  AND THE OTHER THREAD IS NALSO WAITING FOR THE FIRST THREAD TO RELEASE THE FIRST OBJECT,BOTH THE THREADS WILL CONTINUE GETTING FOREVER
  THIS IS CALLED THREAD DEADLOCK

package train;

public class Bookticket extends Thread {
	Object train, comp;

	public Bookticket(Object train, Object comp) {
		// TODO Auto-generated constructor stub
		this.train = train;
		this.comp = comp;

	}

	public void run() {
		synchronized (train) {

			System.out.println("Book Ticket locked on train");
	
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
		// TODO: handle exception
			}
			System.err.println("BookTicket now waiting to lock on compartment");
		}
		synchronized (comp) {
			System.out.println("Book Ticket locked on compartment");
			
		}
	}
}

package train;

public class Cancelticket extends Thread{
	Object train, comp;
	public Cancelticket(Object train,Object comp) {
		this.train=train;
		this.comp=comp;
	}
	public void run() {
		synchronized (comp) {
			System.out.println("Cancel ticket locked on compartment");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO: handle exception
				System.out.println("Cancel ticket now waiting to lock on train");
				
				synchronized (train) {
					System.out.println("cancel ticket lock on train");		
				}
			}	
		}	
	}
}

package train;

public class deadlock {
	public static void main(String[] args) {
		Object train =new Object();
		Object comp =new Object();
		
		Bookticket obj1=new Bookticket(train,comp);
		Cancelticket obj2=new Cancelticket(train,comp);
		
		Thread t1=new Thread(obj1);
		Thread t2=new Thread(obj2);
		t1.start();
		t2.start();
		
	}
}
o/p:
Book Ticket locked on train
Cancel ticket locked on compartment
BookTicket now waiting to lock on compartment
Book Ticket locked on compartment


