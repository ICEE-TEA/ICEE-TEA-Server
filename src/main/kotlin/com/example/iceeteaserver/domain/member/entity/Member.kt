package com.example.iceeteaserver.domain.member.entity

import com.example.iceeteaserver.global.entity.BaseUUIDEntity
import com.example.iceeteaserver.global.role.Role
import java.util.*
import javax.persistence.*

@Entity
class Member(

    @Column(name = "member_idx")
    override val idx: UUID,

    @Column(name = "email")
    val email : String,

    @Column(name = "password")
    val password : String,

    @Column(name = "name")
    val name : String,

    @Enumerated(EnumType.STRING)
    val role: Role

) : BaseUUIDEntity(idx)