package com.henry.rentoria.service

import com.henry.rentoria.repository.PropertyRepository
import io.mockk.clearAllMocks
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class PropertyServiceTest {
    private val propertyRepositoryMock: PropertyRepository = mockk()
    private val propertyService = PropertyService(propertyRepositoryMock)

    @BeforeEach
    fun init() = clearAllMocks()

    @Test
    fun `dummy test`() {
        assert(true)
    }
}