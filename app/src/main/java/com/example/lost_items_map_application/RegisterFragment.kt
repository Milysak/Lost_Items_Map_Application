package com.example.lost_items_map_application

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_register, container, false)

        val listener = activity as mInterface?

        listener?.update(true)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val loginField = view.findViewById<TextView>(R.id.loginField)
        val passwordField = view.findViewById<TextView>(R.id.passwordField)
        val secondPasswordField = view.findViewById<TextView>(R.id.secondPasswordField)

        view.findViewById<Button>(R.id.loginButton).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_loginFragment)
        }

        view.findViewById<Button>(R.id.registerButton).setOnClickListener {
            if(loginField.text.isNotEmpty() && passwordField.text.isNotEmpty() && secondPasswordField.text.isNotEmpty()) {
                if(loginField.text.find { char -> char == '@' } == null) {
                    Toast.makeText(context, "Podany email jest niepoprawny...!", Toast.LENGTH_SHORT).show()
                } else if(passwordField.text.toString() != secondPasswordField.text.toString()) {
                    Toast.makeText(context, "Podane hasła nie są takie same...!", Toast.LENGTH_SHORT).show()
                } else {
                    Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_registerStepOneFragment)
                }
            } else {
                Toast.makeText(context, "Uzupełnij wszystkie pola...!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegisterFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegisterFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}