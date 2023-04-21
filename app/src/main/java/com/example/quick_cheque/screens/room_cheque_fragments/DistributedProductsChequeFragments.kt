package com.example.quick_cheque.screens.room_cheque_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quick_cheque.R
import com.example.quick_cheque.adapters.ListDistributedProductsAdapter
import com.example.quick_cheque.databinding.FragmentDistributedProductsChequeFragmentsBinding
import com.example.quick_cheque.model.DistributedChequeUserItem
import com.example.quick_cheque.model.Product
import com.example.quick_cheque.model.User
import com.example.quick_cheque.screens.BaseFragment
import com.example.quick_cheque.screens.viewmodels.ChoiceItemViewModel
import java.math.BigDecimal

class DistributedProductsChequeFragments : BaseFragment() {
    private var binding: FragmentDistributedProductsChequeFragmentsBinding? = null
    private val _binding: FragmentDistributedProductsChequeFragmentsBinding
        get() = binding!!

    private val choiceItemViewModel: ChoiceItemViewModel by viewModels()
    private lateinit var distributionProductListAdapter: ListDistributedProductsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDistributedProductsChequeFragmentsBinding.inflate(inflater)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setVisibleToolBar()
        setupToolBar(R.menu.menu_with_search)


        val distributedChequeUserItem = mutableListOf(
            DistributedChequeUserItem(
                user = User("Zloi", R.drawable.person_filled),
                listProductsUser = mutableListOf(
                    Product(
                        titleProduct = "Кола",
                        price = BigDecimal(35),
                        count = 1,
                        membersProduct = mutableListOf(
                            User("Kolya", R.drawable.person_filled),
                            User("Olya", R.drawable.person_filled)
                        )
                    ),

                    Product(
                        titleProduct = "Мошня",
                        price = BigDecimal(35),
                        count = 1,
                        membersProduct = mutableListOf(
                            User("Kolya", R.drawable.person_filled),
                            User("Olya", R.drawable.person_filled)
                        )
                    )
                ),
            ),

            DistributedChequeUserItem(
                user = User("Zloi", R.drawable.person_filled),
                listProductsUser = mutableListOf(

                ),
            )
        )

        setupRecyclerDistributionProductList(distributedChequeUserItem)

        _binding.buttonCompleteCheque.setOnClickListener {
            findNavController().navigate(
                R.id.action_distributedProductsChequeFragments_to_waitPaymentFragment
            )
        }
    }

    private fun setupRecyclerDistributionProductList(
        distributedChequeUserItem: MutableList<DistributedChequeUserItem>
    ) = with(_binding) {
        distributionProductListAdapter = ListDistributedProductsAdapter()
        listDistributionProducts.layoutManager = LinearLayoutManager(requireContext())
        listDistributionProducts.adapter = distributionProductListAdapter
        distributionProductListAdapter.submitList(distributedChequeUserItem)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}