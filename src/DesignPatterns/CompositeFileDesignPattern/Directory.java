package DesignPatterns.CompositeFileDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Directory implements DesignPatterns.CompositeFileDesignPattern.FileSystem {

    private final String directoryName;

    private List<DesignPatterns.CompositeFileDesignPattern.FileSystem> fileSystemList;

    public Directory(String name) {
        this.directoryName = name;
        this.fileSystemList = new ArrayList<>();
    }

    public void addFileSystem(DesignPatterns.CompositeFileDesignPattern.FileSystem fileSystem) {
        List<DesignPatterns.CompositeFileDesignPattern.FileSystem> fileSystemsLocal = this.fileSystemList;
        fileSystemsLocal.add(fileSystem);
        this.fileSystemList = fileSystemsLocal;
    }

    @Override
    public void ls() {
        System.out.println("Getting to the directory " + this.directoryName);

        for (FileSystem fileSystem : fileSystemList) {
            fileSystem.ls();
        }
    }
}
