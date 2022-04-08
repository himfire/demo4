package com.example.demo4.persistances.model.user;

import com.example.demo4.persistances.model.language.Language;
import com.example.demo4.persistances.model.role.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String username;

    @Column
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column
    private String summary;

    @UpdateTimestamp
    @Column(name = "password_modified_date",length = 10)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate passwordModifiedDate;

    @Column
    private String phone;

    @Column
    private String address1;

    @Column
    private String address2;

    @Column
    private String address3;

    @CreationTimestamp
    @Column(name = "created_date",length = 10)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate createDate;

    @Column(name = "modified_date",length = 10)
    @LastModifiedDate
    private LocalDate modifiedDate;

    @Column(name = "email_verified",length = 4)
    private Long emailAddressVerified;

    @UpdateTimestamp
    @Column(name = "last_login_date",length = 10)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate lastLoginDate;

    @Column(name = "loginIP",length = 30)
    private String loginIP;

    @Column(name = "failed_attemps",length = 4)
    private Long failedLoginAttempts;

    @ManyToMany(targetEntity = Language.class)
    @JoinTable(name = "user_languages",
            joinColumns = @JoinColumn(name = "user_Id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "language_id", referencedColumnName = "id")
    )
    private Set<Language> languages;

    @ManyToMany(targetEntity = Role.class)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    //user,teacher,employee,admin
    private Set<Role> roles;
}
