package com.henry.rentoria.service

import com.henry.rentoria.model.Property
import com.henry.rentoria.repository.PropertyRepository
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class PropertyService(@Qualifier("propertyRepository") val propertyRepository: PropertyRepository) {

    fun getPropertyById(id: String): Optional<Property> = propertyRepository.findById(id)
    fun getPropertyByType(type: String): List<Property> = propertyRepository.findByType(type)
    fun getAllProperties(): List<Property> = propertyRepository.findAll()
}