package com.kuchumof.fortailoring.fragments.example_of_works


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kuchumof.fortailoring.constant.SeasonEnum
import com.kuchumof.fortailoring.db.AppDatabase
import com.kuchumof.fortailoring.model.FolderItemModel
import com.kuchumof.fortailoring.constant.SeasonEnum.*
import com.kuchumof.fortailoring.repository.FolderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

// https://rezaramesh.medium.com/room-database-with-hilt-in-kotlin-a-guide-to-store-and-access-data-in-android-c3001e507738
@HiltViewModel
class FolderViewModel @Inject constructor(private val repositoryFolder: FolderRepository) :
    ViewModel() {

    /*private val db = AppDatabase.getAppDatabase(application)
    private val repositoryFolder = FolderRepository(db.folderDao())*/

    //Обёртка для автоматического отслеживания изменения в данных в списке
    /**@param listFolderItemModels.filter - фильтрация элемента в списке*/
    private val _foldersSummer = MutableStateFlow<List<FolderItemModel>>(
        emptyList()
    )
    val foldersSummer: StateFlow<List<FolderItemModel>> = _foldersSummer.asStateFlow()

    //Обёртка для автоматического отслеживания изменения в данных в списке
    /**@param listFolderItemModels.filter - фильтрация элемента в списке*/
    private val _foldersWinter = MutableStateFlow<List<FolderItemModel>>(
        emptyList()
    )
    val foldersWinter: StateFlow<List<FolderItemModel>> = _foldersWinter.asStateFlow()

    init {
        viewModelScope.launch {
            repositoryFolder.getAllSummer().collect { newItems ->
                _foldersSummer.update { newItems }
            }
        }
        viewModelScope.launch {
            repositoryFolder.getAllWinter().collect { newItems ->
                _foldersWinter.update { newItems }
            }
        }
    }

    fun addFolder(season: SeasonEnum) {
        viewModelScope.launch {
            repositoryFolder.insertAll(
                listOf(
                    FolderItemModel(UUID.randomUUID(), "Худи", season)
                )
            )
        }
    }

}
