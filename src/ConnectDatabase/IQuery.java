package ConnectDatabase;

import java.util.List;

public interface IQuery<T> {
    public void insert(T t);

    public void update(T t);

    public void delete(T t);

    public T select(int id);

    public List<T> selectAll();
}
