package dao;

import java.util.ArrayList;

public interface IOperaciones<T> {
    public void create();
    public ArrayList<T> read();
    public void update(T t);
    public void delete(T t);
}
