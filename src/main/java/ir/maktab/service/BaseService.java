package ir.maktab.service;

public interface BaseService<T> {
    void save(T t);

    void update(T t);
}
