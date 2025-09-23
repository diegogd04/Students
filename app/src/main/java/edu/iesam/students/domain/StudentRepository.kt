package edu.iesam.students.domain

interface StudentRepository {

    fun save(student: Student)
    fun getStudentList(): List<Student>
    fun deleteStudent(exp: String)
    fun updateStudent(student: Student)
}