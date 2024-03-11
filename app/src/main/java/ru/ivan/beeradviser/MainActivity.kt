package ru.ivan.beeradviser

import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val findBeer = findViewById<Button>(R.id.find_beer)
        findBeer.setOnClickListener {
            val beerColor = findViewById<Spinner>(R.id.beer_color)
            val brands = findViewById<TextView>(R.id.brands)
            brands.text = getBeers(beerColor.selectedItem.toString()).reduce{str, item -> str + "\n" + item}
        }
    }

    private fun getBeers(color: String): List<String> = when (color) {
        "Light" -> listOf("Jail Pale Ale", "Lager Lite")
        "Amber" -> listOf("Jack Amber", "Red Moose")
        "Brown" -> listOf("Born Bear Beer", "Bock Brownie")
        else -> listOf("Gout Stout", "Dark Daniel")
    }
}