package com.vanka.swipeyc21.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.vanka.swipeyc21.databinding.AuthPhoneSheetBinding
import com.vanka.swipeyc21.databinding.BottomSheetBinding

class PhoneAuthSheet:BottomSheetDialogFragment() {
    private var _binding:AuthPhoneSheetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = AuthPhoneSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.textView.text = "Hello from Bottom Sheet"
//        binding.button.setOnClickListener {
//            dismiss()
//        }
        binding.cardView2.setOnClickListener {
            dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}