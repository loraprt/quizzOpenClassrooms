package com.example.quizzopenclassrooms.ui.welcome;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quizzopenclassrooms.R;
import com.example.quizzopenclassrooms.databinding.FragmentWelcomeBinding;
import com.example.quizzopenclassrooms.ui.quiz.QuizFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WelcomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WelcomeFragment extends Fragment {

    private FragmentWelcomeBinding binding;
    public static WelcomeFragment newInstance() {
        return new WelcomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view,@Nullable Bundle saveInstanceState){
        super.onViewCreated(view,saveInstanceState);
        binding.playButton.setEnabled(false);

        //Regarder si le champ de text est rempli
        binding.usernameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                boolean isEmpty = editable.toString().isEmpty();
                binding.playButton.setEnabled(!isEmpty);

            }
        });
        //Detecter le clic sur le bouton Let's play pour démarrer le quizz
        binding.playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Naviguez vers le fragement de clique
                //Log.d("Lora","Clic");
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                QuizFragment quizFragment = new QuizFragment();
                fragmentTransaction.replace(R.id.fragment_container_view, quizFragment);
                //fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }
}