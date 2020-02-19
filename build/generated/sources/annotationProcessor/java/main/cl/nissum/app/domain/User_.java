package cl.nissum.app.domain;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, Instant> lastLogin;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, Instant> created;
	public static volatile SingularAttribute<User, String> name;
	public static volatile SingularAttribute<User, Instant> modified;
	public static volatile SetAttribute<User, Phone> phones;
	public static volatile SingularAttribute<User, Long> id;
	public static volatile SingularAttribute<User, Boolean> isActivated;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, String> token;

	public static final String LAST_LOGIN = "lastLogin";
	public static final String PASSWORD = "password";
	public static final String CREATED = "created";
	public static final String NAME = "name";
	public static final String MODIFIED = "modified";
	public static final String PHONES = "phones";
	public static final String ID = "id";
	public static final String IS_ACTIVATED = "isActivated";
	public static final String EMAIL = "email";
	public static final String TOKEN = "token";

}

