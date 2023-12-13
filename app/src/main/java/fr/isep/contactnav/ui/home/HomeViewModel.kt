package fr.isep.contactnav.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//class HomeViewModel : ViewModel() {
//
//    private val _text = MutableLiveData<String>().apply {
//        value = "This is home Fragment"
//    }
//    val text: LiveData<String> = _text
//}

class HomeViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
    private val _currentTime = MutableLiveData<String>().apply {
        // Initialize with the current time in Paris
        value = getCurrentTimeInParis()
    }
    val currentTime: LiveData<String> = _currentTime

    private val _weatherUrl = MutableLiveData<String>().apply {
        // Replace "YOUR_API_KEY" with your actual API key
        value = "https://www.accuweather.com/en/fr/paris/623/weather-forecast/623"
            //api parse json "https://api.open-meteo.com/v1/forecast?latitude=48.8534&longitude=2.3488&hourly=temperature_2m"
    }
    val weatherUrl: LiveData<String> = _weatherUrl

    // Function to get the current time in Paris
    private fun getCurrentTimeInParis(): String {
        // Implement your logic to get the current time in Paris
        // You can use the SimpleDateFormat class or other methods
        return "12:00 PM"
    }
}