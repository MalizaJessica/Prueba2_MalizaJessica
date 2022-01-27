package app004.flagquizapp;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ResultadoButtonListener_MJ implements OnClickListener {
    private MainActivityFragment_MJ mainActivityFragmentBandera;
    private Handler handler;

    public ResultadoButtonListener_MJ(MainActivityFragment_MJ mainActivityFragmentBandera) {
        this.mainActivityFragmentBandera = mainActivityFragmentBandera;
        this.handler = new Handler();
    }

    @Override
    public void onClick(View v) {
        Button guessButton = ((Button) v);
        String guess = guessButton.getText().toString();
        String answer = this.mainActivityFragmentBandera.getQuizViewModel().getCorrectCountryName();
        this.mainActivityFragmentBandera.getQuizViewModel().setTotalGuesses(1);

        if (guess.equals(answer)) {
            this.mainActivityFragmentBandera.getQuizViewModel().setCorrectAnswers(1);
            this.mainActivityFragmentBandera.getAnswerTextView().setText(answer + "!");
            this.mainActivityFragmentBandera.getAnswerTextView().setTextColor(
                    this.mainActivityFragmentBandera.getResources().getColor(R.color.correct_answer));

            this.mainActivityFragmentBandera.disableButtons();

            if (this.mainActivityFragmentBandera.getQuizViewModel().getCorrectAnswers()
                    == LogicaDePreguntas_MJ.getFlagsInQuiz()) {
                ResultadosDialogFragment_MJ quizResults = new ResultadosDialogFragment_MJ();
                quizResults.setCancelable(false);
                try {
                    quizResults.show(this.mainActivityFragmentBandera.getChildFragmentManager(), "Quiz Results");
                } catch (NullPointerException e) {
                    Log.e(LogicaDePreguntas_MJ.getTag(),
                            "GuessButtonListener: this.mainActivityFragment.getFragmentManager() " +
                                    "returned null",
                            e);
                }
            } else {
                this.handler.postDelayed(
                        new Runnable() {
                            @Override
                            public void run() {
                                mainActivityFragmentBandera.animate(true);
                            }
                        }, 2000);
            }
        } else {
            this.mainActivityFragmentBandera.incorrectAnswerAnimation();
            guessButton.setEnabled(false);
        }
    }
}
