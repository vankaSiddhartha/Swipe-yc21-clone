package com.vanka.swipeyc21.ui.main.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.vanka.swipeyc21.R
import com.vanka.swipeyc21.databinding.FragmentHomeBinding
import com.vanka.swipeyc21.model.HomeItemModel
import com.vanka.swipeyc21.ui.adapter.HomeItemAdapter


class HomeFragment : Fragment() {

private lateinit var binding:FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        val imageList = ArrayList<SlideModel>() // Create image list


        imageList.add(SlideModel("https://bit.ly/2YoJ77H",))
        imageList.add(SlideModel("https://bit.ly/2BteuF2"))
        imageList.add(SlideModel("https://bit.ly/3fLJf72"))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList)
        val list = listOf<HomeItemModel>(HomeItemModel("Add Email","Get Otps, Alert & Reports\ndelivered via email",R.drawable.plus,Color.BLUE),
            HomeItemModel("Add Company Logo","Personalise invoices with your\nbusiness logo!",R.drawable.edition,Color.YELLOW),
            HomeItemModel("Add Signature","and authenticate your invoices!",R.drawable.agreement,Color.CYAN),
            HomeItemModel("One Click e-Invoicing","Make e-invoices on web/mobile app. Get 25% OFF on subscription!",R.drawable.rocket,Color.GREEN)
        )
        binding.homeRv.layoutManager = LinearLayoutManager(requireContext())
        binding.homeRv.adapter = HomeItemAdapter(list)


        return binding.root
    }


}