package fr.eni.velo;

import java.time.LocalDate;

public class test {

	public static void main(String[] args) {
		
		Velo c1 = new Velo("Lapierre","speed 400",LocalDate.of(2021, 11, 07),4.90,27);
		Velo c2 = new Velo("Btwin","riverside 900",LocalDate.of(2021, 12, 07),4.90,10);
		Gyropodes g1 = new Gyropodes ("Segway","Ninebot Elite",LocalDate.of(2021, 12, 07),29.90,40,"1m50");
		Gyropodes g2 = new Gyropodes ("Weebot","Echo",LocalDate.of(2021, 11, 07),29.90,35,"1m60");
		Gyroroues g3 = new Gyroroues ("Immotion","v8",LocalDate.of(2021, 12, 07),18.90,40);
		Gyroroues g4 = new Gyroroues ("Segway","Ninebot One E+",LocalDate.of(2021, 12, 07),18.90,30);
		
		
		Cycles[] tab = new Cycles[6];
		tab[0] = c1;
		tab[1] = c2;
		tab[2] = g1;
		tab[3] = g2;
		tab[4] = g3;
		tab[5] = g4;
		
		for(int i = 0;i < tab.length;i++) {
			System.out.println(tab[i]);
		}
		
		
		
		
	}

}
