package cl.nissum.app.service.mapper;

import cl.nissum.app.domain.*;
import cl.nissum.app.service.dto.UserDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Usuario} and its DTO {@link UsuarioDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UserMapper extends EntityMapper<UserDTO, User> {


    @Mapping(target = "phones", ignore = true)
    @Mapping(target = "removePhone", ignore = true)
    User toEntity(UserDTO usuarioDTO);

    default User fromId(Long id) {
        if (id == null) {
            return null;
        }
        User usuario = new User();
        usuario.setId(id);
        return usuario;
    }
}
