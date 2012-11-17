
import stanford.karel.*;

public class DefendsDemocracy extends SuperKarel {
	public void run() {
		while(frontIsClear()){
			move();
			if(noBeepersPresent()){
				cleanBallot();
				move();
			} else {
				move();
			}
		}		
	}
			
	private void cleanBallot() {
		cleanTop();
		cleanBottom();
	}

	private void cleanTop() {
		turnLeft();
		move();
		while(beepersPresent()){
			pickBeeper();
		}
		turnAround();
		move();
		turnLeft();
	}

	private void cleanBottom() {
		turnRight();
		move();
		while(beepersPresent()){
			pickBeeper();
		}
		turnAround();
		move();
		turnRight();
	}

}
