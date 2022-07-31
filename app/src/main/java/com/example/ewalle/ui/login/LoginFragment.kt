package com.example.ewalle.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ewalle.R
import com.example.ewalle.databinding.FragmentLoginBinding
import java.text.SimpleDateFormat
import java.util.*

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            val currentTime = SimpleDateFormat("hh:mm a", Locale.getDefault()).format(Date())
            val currentDate = SimpleDateFormat("MMM.dd.yyyy", Locale.ENGLISH).format(Date())
            val currentDayOfWeek =
                SimpleDateFormat("EEEE", Locale.ENGLISH).format(Calendar.getInstance().time)
            time.text = currentTime
            date.text = getString(R.string.current_time_and_date, currentDate, currentDayOfWeek)
            tvSignIn.setOnClickListener {
                findNavController().navigate(R.id.home_fragment)
            }
            tvCreateAcc.setOnClickListener {
                findNavController().navigate(R.id.home_fragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}