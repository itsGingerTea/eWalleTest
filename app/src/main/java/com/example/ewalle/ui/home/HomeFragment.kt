package com.example.ewalle.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ewalle.App
import com.example.ewalle.databinding.FragmentHomeBinding
import com.example.ewalle.ui.home.list.ContactsAdapter
import com.example.ewalle.ui.home.list.ServicesAdapter
import java.text.DecimalFormat
import javax.inject.Inject

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var factory: HomeViewModelFactory.Factory
    private val viewModel by viewModels<HomeViewModel> {
        factory.create()
    }
    private val servicesAdapter by lazy(LazyThreadSafetyMode.NONE) {
        ServicesAdapter()
    }
    private val contactsAdapter by lazy(LazyThreadSafetyMode.NONE) {
        ContactsAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies()
    }

    private fun injectDependencies() {
        App.appComponent.homeComponentBuilder().bindsInflater(layoutInflater).build().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            rvServices.layoutManager = GridLayoutManager(requireContext(), 4)
            rvServices.adapter = servicesAdapter
            rvContacts.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            rvContacts.adapter = contactsAdapter
        }
        viewModel.onViewCreated()
        viewModel.services.observe(viewLifecycleOwner) { list ->
            servicesAdapter.submitList(list)
        }
        viewModel.contacts.observe(viewLifecycleOwner) { list ->
            contactsAdapter.submitList(list)
        }
        viewModel.accInfo.observe(viewLifecycleOwner) { info ->
            val formatter = DecimalFormat("###,###,###")
            binding.tvBalance.text = formatter.format(info.wallet_balance)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}