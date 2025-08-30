package com.school.sptech;

public class Main {
    public static void main(String[] args) {
        Biblioteca b1 = new Biblioteca("Central", 2.5);
        b1.registrarLivro(10);
        b1.emprestar(4);
        System.out.println(b1.getQtdLivros());
}
}
