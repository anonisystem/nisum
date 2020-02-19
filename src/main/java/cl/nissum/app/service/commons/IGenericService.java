package cl.nissum.app.service.commons;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface IGenericService<T, ID extends Serializable> {

	T save(T dto);

	List<T> findAll();

	Optional<T> findOne(ID id);

	void delete(ID id);

	Boolean exists(ID id);
	
	T update(T dto);

}
