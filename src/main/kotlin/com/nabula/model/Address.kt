package com.nabula.model

import javax.persistence.*

/**
 * Created by harihar on 15/07/16.
 */

@Entity
class Address(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long,
        @ManyToOne
        @JoinColumn(name = "city_code")
        var city: City,
        var street: String,
        var houseNumber: String,
        var state: String,
        var pinCode: String,
        var country: String
) : BaseAuditEntity()