package eu.jobernas.demohilt.ui.normal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import eu.jobernas.demohilt.R
import eu.jobernas.demohilt.core.ViewModelFactory
import eu.jobernas.demohilt.databinding.FragmentNormalWayBinding

class NormalWayFragment : Fragment() {

    private lateinit var normalWayViewModel: NormalWayViewModel
    private var _binding: FragmentNormalWayBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        normalWayViewModel = ViewModelProvider(this, ViewModelFactory)[NormalWayViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        _binding = FragmentNormalWayBinding.inflate(inflater, container, false)
        _binding?.apply {
            normalToHiltButton.setOnClickListener {
                findNavController().navigate(R.id.action_normal_to_hilt)
            }
            normalWayViewModel.apply {
                onMessageChanged.observe(viewLifecycleOwner) {
                    normalResultTextView.text = it
                }
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        normalWayViewModel.executeSomething()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}