package fr.isep.contactnav.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CallFragmentViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Text any thing for your fam"
    }
    val text: LiveData<String> = _text
}