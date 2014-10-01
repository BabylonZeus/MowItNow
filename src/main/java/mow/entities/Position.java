package mow.entities;

import mow.enums.Direction;

public class Position {

	private Integer x;
	private Integer y;
	private Direction direction;

	public Integer getX() { return x; }
	public Integer getY() { return y; }
	public Direction getDirection() { return direction; }

	public void setX(Integer x) { this.x = x; }
	public void setY(Integer y) { this.y = y; }
	public void setDirection(Direction direction) { this.direction = direction; }

	public Position(Integer x, Integer y, Direction direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "X=" + x + "; Y=" + y + "; D=" + direction;
	}
}
