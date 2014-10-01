package mow.entities;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static mow.enums.Direction.*;

public class PositionTest {
	@Test
	public void shouldGetX() {
		Position p = new Position(1, 2, N);
		assertThat(p.getX()).isEqualTo(1);
	}

	@Test
	public void shouldGetY() {
		Position p = new Position(1, 2, N);
		assertThat(p.getY()).isEqualTo(2);
	}

	@Test
	public void shouldGetDirection() {
		Position p = new Position(1, 2, N);
		assertThat(p.getDirection()).isEqualTo(N);
	}

}
