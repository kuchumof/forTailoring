package com.kuchumof.fortailoring.fragments.example_of_works

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.kuchumof.fortailoring.constant.SeasonEnum
import com.kuchumof.fortailoring.db.AppDatabase
import com.kuchumof.fortailoring.model.FolderItemModel
import com.kuchumof.fortailoring.constant.SeasonEnum.*
import com.kuchumof.fortailoring.constant.TypeOfClothEnum
import com.kuchumof.fortailoring.repository.FolderRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.UUID

class FolderViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AppDatabase.getAppDatabase(application)
    private val repositoryFolder = FolderRepository(db.folderDao())

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
