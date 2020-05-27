package personal.ivan.materialcomponentpractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import personal.ivan.materialcomponentpractice.databinding.FragmentBottomAppBarBinding

class BottomAppBarFragmentWithFab : Fragment() {

    // View Binding
    private lateinit var binding: FragmentBottomAppBarBinding

    // region Life Cycle

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBottomAppBarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setMenuItemClickListener()
        setNavigationOnClickListener()
        setFabOnClickListener()
    }

    // endregion

    // region BottomAppBar

    /**
     * Set menu item click listener
     */
    private fun setMenuItemClickListener() {
        binding.bottomAppBar.setOnMenuItemClickListener {
            showText(text = "select ${it.title}")
            true
        }
    }

    /**
     * Navigation icon click listener
     */
    private fun setNavigationOnClickListener() {
        binding.bottomAppBar.setNavigationOnClickListener {
            showText(text = "click navigation")
        }
    }

    // endregion

    // region FAB

    /**
     * Set FAB button click listener
     */
    private fun setFabOnClickListener() {
        binding.fab.setOnClickListener {
            showText(text = "FAB clicked")
        }
    }

    // endregion

    // region Display text

    /**
     * Update display text on screen
     */
    private fun showText(text: String) {
        Toast.makeText(binding.root.context, text, Toast.LENGTH_SHORT).show()
    }

    // endregion
}