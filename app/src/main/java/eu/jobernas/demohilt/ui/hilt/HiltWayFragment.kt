package eu.jobernas.demohilt.ui.hilt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import eu.jobernas.demohilt.R
import eu.jobernas.demohilt.databinding.FragmentHiltWayBinding

@AndroidEntryPoint
class HiltWayFragment:
    Fragment() {

    private var _binding: FragmentHiltWayBinding? = null

    // Like we have injections in First View Model we can use the viewModels Extensions to speed up things
    private val firstViewModel: HiltWayViewModel by viewModels()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        _binding = FragmentHiltWayBinding.inflate(inflater, container, false)
        _binding?.apply {
            hiltToNormalScreenButton.setOnClickListener {
                findNavController()
                    .navigate(R.id.action_hilt_to_normal)
            }
            firstViewModel.apply {
                onMessageChanged.observe(viewLifecycleOwner) {
                    hiltResultTextView.text = it
                }
            }
        }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        firstViewModel.executeSomething()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}