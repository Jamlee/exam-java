package wsy.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class StudentProfile {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Integer timeOfEnrollment;

    @OneToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<StudentCourse> studentCourses;

    public void setStudentCourses(Collection<StudentCourse> studentCourses)
    {
        this.studentCourses = studentCourses;
        for (StudentCourse studentCourse : studentCourses) {
            if (studentCourse.getStudentProfile() == null)
                studentCourse.setStudentProfile(this);
        }
    }

    public Collection<StudentCourse> getStudentCourses()
    {
        return studentCourses;
    }

    public void setUser(User user)
    {
        this.user = user;
        if (user.getStudentProfile() != null)
            this.user.setStudentProfile(this);
    }

    public User getUser()
    {
        return user;
    }
}
