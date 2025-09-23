package edu.iesam.students.domain

class DeleteStudentUseCase(private val studentRepository: StudentRepository) {

    operator fun invoke(exp: String) {
        studentRepository.deleteStudent(exp)
    }

}