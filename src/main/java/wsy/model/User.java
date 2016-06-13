package wsy.model;

import javax.persistence.*;
import java.security.Principal;
import java.util.Collection;

@Entity
public class User implements Principal {

    public static enum State {
        ACTIVE,
        INACTIVE
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private State state;

    @ManyToMany(cascade = CascadeType.ALL)
    private Collection<Authority> authorities;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private StudentProfile studentProfile;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private TeacherProfile teacherProfile;

    protected User() {}

    public User(String username, String password) {

        this.username = username;
        this.password = password;
        this.state = State.ACTIVE;
    }

    public String getName()
    {
        return username;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public Collection<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<Authority> authorities) {
        this.authorities = authorities;
    }


    public State getState()
    {
        return state;
    }

    public Long getId()
    {
        return id;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setStudentProfile(StudentProfile studentProfile)
    {
        this.studentProfile = studentProfile;
        if (studentProfile.getUser() == null)
            this.studentProfile.setUser(this);
    }

    public void setTeacherProfile(TeacherProfile teacherProfile)
    {
        this.teacherProfile = teacherProfile;
        if (teacherProfile.getUser() == null)
            teacherProfile.setUser(this);
    }

    public StudentProfile getStudentProfile()
    {
        return studentProfile;
    }

    public TeacherProfile getTeacherProfile()
    {
        return teacherProfile;
    }
}