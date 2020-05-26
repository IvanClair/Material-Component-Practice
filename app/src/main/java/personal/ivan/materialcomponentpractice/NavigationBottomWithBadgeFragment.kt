package personal.ivan.materialcomponentpractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.view.forEach
import androidx.core.view.forEachIndexed
import androidx.fragment.app.Fragment
import com.google.android.material.badge.BadgeDrawable
import personal.ivan.materialcomponentpractice.databinding.FragmentNavigationWithBadgeBinding

class NavigationBottomWithBadgeFragment : Fragment() {

    // View Binding
    private lateinit var binding: FragmentNavigationWithBadgeBinding

    // region Life Cycle

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNavigationWithBadgeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialNavigationBottomView()
        initialButtons()
    }

    // endregion

    // region NavigationBottomView

    /**
     * Initial NavigationBottomView
     */
    private fun initialNavigationBottomView() {
        setNavigationMenuSelectedListener()
        setNavigationMenuReselectedListener()
    }

    /**
     * Add badge on each menu
     */
    private fun addBadgeOnEachMenu() {
        binding.bottomNavigation.menu.forEachIndexed { index, item ->
            val badge = binding.bottomNavigation.getOrCreateBadge(item.itemId)

            fun getColor(@ColorRes colorResId: Int): Int =
                ContextCompat.getColor(binding.root.context, colorResId)
            when (index) {
                0 -> {
                    badge.badgeGravity = BadgeDrawable.TOP_START
                    badge.backgroundColor = getColor(colorResId = R.color.colorPrimary)
                }

                1 -> {
                    badge.number = 10
                    badge.badgeGravity = BadgeDrawable.BOTTOM_END
                    badge.backgroundColor =
                        getColor(colorResId = R.color.colorPrimaryVariant)
                }

                2 -> {
                    badge.number = 100
                    badge.badgeGravity = BadgeDrawable.BOTTOM_START
                    badge.backgroundColor = getColor(colorResId = R.color.colorSecondary)
                }

                3 -> {
                    badge.number = 1000
                    badge.badgeGravity = BadgeDrawable.TOP_END
                    badge.backgroundColor =
                        getColor(colorResId = R.color.colorSecondaryVariant)
                }

                4 -> badge.isVisible = false
            }
        }
    }

    /**
     * Set navigation menu selected listener
     *
     * Note : it will trigger every time even you reselect same menu,
     * if you want to know reselect event, call [setNavigationMenuReselectedListener]
     */
    private fun setNavigationMenuSelectedListener() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            updateDisplayText(text = "select ${it.title}")
            true
        }
    }

    /**
     * Set navigation menu reselected listener
     */
    private fun setNavigationMenuReselectedListener() {
        binding.bottomNavigation.setOnNavigationItemReselectedListener {
            updateDisplayText(text = "reselect ${it.title}")
        }
    }

    /**
     * Update display text on screen
     */
    private fun updateDisplayText(text: String) {
        binding.textView.text = text
    }

    // endregion

    // region Buttons

    /**
     * Initial functional buttons
     */
    private fun initialButtons() {
        // remove badges on NavigationBottomView
        binding.buttonRemoveBadge.setOnClickListener {
            binding.bottomNavigation.menu.forEach {
                binding.bottomNavigation.removeBadge(it.itemId)
            }
        }

        // add badges on NavigationBottomView
        binding.buttonAddBadges.setOnClickListener {
            addBadgeOnEachMenu()
        }
    }

    // endregion
}