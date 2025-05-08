/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system_kasir;

/**
 *
 * @author Zulfa Arifqi
 */
import java.util.ArrayList;
import java.util.List;

public class LibrarySystem implements UserOperation, ProductOperation, TransaksiOperation {
    private List<Product> produkList;
    private List<Product> riwayatTransaksi;

    public LibrarySystem() {
        produkList = new ArrayList<>();
        riwayatTransaksi = new ArrayList<>();

        // Contoh data produk
        produkList.add(new Product("Kopi", 15000));
        produkList.add(new Product("Teh", 10000));
        produkList.add(new Product("Roti", 12000));
    }

    @Override
    public boolean login(String username, String password) {
        // Login sederhana
        return username.equals("admin") && password.equals("admin");
    }

    @Override
    public List<Product> getAllProducts() {
        return produkList;
    }

    @Override
    public void beliProduk(int index) {
        if (index >= 0 && index < produkList.size()) {
            Product produk = produkList.get(index);
            riwayatTransaksi.add(produk);
            System.out.println("Berhasil membeli: " + produk);
        } else {
            System.out.println("Produk tidak valid.");
        }
    }

    @Override
    public void tampilkanRiwayat() {
        if (riwayatTransaksi.isEmpty()) {
            System.out.println("Belum ada transaksi.");
        } else {
            System.out.println("Riwayat Transaksi:");
            for (Product produk : riwayatTransaksi) {
                System.out.println("- " + produk);
            }
        }
    }
}

