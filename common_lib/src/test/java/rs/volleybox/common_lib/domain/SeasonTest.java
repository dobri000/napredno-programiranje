package rs.volleybox.common_lib.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SeasonTest {

	private Season season;

    @BeforeEach
    public void setUp() {
        season = new Season(1, 2022, 2023);
    }

    @AfterEach
    public void tearDown() {
        season = null;
    }

    @Test
    public void testGetSeasonId() {
        assertEquals(1, season.getSeasonId());
    }

    @Test
    public void testSetSeasonId() {
        season.setSeasonId(2);
        assertEquals(2, season.getSeasonId());
    }

    @Test
    public void testGetStartYear() {
        assertEquals(2022, season.getStartYear());
    }

    @Test
    public void testSetStartYear() {
        season.setStartYear(2024);
        assertEquals(2024, season.getStartYear());
    }

    @Test
    public void testSetStartYearWithNegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> season.setStartYear(-2022));
    }

    @Test
    public void testGetEndYear() {
        assertEquals(2023, season.getEndYear());
    }

    @Test
    public void testSetEndYear() {
        season.setEndYear(2025);
        assertEquals(2025, season.getEndYear());
    }

    @Test
    public void testSetEndYearWithNegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> season.setEndYear(-2023));
    }

    @Test
    public void testEquals() {
        Season sameSeason = new Season(1, 2022, 2023);
        assertEquals(season, sameSeason);
    }

    @Test
    public void testToString() {
        String expectedToString = "2022/2023";
        assertEquals(expectedToString, season.toString());
    }

}
