package edu.iesam.students.domain

class GetStudentListUseCase(val studentRepository: StudentRepository) {

    operator fun invoke(): List<Student> {
        return studentRepository.getStudentList()
    }
}