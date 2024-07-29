package com.vanka.swipeyc21.ui.forms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.vanka.swipeyc21.R
import com.vanka.swipeyc21.databinding.ActivityFormsBinding
import com.vanka.swipeyc21.ui.forms.fragments.EnterGSTFragment
import com.vanka.swipeyc21.ui.forms.fragments.EnterYourCompanyNameFragment
import com.vanka.swipeyc21.ui.forms.fragments.GSTFragment
import kotlin.properties.Delegates

class FormsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFormsBinding
    private var count by Delegates.notNull<Int>()
    private val totalIncrements = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        count = 0

        // Set initial progress to zero
        binding.progressBar.progress = 0
        binding.progressBar.max = totalIncrements
        goToFragment(GSTFragment(), supportFragmentManager, R.id.formContainer)

        // Example: Setting initial fragment
      binding.cardView4.setOnClickListener {
          binding.progressText.text = "${count+1} of 3"
          if (count==0) {
              goToFragment(GSTFragment(), supportFragmentManager, R.id.formContainer)

          }else if(count==1){
              goToFragment(EnterGSTFragment(), supportFragmentManager, R.id.formContainer)


          }else{
              goToFragment(EnterYourCompanyNameFragment(), supportFragmentManager, R.id.formContainer)

          }
      }
        binding.back.setOnClickListener {
            binding.progressText.text = "${count-1} of 3"

            goBack(supportFragmentManager)
        }
    }

    fun goToFragment(fragment: Fragment, fragmentManager: FragmentManager, containerId: Int) {
        if (count < totalIncrements) {
            count++
            updateProgressBar()

            val transaction = fragmentManager.beginTransaction()
            transaction.replace(containerId, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

    fun goBack(fragmentManager: FragmentManager) {
        if (count > 0) {
            count--
            updateProgressBar()
            fragmentManager.popBackStack()
        }
    }

    private fun updateProgressBar() {
        binding.progressBar.progress = count
    }
}
