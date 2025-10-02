package com.example.lab_week_06

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.ItemTouchHelper

class MainActivity : AppCompatActivity() {
    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }

    private val catAdapter by lazy {
        CatAdapter(layoutInflater, GlideImageLoader(this), object: CatAdapter.OnClickListener {
            override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
        } )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = catAdapter

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        catAdapter.setData(
            listOf(
                CatModel(
                    Gender.Male,
                    CatBreed.BalineseJavanese,
                    "Fred",
                    "Silent and deadly",
                    "https://cdn2.thecatapi.com/images/7dj.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.ExoticShorthair,
                    "Wilma",
                    "Cuddly assassin",
                    "https://cdn2.thecatapi.com/images/egv.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Curious George",
                    "Award winning investigator",
                    "https://cdn2.thecatapi.com/images/bar.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.Abyssinian,
                    "Noe",
                    "Love to hunt",
                    "https://cdn2.thecatapi.com/images/abg.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.Bengal,
                    "Emma",
                    "Cutie Pie",
                    "https://cdn2.thecatapi.com/images/abf.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.TurkishAngora,
                    "Elio",
                    "My first kitten",
                    "https://cdn2.thecatapi.com/images/abe.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.BritishLonghair,
                    "Honey",
                    "The sweetest",
                    "https://cdn2.thecatapi.com/images/29j.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.EgyptianMau,
                    "Nicky",
                    "The last kitten",
                    "https://cdn2.thecatapi.com/images/abd.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.MaineCoon,
                    "Jude",
                    "Two colored eyes",
                    "https://cdn2.thecatapi.com/images/abc.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.Munchkin,
                    "Haru",
                    "Warm and lovely",
                    "https://cdn2.thecatapi.com/images/29d.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.Persian,
                    "Constance",
                    "Love to eat",
                    "https://cdn2.thecatapi.com/images/b9l.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.YorkChocolate,
                    "Cherry",
                    "Love to sleep",
                    "https://cdn2.thecatapi.com/images/bsl.jpg"
                )
            )
        )
    }

    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") { _, _ -> }.show()
    }
}