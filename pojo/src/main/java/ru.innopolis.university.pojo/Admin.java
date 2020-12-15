package ru.innopolis.university.pojo;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Admin extends BaseUser {

    private static final long serialVersionUID = -7408697994794616999L;

    private final Set<Blog> responsibleBlogs = new HashSet<>();

    public Admin() {
        super();
        roles.add(Role.ADMIN);
        setCommentAllowed(true);
    }

    public Admin(Set<Blog> blogs) {
        super();
        if (null != blogs) {
            if (!blogs.isEmpty()) {
                responsibleBlogs.addAll(blogs);
            }
        }
        roles.add(Role.ADMIN);
        setCommentAllowed(true);
    }

    public Admin(String login, String name, int age, Collection<Role> roles) {
        super(login, name, age, roles);
        roles.add(Role.ADMIN);
        setCommentAllowed(true);
    }

    public Set<Blog> getResponsibleBlogs() {
        return responsibleBlogs;
    }

    public void addResponsibleBlog(Blog blog) {
        if (null != blog) {
            responsibleBlogs.add(blog);
        }
    }

    public void addResponsibleBlogs(Set<Blog> blogs) {
        if (null != blogs) {
            if (!blogs.isEmpty()) {
                responsibleBlogs.addAll(blogs);
            }
        }
    }

    public boolean removeResponsibleBlog(Blog blog) {
        if (null != blog) {
            return responsibleBlogs.remove(blog);
        }
        return false;
    }

    public boolean removeResponsibleBlogs(Set<Blog> blogs) {
        if (null != blogs) {
            return responsibleBlogs.removeAll(blogs);
        }
        return false;
    }
}
