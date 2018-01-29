package kz.java.training.dao;

public interface AbstractDao<T> {
	
	T findEntityById(int id);

	void deleteEntityById(int id);

	void insertEntity(T entity);
}
