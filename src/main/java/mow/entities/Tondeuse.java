package mow.entities;

import mow.enums.Action;
import mow.enums.Direction;

import java.util.List;

import static mow.Environment.*;

public class Tondeuse {
	private Position position;
	private List<Action> actions;

	public Position getPosition() {
		return position;
	}

	public Tondeuse(Position position) {
		this.position = position;
	}

	public Tondeuse(Position position, List<Action> actions) {
		this.position = position;
		this.actions = actions;
	}

	public void avancer() {
		switch (position.getDirection()) {
			case N:
				if (position.getY() < gridMaximumValueY)
					position.setY(position.getY() + 1);
				break;
			case E:
				if (position.getX() < gridMaximumValueX)
					position.setX(position.getX() + 1);
				break;
			case W:
				if (position.getX() > 0)
					position.setX(position.getX() - 1);
				break;
			case S:
				if (position.getY() > 0)
					position.setY(position.getY() - 1);
				break;
		}
	}

	public void rotateLeft() {
		switch (position.getDirection()) {
			case N:
				position.setDirection(Direction.W);
				break;
			case E:
				position.setDirection(Direction.N);
				break;
			case W:
				position.setDirection(Direction.S);
				break;
			case S:
				position.setDirection(Direction.E);
				break;
		}
	}

	public void rotateRight() {
		switch (position.getDirection()) {
			case N:
				position.setDirection(Direction.E);
				break;
			case E:
				position.setDirection(Direction.S);
				break;
			case W:
				position.setDirection(Direction.N);
				break;
			case S:
				position.setDirection(Direction.W);
				break;
		}
	}

	@Override
	public String toString() {
		return "Position={" + getPosition() + "}";
	}

	public List<Action> getActions() {
		return actions;
	}

	public void executeAndRemoveNextAction() {
		executeNextAction();
		removeNextAction();
	}

	private void executeNextAction() {
		if (actions != null && actions.size() > 0) {
			switch (actions.get(0)) {
				case A:
					avancer();
					break;
				case G:
					rotateLeft();
					break;
				case D:
					rotateRight();
					break;
			}
		}
	}

	private void removeNextAction() {
		if (actions != null && actions.size() > 0) {
			actions.remove(0);
		}
	}
}
