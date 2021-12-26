/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UAS;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Maulia
 */
public class Data {

    private int h,b,t;
 
    public int statusKar,jumlahAnak,usia,tunjanganKar,tunjanganS,tunjanganAnak,gajiKotor,potongan,
            gajiAkhir ,gajiPokok;
 
    public String idKar,namaKar,alamatKar,tglKar,golongan;
 
    boolean StatusTunjanganA = false,StatusTunjanganKar = false,StatusTunjanganP = false;
    
  
    public Data(String id, String nama, String alamat, String tgl, String golong, int status, int anak){
        this.idKar = id;
        this.namaKar = nama;
        this.alamatKar = alamat;
        this.tglKar = tgl;
        this.golongan = golong;
        this.statusKar = status;
        this.jumlahAnak = anak;
        
        
        String tgllahir =  this.tglKar;
        String[] lahir = tgllahir.split("-");
        t = Integer.parseInt(lahir[0] );
        b = Integer.parseInt(lahir[1] );
        h = Integer.parseInt(lahir[2] );
        
        LocalDate from = LocalDate.of(t, b, h);
        
        LocalDate today = LocalDate.now();
        
        int umur = Period.between(from, today).getYears();
        this.usia = umur;
        
        
        switch (golongan) {
            case "a":
            case "A":
                gajiPokok = 5000000;
                break;
            case "b":
            case "B":
                gajiPokok = 6000000;
                break;
            case "c":
            case "C":
                gajiPokok = 7000000;
                break;
        }
        
        
        switch(statusKar ){
            case 1 : 
                this.tunjanganKar = gajiPokok*10/100;
                this.StatusTunjanganKar = true;
                break;
        }
        
        switch(statusKar){
            case 1 :
                if(jumlahAnak>0){
                    tunjanganAnak = jumlahAnak*gajiPokok*5/100;
                    StatusTunjanganA = true;
                }
                break;
        }
        
        
        
        if(usia>30){
            tunjanganS = gajiPokok*15/100;
            StatusTunjanganP = true;
            
        }

        
        
        gajiKotor = gajiPokok + tunjanganKar + tunjanganS + tunjanganAnak;
        
        potongan = gajiKotor*25/1000;
  
        gajiAkhir = gajiKotor - potongan;
        
    }

    
    
    public void print(){
        System.out.println("=========================================================");
        System.out.println("                  DATA PROFIL KARYAWAN                   ");
        System.out.println("---------------------------------------------------------");

        System.out.println("Kode Karyawan           : " + idKar);
        System.out.println("Nama Karyawan           : " + namaKar);
        System.out.println("Golongan                : " + golongan);
        System.out.println("Usia                    : " + usia);

        // status menikah dan jumlah anak 
        switch( statusKar ){
            case 0 :
                System.out.println("Status Menikah          : Belum Menikah");
                System.out.println("---------------------------------------------------------");
                break;
            
            case 1 :
                System.out.println("Status Menikah          : Sudah Menikah");
                System.out.println("Jumlah Anak             : " + jumlahAnak);
                System.out.println("---------------------------------------------------------");
        }
        System.out.println("Gaji Pokok              : Rp" + gajiPokok);
        
        //pengecekan tunjangan
        if(StatusTunjanganKar){
            System.out.println("Tunjangan Suami/Istri   : Rp" + tunjanganKar );
        }if(StatusTunjanganP){
            System.out.println("Tunjangan Pegawai       : Rp" + tunjanganS);
        }if(StatusTunjanganA){
            System.out.println("Tunjangan Anak          : Rp" + tunjanganAnak); 
        }
        System.out.println("--------------------------------------------------------- +");
        System.out.println("Gaji Kotor              : Rp" + gajiKotor);
        System.out.println("Potongan                : Rp" + potongan);
        System.out.println("--------------------------------------------------------- -");
        System.out.println("Gaji Bersih             : Rp" + gajiAkhir);
    }
}
