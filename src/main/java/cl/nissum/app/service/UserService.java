package cl.nissum.app.service;

import cl.nissum.app.service.dto.UserDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link cl.nissum.app.domain.User}.
 */
public interface UserService {

    /**
     * Save a usuario.
     *
     * @param usuarioDTO the entity to save.
     * @return the persisted entity.
     */
    UserDTO save(UserDTO usuarioDTO);

    /**
     * Get all the usuarios.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<UserDTO> findAll(Pageable pageable);


    /**
     * Get the "id" usuario.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<UserDTO> findOne(Long id);

    /**
     * Delete the "id" usuario.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    /**
     * search the "id" usuario.
     *
     * @param id the id of the entity.
     */
    boolean exists(Long id);
}
