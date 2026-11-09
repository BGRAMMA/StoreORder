package com.bgramma.storeorder.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bgramma.storeorder.databinding.FragmentCategoryBinding
import com.bgramma.storeorder.model.CategoryModel
import com.bgramma.storeorder.ui.SharedViewModel

class CategoryFragment : Fragment() {

    private var _binding : FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    private val categoryViewModel: CategoryViewModel by viewModels()
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

        categoryViewModel.fetchCategories()

        categoryViewModel.categories.observe(viewLifecycleOwner) { categories ->
            if ( categories.isNotEmpty() ) sharedViewModel.selectCategory(categories[0].id)
            binding.rvCategory.adapter = CategoryAdapter(categories) { id ->
                sharedViewModel.selectCategory(id)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}