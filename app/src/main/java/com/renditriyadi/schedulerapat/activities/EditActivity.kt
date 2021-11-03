package com.renditriyadi.schedulerapat.activities

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
<<<<<<< HEAD
import com.renditriyadi.schedulerapat.databinding.ActivityEditBinding
import com.renditriyadi.schedulerapat.room.DatabaseHelper
import com.renditriyadi.schedulerapat.room.DatabaseRapat
=======
import android.util.Log
import com.renditriyadi.schedulerapat.Rapat
import com.renditriyadi.schedulerapat.databinding.ActivityEditBinding
import com.renditriyadi.schedulerapat.room.DatabaseHelper
import com.renditriyadi.schedulerapat.room.DatabaseRapat
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
>>>>>>> 8466c677ffddc73fae459ec994b1b8a9c4691845
import java.text.SimpleDateFormat
import java.util.*

class EditActivity : AppCompatActivity() {
    private lateinit var binding : ActivityEditBinding

    private lateinit var meetingDate: Calendar
    private lateinit var meetingTime: Calendar
    private lateinit var hari: String
<<<<<<< HEAD
    private lateinit var tanggal: String
    private lateinit var waktu: String
    private var dbAdd: DatabaseRapat?=null
    val databaseHelper= DatabaseHelper(this)
=======
    private var id: Int? = null
    private lateinit var tanggal: String
    private lateinit var waktu: String
    private var dbAdd: DatabaseRapat?=null
    private val databaseHelper= DatabaseHelper(this)
>>>>>>> 8466c677ffddc73fae459ec994b1b8a9c4691845

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

<<<<<<< HEAD
=======
        fillData()

        binding.ivShowDatePicker.setOnClickListener{
            showDatePicker()
        }

        binding.ivShowTimePicker.setOnClickListener{
            showTimePicker()
        }

>>>>>>> 8466c677ffddc73fae459ec994b1b8a9c4691845
        binding.btnEdit.setOnClickListener {
            updateRapat()
        }

        binding.btnCancel.setOnClickListener {
            backToMainActivity()
        }
<<<<<<< HEAD

        binding.ivShowDatePicker.setOnClickListener {
            showDatePicker()
        }
        binding.ivShowTimePicker.setOnClickListener {
            showTimePicker()
        }
=======
    }

    private fun fillData() {
        var itemRapat = intent.getParcelableExtra<Rapat>("rapat")
        binding.etJudulRapat.setText(itemRapat?.judul.orEmpty())
        binding.etLokasi.setText(itemRapat?.lokasi.orEmpty())
        hari = itemRapat?.hari.orEmpty()
        waktu = itemRapat?.waktu.orEmpty()
        tanggal = itemRapat?.tanggal.orEmpty()
        id = itemRapat?.id
        renderDate()
        renderTime()
    }

    private fun renderDate() {
        binding.tvDatePicked.text = "Meeting Date: $hari, $tanggal"
    }

    private fun renderTime() {
        binding.tvTimePicked.text = "Meeting Time: $waktu"
>>>>>>> 8466c677ffddc73fae459ec994b1b8a9c4691845
    }

    private fun backToMainActivity() {
        val intent = Intent (this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun updateRapat() {
<<<<<<< HEAD
        TODO("Not yet implemented")
=======
        dbAdd= DatabaseRapat.getInstance(this)
        val objectRapat = Rapat(
            id,
            binding.etJudulRapat.text.toString(),
            hari,
            tanggal,
            waktu,
            binding.etLokasi.text.toString()
        )

        GlobalScope.async {
            databaseHelper.updateRapat(objectRapat)
        }
        backToMainActivity()
>>>>>>> 8466c677ffddc73fae459ec994b1b8a9c4691845
    }

    private fun showTimePicker() {
        meetingTime = Calendar.getInstance()
        val timeSetListener = TimePickerDialog.OnTimeSetListener { view, hour, minute ->
            meetingTime.set(Calendar.HOUR_OF_DAY, hour)
            meetingTime.set(Calendar.MINUTE, minute)

            val timeFormat = "HH:mm"
            val sdf = SimpleDateFormat(timeFormat, Locale.getDefault())
            waktu = sdf.format(meetingTime.time)
<<<<<<< HEAD
            binding.tvTimePicked.text = "Meeting Time: $waktu"
=======
            renderTime()
>>>>>>> 8466c677ffddc73fae459ec994b1b8a9c4691845
        }
        TimePickerDialog(this, timeSetListener,
            meetingTime.get(Calendar.HOUR_OF_DAY),
            meetingTime.get(Calendar.MINUTE), true).show()
    }

    private fun showDatePicker() {
        meetingDate = Calendar.getInstance()
        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            meetingDate.set(Calendar.YEAR, year)
            meetingDate.set(Calendar.MONTH, monthOfYear)
            meetingDate.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val dateFormat = "dd-MM-yyyy"
            val dayFormat = "EEEE"
            val sdfTanggal = SimpleDateFormat(dateFormat, Locale.getDefault())
            val sdfHari = SimpleDateFormat(dayFormat, Locale.getDefault())

            hari = sdfHari.format(meetingDate.time)
            tanggal = sdfTanggal.format(meetingDate.time)
<<<<<<< HEAD
            binding.tvDatePicked.text = "Meeting Date: "+sdfHari.format(meetingDate.time)+", "+sdfTanggal.format(meetingDate.time)
=======
            renderDate()
>>>>>>> 8466c677ffddc73fae459ec994b1b8a9c4691845
        }

        DatePickerDialog(this, dateSetListener,
            meetingDate.get(Calendar.YEAR),
            meetingDate.get(Calendar.MONTH),
            meetingDate.get(Calendar.DAY_OF_MONTH)).show()
    }
<<<<<<< HEAD
=======

>>>>>>> 8466c677ffddc73fae459ec994b1b8a9c4691845
}