package be.seeseemelk.mockbukkit.entity;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import org.bukkit.DyeColor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.bukkit.entity.Cat.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CatMockTest
{

	private CatMock cat;

	@BeforeEach
	public void setup()
	{
		ServerMock server = MockBukkit.mock();
		cat = new CatMock(server, UUID.randomUUID());
	}

	@AfterEach
	public void teardown()
	{
		MockBukkit.unmock();
	}

	@Test
	public void testGetCatTypeDefault()
	{
		assertEquals(Type.SIAMESE, cat.getCatType());
	}

	@Test
	void testSetCatType()
	{
		cat.setCatType(Type.CALICO);
		assertEquals(Type.CALICO, cat.getCatType());
	}

	@Test
	void testSetCatTypeNullThrows()
	{
		assertThrows(NullPointerException.class, () -> cat.setCatType(null));
	}

	@Test
	void testGetCollarColorDefault()
	{
		assertEquals(DyeColor.WHITE, cat.getCollarColor());
	}

	@Test
	void testSetCollarColor()
	{
		cat.setCollarColor(DyeColor.BLACK);
		assertEquals(DyeColor.BLACK, cat.getCollarColor());
	}

	@Test
	void testSetCollarColorNullThrows()
	{
		assertThrows(NullPointerException.class, () -> cat.setCollarColor(null));
	}

	@Test
	void testGetIsLyingDownDefault()
	{
		assertFalse(cat.isLyingDown());
	}

	@Test
	void testSetIsLyingDown()
	{
		cat.setLyingDown(true);
		assertTrue(cat.isLyingDown());
	}

	@Test
	void testGetIsHeadUpDefault()
	{
		assertFalse(cat.isHeadUp());
	}

	@Test
	void testSetIsHeadUp()
	{
		cat.setHeadUp(true);
		assertTrue(cat.isHeadUp());
	}

}
