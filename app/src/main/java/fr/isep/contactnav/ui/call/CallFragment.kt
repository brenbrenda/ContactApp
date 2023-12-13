package fr.isep.contactnav.ui.gallery

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import fr.isep.contactnav.databinding.FragmentCallBinding

class CallFragment : Fragment() {

    private var _binding: FragmentCallBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val callViewModel =
            ViewModelProvider(this).get(CallFragmentViewModel::class.java)

        _binding = FragmentCallBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textCall
        callViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        // Button for placing a phone call
        val callButton: Button = binding.buttonCall
        callButton.setOnClickListener {
            placePhoneCall()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun placePhoneCall() {
        // Replace "phoneNumber" with the actual phone number you want to call
        val phoneNumber = "tel:+123456789"
        val callIntent = Intent(Intent.ACTION_CALL, Uri.parse(phoneNumber))

        // Check for CALL_PHONE permission before making the call
        if (requireActivity().packageManager.resolveActivity(callIntent, 0) != null) {
            startActivity(callIntent)
        } else {
            // Handle the case where the device cannot make phone calls
            // (e.g., if the CALL_PHONE permission is not granted)
        }
    }
}