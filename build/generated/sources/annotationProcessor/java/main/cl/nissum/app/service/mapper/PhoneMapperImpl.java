package cl.nissum.app.service.mapper;

import cl.nissum.app.domain.Phone;
import cl.nissum.app.domain.User;
import cl.nissum.app.service.dto.PhoneDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-02-19T03:17:46-0300",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
@Component
public class PhoneMapperImpl implements PhoneMapper {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Phone> toEntity(List<PhoneDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Phone> list = new ArrayList<Phone>( dtoList.size() );
        for ( PhoneDTO phoneDTO : dtoList ) {
            list.add( toEntity( phoneDTO ) );
        }

        return list;
    }

    @Override
    public List<PhoneDTO> toDto(List<Phone> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<PhoneDTO> list = new ArrayList<PhoneDTO>( entityList.size() );
        for ( Phone phone : entityList ) {
            list.add( toDto( phone ) );
        }

        return list;
    }

    @Override
    public PhoneDTO toDto(Phone phone) {
        if ( phone == null ) {
            return null;
        }

        PhoneDTO phoneDTO = new PhoneDTO();

        phoneDTO.setUsuarioId( phoneUserId( phone ) );
        phoneDTO.setId( phone.getId() );
        phoneDTO.setNumber( phone.getNumber() );
        phoneDTO.setCityCode( phone.getCityCode() );
        phoneDTO.setContryCode( phone.getContryCode() );

        return phoneDTO;
    }

    @Override
    public Phone toEntity(PhoneDTO phoneDTO) {
        if ( phoneDTO == null ) {
            return null;
        }

        Phone phone = new Phone();

        phone.setUser( userMapper.fromId( phoneDTO.getUsuarioId() ) );
        phone.setId( phoneDTO.getId() );
        phone.setNumber( phoneDTO.getNumber() );
        phone.setCityCode( phoneDTO.getCityCode() );
        phone.setContryCode( phoneDTO.getContryCode() );

        return phone;
    }

    private Long phoneUserId(Phone phone) {
        if ( phone == null ) {
            return null;
        }
        User user = phone.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
