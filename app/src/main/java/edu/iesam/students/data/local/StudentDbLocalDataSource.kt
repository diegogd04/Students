package edu.iesam.students.data.local

import edu.iesam.students.domain.Student

class StudentDbLocalDataSource {

    private val dataSource: MutableMap<String, Student> = mutableMapOf()

    fun save(student: Student) {
        dataSource[student.exp] = student
    }
}