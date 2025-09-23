package edu.iesam.students.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import edu.iesam.students.domain.DeleteStudentUseCase
import edu.iesam.students.domain.GetStudentListUseCase
import edu.iesam.students.domain.SaveStudentUseCase
import edu.iesam.students.domain.Student
import edu.iesam.students.domain.UpdateStudentUseCase

class StudentsViewModel(
    private val saveStudentUseCase: SaveStudentUseCase,
    private val getStudentListUseCase: GetStudentListUseCase,
    private val deleteStudentUseCase: DeleteStudentUseCase,
    private val updateStudentUseCase: UpdateStudentUseCase
) {

    private val _uiState = MutableLiveData<List<Student>>()
    val uiState: LiveData<List<Student>> = _uiState


    fun saveClicked(exp: String, name: String) {
        saveStudentUseCase.invoke(Student(exp, name))
    }

    fun getStudentList() {
        val list = getStudentListUseCase.invoke()
        _uiState.value = list
    }

    fun deleteStudent(exp: String) {
        deleteStudentUseCase.invoke(exp)
    }

    fun updateStudent(student: Student) {
        updateStudentUseCase.invoke(student)
    }
}