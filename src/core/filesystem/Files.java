package core.filesystem;

public class Files {

    private static FileSystem fileSystem;

    void setup(FileSystem fileSystem) {
        Files.fileSystem = fileSystem;
    }

    public static ImageDimensions getImageDimensions(String imageName) {
        return fileSystem.getImageDimensions(imageName);
    }

}
