package repository;

public abstract class DBconnection {
    protected String URL = "jdbc:sqlite:identifier.sqlite";
    public abstract void fetchData();
    public abstract void putData();
    public abstract  void deleteData();
    public abstract void update();

}
