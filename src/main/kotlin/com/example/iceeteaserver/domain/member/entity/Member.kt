package com.example.iceeteaserver.domain.member.entity

import com.example.iceeteaserver.global.entity.BaseIdEntity
import com.example.iceeteaserver.global.role.Role
import javax.persistence.*

@Entity
class Member(
    @Column(name = "email")
    val email : String,

    @Column(name = "password")
    val password : String,

    @Column(name = "name")
    val name : String,

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Role")
    val role: MutableList<Role>,
) : BaseIdEntity()