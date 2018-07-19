import java.util.Scanner;

public class GaussSeidle {
    public static void main(String[] args) {
        int i,j,n,iterasi,val=0;
        double[][] A = new double[100][100];
        double[] nilai_awal = new double[50];
        double[] hasil = new double[50];
        double e;
        
        Scanner inputReader=new Scanner(System.in);
        System.out.print("\t\t============================\n");
        System.out.print("\t\t\tGAUSS SEIDEL\n");
        System.out.print("\t\t============================\n");
        System.out.print("\tMuhammad Ali WIldan\t 2103171032\n\n");
        System.out.print("Input Ordo : ");
        n = inputReader.nextInt();
        
        System.out.print("Input Iterasi Maksimum : ");
        iterasi = inputReader.nextInt();
        
        System.out.print("Input Toleransi Error : ");
        e = inputReader.nextDouble();
        
        for (i=0; i<n; i++){
            for (j=0; j<=n; j++){
                Scanner inputR=new Scanner(System.in);
                System.out.print("Matriks A[" + i + "][" + j + "]: ");
                A[i][j] = inputR.nextDouble();
            }
            System.out.println("");
        }
        System.out.println("----------------------------------");
        System.out.println("Augmented Matriks : ");
        for (i=0; i<n; i++){
            for (j=0; j<=n; j++){
                System.out.print(A[i][j] + "\t");
            }
            System.out.println("");
        }
        //Memasukkan Nilai Awal
        System.out.println("----------------------------------");
        for (i = 0; i < n; i++) {
            System.out.print("Masukkan nilai awal x["+(i+1)+"] : ");
            nilai_awal[i] = inputReader.nextDouble();           
        }
        //Cetak Tabel
        System.out.println("\n--------------------------------------------------------");
        i=0;
        System.out.print("i\t");
        
        for (i = 0; i < n; i++) {
            System.out.print("x["+(i+1)+"]\t");
        }
        for ( i = 0; i < n; i++) {
            System.out.print("e["+(i+1)+"]\t");  
        }
        System.out.println("\n--------------------------------------------------------");
        
        i=0;
        System.out.print(i+1);
        
        for ( i = 0; i < n; i++) {
            System.out.printf("\t%.4f",nilai_awal[i]);  
        }
        System.out.println("");
        
        for ( i = 0; i <= iterasi; i++) {
            System.out.print(i+2);
            double sigma = 0;
            double[] temp = new double[50];
            
            for (int k = 0; k < n; k++) {
                sigma = 0;
                for ( j = 0; j < n; j++) {
                    if (k != j) {
                        sigma = sigma + nilai_awal[j]*A[k][j];
                    }
                    
                }
                hasil[k]=(A[k][n] - sigma)/A[k][k];
                temp[k]=nilai_awal[k];
                nilai_awal[k]=hasil[k];
                System.out.printf("\t%.4f",nilai_awal[k]);
            }
            
            for (int k = 0; k < n; k++) {
                if(Math.abs(Math.abs(temp[k]-hasil[k]))>100){
                    break;
                }
                System.out.printf("\t%.4f",Math.abs(temp[k]-hasil[k]));
                if (Math.abs(temp[k]-hasil[k])<=e) {
                    val=1;
                }
            }
            System.out.println("");
            if (val==1) {
                break;
            }
        }
        System.out.println("\n--------------------------------------------------------\n");
        for ( i = 0; i < n; i++) {
            System.out.print("x["+(i+1)+"] : "+nilai_awal[i]+"\n");
        }
        System.out.println("\n--------------------------------------------------------");
    }
    
}

