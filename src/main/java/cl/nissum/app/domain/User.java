package cl.nissum.app.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//import cl.nissum.app.config.Constants;

/**
 * A user.
 */
@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User 
//extends AbstractBaseEntity 
implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @CreatedDate
    @Column(name = "created", updatable = false)
    @JsonIgnore
    private Instant created = Instant.now();

    @LastModifiedDate
    @Column(name = "modified")
    @JsonIgnore
    private Instant modified= Instant.now();

    @NotNull
    @Size(max = 50)
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Email
    @Size(min = 5, max = 254)
    @Column(name = "email",length = 254, unique = true)
    private String email;

    @JsonIgnore
    @NotNull
    @Size(min = 6, max = 60)
    @Column(name = "password", length = 60, nullable = false)
    private String password;

    @NotNull
    @Column(name = "is_activated",nullable = false)
    private boolean isActivated = false;

    @Size(max = 60)
    @Column(name = "token", length = 60)
    @JsonIgnore
    private String token;

    @Column(name = "last_login")
    private Instant lastLogin = Instant.now();

    @OneToMany(mappedBy = "user")
    private Set<Phone> phones = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public User name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public User email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public User password(String password) {
        this.password = password;
        return this;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean isIsActivated() {
        return isActivated;
    }

    public User isActivated(Boolean isActivated) {
        this.isActivated = isActivated;
        return this;
    }

    public void setIsActivated(Boolean isActivated) {
        this.isActivated = isActivated;
    }

    public String getToken() {
        return token;
    }

    public User token(String token) {
        this.token = token;
        return this;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Instant getLastLogin() {
        return lastLogin;
    }

    public User lastLogin(Instant lastLogin) {
        this.lastLogin = lastLogin;
        return this;
    }

    public void setLastLogin(Instant lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Instant getCreated() {
        return created;
    }

    public User created(Instant createdDate) {
        this.created = createdDate;
        return this;
    }

    public void setCreated(Instant createdDate) {
        this.created = createdDate;
    }

    public Instant getModified() {
        return modified;
    }

    public User modified(Instant createdDate) {
        this.modified = createdDate;
        return this;
    }

    public void setModified(Instant modifiedDate) {
        this.modified = modifiedDate;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public User phones(Set<Phone> phones) {
        this.phones = phones;
        return this;
    }

    public User addPhone(Phone phone) {
        this.phones.add(phone);
        phone.setUser(this);
        return this;
    }

    public User removePhone(Phone phone) {
        this.phones.remove(phone);
        phone.setUser(null);
        return this;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        return id != null && id.equals(((User) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "User{" +
        "id=" + getId() +
        ", name='" + getName() + "'" +
        ", email='" + getEmail() + "'" +
       // ", password='" + getPassword() + "'" +
        ", isActivated='" + isIsActivated() + "'" +
        ", token='" + getToken() + "'" +
        ", lastLogin='" + getLastLogin() + "'" +
            "}";
    }


    /*     public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    } */


     /*   @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "user_authority",
        joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "name")})
    @BatchSize(size = 20)
    private Set<Authority> authorities = new HashSet<>(); */

 /*    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = UUID.randomUUID().toString();
    } */
}
