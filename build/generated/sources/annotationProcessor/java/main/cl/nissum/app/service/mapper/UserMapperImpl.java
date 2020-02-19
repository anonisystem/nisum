package cl.nissum.app.service.mapper;

import cl.nissum.app.domain.Phone;
import cl.nissum.app.domain.User;
import cl.nissum.app.service.dto.PhoneDTO;
import cl.nissum.app.service.dto.UserDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-02-19T03:17:46-0300",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( entity.getId() );
        userDTO.setName( entity.getName() );
        userDTO.setEmail( entity.getEmail() );
        userDTO.setPassword( entity.getPassword() );
        userDTO.setIsActivated( entity.isIsActivated() );
        userDTO.setToken( entity.getToken() );
        userDTO.setLastLogin( entity.getLastLogin() );
        userDTO.setCreated( entity.getCreated() );
        userDTO.setModified( entity.getModified() );
        userDTO.setPhones( phoneSetToPhoneDTOSet( entity.getPhones() ) );

        return userDTO;
    }

    @Override
    public List<User> toEntity(List<UserDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( dtoList.size() );
        for ( UserDTO userDTO : dtoList ) {
            list.add( toEntity( userDTO ) );
        }

        return list;
    }

    @Override
    public List<UserDTO> toDto(List<User> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( entityList.size() );
        for ( User user : entityList ) {
            list.add( toDto( user ) );
        }

        return list;
    }

    @Override
    public User toEntity(UserDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( usuarioDTO.getId() );
        user.setName( usuarioDTO.getName() );
        user.setEmail( usuarioDTO.getEmail() );
        user.setPassword( usuarioDTO.getPassword() );
        user.setIsActivated( usuarioDTO.isIsActivated() );
        user.setToken( usuarioDTO.getToken() );
        user.setLastLogin( usuarioDTO.getLastLogin() );
        user.setCreated( usuarioDTO.getCreated() );
        user.setModified( usuarioDTO.getModified() );

        return user;
    }

    protected PhoneDTO phoneToPhoneDTO(Phone phone) {
        if ( phone == null ) {
            return null;
        }

        PhoneDTO phoneDTO = new PhoneDTO();

        phoneDTO.setId( phone.getId() );
        phoneDTO.setNumber( phone.getNumber() );
        phoneDTO.setCityCode( phone.getCityCode() );
        phoneDTO.setContryCode( phone.getContryCode() );

        return phoneDTO;
    }

    protected Set<PhoneDTO> phoneSetToPhoneDTOSet(Set<Phone> set) {
        if ( set == null ) {
            return null;
        }

        Set<PhoneDTO> set1 = new HashSet<PhoneDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Phone phone : set ) {
            set1.add( phoneToPhoneDTO( phone ) );
        }

        return set1;
    }
}
