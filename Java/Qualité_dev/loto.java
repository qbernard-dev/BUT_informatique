import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import SaisieIncorrect_v2.EntierInvalideException;

public class loto{
	
	private int num;
	private Calendar dateT;
	private ArrayList<Integer> les_nums = new ArrayList<Integer>(6);
	
	public loto(int num, Calendar dateT) {
		super();
		this.num = num;
		this.dateT = dateT;
	}

	public Calendar getDateT() {
		return dateT;
	}

	public int getNum() {
		return num;
	}
    
	public int ajoutez(ArrayList<Integer> nums) {
		Scanner clavier = new Scanner(System.in);
		int nb;
		for(int i = 0; i < 6; i++) {
			try {
				nb = clavier.nextInt();	
				if (nb <= 1 && nb >= 49) {
					throw new Exception("L'entier doit être compris entre 1 et 49");
				}
			}
			catch(Exception e) {
				
			}
			nums.add(nb);
		}
	}

	
}
