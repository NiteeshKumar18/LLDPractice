package DesignPatterns.CompositeFileDesignPattern;

public class Main {
    public static void main(String[] args) {
        DesignPatterns.CompositeFileDesignPattern.Directory directory = new DesignPatterns.CompositeFileDesignPattern.Directory("Movies");
        DesignPatterns.CompositeFileDesignPattern.File singleMovie = new File("husharu");
        DesignPatterns.CompositeFileDesignPattern.Directory directory2 = new DesignPatterns.CompositeFileDesignPattern.Directory("COmedy");
        DesignPatterns.CompositeFileDesignPattern.File singleMovie2 = new DesignPatterns.CompositeFileDesignPattern.File("1234");
        directory2.addFileSystem(singleMovie2);
        DesignPatterns.CompositeFileDesignPattern.Directory directory3 = new DesignPatterns.CompositeFileDesignPattern.Directory("Horror");
        directory2.addFileSystem(directory3);

        directory.addFileSystem(singleMovie);
        directory.addFileSystem(directory2);
        directory.ls();
    }
}
