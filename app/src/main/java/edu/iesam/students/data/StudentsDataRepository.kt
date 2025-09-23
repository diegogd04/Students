package edu.iesam.students.data

import edu.iesam.students.data.local.StudentMemLocalDataSource
import edu.iesam.students.data.local.StudentXmlLocalDataSource
import edu.iesam.students.data.remote.StudentApiRemoteDataSource
import edu.iesam.students.domain.Student
import edu.iesam.students.domain.StudentRepository

class StudentsDataRepository(
    private val xmlLocalDataSource: StudentXmlLocalDataSource,
    private val memLocalDataSource: StudentMemLocalDataSource,
    private val apiRemoteDataSource: StudentApiRemoteDataSource
) : StudentRepository {

    override fun save(student: Student) {
        memLocalDataSource.save(student)
    }

    override fun getStudentList(): List<Student> {
        return memLocalDataSource.getStudentList()
    }

    override fun deleteStudent(exp: String) {
        memLocalDataSource.deleteStudent(exp)
    }

    override fun updateStudent(student: Student) {
        memLocalDataSource.updateStudent(student)
    }
}