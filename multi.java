1/Extends thread class / implements runnable method
  2.create a method run
  3.create an object of class
  4.create an object of thread and pass the object to the thread
  5.t.start()  --> run our thread


  THREAD SYNCHRONISATION :
  LOCKS ONE THREAD AND WAIT UNTIL THAT THREAD TO COMPLETED FOR ANOTHER THREAD TO BE EXECUTED
  ANOTHER DEFINITION : WHEN A THREAQD IS ALREADY ACTING ON AN OBJECT PREVENTING ANY OTHER THREAD FROM ACTING ON SAME OBJECT IS CALLED AS .....
      
SYNTAX : Synchronised(object) { stmts}
  
  THIS ALSO CALLED MUTEX....(MUTUALLY EXCLUSIVE)

///////SUPER CLASS
  package train;

public class BookMyTrain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrainTicket tc=new TrainTicket(1);
		Thread t1=new Thread(tc);
		Thread t2=new Thread(tc);
		
		t1.setName("First person");
		t2.setName("Second person");
		
		t1.start();
		t2.start();
		}

	}

////SUB CLASS
package train;
public class TrainTicket implements Runnable {
	int available=1;
	int wanted;
	
	public TrainTicket(int i) {
		wanted=i;
	}
	public void run() {
		System.out.println("Available berth : "+available);
		if(available>=wanted)
		{
			String name=Thread.currentThread().getName();
			System.out.println(wanted +"Berths reserved for "+name);
			try {
				Thread.sleep(1500);
				available=available-wanted;
				System.out.println(available);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		else {
			System.out.println("sorry no berath");
		}	
	}
}
PKEH
O/P:
Available berth : 1
1 Berths reserved for First person
Available berth : 1
1 Berths reserved for Second person
0
-1


 
