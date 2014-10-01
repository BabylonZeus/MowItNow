package mow;

import mow.entities.Tondeuse;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private List<Tondeuse> tondeuses;

	public Game(ArrayList<Tondeuse> tondeuses) {
		this.tondeuses = tondeuses;
	}

	public List<Tondeuse> getTondeuses() {
		return tondeuses;
	}

	public void fullyMoveTondeuses() {
		for (int i = 0; i < tondeuses.size(); i++) {
			Tondeuse t = tondeuses.get(i);
			Integer totalNumberOfActions = t.getActions().size();
			for (int j = 0; j < totalNumberOfActions; j++) {
				t.executeAndRemoveNextAction();
			}
		}
	}

	public void printResults() {
		for (int i = 0; i < tondeuses.size(); i++) {
			System.out.println("Tondeuse N°" + i + " : " + tondeuses.get(i).toString());
		}
	}
}
