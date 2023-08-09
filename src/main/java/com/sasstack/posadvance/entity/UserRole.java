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
@Table(name = "user_role")
public class UserRole {

    @Id
    @Column(name = "role_id",length = 45)
    private String roleId;

    @Column(name = "role_name",length = 45,unique = true)
    private String roleName;

    @Column(name = "description",length = 250)
    private String description;

    @OneToMany(mappedBy = "userRole",fetch = FetchType.LAZY)
    private Set<UserRoleHasUser> userRoleHasUsers;
}
