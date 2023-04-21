package com.example.quick_cheque.screens.room_cheque_fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quick_cheque.R
import com.example.quick_cheque.adapters.ListExpandableChoiceChequeAdapter
import com.example.quick_cheque.databinding.FragmentChoiceChequeBinding
import com.example.quick_cheque.model.Cheque
import com.example.quick_cheque.model.ChoiceItem
import com.example.quick_cheque.model.Product
import com.example.quick_cheque.model.User
import com.example.quick_cheque.screens.BaseFragment
import com.example.quick_cheque.screens.viewmodels.ChoiceItemViewModel
import java.math.BigDecimal

class ChoiceChequeFragment : BaseFragment(), ListExpandableChoiceChequeAdapter.Clickable {
    private var binding: FragmentChoiceChequeBinding? = null
    private val _binding: FragmentChoiceChequeBinding
        get() = binding!!

    private val choiceItemViewModel: ChoiceItemViewModel by viewModels()

    private lateinit var chequeExpandableRecyclerViewList: RecyclerView
    private lateinit var chequeExpandableChequeAdapter: ListExpandableChoiceChequeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChoiceChequeBinding.inflate(inflater)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setVisibleToolBar()
        setupToolBar(R.menu.menu_with_search)

        choiceItemViewModel.setListItems(getChequeList())
        if (isEmptyLastQuerySearch()) {
            choiceItemViewModel.setFilteredListItems(getChequeList())
        }

        setupChequeRecyclerViewList()

        _binding.buttonNextToDistributeCheque.setOnClickListener {
            val bundle = Bundle().apply {
                putParcelable(
                    "CHEQUE_TAG",
                    (choiceItemViewModel.listItems.value[choiceItemViewModel.choiceCurrentPosition.value] as Cheque)
                )
            }

            findNavController().navigate(
                R.id.action_choiceChequeFragment_to_choiceProductFragment,
                bundle
            )
        }
    }

    private fun setupChequeRecyclerViewList() {
        chequeExpandableRecyclerViewList = _binding.chequeList
        chequeExpandableRecyclerViewList.layoutManager = LinearLayoutManager(requireContext())
        chequeExpandableChequeAdapter = ListExpandableChoiceChequeAdapter(this)
        chequeExpandableRecyclerViewList.adapter = chequeExpandableChequeAdapter
        chequeExpandableChequeAdapter.submitList(choiceItemViewModel.filteredListItems.value as List<Cheque>)
    }

    override fun onClick(position: Int) {
        choiceItemViewModel.setChoiceCurrentPosition(position)
    }

    override fun filterSearchingItems(query: String) {
        choiceItemViewModel.setFilteredListItems(
            choiceItemViewModel.listItems.value.filter { item ->
                val firstChequeTittle = item.getTitleItem().lowercase().trim()
                firstChequeTittle.contains(query.lowercase().trim())
            }.toMutableList()
        )

        chequeExpandableChequeAdapter.submitList(choiceItemViewModel.filteredListItems.value as List<Cheque>)
    }

    private fun getChequeList(): MutableList<ChoiceItem> {
        return mutableListOf(
            Cheque(
                title = "Valera",
                owner = User("Zloi", R.drawable.person_filled),
                sumOfCheque = BigDecimal(30),
                products = mutableListOf(
                    Product(
                        titleProduct = "Кола",
                        price = BigDecimal(35),
                        count = 1,
                        membersProduct = mutableListOf(
                            User("Kolya", R.drawable.person_filled),
                            User("Olya", R.drawable.person_filled)
                        )
                    )
                ),
                membersCheque = mutableListOf(
                    User("ZA", R.drawable.person_filled),
                    User("ZA", R.drawable.person_filled),
                    User("ZA", R.drawable.person_filled),
                ),
            ),


            Cheque(
                title = "Valera",
                owner = User("Zloi", R.drawable.person_filled),
                products = mutableListOf(
                    Product(
                        titleProduct = "Чипсы",
                        price = BigDecimal(35),
                        count = 1,
                        membersProduct = mutableListOf(User("Zloi", R.drawable.person_filled))
                    ),

                    Product(
                        titleProduct = "Бутер",
                        price = BigDecimal(35),
                        count = 1
                    )
                ),
            ),


            Cheque(
                title = "Dii",
                owner = User("Zloi", R.drawable.person_filled),
                sumOfCheque = BigDecimal(30),
                membersCheque = mutableListOf(
                    User("ZA", R.drawable.person_filled),
                    User("ZA", R.drawable.person_filled),
                    User("ZA", R.drawable.person_filled),
                    User("ZA", R.drawable.person_filled),
                    User("ZA", R.drawable.person_filled),
                    User("ZA", R.drawable.person_filled),
                    User("ZA", R.drawable.person_filled),
                ),
            ),
        )
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}