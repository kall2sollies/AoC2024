package kall.Shared;

public abstract class BaseExercise {
    private String[] _lines;

    public String[] getLines() {
        return _lines;
    }

    public BaseExercise(String path) throws Exception {
        _lines = new ExerciseFileReader(path).readAllLines();
    }

    protected abstract String run() throws Exception;
}
