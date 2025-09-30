package edu.iesam.students.domain

import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class DeleteStudentUseCaseTest {

    @Test
    fun `when invoke then delete student`() {
        val studentRepositoryMock = mockk<StudentRepository>(relaxed = true)
        val deleteStudentUseCase = DeleteStudentUseCase(studentRepositoryMock)
        val exp = "0001"

        deleteStudentUseCase(exp)

        verify(exactly = 1) { studentRepositoryMock.deleteStudent(exp) }
    }
}