package eu.jobernas.demohilt.ui.normal

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import eu.jobernas.demohilt.ui.hilt.HiltWayViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NormalWayViewModel(private val ioDispatcher: CoroutineDispatcher,
                         private val mainDispatcher: CoroutineDispatcher):
    ViewModel() {

    companion object {
        private val TAG = NormalWayViewModel::class.java.simpleName
    }

    val onMessageChanged: MutableLiveData<String> = MutableLiveData("")

    fun executeSomething() {
        Log.d(TAG, "executeSomething::started")
        viewModelScope.launch(ioDispatcher) {
            delay(2000)
            withContext(mainDispatcher) {
                onMessageChanged.value = "This message was executed 2sec after the Screen start!"
            }
        }
    }
}