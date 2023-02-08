package edu.hust.tu.projecti.question;

import edu.hust.tu.projecti.services.QuestionService;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.*;
import java.util.function.IntFunction;

/**
 * <h1> QUESTION </h1>
 * This class is an implement of question in services.
 * Each new object take 15 random questions in services
 * with 5 level-5, 5 level-10 and 5 level-15
 * <b>Note:</b> For other question distribution, consider checking {@link Question}.
 * Upon constructed, this class create an 15-wide array of {@link QuestionContent}s
 * which is public to use.
 */
public class P1QuestionSet implements Set<QuestionContent> {
	public QuestionContent[] questions;

    /**
     * Constructor of question
     */
    public P1QuestionSet(){
        this.questions = new QuestionContent[15];
        for (int i = 0; i < 15; i++){
            questions[i] = new QuestionContent();
        }
        addQuestion(5);
        addQuestion(10);
        addQuestion(15);
    }

    /**
     * This method refresh Question with another one at level = level
     * <b> Note </b> In this project, at least 5 Question object is needed.
     */
    private void addQuestion(int level){
		try {
			var sqlQuestion = QuestionService.getQuestions(level, 5);
            for (int i = level - 5; i < level; i++){
                sqlQuestion.next();
                this.questions[i].id = sqlQuestion.getInt("QID");
                this.questions[i].question = sqlQuestion.getString("Question");
                //this.questions[i].answers.clear();
                this.questions[i].answers[0] = sqlQuestion.getString("RightAnswer");
                this.questions[i].answers[1] = sqlQuestion.getString("WrongAnswer1");
                this.questions[i].answers[2] = sqlQuestion.getString("WrongAnswer2");
                this.questions[i].answers[3] = sqlQuestion.getString("WrongAnswer3");

                //shuffle answer and retrieve right answer id
                var tmpR = this.questions[i].answers[0];
                var tmpL = Arrays.asList(this.questions[i].answers);
                Collections.shuffle(tmpL);
                tmpL.toArray(this.questions[i].answers);
                for ( int j = 0; j < 4; j++){
                    if(tmpR.equals(questions[i].answers[j])){
                        this.questions[i].rightAnswer = j;
                        break;
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Query failed in taking a question");
        }
    }

	@Override
	public int size() {
		return questions.length;
	}

	@Override
	public boolean isEmpty() {
		return questions.length == 0;
	}

	@Override
	public boolean contains(Object o) {
		if (o instanceof QuestionContent) {
			for (QuestionContent questionContent : questions) {
				if (questionContent.id == (((QuestionContent) o).id)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Iterator<QuestionContent> iterator() {
		return new Iterator<>() {
			// next index of iterator
			int next = 0;

			@Override
			public boolean hasNext() {
				try {
					return questions[next] != null;
				} catch (IndexOutOfBoundsException e) {
					return false;
				}
			}

			@Override
			public QuestionContent next() {
				try {
					return questions[next++];
				} catch (IndexOutOfBoundsException e) {
					return null;
				}
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	@Override
	public Object[] toArray() {
		return questions.clone();
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T[] toArray(T[] input) {
		// new array of whichever longer
		T[] output = input.length >= questions.length ?
				input :
				(T[]) Array.newInstance(input.getClass().getComponentType(), questions.length);

		var iterator = iterator();
		for (int i = 0; i < output.length; i++) {
			if (!iterator.hasNext()) { // fewer elements than expected
				if (input != output) return Arrays.copyOf(output, i); // if input is shorter
				output[i] = null; // input is longer, output = input, add null-terminate
				return output;
			}
			// copy questions to output if sufficient
			output[i] = (T) iterator.next();
		}
		/*if (!iterator.hasNext())*/ return output; // done copying

	}

	@Override
	public <T> T[] toArray(IntFunction<T[]> generator) {
		return Set.super.toArray(generator);
	}

	@Override
	public boolean add(QuestionContent questionContent) {
		throw new UnsupportedOperationException("This Set only support read");
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException("This Set only support read");
	}

	@Override
	public boolean containsAll(Collection<?> collection) {
		for (var x : collection) {
			if (!this.contains(x)) return false;
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends QuestionContent> collection) {
		throw new UnsupportedOperationException("This Set only support read");
	}

	@Override
	public boolean retainAll(Collection<?> collection) {
		throw new UnsupportedOperationException("This Set only support read");
	}

	@Override
	public boolean removeAll(Collection<?> collection) {
		throw new UnsupportedOperationException("This Set only support read");
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException("This Set only support read");
	}
}
