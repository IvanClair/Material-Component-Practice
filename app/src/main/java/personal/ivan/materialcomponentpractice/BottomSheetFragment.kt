package personal.ivan.materialcomponentpractice

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import personal.ivan.materialcomponentpractice.databinding.FragmentBottomSheetBinding

class BottomSheetFragment : Fragment() {

    // View Binding
    private lateinit var binding: FragmentBottomSheetBinding

    // region Life Cycle

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDialogBottomSheetButtonOnClickListener()
    }

    // endregion

    // region Modal Button Sheet

    @SuppressLint("InflateParams")
    private fun setDialogBottomSheetButtonOnClickListener() {
        binding.buttonShowDialogBottomSheet.setOnClickListener {
            BottomSheetDialog(binding.root.context).apply {
                val view = layoutInflater.inflate(R.layout.view_bottom_sheet, null)
                setContentView(view)
                show()
            }
        }
    }
    // endregion
}