package eu.jobernas.demohilt.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import eu.jobernas.demohilt.ui.normal.NormalWayViewModel
import kotlinx.coroutines.Dispatchers

object ViewModelFactory: ViewModelProvider.Factory {

    private val TAG = ViewModelFactory::class.java.simpleName

    override fun <T: ViewModel>create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(NormalWayViewModel::class.java) ->
                NormalWayViewModel(
                    Dispatchers.IO,
                    Dispatchers.Main) as T
            else -> throw Throwable("View Model not recognized")
        }
    }
}