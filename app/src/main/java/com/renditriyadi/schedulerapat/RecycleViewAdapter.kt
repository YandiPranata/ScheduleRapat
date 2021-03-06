package com.renditriyadi.schedulerapat

<<<<<<< HEAD
import android.content.Intent
import android.media.Image
=======
import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import android.util.Log
>>>>>>> 8466c677ffddc73fae459ec994b1b8a9c4691845
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.renditriyadi.schedulerapat.activities.EditActivity
<<<<<<< HEAD
=======
import com.renditriyadi.schedulerapat.room.DatabaseHelper
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
>>>>>>> 8466c677ffddc73fae459ec994b1b8a9c4691845

class RecycleViewAdapter: RecyclerView.Adapter<RecycleViewAdapter.RapatViewHolder>() {
    private val daftarRapat: MutableList<Rapat> = mutableListOf()


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    fun addDaftarRapat(daftarRapat: List<Rapat>){
        this.daftarRapat.clear()
        this.daftarRapat.addAll(daftarRapat)
        notifyDataSetChanged()
    }

    inner class RapatViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(itemRapat: Rapat) = itemView.run{
            val tvJudul: TextView = findViewById(R.id.tv_judul)
            val tvHari: TextView = findViewById(R.id.tv_hari)
            val tvTanggal: TextView = findViewById(R.id.tv_tanggal)
            val tvWaktu: TextView = findViewById(R.id.tv_waktu)
            val tvLokasi: TextView = findViewById(R.id.tv_lokasi)
            val btnEdit: ImageView = findViewById(R.id.iv_edit)
            val btnDelete: ImageView = findViewById(R.id.iv_delete)

            tvJudul.text=itemRapat.judul
            tvHari.text=itemRapat.hari
            tvTanggal.text=itemRapat.tanggal
            tvWaktu.text=itemRapat.waktu
            tvLokasi.text=itemRapat.lokasi

            btnEdit.setOnClickListener{
                val intentKeEditActivity = Intent(it.context,
                    EditActivity::class.java)

<<<<<<< HEAD
                intentKeEditActivity.putExtra("rapat",daftarRapat[position])
=======
                intentKeEditActivity.putExtra("rapat",itemRapat)
>>>>>>> 8466c677ffddc73fae459ec994b1b8a9c4691845
                it.context.startActivity(intentKeEditActivity)
            }

            btnDelete.setOnClickListener {
<<<<<<< HEAD
                // TODO: 28/10/2021  
=======
                val databaseHelper= DatabaseHelper(this.context)
                MainScope().launch {
                    databaseHelper.deleteRapat(itemRapat)
                    this@RecycleViewAdapter.addDaftarRapat(databaseHelper.getRapat())
                }
>>>>>>> 8466c677ffddc73fae459ec994b1b8a9c4691845
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RapatViewHolder {
        val context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.list_rapat, parent, false)
        return RapatViewHolder(view)
    }

    override fun onBindViewHolder(holder: RapatViewHolder, position: Int) {
        val rapat = daftarRapat[position]
        holder.bind(rapat)
    }

    override fun getItemCount(): Int {
        return daftarRapat.size
    }
}