package com.example.fortailoring.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.fortailoring.R
import com.example.fortailoring.databinding.ActivityNewItemBinding
import com.example.fortailoring.entities.OrderItem
import com.example.fortailoring.fragments.ItemOrderFragment
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class NewItemActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewItemBinding
    private var item: OrderItem? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBarSettings()
        getItem()
    }

    private fun getItem() {
        val sItem = intent.getSerializableExtra(ItemOrderFragment.NEW_ITEM_KEY)
        if (sItem != null) {
            item = sItem as OrderItem
            fillItem()
        }
    }

    private fun fillItem() = with(binding) {
        edHeight2.setText(item?.title)
        edNeckCircumference2.setText(item?.content)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.new_item_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.id_save) {
            setMainResult()
        } else if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setMainResult() {
        var editState = "new"
        val tempItem: OrderItem? = if (item == null) {
            createNewItem()
        } else {
            editState = "update"
            updateItem()
        }
        val i = Intent().apply {
            putExtra(ItemOrderFragment.NEW_ITEM_KEY, tempItem)
            putExtra(ItemOrderFragment.EDIT_STATE_KEY, editState)
        }
        setResult(RESULT_OK, i)
        finish()
    }

    private fun updateItem(): OrderItem? = with(binding) {
        return item?.copy(
            title = edHeight2.text.toString(),
            content = edNeckCircumference2.text.toString()
        )
    }

    private fun createNewItem(): OrderItem {
        return OrderItem(
            null,
            binding.tvTitle2.text.toString(),
            binding.edHeight2.text.toString(),
            getCurrentTime(),
            ""
        )
    }

    private fun getCurrentTime(): String {
        val formatter = SimpleDateFormat("hh : mm - yyyy/MM/dd", Locale.getDefault())
        return formatter.format(Calendar.getInstance().time)
    }

    private fun actionBarSettings() {
        val ab = supportActionBar
        ab?.setDisplayHomeAsUpEnabled(true)
    }
}