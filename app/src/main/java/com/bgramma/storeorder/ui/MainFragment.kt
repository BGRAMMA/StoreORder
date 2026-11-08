package com.bgramma.storeorder.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bgramma.storeorder.R
import com.bgramma.storeorder.databinding.FragmentMainBinding
import com.bgramma.storeorder.ui.category.CategoryFragment
import com.bgramma.storeorder.ui.menu.MenuFragment

class MainFragment : Fragment() {

    private var _binding : FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        childFragmentManager.beginTransaction()
            .replace(R.id.fr_menu, MenuFragment()).commit()

        childFragmentManager.beginTransaction()
            .replace(R.id.fr_category, CategoryFragment()).commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}