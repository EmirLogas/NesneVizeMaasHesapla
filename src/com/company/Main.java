package com.company;

import java.util.Scanner;

public class Main {

    public static class personel {
        String personel_ad, personel_soyad;
        int cocuk_sayisi;
        double maas;// çocuk başına 42 tl
        int kacyilsonraki;
        public static boolean devam = true;

        public void zam_hesapla() {
            double eskimaas = maas;
            double zamlimaas = 0;
            for (int i = 0; i < kacyilsonraki; i++) {
                if (maas < 1000) {
                    maas += (maas * 3) / 100;
                } else if (maas >= 1000 && maas <= 2500) {
                    maas += (maas * 4) / 100;
                } else if (maas > 2500) {
                    maas += (maas * 5) / 100;
                }
            }
            maas += cocuk_sayisi * 42;
            zamlimaas = maas;
            yil_hesapla(eskimaas, zamlimaas);
        }

        public void yil_hesapla(double eskimaas, double zamlimaas) {
            int uygulamakapat = 0;
            System.out.println("Personel: " + personel_ad + " " + personel_soyad + ", Eski maaş: " + eskimaas + ", Yeni maaş: " + zamlimaas + ", Zam miktarı: " + (zamlimaas - eskimaas));
            System.out.println("uygulamadan çıkmak için 2, tekrar hesaplama için 1 giriniz.");
            Scanner scan = new Scanner(System.in);
            uygulamakapat = scan.nextInt();
            if (uygulamakapat == 1) {
                devam = true;
            } else {
                devam = false;
            }
        }
    }


    public static void main(String[] args) {
        while (personel.devam) {
            personel personel = new personel();
            Scanner scan = new Scanner(System.in);
            System.out.print("Personel Ad : ");
            personel.personel_ad = scan.next();
            System.out.println();
            System.out.print("Personel Soyad : ");
            personel.personel_soyad = scan.next();
            System.out.println();
            System.out.print("Personel Çocuk Sayısı : ");
            personel.cocuk_sayisi = scan.nextInt();
            System.out.println();
            System.out.print("Personel Maaşı : ");
            personel.maas = scan.nextInt();
            System.out.println();
            System.out.print("Kaç yıl sonraki maaş : ");
            personel.kacyilsonraki = scan.nextInt();
            System.out.println();
            personel.zam_hesapla();
        }
    }
}
