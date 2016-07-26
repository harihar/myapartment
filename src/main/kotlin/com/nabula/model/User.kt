package com.nabula.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
class User() : BaseAuditEntity() {
    @Id @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    var id: Long = 0

    @Column(unique = true, nullable = false)
    lateinit var username: String

    @Column(nullable = false)
    lateinit var password: String

    @Column(unique = true, nullable = false)
    lateinit var mobileNumber: String

    @Column(unique = true, nullable = false)
    lateinit var emailId: String

    @Column(nullable = false)
    var firstName: String = ""

    @Column(nullable = false)
    var lastName: String = ""

    @Enumerated(javax.persistence.EnumType.STRING)
    lateinit var gender: Gender

    @OneToOne
    @JoinColumn(name = "adr_id")
    var address: Address? = null

    var isEnabled: Boolean = false
    var isLocked: Boolean = true
}