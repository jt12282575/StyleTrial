package dada.com.styletrial

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dada.com.styletrial.databinding.FragmentTrialBinding
import kotlinx.android.synthetic.main.fragment_trial.view.*

class Frag3: Fragment() {

    private var _binding:FragmentTrialBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTrialBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvF.text = "3"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun onResume() {
        super.onResume()
        Log.i("Frag", "onResume 3 ")
        (requireActivity() as? AppCompatActivity)?.supportActionBar?.setIcon(R.mipmap.ic_launcher)

    }

    override fun onPause() {
        super.onPause()
        Log.i("Frag1", "onPause 3 ")
    }
}