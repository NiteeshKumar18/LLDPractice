package DesignPatterns.CompositeFileDesignPattern;

public class File implements FileSystem {

    private final String name;

    public File(String nameLocal) {
        this.name = nameLocal;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void ls() {
        System.out.println(this.name);
    }
}
