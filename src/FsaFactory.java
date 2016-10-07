import java.util.ArrayList;
import java.util.HashSet;

public class FsaFactory {
	private String fsaFile;
	private String testFile;
	private InputReader reader;
	private HashSet<String> alphabet = new HashSet<>();
	private ArrayList<State> stateList;
	private ArrayList<Integer> acceptingStatesList;
	FsaFactory(String fsaFile, String testFile){
		this.fsaFile = fsaFile;
		this.testFile = testFile;
		stateList = new ArrayList<>();
		acceptingStatesList = new ArrayList<>();
	}

	public void run(){
		addFSA();
		testInput();
	}

	private void addFSA(){
		String stateTriplet;
		reader = new InputReader();
		reader.openFile(fsaFile);
		while(!reader.endOfFile()){
			stateTriplet = reader.readLine();
			addState(stateTriplet, stateList);
		}
		reader.closeFile();
		System.out.println("All transitions added.");
	}

	private void addState(String stateTriplet, ArrayList<State> stateList) {
		String[] fsa;
		fsa = stateTriplet.split(" ");
		int currentState = Integer.parseInt(fsa[0]);
		String input = fsa[1];
		alphabet.add(input);
		int nextState = Integer.parseInt(fsa[2]);
		if(fsa.length>3){
			if(fsa[3].equals("*")){
				acceptingStatesList.add(nextState);
			}
		}
		boolean contained = false;
		for(State s:stateList){
			if (s.getState() == currentState) {
				contained = true;
				s.addTransition(input, nextState);
			}
		}
		if (!contained){
			stateList.add(new State(currentState,input,nextState));
		}
	}

	private void testInput() {
		String input;
		int currentState = 1;
		reader = new InputReader();
		reader.openFile(testFile);
		while(!reader.endOfFile()){
			input = reader.readLine();
			if(alphabet.contains(input)){
				for(State s:stateList){
					if(s.getState()==currentState){
						currentState = s.getNextState(input);
						break;
					}
				}
			} else {
				currentState = -1;
			}
			if(currentState==-1){
				break;
			}
		}
		System.out.println(currentState);
		if(acceptingStatesList.contains(currentState)){
			System.out.println("Accepted");
		} else {
			System.out.println("Not accepted");
		}
		

	}
}
