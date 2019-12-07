package JavaSpringTest.model;

import javax.persistence.*;

@Entity
@Table(name = "usr_info")
public class UserInfo {
    @Id
    @Column(name = "user_info_id")
    private int id;
    private String name;
    private String lastname;
    private Integer age;
    @OneToOne(mappedBy = "info")
    private User user;
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
}
