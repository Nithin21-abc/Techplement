import java.util.*;
public class QuizGenerator {
    static Map<String, Quiz> quizzes = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);
    private static void showMenu(){
    	System.out.println("\n--- Quiz Generator ---");
    	System.out.println("1. Create a new quiz");
    	System.out.println("2. Take a quiz");
    	System.out.println("3. Exit");
    	System.out.print("Enter your choice: ");
    	
    }
    private static void createQuiz(){
    	System.out.println("Enter the title of QUIZ:");
    	String title=sc.nextLine();
    	Quiz quiz=new Quiz(title);
    	while(true)
    	{
    		System.out.println("Do you want to add question?(Yes/No):");
    		String addOneMore=sc.nextLine();
    		if(addOneMore.equalsIgnoreCase("yes"))
    		{
    			System.out.print("Enter the question: ");
    			String question = sc.nextLine();
    			
    			List<String> options = new ArrayList<>();
    			for (int i = 0; i < 4; i++) {
    				System.out.print("Enter option " + (i + 1) + ": ");
    				options.add(sc.nextLine());
    			}

    			System.out.print("Enter the index of the correct option (1-4): ");
    			int correctOptionIndex = sc.nextInt()-1;
    			sc.nextLine();

    			quiz.addQuestion(new Question(question, options, correctOptionIndex));
    			System.out.println("Question added successfully.");
    			quizzes.put(title,quiz);
    		}
    		else
    			return;
    	}
    }
    public static void takeQuiz(){
    	System.out.println("QUIZ Topics:");
    	Iterator<String> itr=quizzes.keySet().iterator();
    	int i=1;
    	while(itr.hasNext())
    		System.out.println(i+"."+itr.next());
    	System.out.println("Enter the one quiz topic:");
    	String topic=sc.nextLine();
    	Quiz quiz=quizzes.get(topic);
    	
    	int score = 0;
        List<Question> questions = quiz.getQuestions();

        for (Question question : questions) {
            System.out.println("\n" + question.getQuestion());
            List<String> options = question.getOptions();
            for (i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            System.out.print("Enter your answer (1-4): ");
            int userAnswer = sc.nextInt() - 1;
            sc.nextLine(); 

            if (userAnswer == question.getCorrectAns()) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect Answer. The correct answer was: " + 
                                   options.get(question.getCorrectAns()));
            }
        }

        System.out.println("\nYour score: " + score + " out of " + questions.size());
    }
	public static void main(String[] args) {
		 while(true) {
	            showMenu();
	            String choice = sc.nextLine();
	            switch (choice) {
	                case "1":
	                    createQuiz();
	                    break;
	                case "2":
	                    takeQuiz();
	                    break;
	                case "3":
	                    System.out.println("Exiting the application.");
	                    return;
	                default:
	                    System.out.println("Invalid option. Please try again.");
	            }
	        }
	}

}
