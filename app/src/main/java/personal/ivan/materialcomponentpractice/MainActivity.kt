package personal.ivan.materialcomponentpractice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import personal.ivan.materialcomponentpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // View Binding
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    // region Life Cycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViewPager()
    }

    // endregion

    // region UI

    /**
     * Initial view pager
     */
    private fun initViewPager() {
        binding.viewPagerMain.adapter = MyViewPagerAdapter(activity = this)
    }

    /**
     * View pager adapter
     */
    private inner class MyViewPagerAdapter(activity: FragmentActivity) :
        FragmentStateAdapter(activity) {

        private val dataList = mutableListOf<Fragment>(
            NavigationBottomWithBadgeFragment()
        )

        override fun getItemCount(): Int = dataList.size

        override fun createFragment(position: Int): Fragment = dataList[position]

    }
    // endregion
}
