import java.util.Scanner;
public class GausJordan{
	public static void main(String[] args) {
		double konstanta;
		double a[][] = new double[100][100];
		int i, j, k, n;
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
		//Mencetak Matrix awal
		System.out.println("Matriks Awal");
        for (i = 0; i < n; i++) {
            for (j = 0; j < n + 1; j++) {
                if (j != n) {
                    System.out.printf(" %.2f", a[i][j]);
                } else {
                    System.out.printf(" | %.2f\n", a[i][j]);
                }
            }
        }
		//Mengubah matriks menjadi Gauss Jordan     
		//Cek diagonal utama tidak boleh 0
		for(i=0;i<n;i++){
			if(a[i][i]==0){
				for(j=0;j<n;j++){
					if(a[j][i]!=0){
						for(k=0;k<n+1;k++){     
							a[i][k] += a[j][k];                     
						}      
						break;                 
					}             
				}    
			}
			if(a[i][i]!=1) {             
			
				konstanta = a[i][i];             
			
				for (j=0;j<n+1;j++){                 
				
					a[i][j] /= konstanta;             
				}         
			}
			for(j=i+1;j<n;j++){
				konstanta = a[j][i];             
				for (k=0;k<n+1;k++){
					a[j][k] -= (konstanta*a[i][k]);             
				}
			}         
		}
		//Menjadikan 0 atasnya diagonal utama (Jordan)     
		for(i=n-2;i>=0;i--) {         
		
			for(j=0;j<=i;j++) {             
			
				konstanta = a[j][i+1];             
				for(k=0;k<=n;k++){ 
                
					a[j][k] -= (konstanta*a[i+1][k]);             
				}         
			}     
		}     
		//Ngubah -0 jadi 0     
		for(i=0;i<n;i++){         
			for (j=0;j<n+1;j++)             
				if(a[i][j]==-0)                 
					a[i][j]=0;    
		}
		//Mencetak matrix baru
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
		System.out.print("\n");
		for(i=0;i<n;i++){
			System.out.printf("Nilai X%d = %.2f\n",i+1, a[i][n]);
		}
	}
}
