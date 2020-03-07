package com.example.monarq.ui.post

import com.example.monarq.base.BaseViewModel
import com.example.monarq.network.PostApi
import javax.inject.Inject


class PostListViewModel: BaseViewModel(){
    @Inject
    lateinit var postApi: PostApi
}