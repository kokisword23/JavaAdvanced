package app.appenders.file;

public interface File {

    void write(String message);

    int getSize();
}
