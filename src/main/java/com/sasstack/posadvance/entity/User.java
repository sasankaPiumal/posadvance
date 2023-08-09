package com.sasstack.posadvance.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_id",length = 45)
    private String userId;

    @Column(name = "email",length = 100)
    private String email;

    @Column(name = "full_name",length = 250)
    private String fullName;

    @Column(name = "password",length = 750)
    private String password;

    @Column(name = "is_account_non_expired",columnDefinition = "TINYINT")
    private boolean isAccountNonExpired;

    @Column(name = "is_account_non_locked",columnDefinition = "TINYINT")
    private boolean isAccountNonLocked;

    @Column(name = "is_credential_non_expired",columnDefinition = "TINYINT")
    private boolean isCredentialNonExpired;

    @Column(name = "is_enabled",columnDefinition = "TINYINT")
    private boolean isEnabled;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private Set<UserRoleHasUser> userRoleHasUsers;





}
