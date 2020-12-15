package ru.innopolis.university.pojo;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ru.innopolis.university.util.IdGenerator;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public abstract class BaseUser implements Serializable, Comparable<BaseUser> {

    protected final String id;

    protected String login;

    protected String name;

    protected Integer age;

    protected boolean commentAllowed;

    protected final Set<Role> roles = new HashSet<>();

    protected final Set<Blog> subscriptions = new HashSet<>();

    public BaseUser() {
        id = String.valueOf(IdGenerator.getId());
        roles.add(Role.READER);
    }

    public BaseUser(String login, String name, int age, Collection<Role> roles) {
        if (Stream.of(login, name, age, roles).anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("null value not allowed to create user");
        }
        id = String.valueOf(IdGenerator.getId());
        this.login = login;
        this.name = name;
        this.age = age;
        this.roles.add(Role.READER);
        this.roles.addAll(roles);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public boolean isCommentAllowed() {
        return commentAllowed;
    }

    public void setCommentAllowed(boolean value) {
        commentAllowed = value;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void addRole(Role role) {
        if (null != role) {
            roles.add(role);
        }
    }

    public void addRoles(Set<Role> roles) {
        if (null != roles) {
            if (!roles.isEmpty()) {
                this.roles.addAll(roles);
            }
        }
    }

    public boolean removeRole(Role role) {
        if (null != role) {
            return roles.remove(role);
        }
        return false;
    }

    public boolean removeRoles(Set<Role> roles) {
        if (null != roles) {
            return this.roles.removeAll(roles);
        }
        return false;
    }

    public boolean checkRole(Role role) {
        if (null != role) {
            return roles.contains(role);
        }
        return false;
    }

    public Set<Blog> getSubscriptions() {
        return subscriptions;
    }

    public void addSubscription(Blog blog) {
        if (null != blog) {
            subscriptions.add(blog);
        }
    }

    public void addSubscriptions(Set<Blog> blogs) {
        if (null != blogs) {
            if (!blogs.isEmpty()) {
                subscriptions.addAll(blogs);
            }
        }
    }

    public boolean removeSubscription(Blog blog) {
        if (null != blog) {
            return subscriptions.remove(blog);
        }
        return false;
    }

    public boolean removeSubscriptions(Set<Blog> blogs) {
        if (null != blogs) {
            return subscriptions.removeAll(blogs);
        }
        return false;
    }

    @Override
    public int compareTo(BaseUser o) {
        int i = this.getLogin().compareTo(o.getLogin());
        if (i != 0) {
            return i;
        }

        i = this.getName().compareTo(o.getName());
        if (i != 0) {
            return i;
        }

        return Integer.compare(this.getAge(), o.getAge());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        BaseUser baseUser = (BaseUser) o;

        return new EqualsBuilder()
                .append(login, baseUser.login)
                .append(name, baseUser.name)
                .append(age, baseUser.age)
                .append(roles, baseUser.roles)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(login)
                .append(name)
                .append(age)
                .append(roles)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", roles=" + roles +
                '}';
    }
}
