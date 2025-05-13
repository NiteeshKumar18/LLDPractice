package DesignPatterns.CompositeFileDesignPattern;

import TicTacToe.TicTacToe;

public class Main {
    public static void main(String[] args) {
        Directory directory = new Directory("Movies");
        File singleMovie = new File("husharu");
        Directory directory2 = new Directory("COmedy");
        File singleMovie2 = new File("1234");
        directory2.addFileSystem(singleMovie2);
        Directory directory3 = new Directory("Horror");
        directory2.addFileSystem(directory3);

        directory.addFileSystem(singleMovie);
        directory.addFileSystem(directory2);
        directory.ls();
    }
}
