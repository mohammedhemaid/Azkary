package com.app.durdling.azkar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.app.durdling.azkar.databinding.FragmentCounterBinding

class CounterFragment : Fragment() {

    companion object {
        private const val ZEKER_POSITION = "zekerPosition"
        private const val ZEKER_TEXT = "zekerText"

        fun createInstance(position: Int, text: String): Fragment {
            return CounterFragment().apply {
                arguments = bundleOf(
                    ZEKER_TEXT to text,
                    ZEKER_POSITION to position
                )
            }
        }
    }

    private var _binding: FragmentCounterBinding? = null
    private val binding: FragmentCounterBinding get() = _binding!!

    private lateinit var preferenceManager: PreferencesManager
    private var counter = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCounterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferenceManager = PreferencesManager(requireContext())
        with(binding) {
            zeker.text = requireArguments().getString(ZEKER_TEXT)
            val preferenceCounter = preferenceManager.getZekerCounter(requireArguments().getInt(ZEKER_POSITION))
            countertext.text = preferenceCounter.toString()
            counter = preferenceCounter
            root.setOnClickListener {
                if (counter == 100) return@setOnClickListener
                binding.countertext.text = (++counter).toString()
                if (counter == 100) {
                    counter = 0
                    (requireActivity() as CounterActivity).nextZerker()
                }
            }
            reset.setOnClickListener {
                counter = 0
                binding.countertext.text = "0"
                val position = requireArguments().getInt(ZEKER_POSITION)
                preferenceManager.setZekerCounter(position, 0)
            }
        }
    }

    override fun onPause() {
        super.onPause()
        val position = requireArguments().getInt(ZEKER_POSITION)
        preferenceManager.setZekerCounter(position, counter)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}