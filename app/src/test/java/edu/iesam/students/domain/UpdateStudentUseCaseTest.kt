package edu.iesam.students.domain

import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class UpdateStudentUseCaseTest {

    @Test
    fun `when invoke then update student`() {
        val studentRepositoryMock = mockk<StudentRepository>(relaxed = true)
        val updateStudentUseCase = UpdateStudentUseCase(studentRepositoryMock)
        val student = Student("0001", "Alberto")

        updateStudentUseCase(student)

        verify(exactly = 1) { studentRepositoryMock.updateStudent(student) }
    }
}