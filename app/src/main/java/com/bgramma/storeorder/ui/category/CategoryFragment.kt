package com.bgramma.storeorder.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bgramma.storeorder.databinding.FragmentCategoryBinding
import com.bgramma.storeorder.model.CategoryModel
import com.bgramma.storeorder.ui.SharedViewModel

class CategoryFragment : Fragment() {

    private var _binding : FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvCategory.layoutManager = LinearLayoutManager(requireContext())

        val dummyList = listOf(
            CategoryModel(1L, "커피"),
            CategoryModel(2L, "디카페인")
        )

        sharedViewModel.selectCategory(1L)

        binding.rvCategory.adapter = CategoryAdapter(dummyList, { id ->
            sharedViewModel.selectCategory(id)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}