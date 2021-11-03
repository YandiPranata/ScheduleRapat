package com.renditriyadi.schedulerapat.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.renditriyadi.schedulerapat.R
import com.renditriyadi.schedulerapat.room.DatabaseHelper
import com.renditriyadi.schedulerapat.Rapat
import com.renditriyadi.schedulerapat.RecycleViewAdapter
import com.renditriyadi.schedulerapat.databinding.MainActivityBinding
import com.renditriyadi.schedulerapat.sharedpref.Constant
import com.renditriyadi.schedulerapat.sharedpref.PreferencesHelper
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding
    private lateinit var sharedpref: PreferencesHelper

    private val rapatAdapter: RecycleViewAdapter by lazy {
        RecycleViewAdapter()
    }
    private lateinit var rapatBaru: Rapat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedpref = PreferencesHelper(this)
        binding = MainActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        showFormTambah()

        showListRapat()

        logOut()

        binding.appBar.tvUsername.text = sharedpref.getString(Constant.PREF_USERNAME)

        setupLoadingDialog()

      }

    private fun setupLoadingDialog(){
        val loading = LoadingDialog(this)
        loading.startLoading()

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            loading.isDismiss() }, 4000)
    }



    private fun logOut() {
        binding.appBar.ivLogout.setOnClickListener {
            sharedpref.clear()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    private fun showListRapat() {
        binding.mainActivitySheet.rvListRapat.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        binding.mainActivitySheet.rvListRapat.adapter= rapatAdapter
        val databaseHelper = DatabaseHelper(this)

        MainScope().launch {
            val listRapat = databaseHelper.getRapat()
            runOnUiThread {
               rapatAdapter.addDaftarRapat(listRapat)
            }
        }
    }

    private fun showFormTambah() {
        binding.mainActivitySheet.ivShowForm.setOnClickListener {
            val intent = Intent(this, FormTambah::class.java)
            startActivity(intent)
        }
        binding.mainActivitySheet.tvShowForm.setOnClickListener {
            val intent = Intent(this, FormTambah::class.java)
            startActivity(intent)
        }
    }
//    private fun setupCustomScrollView() {
//        val fsb = FastScrollerBuilder(binding.mainActivitySheet.fsvMain)
////        ResourcesCompat.getDrawable(resources, R.drawable.ic_thumb_grafik,null)?.let {
////            fsb.setThumbDrawable(it)
////        }
////        ResourcesCompat.getDrawable(resources,R.drawable.ic_track_grafik,null)?.let {
////            fsb.setTrackDrawable(it)
////        }
//        fsb.disableScrollbarAutoHide()
//        fsb.setPadding(0,0,15,0)
//        fsb.build()
//    }

}