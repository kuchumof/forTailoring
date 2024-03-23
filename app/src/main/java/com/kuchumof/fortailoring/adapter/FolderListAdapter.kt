package com.kuchumof.fortailoring.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kuchumof.fortailoring.BR
import com.kuchumof.fortailoring.R
import com.kuchumof.fortailoring.databinding.ExampleFolderItemBinding
import com.kuchumof.fortailoring.model.FolderItemModel

class FolderListAdapter :
    ListAdapter<FolderItemModel, FolderListAdapter.FolderViewHolder>(FolderDiffCallback()) {

    /**
     * Класс отвечает за хранение ссылок на элементы интерфейса для отображения одного элемента данных.
     * @param itemBinding - экземпляр сгенерированного класса, позволяющего проще обращаться к эл-ам интерфейса.
     */
    class FolderViewHolder(private val itemBinding: ExampleFolderItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {


        /**
         * Метод отвечает за вывод на экран одного элемента данных.
         * @param exampleOfWork - элемент данных, который выводится на экран.
         */
        fun bind(exampleOfWork: FolderItemModel) = with(itemBinding) {
            setVariable(BR.folder, exampleOfWork)
            /*TODO
            поменять картинку на первый элементв  папке
            itemBinding.ivExampleFolder.setImageBitmap()
            */
        }
    }

    /**
     * Метод вызывается при создании новой карточки в списке.
     */
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): FolderViewHolder {
        /*Считываются элементы графического интерфейса,
        ссылки записываются в переменную itemBinding*/
        val itemBinding: ExampleFolderItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(viewGroup.context),
            R.layout.example_folder_item,
            viewGroup,
            false
        )
        return FolderViewHolder(itemBinding)
    }

    /**
     *Вызывается, когда старая, ранее созданная карточка переиспользуется для вывода нового элемента данных.
     * @param folderViewHolder - ссылка на старую карточку.
     * @param position - порядковый номер нового элемента данных для вывода.
     */
    override fun onBindViewHolder(folderViewHolder: FolderViewHolder, position: Int) {
        folderViewHolder.bind(getItem(position))

    }

    /**
     * Возвращает полное кол-во элементов в списке
     */
    override fun getItemCount(): Int {
        return currentList.size
    }

    /**
     * Сравнивает item-ы в старом списке с item-ми в новом(изменились, удалились, добавились)
     */
    private class FolderDiffCallback : DiffUtil.ItemCallback<FolderItemModel>() {

        /*Сравнивает item-ы по ключу(уникальному индификатору)*/
        override fun areItemsTheSame(oldItem: FolderItemModel, newItem: FolderItemModel): Boolean {
            return oldItem.id == newItem.id
        }

        /*Сравнивает сами item-ы*/
        override fun areContentsTheSame(
            oldItem: FolderItemModel,
            newItem: FolderItemModel
        ): Boolean {
            return oldItem == newItem
        }
    }
}
