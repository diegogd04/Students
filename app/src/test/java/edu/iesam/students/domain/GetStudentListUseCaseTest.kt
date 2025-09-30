package edu.iesam.students.domain

import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class GetStudentListUseCaseTest {

    @Test
    fun `when invoke then return student list`() {

        val studentRepositoryMock = mockk<StudentRepository>(relaxed = true)
        val getStudentListUseCase = GetStudentListUseCase(studentRepositoryMock)

        getStudentListUseCase()

        verify(exactly = 1) { studentRepositoryMock.getStudentList() }
    }
}