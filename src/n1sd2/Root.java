package n1sd2;

public class Root implements Runnable {
	private int index;
	private long time;
	
	public Root(int index, long time) {
		this.index = index;
		this.time = time;
		
		Thread t = new Thread(this);
		t.start();
		
		try {
			t.join();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		print();
	}
	
	public synchronized double root(double number) {
		return Math.pow(number, (double) 1 / index);
	}
	
	public synchronized void print() {
		for(int i = 1; i < 1001; i++) {
			try {
				Thread.sleep(time);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(i % 2 != 0 && i < 100 && index == 2) {
				System.out.println("Raiz quadrada de " + i + " = " + String.format("%.2f", root(i)));
			}
			else {
				if(i % 2 == 0 && index == 3 && i % 20 == 0) {
					System.out.println("Raiz cúbica de " + i + " = " + String.format("%.2f", root(i)));
				}
			}
		}
	}
	
}
