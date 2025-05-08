/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.system_kasir;

/**
 *
 * @author Zulfa Arifqi
 */

import java.util.Scanner;

public class System_Kasir {

    public static void main(String[] args) {
        UserOperation userOp = new LibrarySystem();
        ProductOperation productOp = (ProductOperation) userOp;
        TransaksiOperation transOp = (TransaksiOperation) userOp;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (userOp.login(username, password)) {
            System.out.println("Login berhasil!");

            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Lihat Produk");
                System.out.println("2. Beli Produk");
                System.out.println("3. Lihat Riwayat");
                System.out.println("4. Keluar");
                System.out.print("Pilih: ");
                int pilihan = scanner.nextInt();

                switch (pilihan) {
                    case 1:
                        System.out.println("Daftar Produk:");
                        var produkList = productOp.getAllProducts();
                        for (int i = 0; i < produkList.size(); i++) {
                            System.out.println((i + 1) + ". " + produkList.get(i));
                        }
                        break;
                    case 2:
                        var produkList2 = productOp.getAllProducts();
                        for (int i = 0; i < produkList2.size(); i++) {
                            System.out.println((i + 1) + ". " + produkList2.get(i));
                        }
                        System.out.print("Pilih nomor produk: ");
                        int index = scanner.nextInt() - 1;
                        transOp.beliProduk(index);
                        break;
                    case 3:
                        transOp.tampilkanRiwayat();
                        break;
                    case 4:
                        System.out.println("Keluar...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            }
        } else {
            System.out.println("Login gagal.");
        }

        scanner.close();
    }
}

