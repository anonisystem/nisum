package cl.nissum.app.service.dto;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link cl.nissum.app.domain.Phone} entity.
 */
public class PhoneDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @Max(value = 11L)
    private Long number;

    @Size(max = 10)
    private String cityCode;

    @Max(value = 10)
    private Integer contryCode;


    private Long usuarioId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public Integer getContryCode() {
        return contryCode;
    }

    public void setContryCode(Integer contryCode) {
        this.contryCode = contryCode;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PhoneDTO phoneDTO = (PhoneDTO) o;
        if (phoneDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), phoneDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PhoneDTO{" +
            "id=" + getId() +
            ", number=" + getNumber() +
            ", cityCode='" + getCityCode() + "'" +
            ", contryCode=" + getContryCode() +
            ", usuarioId=" + getUsuarioId() +
            "}";
    }
}
