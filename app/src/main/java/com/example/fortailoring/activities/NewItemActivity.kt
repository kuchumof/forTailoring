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

    /**наполнение нового заказа*/
    private fun fillItem() = with(binding) {
        edHeight.setText(item?.height?.toString() ?: "")
        edNeckCircumference.setText(item?.neckCircumference?.toString() ?: "")
        edChestGirth1.setText(item?.chestGirth1?.toString() ?: "")
        edChestGirth2.setText(item?.chestGirth2?.toString() ?: "")
        edChestGirth3.setText(item?.chestGirth3?.toString() ?: "")
        edThighCircumference.setText(item?.thighCircumference?.toString() ?: "")
        edShoulderWidth.setText(item?.shoulderWidth?.toString() ?: "")
        edArmLength.setText(item?.armLength?.toString() ?: "")
        edShoulderGirth.setText(item?.shoulderGirth?.toString() ?: "")
        edWristCircumference.setText(item?.wristCircumference?.toString() ?: "")
        edChestWidth1.setText(item?.chestWidth1?.toString() ?: "")
        edChestWidth2.setText(item?.chestWidth2?.toString() ?: "")
        edChestHeight.setText(item?.chestHeight?.toString() ?: "")
        edFrontLengthToWaist.setText(item?.frontLengthToWaist?.toString() ?: "")
        edBackWidth.setText(item?.backWidth?.toString() ?: "")
        edBackLengthToWaist.setText(item?.backLengthToWaist?.toString() ?: "")
        edShoulderHeightObliqueBack.setText(item?.shoulderHeightObliqueBack?.toString() ?: "")
        edLengthFromWaistToFloorSide.setText(item?.lengthFromWaistToFloorSide?.toString() ?: "")
        edLengthFromWaistToKneeSide.setText(item?.lengthFromWaistToKneeSide?.toString() ?: "")
        edLengthOfTheProduct.setText(item?.lengthOfTheProduct?.toString() ?: "")
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

    /**обновление заказа*/
    private fun updateItem(): OrderItem? = with(binding) {
        return item?.copy(
            title = tvTitle2.text.toString(),
            height = edHeight.text.toString().toInt(),
            neckCircumference = edNeckCircumference.text.toString().toInt(),
            chestGirth1 = edChestGirth1.text.toString().toInt(),
            chestGirth2 = edChestGirth2.text.toString().toInt(),
            chestGirth3 = edChestGirth3.text.toString().toInt(),
            thighCircumference = edThighCircumference.text.toString().toInt(),
            shoulderWidth = edShoulderWidth.text.toString().toInt(),
            armLength = edArmLength.text.toString().toInt(),
            shoulderGirth = edShoulderGirth.text.toString().toInt(),
            wristCircumference = edWristCircumference.text.toString().toInt(),
            chestWidth1 = edChestWidth1.text.toString().toInt(),
            chestWidth2 = edChestWidth2.text.toString().toInt(),
            chestHeight = edChestHeight.text.toString().toInt(),
            frontLengthToWaist = edFrontLengthToWaist.text.toString().toInt(),
            backWidth = edBackWidth.text.toString().toInt(),
            backLengthToWaist = edBackLengthToWaist.text.toString().toInt(),
            shoulderHeightObliqueBack = edShoulderHeightObliqueBack.text.toString().toInt(),
            lengthFromWaistToFloorSide = edLengthFromWaistToFloorSide.text.toString().toInt(),
            lengthFromWaistToKneeSide = edLengthFromWaistToKneeSide.text.toString().toInt(),
            lengthOfTheProduct = edLengthOfTheProduct.text.toString().toInt()
        )
    }

    /**сохранение нового заказа*/
    private fun createNewItem(): OrderItem {
        return OrderItem(
            null,
            binding.tvTitle2.text.toString(),
            binding.edHeight.text.toString().toInt(),
            binding.edNeckCircumference.text.toString().toInt(),
            binding.edChestGirth1.text.toString().toInt(),
            binding.edChestGirth2.text.toString().toInt(),
            binding.edChestGirth3.text.toString().toInt(),
            binding.edThighCircumference.text.toString().toInt(),
            binding.edShoulderWidth.text.toString().toInt(),
            binding.edArmLength.text.toString().toInt(),
            binding.edShoulderGirth.text.toString().toInt(),
            binding.edWristCircumference.text.toString().toInt(),
            binding.edChestWidth1.text.toString().toInt(),
            binding.edChestWidth2.text.toString().toInt(),
            binding.edChestHeight.text.toString().toInt(),
            binding.edFrontLengthToWaist.text.toString().toInt(),
            binding.edBackWidth.text.toString().toInt(),
            binding.edBackLengthToWaist.text.toString().toInt(),
            binding.edShoulderHeightObliqueBack.text.toString().toInt(),
            binding.edLengthFromWaistToFloorSide.text.toString().toInt(),
            binding.edLengthFromWaistToKneeSide.text.toString().toInt(),
            binding.edLengthOfTheProduct.text.toString().toInt(),
            getCurrentTime()
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