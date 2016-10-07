import java.util.HashMap;

public class State {
	private int stateNum;
	private HashMap<String, Integer> hmTransitions;
	public State(int currentState, String input, int nextState) {
		this.stateNum = currentState;
		hmTransitions = new HashMap<>();
		hmTransitions.put(input, nextState);
	}

	public int getState() {
		return stateNum;
	}
	
	public int getNextState(String input) {
		if(hmTransitions.containsKey(input)){
			return hmTransitions.get(input);
		} else {
			return -1;
		}
	}

	public void addTransition(String input, int nextState) {
		hmTransitions.put(input, nextState);
	}

}
