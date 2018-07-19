import java.util.Scanner;

public class Gaus {

    public static void main(String[] args) {
        double konstanta, sigma;
        double a[][] = new double[100][100];
        int i, j, k, n;
	double x[], b[];

	x = new double[100];
	b = new double[100];

        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan ordo Matriks : ");
        n = input.nextInt();
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
        System.out.println("\nMatriks Awal");
        for (i = 0; i < n; i++) {
            for (j = 0; j < n + 1; j++) {
                if (j != n) {
                    System.out.printf(" %.2f", a[i][j]);
                } else {
                    System.out.printf(" | %.2f\n", a[i][j]);
                }
            }
        }

        for (i = 0; i < n; i++) {
            //menjadikan diagonal utama matriks menjadi 1
            //membagi bil diagonal dengan diagonal
            if (a[i][i] != n) {
                konstanta = a[i][i];

                for (j = 0; j < n + 1; j++) {
                    a[i][j] /= konstanta;
                }
            }
            //mengnolkan bawah diagonal utama
            for (j = i + 1; j < n; j++) {
                konstanta = a[j][i];
                for (k = 0; k < n + 1; k++) {
                    a[j][k] -= (konstanta * a[i][k]);
                }
            }

        }
        for (i = 0; i < n; i++) {
            for (j = 0; j < n + 1; j++) {
                if (a[i][j] == -0) {
                    a[i][j] = 0;
                }

            }
        }
        //cetak matriks baru
        System.out.print("\nMatriks Baru\n");
        for (i = 0; i < n; i++) {
            for (j = 0; j < n + 1; j++) {
                if (j != n) {
                    System.out.printf(" %.2f", a[i][j]);
                } else {
                    System.out.printf(" | %.2f\n", a[i][j]);
                }
            }
        }

	for(i=0;i<n+1;i++){
		b[i] = a[i][n];
	}

	//menghitung x1 x2 x3
	x[n-1] = b[n-1] / a[n-1][n-1];
        for(k = n-2; k >= 0; k--){
            sigma = 0;
            for(j = k+1; j < n; j++){
                sigma += a[k][j] * x[j];
            }
            x[k] = (b[k] - sigma) / a[k][k];
        }
        System.out.println("\nPersamaan : ");
        for(i = 0; i < n; i++){
            System.out.printf("x" + (i + 1) + " : " + x[i] + "\n");
        }

    }

}
