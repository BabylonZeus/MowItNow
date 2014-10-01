package mow;

import mow.entities.Position;
import mow.entities.Tondeuse;
import org.fest.util.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static mow.Environment.*;
import static org.fest.assertions.api.Assertions.assertThat;
import static mow.enums.Action.*;
import static mow.enums.Direction.*;

public class GameTest {
	@Before
	public void setUp() {
		gridMaximumValueX = 5;
		gridMaximumValueY = 5;
	}

	@Test
	public void shouldBuildTondeuses() {
		ArrayList<Tondeuse> tondeuses = Lists.newArrayList(
				new Tondeuse(new Position(1, 2, N)),
				new Tondeuse(new Position(3, 3, E)));
		Game g = new Game(tondeuses);
		assertThat(g.getTondeuses()).hasSize(2);
	}

	@Test
	public void shouldFullyMoveTondeuses() {
		ArrayList<Tondeuse> tondeuses = Lists.newArrayList(
				new Tondeuse(new Position(1, 2, N), Lists.newArrayList(G, A, G, A, G, A, G, A, A)),
				new Tondeuse(new Position(3, 3, E), Lists.newArrayList(A, A, D, A, A, D, A, D, D, A))
		);
		Game g = new Game(tondeuses);
		g.fullyMoveTondeuses();
		assertThat(g.getTondeuses().get(0).getPosition()).isEqualsToByComparingFields(new Position(1, 3, N));
		assertThat(g.getTondeuses().get(1).getPosition()).isEqualsToByComparingFields(new Position(5, 1, E));
	}
}
