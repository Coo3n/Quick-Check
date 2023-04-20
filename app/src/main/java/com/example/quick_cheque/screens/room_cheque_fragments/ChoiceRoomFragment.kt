package com.example.quick_cheque.screens.room_cheque_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quick_cheque.R
import com.example.quick_cheque.adapters.ListRoomAdapter
import com.example.quick_cheque.databinding.FragmentChoiceRoomBinding
import com.example.quick_cheque.model.*
import com.example.quick_cheque.screens.BaseFragment
import java.math.BigDecimal

class ChoiceRoomFragment : BaseFragment(), ListRoomAdapter.Clickable {
    private var binding: FragmentChoiceRoomBinding? = null
    private val _binding: FragmentChoiceRoomBinding
        get() = binding!!

    private lateinit var roomRecyclerViewList: RecyclerView
    private lateinit var roomChequeAdapter: ListRoomAdapter
    private lateinit var listItems: MutableList<RoomListItem>

    private var choiceCurrentPosition = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChoiceRoomBinding.inflate(inflater)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listItems = getChequeList()
        setupRoomRecyclerViewList(listItems)




    }

    private fun setupRoomRecyclerViewList(listItems: MutableList<RoomListItem>) {
        roomRecyclerViewList = _binding.chequeList
        roomRecyclerViewList.layoutManager = LinearLayoutManager(requireContext())
        roomChequeAdapter = ListRoomAdapter(this)
        roomRecyclerViewList.adapter = roomChequeAdapter
        roomChequeAdapter.submitList(listItems)
    }

    override fun onClick(position: Int) {
        choiceCurrentPosition = position
    }

    override fun filterSearchingItems(query: String) {
        val filteredListItems: MutableList<RoomListItem> =
            listItems.filter { item ->
                val firstRoomTittle = item.room.title.lowercase().trim()
                firstRoomTittle.contains(query.lowercase().trim())
            }.toMutableList()

        roomChequeAdapter.submitList(filteredListItems)
    }

    private fun getChequeList(): MutableList<RoomListItem> {
        return mutableListOf(
            RoomListItem(
                room = Room(
                    id = 1,
                    title = "Крутецкая компания",
                    host = "Никитос",
                    membersRoom = mutableListOf(
                        User("Kolya", R.drawable.person_filled),
                        User("Olya", R.drawable.person_filled)
                    ),
                    cheques = mutableListOf(
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
                            )
                        ),
                        Cheque(
                            title = "Valera",
                            owner = User("Zloi", R.drawable.person_filled),
                            products = mutableListOf(
                                Product(
                                    titleProduct = "Чипсы",
                                    price = BigDecimal(35),
                                    count = 1,
                                    membersProduct = mutableListOf(
                                        User(
                                            "Zloi",
                                            R.drawable.person_filled
                                        )
                                    )
                                ),

                                Product(
                                    titleProduct = "Чипсы",
                                    price = BigDecimal(35),
                                    count = 1
                                )
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
                                    membersProduct = mutableListOf(
                                        User(
                                            "Zloi",
                                            R.drawable.person_filled
                                        )
                                    )
                                ),

                                Product(
                                    titleProduct = "Чипсы",
                                    price = BigDecimal(35),
                                    count = 1
                                )
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
                                    membersProduct = mutableListOf(
                                        User(
                                            "Zloi",
                                            R.drawable.person_filled
                                        )
                                    )
                                ),

                                Product(
                                    titleProduct = "Чипсы",
                                    price = BigDecimal(35),
                                    count = 1
                                )
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
                                    membersProduct = mutableListOf(
                                        User(
                                            "Zloi",
                                            R.drawable.person_filled
                                        )
                                    )
                                ),

                                Product(
                                    titleProduct = "Чипсы",
                                    price = BigDecimal(35),
                                    count = 1
                                )
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
                                    membersProduct = mutableListOf(
                                        User(
                                            "Zloi",
                                            R.drawable.person_filled
                                        )
                                    )
                                ),

                                Product(
                                    titleProduct = "Чипсы",
                                    price = BigDecimal(35),
                                    count = 1
                                )
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
                                    membersProduct = mutableListOf(
                                        User(
                                            "Zloi",
                                            R.drawable.person_filled
                                        )
                                    )
                                ),

                                Product(
                                    titleProduct = "Чипсы",
                                    price = BigDecimal(35),
                                    count = 1
                                )
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
                                    membersProduct = mutableListOf(
                                        User(
                                            "Zloi",
                                            R.drawable.person_filled
                                        )
                                    )
                                ),

                                Product(
                                    titleProduct = "Чипсы",
                                    price = BigDecimal(35),
                                    count = 1
                                )
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
                                    membersProduct = mutableListOf(
                                        User(
                                            "Zloi",
                                            R.drawable.person_filled
                                        )
                                    )
                                ),

                                Product(
                                    titleProduct = "Чипсы",
                                    price = BigDecimal(35),
                                    count = 1
                                )
                            ),
                        ),
                    ),
                )
            ),
            RoomListItem(
                room = Room(
                    id = 2,
                    title = "Каша малаша",
                    host = "Ну я хостом буду",
                    membersRoom = mutableListOf(
                        User("Kolya", R.drawable.person_filled),
                        User("Olya", R.drawable.person_filled),
                        User("Ibragym", R.drawable.person_filled),
                        User("Svyat", R.drawable.person_filled)
                    ),
                    cheques = mutableListOf(
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
                            )
                        ),
                        Cheque(
                            title = "Valera",
                            owner = User("Zloi", R.drawable.person_filled),
                            products = mutableListOf(
                                Product(
                                    titleProduct = "Чипсы",
                                    price = BigDecimal(35),
                                    count = 1,
                                    membersProduct = mutableListOf(
                                        User(
                                            "Zloi",
                                            R.drawable.person_filled
                                        )
                                    )
                                ),

                                Product(
                                    titleProduct = "Чипсы",
                                    price = BigDecimal(35),
                                    count = 1
                                )
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
                                    membersProduct = mutableListOf(
                                        User(
                                            "Zloi",
                                            R.drawable.person_filled
                                        )
                                    )
                                ),

                                Product(
                                    titleProduct = "Чипсы",
                                    price = BigDecimal(35),
                                    count = 1
                                )
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
                                    membersProduct = mutableListOf(
                                        User(
                                            "Zloi",
                                            R.drawable.person_filled
                                        )
                                    )
                                ),

                                Product(
                                    titleProduct = "Чипсы",
                                    price = BigDecimal(35),
                                    count = 1
                                )
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
                                    membersProduct = mutableListOf(
                                        User(
                                            "Zloi",
                                            R.drawable.person_filled
                                        )
                                    )
                                ),

                                Product(
                                    titleProduct = "Чипсы",
                                    price = BigDecimal(35),
                                    count = 1
                                )
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
                                    membersProduct = mutableListOf(
                                        User(
                                            "Zloi",
                                            R.drawable.person_filled
                                        )
                                    )
                                ),

                                Product(
                                    titleProduct = "Чипсы",
                                    price = BigDecimal(35),
                                    count = 1
                                )
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
                                    membersProduct = mutableListOf(
                                        User(
                                            "Zloi",
                                            R.drawable.person_filled
                                        )
                                    )
                                ),

                                Product(
                                    titleProduct = "Кока",
                                    price = BigDecimal(35),
                                    count = 1
                                )
                            ),
                        ),
                        Cheque(
                            title = "Valera",
                            owner = User("Zloi", R.drawable.person_filled),
                            products = mutableListOf(
                                Product(
                                    titleProduct = "Кока",
                                    price = BigDecimal(35),
                                    count = 1,
                                    membersProduct = mutableListOf(
                                        User(
                                            "Zloi",
                                            R.drawable.person_filled
                                        )
                                    )
                                ),

                                Product(
                                    titleProduct = "Кока",
                                    price = BigDecimal(35),
                                    count = 1
                                )
                            ),
                        ),
                        Cheque(
                            title = "Valera",
                            owner = User("Zloi", R.drawable.person_filled),
                            products = mutableListOf(
                                Product(
                                    titleProduct = "Кока",
                                    price = BigDecimal(35),
                                    count = 1,
                                    membersProduct = mutableListOf(
                                        User(
                                            "Zloi",
                                            R.drawable.person_filled
                                        )
                                    )
                                ),

                                Product(
                                    titleProduct = "Кока",
                                    price = BigDecimal(35),
                                    count = 1
                                )
                            ),
                        ),
                    ),
                ),
                isExpanded = false
            ),
            RoomListItem(
                room = Room(
                    id = 3,
                    title = "А я опять затуплю...",
                    host = "Самый лысый",
                    membersRoom = mutableListOf(
                        User("Ignat", R.drawable.person_filled),
                        User("Ignat", R.drawable.person_filled),
                        User("Ignat", R.drawable.person_filled),
                        User("Ignat", R.drawable.person_filled),
                        User("Ignat", R.drawable.person_filled),
                        User("Ignat", R.drawable.person_filled),
                        User("Ignat", R.drawable.person_filled),
                    ),
                    cheques = mutableListOf(
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
                            )
                        ),
                        Cheque(
                            title = "Valera",
                            owner = User("Zloi", R.drawable.person_filled),
                            products = mutableListOf(
                                Product(
                                    titleProduct = "Чипсы",
                                    price = BigDecimal(35),
                                    count = 1,
                                    membersProduct = mutableListOf(
                                        User(
                                            "Zloi",
                                            R.drawable.person_filled
                                        )
                                    )
                                ),

                                Product(
                                    titleProduct = "Чипсы",
                                    price = BigDecimal(35),
                                    count = 1
                                )
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
                                    membersProduct = mutableListOf(
                                        User(
                                            "Zloi",
                                            R.drawable.person_filled
                                        )
                                    )
                                ),

                                Product(
                                    titleProduct = "Чипсы",
                                    price = BigDecimal(35),
                                    count = 1
                                )
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
                                    membersProduct = mutableListOf(
                                        User(
                                            "Zloi",
                                            R.drawable.person_filled
                                        )
                                    )
                                ),

                                Product(
                                    titleProduct = "Чипсы",
                                    price = BigDecimal(35),
                                    count = 1
                                )
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
                                    membersProduct = mutableListOf(
                                        User(
                                            "Zloi",
                                            R.drawable.person_filled
                                        )
                                    )
                                ),

                                Product(
                                    titleProduct = "Чипсы",
                                    price = BigDecimal(35),
                                    count = 1
                                )
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
                                    membersProduct = mutableListOf(
                                        User(
                                            "Zloi",
                                            R.drawable.person_filled
                                        )
                                    )
                                ),

                                Product(
                                    titleProduct = "Чипсы",
                                    price = BigDecimal(35),
                                    count = 1
                                )
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
                                    membersProduct = mutableListOf(
                                        User(
                                            "Zloi",
                                            R.drawable.person_filled
                                        )
                                    )
                                ),

                                Product(
                                    titleProduct = "Чипсы",
                                    price = BigDecimal(35),
                                    count = 1
                                )
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
                                    membersProduct = mutableListOf(
                                        User(
                                            "Zloi",
                                            R.drawable.person_filled
                                        )
                                    )
                                ),

                                Product(
                                    titleProduct = "Чипсы",
                                    price = BigDecimal(35),
                                    count = 1
                                )
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
                                    membersProduct = mutableListOf(
                                        User(
                                            "Zloi",
                                            R.drawable.person_filled
                                        )
                                    )
                                ),

                                Product(
                                    titleProduct = "Чипсы",
                                    price = BigDecimal(35),
                                    count = 1
                                )
                            ),
                        ),
                    ),
                ),
                isExpanded = false
            )
        )
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

}