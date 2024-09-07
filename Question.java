import java.util.List;

public class Question {
	private String question;
	private List<String> options;
	private int correctAns;
	Question(String question,List<String> options,int correctOptionIndex){
		this.question=question;
		this.options=options;
		this.correctAns=correctOptionIndex;
	}
	public int getCorrectAns(){
		return correctAns;
	}
	public String getQuestion(){
		return question;
	}
	public List<String> getOptions(){
		return options;
	}
}
