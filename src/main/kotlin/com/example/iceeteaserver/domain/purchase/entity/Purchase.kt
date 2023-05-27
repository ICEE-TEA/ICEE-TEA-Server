package com.example.iceeteaserver.domain.purchase.entity

import com.example.iceeteaserver.domain.member.entity.Member
import com.example.iceeteaserver.global.entity.BaseUUIDEntity
import java.util.*
import javax.persistence.*


@Entity
class Purchase(
    @Column(name = "purchase_id")
    override val idx: UUID,
    @Column(name = "flavor")
    val flavor: String,
    @Column(name = "size")
    val size: Long,
    @Column(name = "pay")
    val pay: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    val member: Member
) : BaseUUIDEntity(idx)