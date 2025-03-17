package app.trekz.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Table(name = "users")
@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(unique = true, length = 100, nullable = false)
    @Pattern(
            regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
            message = "Invalid email"
    )
    private String email;

    @Column(length = 100, nullable = false)
    @Size(min = 8, max = 50, message = "Password must be between 8 and 50 characters")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character"
    )
    private String password;

    @Column(length = 100)
    @Size(min = 1, max = 100, message = "First name must be between 1 and 100 characters")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "Birthdate is required")
    @Past(message = "Birthdate must be in the past")
    private Date birthday;

    @CreationTimestamp
    @Column(nullable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(nullable = false, name= "updated_at")
    private Date updatedAt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return List.of();
    }

    public String getPassword(){
        return password;
    }

    @Override
    public String getUsername(){
        return email;
    }

    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override
    public boolean isEnabled(){
        return true;
    }

    //  Getters and Setters

    // ID
    public Integer getId(){
        return id;
    }

    // email
    public String getEmail(){
        return email;
    }


    public void setEmail(String email){
        this.email = email;
    }

    // password
    public void setPassword(String password){
        this.password = password;
    }

    // name
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    //birthdate
    public Date getBirthday(){
        return birthday;
    }

    public void setBirthday(Date birthday){
        this.birthday = birthday;
    }

    // created at
    public Date getCreatedAt() {
        return createdAt;
    }

    // updated at
    public Date getUpdatedAt() {
        return updatedAt;
    }
}
