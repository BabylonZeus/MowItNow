package mow;

import mow.entities.Position;
import mow.entities.Tondeuse;
import org.fest.util.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static mow.Environment.*;
import static mow.enums.Action.A;
import static mow.enums.Action.D;
import static mow.enums.Action.G;
import static mow.enums.Direction.E;
import static mow.enums.Direction.N;

public class GameIntegTest {

	@Before
	public void setUp() {
		gridMaximumValueX = 5;
		gridMaximumValueY = 5;}

	@Test
	public void run() {
		ArrayList<Tondeuse> tondeuses = Lists.newArrayList(
				new Tondeuse(new Position(1, 2, N), Lists.newArrayList(G, A, G, A, G, A, G, A, A)),
				new Tondeuse(new Position(3, 3, E), Lists.newArrayList(A, A, D, A, A, D, A, D, D, A))
		);
		Game g = new Game(tondeuses);
		g.fullyMoveTondeuses();
		g.printResults();
	}
}
