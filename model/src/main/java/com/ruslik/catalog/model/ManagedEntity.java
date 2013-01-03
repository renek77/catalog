package com.ruslik.catalog.model;

import org.hibernate.proxy.HibernateProxyHelper;

import javax.persistence.*;
import java.io.Serializable;


@MappedSuperclass
public abstract class ManagedEntity implements Serializable {

    public static final String ID_COLUMN = "id";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = ID_COLUMN)
    private Long id;

    /**
     * The id attribute used to uniquelly identify the instance of the subclass
     *
     * @return the unique id (primary key) of the instance
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter method which could not be used on attached objects as it would violate the session cache. Usage of this
     * method should be avoided as it could cause severe problems and inconsistent data.
     *
     * @param id which should be used as primary key on the instance
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Two entities are equal if they have equal ids and the same class
     * See http://onjava.com/pub/a/onjava/2006/09/13/dont-let-hibernate-steal-your-identity.html
     * See http://stackoverflow.com/questions/7132649/is-this-a-good-equals-hashcode-implementation
     */
    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!getClassWithoutProxy(this)
                .equals(getClassWithoutProxy(o))) {
            return false;
        }

        ManagedEntity other = (ManagedEntity) o;//NOSONAR
        // if the id is missing, return false
        if (id == null) {
            return false;
        }
        // equivalence by id
        return id.equals(other.getId());
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : super.hashCode();
    }

    /**
     * Get the class of an instance or the underlying class
     * of a proxy
     *
     * @param entity entity
     */
    public static Class<?> getClassWithoutProxy(Object entity) {
        return HibernateProxyHelper.getClassWithoutInitializingProxy(entity);
    }
}
