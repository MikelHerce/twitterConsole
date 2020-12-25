package infrastructure.helper;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

public class TimeAgoDateHelperTest {
	
	private DateHelper dateHelper = new TimeAgoDateHelper();
	private LocalDateTime now;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		now = LocalDateTime.now();
	}
	
	@Test
	public void one_year_ago() {
		// given
		LocalDateTime oneYearAgo = now.minusYears(1);
		// when
		String timeAgo = dateHelper.timeAgo(oneYearAgo);
		//then
		assertEquals("1 year ago", timeAgo);
	}
	
	@Test
	public void two_year_ago() {
		// given
		LocalDateTime twoYearsAgo = now.minusYears(2);
		// when
		String timeAgo = dateHelper.timeAgo(twoYearsAgo);
		//then
		assertEquals("2 years ago", timeAgo);
	}
	@Test
	public void should_return_empty_if_null() {
		// given
		// when
		String timeAgo = dateHelper.timeAgo(null);
		//then
		assertEquals("", timeAgo);
	}
	@Test
	public void one_month_ago() {
		// given
		LocalDateTime oneMonthAgo = now.minusMonths(1);
		// when
		String timeAgo = dateHelper.timeAgo(oneMonthAgo);
		//then
		assertEquals("1 month ago", timeAgo);
	}
	@Test
	public void two_months_ago() {
		// given
		LocalDateTime twoMonthsAgo = now.minusMonths(2);
		// when
		String timeAgo = dateHelper.timeAgo(twoMonthsAgo);
		//then
		assertEquals("2 months ago", timeAgo);
		
	}
	@Test
	public void one_day_ago() {
		// given
		LocalDateTime oneDayAgo = now.minusDays(1);
		// when
		String timeAgo = dateHelper.timeAgo(oneDayAgo);
		//then
		assertEquals("1 day ago", timeAgo);
	}
	@Test
	public void two_days_ago() {
		// given
		LocalDateTime twoDaysAgo = now.minusDays(2);
		// when
		String timeAgo = dateHelper.timeAgo(twoDaysAgo);
		//then
		assertEquals("2 days ago", timeAgo);
		
	}
	@Test
	public void one_hour_ago() {
		// given
		LocalDateTime oneHourAgo = now.minusHours(1);
		// when
		String timeAgo = dateHelper.timeAgo(oneHourAgo);
		//then
		assertEquals("1 hour ago", timeAgo);
	}
	@Test
	public void two_hours_ago() {
		// given
		LocalDateTime twoHoursAgo = now.minusHours(2);
		// when
		String timeAgo = dateHelper.timeAgo(twoHoursAgo);
		//then
		assertEquals("2 hours ago", timeAgo);
		
	}
	@Test
	public void one_minute_ago() {
		// given
		LocalDateTime oneMinuteAgo = now.minusMinutes(1);
		// when
		String timeAgo = dateHelper.timeAgo(oneMinuteAgo);
		//then
		assertEquals("1 minute ago", timeAgo);
	}
	@Test
	public void two_minutes_ago() {
		// given
		LocalDateTime twoMinutesAgo = now.minusMinutes(2);
		// when
		String timeAgo = dateHelper.timeAgo(twoMinutesAgo);
		//then
		assertEquals("2 minutes ago", timeAgo);
		
	}
	@Test
	public void one_second_ago() {
		// given
		LocalDateTime oneSecondAgo = now.minusSeconds(1);
		// when
		String timeAgo = dateHelper.timeAgo(oneSecondAgo);
		//then
		assertEquals("1 second ago", timeAgo);
	}
	@Test
	public void two_seconds_ago() {
		// given
		LocalDateTime twoSecondsAgo = now.minusSeconds(2);
		// when
		String timeAgo = dateHelper.timeAgo(twoSecondsAgo);
		//then
		assertEquals("2 seconds ago", timeAgo);
		
	}
	@Test
	public void more_than_one_months_days_should_return_1_month() {
		// given
		LocalDateTime moreThan30Days = now.minusDays(31);
		// when
		String timeAgo = dateHelper.timeAgo(moreThan30Days);
		//then
		assertEquals("1 month ago", timeAgo);
		
	}
	@Test
	public void right_now() {
		// given
		LocalDateTime rightNow = now;
		// when
		String timeAgo = dateHelper.timeAgo(rightNow);
		//then
		assertEquals("right now", timeAgo);
		
	}
	
	

}
