package cl.nissum.app.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import cl.nissum.app.service.UserService;
import cl.nissum.app.service.dto.UserDTO;
import cl.nissum.app.web.rest.errors.BadRequestAlertException;
import cl.nissum.app.web.rest.util.HeaderUtil;
import cl.nissum.app.web.rest.util.PaginationUtil;
import cl.nissum.app.web.rest.util.ResponseUtil;

/**
 * REST controller for managing {@link cl.nissum.app.domain.User}.
 */
@RestController
@RequestMapping("/api")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(UserController.class);

    private static final String ENTITY_NAME = "user";

    //@Value("${nissum.clientApp.name}")
    private String applicationName;

    private final UserService usuarioService;

    public UserController(UserService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /**
     * {@code POST  /users} : Create a new User.
     *
     * @param usuarioDTO the userDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new userDTO, or with status {@code 400 (Bad Request)} if the usuario has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/users")
    public ResponseEntity<UserDTO> createUsuario(@Valid @RequestBody UserDTO usuarioDTO) throws URISyntaxException {
        log.debug("REST request to save Usuario : {}", usuarioDTO);
        if (usuarioDTO.getId() != null) {
            throw new BadRequestAlertException("A new usuario cannot already have an ID", ENTITY_NAME, "idexists");
        }
        UserDTO result = usuarioService.save(usuarioDTO);
        return ResponseEntity.created(new URI("/api/usuarios/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /users} : Updates an existing usuario.
     *
     * @param userDTO the UserDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated UserDTO,
     * or with status {@code 400 (Bad Request)} if the UserDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the UserDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/users")
    public ResponseEntity<UserDTO> updateUsuario(@Valid @RequestBody UserDTO usuarioDTO) throws URISyntaxException {
        log.debug("REST request to update Usuario : {}", usuarioDTO);
        if (usuarioDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        UserDTO result = usuarioService.save(usuarioDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, usuarioDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /users} : get all the users.
     *

     * @param pageable the pagination information.

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of usuarios in body.
     */
    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsuarios(Pageable pageable) {
        log.debug("REST request to get a page of Usuarios");
        Page<UserDTO> page = usuarioService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /users/:id} : get the "id" usuario.
     *
     * @param id the id of the usuarioDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the usuarioDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> getUsuario(@PathVariable Long id) {
        log.debug("REST request to get Usuario : {}", id);
        Optional<UserDTO> usuarioDTO = usuarioService.findOne(id);
        return ResponseUtil.wrapOrNotFound(usuarioDTO);
    }

    /**
     * {@code DELETE  /users/:id} : delete the "id" usuario.
     *
     * @param id the id of the usuarioDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        log.debug("REST request to delete Usuario : {}", id);
        usuarioService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
