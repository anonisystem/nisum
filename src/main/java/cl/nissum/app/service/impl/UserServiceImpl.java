package cl.nissum.app.service.impl;

import cl.nissum.app.service.UserService;
import cl.nissum.app.domain.User;
import cl.nissum.app.repository.UserRepository;
import cl.nissum.app.service.dto.UserDTO;
import cl.nissum.app.service.mapper.UserMapper;
import cl.nissum.app.web.rest.errors.EmailAlreadyUsedException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

/**
 * Service Implementation for managing {@link Usuario}.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository usuarioRepository;

    private final UserMapper usuarioMapper;

   // private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository usuarioRepository, 
        UserMapper usuarioMapper
   // ,PasswordEncoder passwordEncoder
    ) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
       // this.passwordEncoder=  passwordEncoder;
    }

    /**
     * Save a usuario.
     *
     * @param usuarioDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public UserDTO save(UserDTO usuarioDTO) {
        log.debug("Request to save Usuario : {}", usuarioDTO);
        //validate exists email user
        usuarioRepository.findOneByEmailIgnoreCase(usuarioDTO.getEmail()).ifPresent(existingUser -> {
            throw new EmailAlreadyUsedException();
        });
        // new user is active
        usuarioDTO.setIsActivated(true);
        // new user token generator
        usuarioDTO.setToken(UUID.randomUUID().toString());
        //String encryptedPassword = passwordEncoder.encode(usuarioDTO.getPassword());
        User usuario = usuarioMapper.toEntity(usuarioDTO);
      //  usuario.setPassword(encryptedPassword);
        usuario = usuarioRepository.save(usuario);
        return usuarioMapper.toDto(usuario);
    }

    /**
     * Get all the usuarios.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<UserDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Usuarios");
        return usuarioRepository.findAll(pageable)
            .map(usuarioMapper::toDto);
    }


    /**
     * Get one usuario by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<UserDTO> findOne(Long id) {
        log.debug("Request to get Usuario : {}", id);
        return usuarioRepository.findById(id)
            .map(usuarioMapper::toDto);
    }

    /**
     * Delete the usuario by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Usuario : {}", id);
        usuarioRepository.deleteById(id);
    }
    /**
     * Search the user by id
     */
    @Override
    public boolean exists(Long id) {
        return usuarioRepository.existsById(id);
    }
}
