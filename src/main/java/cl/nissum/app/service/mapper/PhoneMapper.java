package cl.nissum.app.service.mapper;

import cl.nissum.app.domain.*;
import cl.nissum.app.service.dto.PhoneDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Phone} and its DTO {@link PhoneDTO}.
 */
@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface PhoneMapper extends EntityMapper<PhoneDTO, Phone> {

    @Mapping(source = "user.id", target = "usuarioId")
    PhoneDTO toDto(Phone phone);

    @Mapping(source = "usuarioId", target = "user")
    Phone toEntity(PhoneDTO phoneDTO);

    default Phone fromId(Long id) {
        if (id == null) {
            return null;
        }
        Phone phone = new Phone();
        phone.setId(id);
        return phone;
    }
}
