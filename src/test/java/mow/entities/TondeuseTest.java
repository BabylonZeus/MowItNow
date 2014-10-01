package mow.entities;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static mow.Environment.*;
import static mow.enums.Direction.*;
import static mow.enums.Action.*;

public class TondeuseTest {

	@Before
	public void setUp() {
		gridMaximumValueX = 5;
		gridMaximumValueY = 5;
	}

	@Test
	public void shouldGetTondeusePosition() {
		Tondeuse tondeuse = new Tondeuse(new Position(0, 0, N));
		assertThat(tondeuse.getPosition()).isEqualsToByComparingFields(new Position(0, 0, N));
	}

	@Test
	public void shouldAvanceTondeuseToNorth() {
		Tondeuse tondeuse = new Tondeuse(new Position(0, 0, N));
		tondeuse.avancer();
		assertThat(tondeuse.getPosition()).isEqualsToByComparingFields(new Position(0, 1, N));
	}

	@Test
	public void shouldAvanceTondeuseToEast() {
		Tondeuse tondeuse = new Tondeuse(new Position(0, 0, E));
		tondeuse.avancer();
		assertThat(tondeuse.getPosition()).isEqualsToByComparingFields(new Position(1, 0, E));
	}

	@Test
	public void shouldAvanceTondeuseToWest() {
		Tondeuse tondeuse = new Tondeuse(new Position(1, 2, W));
		tondeuse.avancer();
		assertThat(tondeuse.getPosition()).isEqualsToByComparingFields(new Position(0, 2, W));
	}

	@Test
	public void shouldAvanceTondeuseToSouth() {
		Tondeuse tondeuse = new Tondeuse(new Position(1, 2, S));
		tondeuse.avancer();
		assertThat(tondeuse.getPosition()).isEqualsToByComparingFields(new Position(1, 1, S));
	}

	@Test
	public void shouldBlockTondeuseToNorth() {
		Tondeuse tondeuse = new Tondeuse(new Position(1, 5, N));
		tondeuse.avancer();
		assertThat(tondeuse.getPosition()).isEqualsToByComparingFields(new Position(1, 5, N));
	}

	@Test
	public void shouldBlockTondeuseToEast() {
		Tondeuse tondeuse = new Tondeuse(new Position(5, 1, E));
		tondeuse.avancer();
		assertThat(tondeuse.getPosition()).isEqualsToByComparingFields(new Position(5, 1, E));
	}

	@Test
	public void shouldBlockTondeuseToWest() {
		Tondeuse tondeuse = new Tondeuse(new Position(0, 1, W));
		tondeuse.avancer();
		assertThat(tondeuse.getPosition()).isEqualsToByComparingFields(new Position(0, 1, W));
	}

	@Test
	public void shouldBlockTondeuseToSouth() {
		Tondeuse tondeuse = new Tondeuse(new Position(1, 0, S));
		tondeuse.avancer();
		assertThat(tondeuse.getPosition()).isEqualsToByComparingFields(new Position(1, 0, S));
	}

	@Test
	public void shouldRotateLeftToEast() {
		Tondeuse tondeuse = new Tondeuse(new Position(1, 0, S));
		tondeuse.rotateLeft();
		assertThat(tondeuse.getPosition()).isEqualsToByComparingFields(new Position(1, 0, E));
	}

	@Test
	public void shouldRotateLeftToNorth() {
		Tondeuse tondeuse = new Tondeuse(new Position(1, 0, E));
		tondeuse.rotateLeft();
		assertThat(tondeuse.getPosition()).isEqualsToByComparingFields(new Position(1, 0, N));
	}

	@Test
	public void shouldRotateLeftToWest() {
		Tondeuse tondeuse = new Tondeuse(new Position(1, 0, N));
		tondeuse.rotateLeft();
		assertThat(tondeuse.getPosition()).isEqualsToByComparingFields(new Position(1, 0, W));
	}

	@Test
	public void shouldRotateLeftToSouth() {
		Tondeuse tondeuse = new Tondeuse(new Position(1, 0, W));
		tondeuse.rotateLeft();
		assertThat(tondeuse.getPosition()).isEqualsToByComparingFields(new Position(1, 0, S));
	}

	@Test
	public void shouldRotateRightToEast() {
		Tondeuse tondeuse = new Tondeuse(new Position(1, 0, N));
		tondeuse.rotateRight();
		assertThat(tondeuse.getPosition()).isEqualsToByComparingFields(new Position(1, 0, E));
	}

	@Test
	public void shouldRotateRightToNorth() {
		Tondeuse tondeuse = new Tondeuse(new Position(1, 0, W));
		tondeuse.rotateRight();
		assertThat(tondeuse.getPosition()).isEqualsToByComparingFields(new Position(1, 0, N));
	}

	@Test
	public void shouldRotateRightToWest() {
		Tondeuse tondeuse = new Tondeuse(new Position(1, 0, S));
		tondeuse.rotateRight();
		assertThat(tondeuse.getPosition()).isEqualsToByComparingFields(new Position(1, 0, W));
	}

	@Test
	public void shouldRotateRightToSouth() {
		Tondeuse tondeuse = new Tondeuse(new Position(1, 0, E));
		tondeuse.rotateRight();
		assertThat(tondeuse.getPosition()).isEqualsToByComparingFields(new Position(1, 0, S));
	}

	@Test
	public void shouldExecuteAndUnstackNextAction() {
		Tondeuse tondeuse = new Tondeuse(new Position(1, 1, E), Lists.newArrayList(D, A));
		tondeuse.executeAndRemoveNextAction();
		assertThat(tondeuse.getPosition()).isEqualsToByComparingFields(new Position(1, 1, S));
		assertThat(tondeuse.getActions()).hasSize(1);
	}

	@Test
	public void shouldBuildActions() {
		Tondeuse tondeuse = new Tondeuse(new Position(1, 0, E), Lists.newArrayList(G, D, A));
		assertThat(tondeuse.getActions()).hasSize(3);
	}
}
