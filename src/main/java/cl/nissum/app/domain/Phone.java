package cl.nissum.app.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A Phone.
 */
@Entity
@Table(name = "phone")
public class Phone implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Max(value = 11L)
    @Column(name = "number")
    private Long number;

    @Size(max = 10)
    @Column(name = "city_code", length = 10)
    private String cityCode;

    @Max(value = 10)
    @Column(name = "contry_code")
    private Integer contryCode;

    @ManyToOne
    @JsonIgnoreProperties("phones")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public Phone number(Long number) {
        this.number = number;
        return this;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getCityCode() {
        return cityCode;
    }

    public Phone cityCode(String cityCode) {
        this.cityCode = cityCode;
        return this;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public Integer getContryCode() {
        return contryCode;
    }

    public Phone contryCode(Integer contryCode) {
        this.contryCode = contryCode;
        return this;
    }

    public void setContryCode(Integer contryCode) {
        this.contryCode = contryCode;
    }

    public User getUser() {
        return user;
    }

    public Phone user(User user) {
        this.user = user;
        return this;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Phone)) {
            return false;
        }
        return id != null && id.equals(((Phone) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Phone{" +
            "id=" + getId() +
            ", number=" + getNumber() +
            ", cityCode='" + getCityCode() + "'" +
            ", contryCode=" + getContryCode() +
            "}";
    }
}
