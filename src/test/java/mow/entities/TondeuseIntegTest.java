package mow.entities;

import org.junit.Before;
import org.junit.Test;

import static mow.Environment.gridMaximumValueX;
import static mow.Environment.gridMaximumValueY;
import static mow.enums.Direction.*;

public class TondeuseIntegTest {

	@Before
	public void setUp() {
		gridMaximumValueX = 5;
		gridMaximumValueY = 5;
	}

	@Test
	public void run1() {
		Tondeuse tondeuse = new Tondeuse(new Position(1, 2, N));
		tondeuse.rotateLeft();
		tondeuse.avancer();
		tondeuse.rotateLeft();
		tondeuse.avancer();
		tondeuse.rotateLeft();
		tondeuse.avancer();
		tondeuse.rotateLeft();
		tondeuse.avancer();
		tondeuse.avancer();
		System.out.println(tondeuse.toString());
	}

	@Test
	public void run2() {
		Tondeuse tondeuse = new Tondeuse(new Position(3, 3, E));
		tondeuse.avancer();
		tondeuse.avancer();
		tondeuse.rotateRight();
		tondeuse.avancer();
		tondeuse.avancer();
		tondeuse.rotateRight();
		tondeuse.avancer();
		tondeuse.rotateRight();
		tondeuse.rotateRight();
		tondeuse.avancer();
		System.out.println(tondeuse.toString());
	}
}
