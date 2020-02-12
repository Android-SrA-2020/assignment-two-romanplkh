package com.example.list


import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.list.databinding.FragmentMainBinding

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding;
    private var questionIndex = 0;

    //Create list of questions
    private val questionBank = listOf(
        Question(R.string.question_1, false),
        Question(R.string.question_2, true),
        Question(R.string.question_3, true),
        Question(R.string.question_4, false),
        Question(R.string.question_5, false),
        Question(R.string.question_6, true),
        Question(R.string.question_7, false),
        Question(R.string.question_8, true),
        Question(R.string.question_9, false),
        Question(R.string.question_10, false),
        Question(R.string.question_11, false),
        Question(R.string.question_12, true),
        Question(R.string.question_13, false),
        Question(R.string.question_14, true),
        Question(R.string.question_15, false),
        Question(R.string.question_16, false),
        Question(R.string.question_17, true),
        Question(R.string.question_18, false),
        Question(R.string.question_19, false),
        Question(R.string.question_20, true)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentMainBinding>(
            inflater,
            R.layout.fragment_main, container, false
        )
        

        binding.apply {
            nextButton.setOnClickListener {
                nextQ()
            }
            pervButton.setOnClickListener {
                prevQ();
            }
            trueButton.setOnClickListener {
                answer(true)
            }
            falseButton.setOnClickListener {
                answer(false)
            }


            //Cheat Button Click Navigate to
            cheatActionButton.setOnClickListener { view: View ->

                val quest = getString(questionBank[questionIndex].resourceId);

                view.findNavController().navigate(
                    MainFragmentDirections.actionMainFragmentToCheatFragment(
                        quest,
                        questionBank[questionIndex].answer.toString()
                    )
                )
            }
        }


        //TELL VIEW THAT IT HAS AN OPTION MENU, SO IT WILL ENABLE IT
        setHasOptionsMenu(true)

        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //GET VALUE FROM SAVED STATE
        questionIndex = savedInstanceState?.getInt("questionIndex")  ?: questionIndex;

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
               updateView()
    }





    //SAVE STATE
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("questionIndex", questionIndex)

    }


    private fun nextQ() {
        //Get question index. If it is the last question it will be reseted to 0
        questionIndex = (questionIndex + 1) % 20;
        updateView();

    }

    private fun prevQ() {
        questionIndex = if (questionIndex == 0) {
            questionBank.size - 1;
        } else {
            (questionIndex - 1) % 20;
        }

        //questionIndex =  20 - abs(questionIndex - 1) % 20;

        updateView();
    }


    private fun answer(ans: Boolean) {
        if (ans == questionBank[questionIndex].answer) {
            Toast.makeText(requireContext(), "CORRECT", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(requireContext(), "WRONG", Toast.LENGTH_SHORT).show();
        }
    }

    private fun updateView() {
        //Find TextView for question and set question from QuestionBank
        //This resourceId will get text from this resource id
        binding.txtQuestion.setText(questionBank[questionIndex].resourceId)

    }


    //INFLATE OPTIONS MENU ITEM ON UI
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.options_menu, menu)
    }


    //ADD CLICK HANDLER TO OPTIONS MENU
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //CLICK HANDLER MUST NAVIGATE US TO ABOUT FRAGMENT

        //IF WE HAVE CLICK HANDLER THAT SHOULD NAVIGATE US TO FRAGMENT -> GO TO THAT FRAGMENT ELSE DO WHATEVER ACTION ON ITEM SELECTED
        return NavigationUI.onNavDestinationSelected(
            item!!,
            view!!.findNavController()
        ) || super.onOptionsItemSelected(item)
    }

}
