package com.henry.rentoria.controller

import com.henry.rentoria.service.PropertyService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class PropertyController(@Qualifier("propertyService") val propertyService: PropertyService ) {

    @GetMapping("/property/id/{id}")
    fun getPropertyById(@PathVariable id:String) = propertyService.getPropertyById(id)

    @GetMapping("/property/type/{type}")
    fun getPropertyByType(@PathVariable type:String) = propertyService.getPropertyByType(type)

    @GetMapping("/property/all")
    fun getAllProperties() = propertyService.getAllProperties()
}