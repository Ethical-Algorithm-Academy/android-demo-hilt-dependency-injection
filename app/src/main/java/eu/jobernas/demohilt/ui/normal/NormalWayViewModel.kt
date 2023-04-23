package eu.jobernas.demohilt.ui.normal

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineDispatcher

class NormalWayViewModel(private val ioDispatcher: CoroutineDispatcher,
                         private val mainDispatcher: CoroutineDispatcher):
    ViewModel() {

    companion object {
        private val TAG = NormalWayViewModel::class.java.simpleName
    }
}