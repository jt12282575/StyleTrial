package dada.com.styletrial.child_frag

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dada.com.styletrial.databinding.FragmentChildTrialBinding
import dada.com.styletrial.databinding.FragmentTrialBinding
import kotlinx.android.synthetic.main.fragment_trial.view.*

class FragChild2: Fragment() {

    private var _binding:FragmentChildTrialBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChildTrialBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvFChild.text = "2"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        Log.i("Frag", "c onResume 2 ")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Frag1", "c onPause 2 ")
    }
}