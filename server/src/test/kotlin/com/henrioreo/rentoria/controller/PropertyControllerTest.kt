package com.henrioreo.rentoria.controller

import com.henrioreo.rentoria.model.Property
import com.henrioreo.rentoria.service.PropertyService
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.Optional
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PropertyControllerTest {
    private val propertyServiceMock: PropertyService = mockk()
    private val propertyController = PropertyController(propertyServiceMock)

    private val testProperty = Property(
            id = "1",
            type = "Condo",
            bedroom = 2,
            bathroom = 2,
            garage = 0,
            story = 1,
            size = 1900,
            community = "Downtown Bellevue")

    @BeforeEach
    fun init() = clearAllMocks()

    @Test
    fun `test get property by id api`() {
        every { propertyServiceMock.getPropertyById(any()) } returns Optional.of(testProperty)
        val property = propertyController.getPropertyById("1")
        assertTrue(property.isPresent)
        assertEquals(testProperty, property.get(), "Actual returned property is not the same with the expected one!")
    }

    @Test
    fun `test get property by type api`() {
        val expectedProperties = listOf(testProperty)
        every { propertyServiceMock.getPropertyByType(any()) } returns expectedProperties
        val properties = propertyController.getPropertyByType("Condo")
        assertEquals(expectedProperties.size, properties.size, "Actual returned property list is of the wrong size!")
        assertEquals(expectedProperties[0], properties[0], "Actual returned property list doesn't have the expected content")
    }

    @Test
    fun `test get all properties api`() {
        val expectedProperties = listOf(testProperty)
        every { propertyServiceMock.getAllProperties() } returns expectedProperties
        val properties = propertyController.getAllProperties()
        assertEquals(expectedProperties.size, properties.size, "Actual returned property list is of the wrong size!")
        assertEquals(expectedProperties[0], properties[0], "Actual returned property list doesn't have the expected content")
    }
}
