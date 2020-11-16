package dada.com.styletrial

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dada.com.styletrial.child_frag.*
import dada.com.styletrial.databinding.FragContainerBinding
import dada.com.styletrial.databinding.FragmentTrialBinding
import kotlinx.android.synthetic.main.fragment_trial.view.*

class Frag5: Fragment() {

    private var _binding:FragContainerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragContainerBinding.inflate(inflater,container,false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fcVp2.apply {
            adapter = ChildViewAdapter(this@Frag5)
        }
        TabLayoutMediator(binding.tabs,binding.fcVp2){ tab,position->
            tab.text = "第${position}頁"
        }.attach()


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        Log.i("Frag", "frag5 onResume 1 ")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Frag1", "frag5 onPause 1 ")
    }

    inner class ChildViewAdapter(
        private val fragment:Frag5
    ): FragmentStateAdapter(fragment){
        private val tabs = mutableListOf(
            FragChild1(), FragChild2(), FragChild3(), FragChild4(), FragChild5()
        )
        override fun getItemCount(): Int {
            return tabs.size
        }

        override fun createFragment(position: Int): Fragment {
            return tabs[position]
        }

    }


}