package com.example.list


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.list.databinding.FragmentCheatBinding
import com.example.list.databinding.FragmentMainBinding

/**
 * A simple [Fragment] subclass.
 */
class CheatFragment : Fragment() {


    private lateinit var binding: FragmentCheatBinding;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //ADD BINDING
        binding = DataBindingUtil.inflate<FragmentCheatBinding>(
            inflater,
            R.layout.fragment_cheat, container, false
        )

        //EXTRACT PASSED ARGS
        val args = CheatFragmentArgs.fromBundle(arguments!!)




        binding.apply {
            quetsionTitleCheat.text = args.questionText;
            cheatButton.setOnClickListener { showAnswer(args.answerText) }
            //cancelCheatButton.setOnClickListener { view:View-> view.findNavController().navigate(R.id.action_cheatFragment_to_mainFragment) }
            cancelCheatButton.setOnClickListener {  activity!!.onBackPressed() }
        }



        return binding.root
    }


    private fun showAnswer(answer: String) {

        binding.answerTextCheat.text = answer;
    }


}
