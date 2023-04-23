package eu.jobernas.demohilt.ui.hilt

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import eu.jobernas.demohilt.core.CoroutinesDispatchersModule
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

@HiltViewModel
class HiltWayViewModel @Inject constructor(
    @CoroutinesDispatchersModule.IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    @CoroutinesDispatchersModule.MainDispatcher private val mainDispatcher: CoroutineDispatcher):
    ViewModel() {

    companion object {
        private val TAG = HiltWayViewModel::class.java.simpleName
    }
}