package edu.ucsb.cs.cs184.isaiahgarcia.isaiahgarciachangemaker

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.ArrayList
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)

        val tv = findViewById<View>(R.id.price_value) as TextView
        val twentyDollar = findViewById<View>(R.id.dollar_twenty_zero) as TextView
        val tenDollar = findViewById<View>(R.id.dollar_ten_zero) as TextView
        val fiveDollar = findViewById<View>(R.id.dollar_five_zero) as TextView
        val oneDollar = findViewById<View>(R.id.dollar_one_zero) as TextView
        val twentyFiveCents = findViewById<View>(R.id.cent_twenty_five_zero) as TextView
        val tenCents = findViewById<View>(R.id.cent_ten_zero) as TextView
        val fiveCents = findViewById<View>(R.id.cent_five_zero) as TextView
        val oneCent = findViewById<View>(R.id.cent_one_zero) as TextView

        savedInstanceState.putString("savedPrice", tv.text.toString())
        savedInstanceState.putString("savedTwentyDollar", twentyDollar.text.toString())
        savedInstanceState.putString("savedTenDollar", tenDollar.text.toString())
        savedInstanceState.putString("savedFiveDollar", fiveDollar.text.toString())
        savedInstanceState.putString("savedOneDollar", oneDollar.text.toString())
        savedInstanceState.putString("savedTwentyFiveCents", twentyFiveCents.text.toString())
        savedInstanceState.putString("savedTenCents", tenCents.text.toString())
        savedInstanceState.putString("savedFiveCents", fiveCents.text.toString())
        savedInstanceState.putString("savedOneCent", oneCent.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val tv = findViewById<View>(R.id.price_value) as TextView
        val twentyDollar = findViewById<View>(R.id.dollar_twenty_zero) as TextView
        val tenDollar = findViewById<View>(R.id.dollar_ten_zero) as TextView
        val fiveDollar = findViewById<View>(R.id.dollar_five_zero) as TextView
        val oneDollar = findViewById<View>(R.id.dollar_one_zero) as TextView
        val twentyFiveCents = findViewById<View>(R.id.cent_twenty_five_zero) as TextView
        val tenCents = findViewById<View>(R.id.cent_ten_zero) as TextView
        val fiveCents = findViewById<View>(R.id.cent_five_zero) as TextView
        val oneCent = findViewById<View>(R.id.cent_one_zero) as TextView

        val userPrice = savedInstanceState.getString("savedPrice")
        tv.text = userPrice
        val userTWD = savedInstanceState.getString("savedTwentyDollar")
        twentyDollar.text = userTWD
        val userTED = savedInstanceState.getString("savedTenDollar")
        tenDollar.text = userTED
        val userFD = savedInstanceState.getString("savedFiveDollar")
        fiveDollar.text = userFD
        val userOD = savedInstanceState.getString("savedOneDollar")
        oneDollar.text = userOD
        val userTFC = savedInstanceState.getString("savedTwentyFiveCents")
        twentyFiveCents.text = userTFC
        val userTEC = savedInstanceState.getString("savedTenCents")
        tenCents.text = userTEC
        val userFC = savedInstanceState.getString("savedFiveCents")
        fiveCents.text = userFC
        val userOC = savedInstanceState.getString("savedOneCent")
        oneCent.text = userOC
    }

    fun buttonClick(view: View) {
        val buttonList = ArrayList<Button>()
        buttonList.add(findViewById<Button>(R.id.button0) as Button)
        buttonList.add(findViewById<Button>(R.id.button1) as Button)
        buttonList.add(findViewById<Button>(R.id.button2) as Button)
        buttonList.add(findViewById<Button>(R.id.button3) as Button)
        buttonList.add(findViewById<Button>(R.id.button4) as Button)
        buttonList.add(findViewById<Button>(R.id.button5) as Button)
        buttonList.add(findViewById<Button>(R.id.button6) as Button)
        buttonList.add(findViewById<Button>(R.id.button7) as Button)
        buttonList.add(findViewById<Button>(R.id.button8) as Button)
        buttonList.add(findViewById<Button>(R.id.button9) as Button)
        val clearButton = findViewById<Button>(R.id.button_clear) as Button
        val tv = findViewById<View>(R.id.price_value) as TextView
        val twentyDollar = findViewById<View>(R.id.dollar_twenty_zero) as TextView
        val tenDollar = findViewById<View>(R.id.dollar_ten_zero) as TextView
        val fiveDollar = findViewById<View>(R.id.dollar_five_zero) as TextView
        val oneDollar = findViewById<View>(R.id.dollar_one_zero) as TextView
        val twentyFiveCents = findViewById<View>(R.id.cent_twenty_five_zero) as TextView
        val tenCents = findViewById<View>(R.id.cent_ten_zero) as TextView
        val fiveCents = findViewById<View>(R.id.cent_five_zero) as TextView
        val oneCent = findViewById<View>(R.id.cent_one_zero) as TextView

        for (i in buttonList) {
            i.setOnClickListener {
                val price: Double = tv.text.toString().toDouble()
                val number: Double = i.text.toString().toDouble()
                val priceConverted: String = String.format("%.2f",(price*10 + (number/100)))
                tv.text = priceConverted

                val indexOfPoint: Int = priceConverted.indexOf(".")
                var money = priceConverted.subSequence(0, indexOfPoint).toString().toInt()

                val dollarTwenty: String = (money/20).toString()
                twentyDollar.text = twentyDollar.text.toString().dropLast(1).plus(dollarTwenty)
                money %= 20

                val dollarTen: String = (money/10).toString()
                tenDollar.text = tenDollar.text.toString().dropLast(1).plus(dollarTen)
                money %= 10

                val dollarFive: String = (money/5).toString()
                fiveDollar.text = fiveDollar.text.toString().dropLast(1).plus(dollarFive)
                money %= 5

                val dollarOne: String = (money/1).toString()
                oneDollar.text = oneDollar.text.toString().dropLast(1).plus(dollarOne)
                money %= 1

                var currency: Int = priceConverted.takeLast(2).toInt()
                val centTwentyFive: String = (currency/25).toString()
                twentyFiveCents.text = twentyFiveCents.text.toString().dropLast(1).plus(centTwentyFive)
                currency %= 25

                val centTen: String = (currency/10).toString()
                tenCents.text = tenCents.text.toString().dropLast(1).plus(centTen)
                currency %= 10

                val centFive: String = (currency/5).toString()
                fiveCents.text = fiveCents.text.toString().dropLast(1).plus(centFive)
                currency %= 5

                val centOne: String = (currency/1).toString()
                oneCent.text = oneCent.text.toString().dropLast(1).plus(centOne)
                currency %= 1
            }
        }

        clearButton.setOnClickListener {
            tv.text = "0.00"
            twentyDollar.text = "0"
            tenDollar.text = "0"
            fiveDollar.text = "0"
            oneDollar.text = "0"
            twentyFiveCents.text = "0"
            tenCents.text = "0"
            fiveCents.text = "0"
            oneCent.text = "0"
        }
    }

}