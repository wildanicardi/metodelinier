import java.util.Scanner;
public class GausSeidel  {
	public static void main (String args []){
		int n, k, i, j,besar=0;
		double c ,pivot;
		double a[][]= new double[100][100];
		double temp[] =  new double[100];
		double b[] = new double[100];
		double x[] = new double[100];

		System.out.print("      LABORATORIUM PEMROGRAMAN\n");
		System.out.print("POLITEKNIK ELEKTRONIKA NEGERI SURABAYA\n");
		System.out.print("--------------------------------------\n");

		//Input Ordo Matrix
		Scanner input = new Scanner(System.in);
        System.out.print("Masukkan ordo Matriks : ");
        n = input.nextInt();
		//Menginput Nilai Matrix
		for (i = 0; i < n; i++) {
            for (j = 0; j < n + 1; j++) {
                if (j != n) {
                    System.out.print("Masukkan nilai Matriks [" + (i + 1) + "]["
                            + (j + 1) + "] : ");
                    a[i][j] = input.nextDouble();
                } else {
                    System.out.print("Masukkan nilai augmented : ");
                    a[i][j] = input.nextDouble();
                }
            }
        }

    	
	}
}