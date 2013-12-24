package objects;

import java.awt.Toolkit;

public class PomodoroTimer {

	private String task;
	private int veces;

	public PomodoroTimer(String task, int veces) {
		this.task = task;
		this.veces = veces;
		inicia();
	}

	public PomodoroTimer() {
		this("Indefinida", 5);
	}

	private void timer(long time) {
		try {
			Thread.sleep(time);
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}

	public void trabajo() {
		timer(15000);
	}

	public void pausaCorta() {
		timer(3000);
	}

	public void pausaLarga() {
		timer(12000);
	}

	public void inicia() {
		System.out.println("Empieza a trabajar en "+task);
		for (int i = 0; i < veces; i++) {
			Toolkit.getDefaultToolkit().beep();
			trabajo();
			System.out.print("Descansa por unos ");
			if ((i + 1) % 4 == 0) {
				System.out.println("20 minutos.");
				pausaLarga();
			} else {
				System.out.println("5 minutos.");
				pausaCorta();
			}
			
			if (i == veces - 1) {
				System.out.println("Tiempo terminado");
			} else {
				System.out.println("Continua trabajando");
			}
			
		}

	}

	public String getTask() {
		return task;
	}
	
	public int getVeces() {
		return veces;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
