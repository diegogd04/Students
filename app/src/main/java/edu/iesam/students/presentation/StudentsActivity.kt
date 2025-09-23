package edu.iesam.students.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import edu.iesam.students.R
import edu.iesam.students.data.StudentsDataRepository
import edu.iesam.students.data.local.StudentMemLocalDataSource
import edu.iesam.students.data.local.StudentXmlLocalDataSource
import edu.iesam.students.data.remote.StudentApiRemoteDataSource
import edu.iesam.students.domain.DeleteStudentUseCase
import edu.iesam.students.domain.GetStudentListUseCase
import edu.iesam.students.domain.SaveStudentUseCase
import edu.iesam.students.domain.Student
import edu.iesam.students.domain.UpdateStudentUseCase

class StudentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initStudents()
    }

    fun initStudents() {
        val xml = StudentXmlLocalDataSource()
        val mem = StudentMemLocalDataSource()
        val api = StudentApiRemoteDataSource()
        val dataRepository = StudentsDataRepository(xml, mem, api)
        val saveStudentUseCase = SaveStudentUseCase(dataRepository)
        val getStudentList = GetStudentListUseCase(dataRepository)
        val deleteStudentUseCase = DeleteStudentUseCase(dataRepository)
        val updateStudentUseCase = UpdateStudentUseCase(dataRepository)

        val viewModel = StudentsViewModel(saveStudentUseCase, getStudentList, deleteStudentUseCase, updateStudentUseCase)
        viewModel.saveClicked("0001", "Diego")
        viewModel.saveClicked("0002", "Cristina")
        viewModel.deleteStudent("0001")
        val student = Student("0002", "Diego")
        viewModel.updateStudent(student)
        viewModel.getStudentList()
        Log.d("@dev", viewModel.uiState.value.toString())
    }
}