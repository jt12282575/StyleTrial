package dada.com.styletrial

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import dada.com.styletrial.databinding.FragmentTrialBinding

class Frag4: Fragment() {

    private var _binding:FragmentTrialBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
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
        binding.tvF.text = "4"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()

        Log.i("Frag", "onResume 1 ")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Frag1", "onPause 1 ")
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.action_bar,menu)
        val searchItem = menu?.findItem(R.id.action_search)
        val searchView = searchItem?.actionView as SearchView
        searchView.setIconifiedByDefault(false)
        searchItem.expandActionView()
        searchItem.setOnActionExpandListener(object : MenuItem.OnActionExpandListener {
            override fun onMenuItemActionExpand(item: MenuItem?): Boolean {
                return true
            }

            override fun onMenuItemActionCollapse(item: MenuItem?): Boolean {
                return false
            }
        })
        super.onCreateOptionsMenu(menu, inflater)
    }
}