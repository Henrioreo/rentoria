package com.henrioreo.rentoria.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("properties")
data class Property(
    @Id
    val id:String,
    val type:String,
    val bedroom:Short,
    val bathroom:Short,
    val garage:Short,
    val story:Short,
    val size:Short,
    val community:String)