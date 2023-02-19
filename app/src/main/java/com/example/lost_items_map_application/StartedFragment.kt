package com.example.lost_items_map_application

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [StartedFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StartedFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var startedAnimatedInstruction: TextView
    lateinit var animatedElement0: TextView
    lateinit var animatedElement1: TextView
    lateinit var animatedElement2: TextView

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
        return inflater.inflate(R.layout.fragment_started, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startedAnimatedInstruction = view.findViewById(R.id.startedAnimatedInstruction)

        animatedElement0 = view.findViewById(R.id.animatedElement0)
        animatedElement1 = view.findViewById(R.id.animatedElement1)
        animatedElement2 = view.findViewById(R.id.animatedElement2)

        startAnimation()
    }

    override fun onResume() {
        super.onResume()

        startAnimation()
    }

    private fun startAnimation() {
        val animation1 = AnimationUtils.loadAnimation(context, R.anim.anim_1)
        val animation2 = AnimationUtils.loadAnimation(context, R.anim.anim_2)
        val animation3 = AnimationUtils.loadAnimation(context, R.anim.anim_3)
        val animation4 = AnimationUtils.loadAnimation(context, R.anim.anim_4)

        startedAnimatedInstruction.startAnimation(animation1)

        animatedElement0.startAnimation(animation2)
        animatedElement1.startAnimation(animation3)
        animatedElement2.startAnimation(animation4)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment StartedFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StartedFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}