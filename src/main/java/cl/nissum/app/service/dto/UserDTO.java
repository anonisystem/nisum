package cl.nissum.app.service.dto;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import cl.nissum.app.config.Constants;
import cl.nissum.app.domain.User;
import io.swagger.annotations.ApiModel;

/**
 * A DTO representing a user, with his authorities.
 * for the {@link cl.nisum.app.domain.User} entity.
 */
@ApiModel(description = "Una clase que representa los Usuarios de Nissum\nDatos: Se cargan Algunos por Defecto\nClass User.\n@author Nisum\n@version 1.0")
public class UserDTO {

    private Long id;

    @NotNull(message = "Nombre del Usuario No Puede ser null")
    @Size(max = 50,  message = "El Nombre del Usuario debe tener maximo 50 Caracteres")
    @Pattern(regexp = Constants.NAME_REGEX ,message = "Nombre Usuario Solo Letras y Espacio")
    private String name;

    @Email
    @Size(min = 5, max = 254)
    private String email;

    @Size(min = 5, max = 60,message = "Contraseña del Usuario debe tener minimo 5 y maximo 60 Caracteres")
    @NotNull(message = "Contraseña del Usuario No Puede ser null")
   // @Pattern(regexp = Constants.PASSWORD_REGEX ,message = "Contraseña del Usuario debe tener Una Mayuscula, letras minúsculas, y dos numeros)")
    private String password;

    private Boolean isActivated;

    @Size(max = 60)
    private String token;

    private Instant lastLogin;

    private Instant created;

    private Instant modified;

    private Set<PhoneDTO> phones = new HashSet<>();

    public UserDTO() {
        // Empty constructor needed for Jackson.
    } 

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.isActivated = user.isIsActivated();
        this.token = user.getToken();
        this.lastLogin = user.getLastLogin();
        this.created = user.getCreated();
        this.modified = user.getModified();
     /*   this.authorities = user.getAuthorities().stream()
            .map(Authority::getName)
            .collect(Collectors.toSet()); */
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean isIsActivated() {
        return isActivated;
    }

    public void setIsActivated(Boolean isActivated) {
        this.isActivated = isActivated;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Instant getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Instant lastLogin) {
        this.lastLogin = lastLogin;
    }
    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public Set<PhoneDTO> getPhones() {
        return phones;
    }

    public void setPhones(Set<PhoneDTO> phones) {
        this.phones = phones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserDTO usuarioDTO = (UserDTO) o;
        if (usuarioDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), usuarioDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "UserDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
           // ", password='" + getPassword() + "'" +
            ", isActivated='" + isIsActivated() + "'" +
            ", token='" + getToken() + "'" +
            ", lastLogin='" + getLastLogin() + "'" +
            ", createdDate=" + getCreated() +
            ", lastModifiedDate=" + getModified() +
          //  ", authorities=" + authorities +
            "}";
    }

/* 
 

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    } */
 

}
