/*****************
 * Dwi Putra Sudaryanto
 * 12111075
 * 22 / Teknik Informasi
 *
 *****************/

import java.util.Scanner;

public class PutraSudaryanto {
	public static void main(String[] args) {

		Scanner mainmenu = new Scanner(System.in);
		Scanner input1 = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		Scanner input3 = new Scanner(System.in);
		
		String menu;
		
		do {
			System.out.println("");
			System.out.println("Dwi Putra Sudaryanto");
			System.out.println("12111075");
			System.out.println("");
			System.out.println("======= PROGRAM MENGHITUNG LUAS =======");
			System.out.println("1. Menghitung Luas Persegi Panjang");
			System.out.println("2. Menghitung Luas Persegi");
			System.out.println("3. Input Biodata");
			System.out.println("4. Selesai");
			System.out.println("=======================================");
			
			System.out.print("Pilihan (1 - 4) ? ");
			menu = mainmenu.nextLine();

			System.out.println("");
			
			switch (menu) {
				case "1":
					System.out.println("Menu : " + menu + ". Menghitung Luas Persegi Panjang");
					System.out.println("------------------------------------");
					System.out.print("masukkan nilai panjang : ");
					int p = input1.nextInt();
					System.out.print("masukkan nilai lebar : ");
					int l = input1.nextInt();
					
					Persegipanjang lpp;
					
					if((p<0) || (l<0)) {
						System.out.println("");
						System.out.println("ERROR : maaf nilai panjang dan lebar harus lebih besar dari 0!!");
						System.out.println("\n\n\n\n\n");
					} 
					else if((p<l)||(p==l)) {
						System.out.println("");
						System.out.println("ERROR : maaf nilai panjang harus lebih besar dari nilai lebar!!");
						System.out.println("\n\n\n\n\n");
					} 
					else {
						lpp = new Persegipanjang(p,l);
						
						System.out.println("");
						System.out.println("Panjang = " + p);
						System.out.println("lebar = " + l);
						System.out.println("maka luas persegi panjang = " + lpp.luaspersegipanjang());
						System.out.println("------------------------------------");
						System.out.println("\n\n\n\n\n");
					}
					break;
				
				case "2":
					System.out.println("Menu : " + menu + ". Menghitung Luas Persegi");
					System.out.println("------------------------------------");
					System.out.print("masukkan nilai sisi persegi : ");
					int s = input2.nextInt();
					
					if(s<0) {
						System.out.println("");
						System.out.println("ERROR : maaf nilai sisi persegi harus lebih besar dari 0!!");
						System.out.println("\n\n\n\n\n");
					} 
					else {
					
						Persegi lpr;
						lpr = new Persegi(s);
					
						System.out.println("");
						System.out.println("Panjang sisi = " + s);
						System.out.println("maka luas persegi = " + lpr.luaspersegi());
						System.out.println("------------------------------------");
						System.out.println("\n\n\n\n\n");
					}
					break;
				
				case "3":
					System.out.println("Menu : " + menu + ". Input Biodata");
					System.out.println("------------------------------------");
					System.out.println("");
					
					System.out.print("masukkan nim anda : ");
					String nim = input3.nextLine();
					System.out.print("masukkan nama anda : ");
					String nama = input3.nextLine();
					System.out.print("apa yang sedang anda pikirkan? ");
					String minds = input3.nextLine();
					
					System.out.println("\n\n");
					System.out.println("PRINTOUT :");
					System.out.println("nim anda  = " + nim);
					System.out.println("nama anda = " + nama);
					System.out.println("yang sedang anda pikirkan = " + minds);
					System.out.println("------------------------------------");
					System.out.println("\n\n\n\n\n");
				
					break;
				
				case "4":
				System.out.println("\nTerima kasih sudah menggunakan program ini");
				System.out.println("Teknik Informatika - Universitas Mercubuana Yogyakarta");
				System.exit(0);
				break;
				
				default:
				System.out.println("\nMenu yang anda maksud tidak tersedia, silahkan ulangi kembali"); 
				System.out.println("");
				System.out.println("");
				break;              
			}


		} while(menu != "4");
		
		input1.close();
		
	}
}

class Persegipanjang {
	int panjang, lebar;
	
	Persegipanjang (int panjang, int lebar) {	
		this.panjang = panjang;
		this.lebar = lebar;
	}
	
	double luaspersegipanjang() {
		double luaspersegipanjang = panjang * lebar;
		return(luaspersegipanjang);
	} 
}

class Persegi {
	Scanner input1 = new Scanner(System.in);
	int sisi;
	
	Persegi (int sisi) {	
		this.sisi = sisi;
	}
	
	double luaspersegi() {
		double luaspersegi = sisi * sisi;
		return(luaspersegi);
	} 
}
