package ir.maktab.dao;

public interface CrudeRepository<T> {
    void save(T t);

    void update(T t);

    void softDelete(T t);

}
