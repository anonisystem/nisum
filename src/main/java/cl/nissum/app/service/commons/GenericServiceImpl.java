package cl.nissum.app.service.commons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class GenericServiceImpl<T, ID extends Serializable> implements IGenericService<T, ID> {

	public abstract JpaRepository<T, ID> getRepository();

	@Override
	public T save(T dto) {
		return getRepository().save(dto);
	}

	@Override
	public List<T> findAll() {
		List<T> returnList = new ArrayList<>();
		getRepository().findAll().forEach(Obj -> returnList.add(Obj));
		return (List<T>) returnList;

	}

	@Override
	public Optional<T> findOne(ID id) {
		Optional<T> obj = getRepository().findById(id);
/* 		if (obj.isPresent()) {
			o = obj.get();
		} */
		return obj;
	}

	@Override
	public Boolean exists(ID id) {
		return getRepository().existsById(id);
	}

	public void delete(ID id) {
		getRepository().deleteById(id);
	}
	
	@Override
	public T update(T dto) {
		return getRepository().save(dto);
	}
}
