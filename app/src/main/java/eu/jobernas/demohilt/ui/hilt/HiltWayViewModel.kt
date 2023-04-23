package eu.jobernas.demohilt.ui.hilt

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import eu.jobernas.demohilt.core.CoroutinesDispatchersModule
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HiltWayViewModel @Inject constructor(
    @CoroutinesDispatchersModule.IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    @CoroutinesDispatchersModule.MainDispatcher private val mainDispatcher: CoroutineDispatcher):
    ViewModel() {

    companion object {
        private val TAG = HiltWayViewModel::class.java.simpleName
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