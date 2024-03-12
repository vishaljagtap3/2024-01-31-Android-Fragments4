package `in`.bitcode.fragments4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import `in`.bitcode.fragments2.CounterFragment

class MainActivity : AppCompatActivity() {

    private lateinit var btnAddFragment : Button
    private lateinit var btnRemoveFragment : Button

    private val fragmentsList = ArrayList<CounterFragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initListeners()
    }

    private fun initViews() {
        btnAddFragment = findViewById(R.id.btnAddFragment)
        btnRemoveFragment = findViewById(R.id.btnRemoveFragment)
    }

    private fun initListeners() {
        btnAddFragment.setOnClickListener {
            val counterFragment = CounterFragment()

            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.mainContainer, counterFragment, "tag1")
            fragmentTransaction.commit()

            fragmentsList.add(counterFragment)
        }

        btnRemoveFragment.setOnClickListener {
            if(fragmentsList.size > 0) {
                val fragmentTransaction = supportFragmentManager.beginTransaction()
                fragmentTransaction.remove(fragmentsList[0])
                fragmentTransaction.commit()
                fragmentsList.removeAt(0)
            }
        }
    }
}