package edu.iesam.students.domain

class UpdateStudentUseCase(private val studentRepository: StudentRepository) {

    operator fun invoke(student: Student) {
        studentRepository.updateStudent(student)
    }
}