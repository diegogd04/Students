package edu.iesam.students.domain

class SaveStudentUseCase(val studentRepository: StudentRepository) {

    operator fun invoke(student: Student) {
        studentRepository.save(student)
    }
}