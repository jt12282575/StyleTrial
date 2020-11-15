package dada.com.styletrial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_SET_USER_VISIBLE_HINT
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import dada.com.styletrial.databinding.ActivityMainBinding
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.toolbar)

        supportActionBar?.title = "Hi"


        binding.bnBottom.apply {
            setOnNavigationItemSelectedListener(this@MainActivity)
        }
        binding.vp2Body.apply {
            adapter = ViewPagerAdapter(this@MainActivity)
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.bnBottom.menu.getItem(position).isChecked = true
                }
            })
        }




    }





    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        return when(p0.itemId){
            R.id.f_f1->{
                binding.vp2Body.setCurrentItem(0,true)
                true
            }
            R.id.f_f2->{
                binding.vp2Body.setCurrentItem(1,true)
                true
            }
            R.id.f_f3->{
                binding.vp2Body.setCurrentItem(2,true)
                true
            }
            R.id.f_f4->{
                binding.vp2Body.setCurrentItem(3,true)
                true
            }
            R.id.f_f5->{
                binding.vp2Body.setCurrentItem(4,true)
                true
            }
            else->{
                false
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem) = when(item.itemId){

        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }


}

class ViewPagerAdapter(activity: MainActivity): FragmentStateAdapter(activity) {
    private val tabs = mutableListOf(Frag1(),Frag2(),Frag3(),Frag4(),Frag5())
    override fun getItemCount(): Int {
        return tabs.size
    }

    override fun createFragment(position: Int): Fragment {
        return tabs[position]
    }

}