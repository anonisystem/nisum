package cl.nissum.app.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Phone.class)
public abstract class Phone_ {

	public static volatile SingularAttribute<Phone, Long> number;
	public static volatile SingularAttribute<Phone, String> cityCode;
	public static volatile SingularAttribute<Phone, Long> id;
	public static volatile SingularAttribute<Phone, User> user;
	public static volatile SingularAttribute<Phone, Integer> contryCode;

	public static final String NUMBER = "number";
	public static final String CITY_CODE = "cityCode";
	public static final String ID = "id";
	public static final String USER = "user";
	public static final String CONTRY_CODE = "contryCode";

}

