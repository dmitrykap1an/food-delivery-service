package com.example.foodservice.domain.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "Address")
class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var addressId: Int? = null
    lateinit var address: String
}