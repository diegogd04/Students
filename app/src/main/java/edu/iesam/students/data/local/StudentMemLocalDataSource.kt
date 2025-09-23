package edu.iesam.students.data.local

import edu.iesam.students.domain.Student

class StudentMemLocalDataSource {

    val dataSource: MutableMap<String, Student> = mutableMapOf()

    fun save(student: Student) {
        dataSource[student.exp] = student
    }

    fun getStudentList(): List<Student> {
        return dataSource.values.toList()
    }

    fun deleteStudent(exp: String) {
        dataSource.remove(exp)
    }

    fun updateStudent(student: Student) {
        dataSource[student.exp] = student
    }
}