package com.henrioreo.rentoria.repository

import com.henrioreo.rentoria.model.Property
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface PropertyRepository:MongoRepository<Property, String> {
    override fun findById(id: String): Optional<Property>
    override fun findAll(): MutableList<Property>
    fun findByType(type: String): List<Property>
}