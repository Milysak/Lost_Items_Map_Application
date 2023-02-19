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
import org.w3c.dom.Text

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterStepOneFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterStepOneFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_register_step_one, container, false)

        val listener = activity as mInterface?

        listener?.update(false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = view.findViewById<TextView>(R.id.nameField)
        val surname = view.findViewById<TextView>(R.id.surnameField)
        val nickName = view.findViewById<TextView>(R.id.pseudonimField)

        view.findViewById<Button>(R.id.nextButton).setOnClickListener {
            if(name.text.isNotEmpty() && nickName.text.isNotEmpty()) {
                Navigation.findNavController(view).navigate(R.id.action_registerStepOneFragment_to_registerStepTwoFragment)
            }
            else {
                Toast.makeText(context, "Uzupełnij wszystkie wymagane pola...!", Toast.LENGTH_SHORT).show()
            }
        }

        view.findViewById<Button>(R.id.backButton).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_registerStepOneFragment_to_registerFragment)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegisterStepOneFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegisterStepOneFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}