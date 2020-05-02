package com.github.yasukotelin.deeplinkwithnavigation.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.yasukotelin.deeplinkwithnavigation.util.Event

class HomeViewModel : ViewModel() {

    private val _navigateToDetailAction = MutableLiveData<Event<Unit>>()
    val navigateToDetailAction: LiveData<Event<Unit>> = _navigateToDetailAction

    private val _navigateToNoticeAction = MutableLiveData<Event<Unit>>()
    val navigateToNoticeAction: LiveData<Event<Unit>> = _navigateToNoticeAction

    fun onClickDetail() {
        _navigateToDetailAction.postValue(Event(Unit))
    }

    fun onClickNotice() {
        _navigateToNoticeAction.postValue(Event(Unit))
    }
}
