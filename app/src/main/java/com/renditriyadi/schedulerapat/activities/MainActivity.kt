package com.renditriyadi.schedulerapat.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
<<<<<<< HEAD
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
=======
import android.os.Handler
import android.os.Looper
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.renditriyadi.schedulerapat.R
>>>>>>> 8466c677ffddc73fae459ec994b1b8a9c4691845
import com.renditriyadi.schedulerapat.room.DatabaseHelper
import com.renditriyadi.schedulerapat.Rapat
import com.renditriyadi.schedulerapat.RecycleViewAdapter
import com.renditriyadi.schedulerapat.databinding.MainActivityBinding
import com.renditriyadi.schedulerapat.sharedpref.Constant
import com.renditriyadi.schedulerapat.sharedpref.PreferencesHelper
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

<<<<<<< HEAD
class MainActivity : AppCompatActivity() {

    private lateinit var binding : MainActivityBinding
    lateinit var sharedpref: PreferencesHelper
=======

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding
    private lateinit var sharedpref: PreferencesHelper
>>>>>>> 8466c677ffddc73fae459ec994b1b8a9c4691845

    private val rapatAdapter: RecycleViewAdapter by lazy {
        RecycleViewAdapter()
    }
    private lateinit var rapatBaru: Rapat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
<<<<<<< HEAD

        sharedpref = PreferencesHelper(this)

        binding = MainActivityBinding.inflate(layoutInflater)

        setContentView(binding.root)

=======
        sharedpref = PreferencesHelper(this)
        binding = MainActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
>>>>>>> 8466c677ffddc73fae459ec994b1b8a9c4691845
        showFormTambah()

        showListRapat()

        logOut()

<<<<<<< HEAD
        binding.tvUsername.text = sharedpref.getString(Constant.PREF_USERNAME)
    }

    private fun logOut() {
        binding.ivLogout.setOnClickListener {
=======
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
>>>>>>> 8466c677ffddc73fae459ec994b1b8a9c4691845
            sharedpref.clear()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    private fun showListRapat() {
<<<<<<< HEAD
        binding.rvListRapat.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        binding.rvListRapat.adapter= rapatAdapter
=======
        binding.mainActivitySheet.rvListRapat.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        binding.mainActivitySheet.rvListRapat.adapter= rapatAdapter
>>>>>>> 8466c677ffddc73fae459ec994b1b8a9c4691845
        val databaseHelper = DatabaseHelper(this)

        MainScope().launch {
            val listRapat = databaseHelper.getRapat()
            runOnUiThread {
               rapatAdapter.addDaftarRapat(listRapat)
            }
        }
    }

    private fun showFormTambah() {
<<<<<<< HEAD
        binding.ivShowForm.setOnClickListener {
            val intent = Intent(this, FormTambah::class.java)
            startActivity(intent)
        }
        binding.tvShowForm.setOnClickListener {
=======
        binding.mainActivitySheet.ivShowForm.setOnClickListener {
            val intent = Intent(this, FormTambah::class.java)
            startActivity(intent)
        }
        binding.mainActivitySheet.tvShowForm.setOnClickListener {
>>>>>>> 8466c677ffddc73fae459ec994b1b8a9c4691845
            val intent = Intent(this, FormTambah::class.java)
            startActivity(intent)
        }
    }
<<<<<<< HEAD
=======
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
>>>>>>> 8466c677ffddc73fae459ec994b1b8a9c4691845

}