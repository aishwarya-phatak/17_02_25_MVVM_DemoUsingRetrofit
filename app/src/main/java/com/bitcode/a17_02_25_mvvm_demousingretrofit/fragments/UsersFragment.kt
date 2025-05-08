package com.bitcode.a17_02_25_mvvm_demousingretrofit.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bitcode.a17_02_25_mvvm_demousingretrofit.adapters.UsersAdapter
import com.bitcode.a17_02_25_mvvm_demousingretrofit.databinding.UserFragmentBinding
import com.bitcode.a17_02_25_mvvm_demousingretrofit.factory.MyViewModelFactory
import com.bitcode.a17_02_25_mvvm_demousingretrofit.network.UserApiService
import com.bitcode.a17_02_25_mvvm_demousingretrofit.repository.UsersRepository
import com.bitcode.a17_02_25_mvvm_demousingretrofit.viewmodels.UserViewModel

class UsersFragment : Fragment() {
    private lateinit var userFragmentBinding: UserFragmentBinding
    private lateinit var usersViewModel: UserViewModel
    private lateinit var usersAdapter: UsersAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        userFragmentBinding = UserFragmentBinding.inflate(inflater)

        initViews()
        initViewModels()
        initAdapters()
        initListeners()
        initObservers()

        usersViewModel.fetchUsers()
        return userFragmentBinding.root
    }

    private fun initViews() {
        userFragmentBinding.recyclerViewForUsers.layoutManager =
            LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
            )
    }

    private fun initViewModels() {
        usersViewModel = ViewModelProvider(
            this, MyViewModelFactory(
                UsersRepository(
                    UserApiService.getInstance()
                )
            )
        ).get(UserViewModel::class.java)
    }

    private fun initAdapters() {
        usersAdapter = UsersAdapter(usersViewModel.users)
        userFragmentBinding.recyclerViewForUsers.adapter = usersAdapter
    }

    private fun initListeners() {
        userFragmentBinding.recyclerViewForUsers.addOnScrollListener(
            object : RecyclerView.OnScrollListener(){
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)

                    if(recyclerView.canScrollVertically(1) && (newState == RecyclerView.SCROLL_STATE_IDLE)){
                        usersViewModel.fetchUsers()
                    }
                }
            }
        )
    }

    private fun initObservers() {
        usersViewModel.usersUpdateAvailableLiveData.observe(viewLifecycleOwner) {
            if (it){
                usersAdapter.notifyDataSetChanged()
            }
        }
    }
}