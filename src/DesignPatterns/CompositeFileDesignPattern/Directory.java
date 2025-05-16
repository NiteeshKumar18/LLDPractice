package DesignPatterns2.CompositeFileDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {

    private final String directoryName;

    private List<FileSystem> fileSystemList;

    public Directory(String name) {
        this.directoryName = name;
        this.fileSystemList = new ArrayList<>();
    }

    public void addFileSystem(FileSystem fileSystem) {
        List<FileSystem> fileSystemsLocal = this.fileSystemList;
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
