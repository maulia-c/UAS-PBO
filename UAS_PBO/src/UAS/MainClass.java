/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UAS;

import java.util.Scanner;

/**
 *
 * @author Maulia
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */

    
    public static void main(String[] args) {
        Override dataK = new Override();
        
   
        boolean cekinput = true;
        
        while( cekinput ){    
            System.out.println("---- Menu Utama ----");
            System.out.println("1.Tambah data");
            System.out.println("2.Hapus Data");
            System.out.println("3.Cari Data");
            System.out.println("4.Lihat Data");
            System.out.println("5.Exit");
            Scanner input = new Scanner( System.in );
            System.out.print("Menu pilihan: ");
            int inp = input.nextInt();
            switch(inp){
                case 1 : 
                    boolean adddata = true;
                    while( adddata ){
                        System.out.println("");
                        System.out.println("===========================================");
                        System.out.println("               Menu Tambah Data            ");
                        System.out.println("-------------------------------------------");
                        String cb = input.nextLine();
                        
                        System.out.print("Masukan Kode Karyawan             : ");
                        String kode_karyawan = input.nextLine();
   
                        System.out.print("Masukan Nama Karyawan             : ");
                        String nama_karyawan = input.nextLine();

                        System.out.print("Masukan Alamat                    : ");
                        String alamat = input.nextLine();

                        System.out.print("Masukan Tanggal Lahir (YYYY-MM-DD): ");
                        String tanggal_lahir = input.nextLine();
       
                        System.out.print("Masukan Golongan (A/B/C)          : ");
                        String golongan = input.nextLine();
                        System.out.println("");
            
                        System.out.println("Masukan Status Menikah");
                        System.out.println("0.belum");
                        System.out.println("1.menikah");
                        System.out.print("Status Karyawan                   : ");
                        int statusKar = input.nextInt();
      
                        int banyakAnak;
                        if( statusKar == 1 ){
                            System.out.print("Jumlah Anak                       : ");
                            banyakAnak = input.nextInt();
                        } else {
                            statusKar = 0;
                            banyakAnak = 0;
                        }
                        

                        Data karyawan = new Data(
                                kode_karyawan,
                                nama_karyawan,
                                alamat,
                                tanggal_lahir,
                                golongan,
                                statusKar,
                                banyakAnak
                        );
   
                        dataK.add(karyawan);
                        
                        System.out.println("\n");
                        System.out.println("Pilih Submenu : ");
                        System.out.println("1 Kembali ke menu utama");
                        System.out.println("2 Tambah Data Kembali");
                        System.out.println("");
                        System.out.print("Menu Pilihan : ");
          
                        int inpSub = input.nextInt();
                        if( inpSub == 1 ){
                            adddata = false;
                        }else if(inpSub != 2) {
                            System.out.println("Pilihan sub menu tidak ada");
                        }  
                    }
                    break;
                
                    
                case 2 : 
                    boolean inpHapus = true;
                    while( inpHapus ) {
                        System.out.println("");
                        System.out.println("===========================================");
                        System.out.println("                 Hapus Data                ");
                        System.out.println("-------------------------------------------");
                        String cb = input.nextLine();
                        
                        System.out.print("Masukan kode karyawan yg ingin dihapus : ");
                        String kode_karyawan = input.nextLine();
              
                        dataK.delete(kode_karyawan);
            
                        System.out.println("Pilih Submenu : ");
                        System.out.println("1 Kembali ke menu utama");
                        System.out.println("2 Hapus Data Kembali");
                        System.out.println("");
                        System.out.print("Menu Pilihan : ");
           
                        int inpSub = input.nextInt();
                        if( inpSub == 1 ){
                            inpHapus = false;
                        } else if(inpSub != 2) {
                            System.out.println("pilihan sub menu tidak ada");
                        }
                        
                    }
                    break;
                
                case 3 :                     
                    boolean menu_cari_data = true;
                    while( menu_cari_data ){
                        System.out.println("");
                        System.out.println("===========================================");
                        System.out.println("                 Cari Data                 ");
                        System.out.println("-------------------------------------------");
                        String cb = input.nextLine();
                        
                        System.out.print("Masukan Kode Karyawan untuk dicari : ");
                        String inputID = input.nextLine();

                        dataK.search(inputID);

                        System.out.println("");
                        System.out.println("Pilih SubMenu : ");
                        System.out.println("1.Kembali ke menu utama");
                        System.out.println("");
                        System.out.print("Menu Pilihan : ");
                        
                        int inpSub = input.nextInt();
                        if( inpSub == 1 ){
                            menu_cari_data = false;
                        } else{
                            System.out.println("pilihan sub menu tidak ada");
                        }
                    }
                    break;
                
                case 4 : 
                    boolean perint = true;
                    while( perint ){
      
                        dataK.print();
                        
            
                        System.out.println("");
                        System.out.println("Pilih SubMenu : ");
                        System.out.println("1.Kembali ke menu utama");
                        System.out.println("");
                        System.out.print("Menu Pilihan : ");

                        int inpSub = input.nextInt();
                        if( inpSub == 1 ){
                            perint = false;
                        } else {
                            System.out.println("Pilihan sub menu tidak ada");
                        }
                    }
                    break;

                    
                case 5 : 
                    System.exit(0);
                
                default: 
                    System.out.println("Menu yang anda pilih tidak ada dalam daftar");
                    System.out.println("");
                
            }   
            
        }
    }
    
}
