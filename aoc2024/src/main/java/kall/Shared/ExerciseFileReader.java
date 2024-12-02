package kall.Shared;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExerciseFileReader {
    private String _path;

    public ExerciseFileReader(String path) {
        this._path = path;
    }

    public String readAllText() throws Exception {
        Path qualifiedPath = Paths.get(_path);
        byte[] bytes = Files.readAllBytes(qualifiedPath);
        return new String(bytes);
    }

    public String[] readAllLines() throws Exception {
        String text = readAllText();
        String[] lines = text.split("\r\n");
        return lines;
    }
}
