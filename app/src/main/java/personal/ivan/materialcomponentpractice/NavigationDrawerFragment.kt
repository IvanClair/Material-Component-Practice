package personal.ivan.materialcomponentpractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import personal.ivan.materialcomponentpractice.databinding.FragmentNavigationDrawerBinding

class NavigationDrawerFragment : Fragment() {

    // View Binding
    private lateinit var binding: FragmentNavigationDrawerBinding

    // region Life Cycle

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNavigationDrawerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setNavigationIconClickListener()
        binding.navigationView.setNavigationItemSelectedListener {
            true
        }
    }
    // endregion

    // region Navigation Icon

    private fun setNavigationIconClickListener() {
        binding.apply {
            toolBar.setNavigationOnClickListener {
                if (drawerLayout.isDrawerOpen(navigationView)) {
                    drawerLayout.closeDrawer(navigationView)
                } else {
                    drawerLayout.openDrawer(navigationView)
                }
            }
        }
    }

    // endregion
}