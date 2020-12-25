package infrastructure.helper;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

public class TimeAgoDateHelper implements DateHelper {


	private static final String ONE_SECOND_AGO = "1 second ago";
	private static final String ONE_MINUTE_AGO = "1 minute ago";
	private static final String ONE_HOUR_AGO = "1 hour ago";
	private static final String ONE_DAY_AGO = "1 day ago";
	private static final String ONE_MONTH_AGO = "1 month ago";
	private static final String ONE_YEAR_AGO = "1 year ago";
	
	private static final String SECONDS_AGO = " seconds ago";
	private static final String MINUTE_AGO = " minutes ago";
	private static final String HOURS_AGO = " hours ago";
	private static final String DAYS_AGO = " days ago";
	private static final String MONTHS_AGO = " months ago";
	private static final String YEARS_AGO = " years ago";
	
	@Override
	public String timeAgo(LocalDateTime localDate) {
		String timeAgo = "";
		if (null == localDate) {
			return "";
		}
		LocalDateTime now = LocalDateTime.now();
		
		Period period = Period.between(localDate.toLocalDate(), now.toLocalDate());
		Duration duration = Duration.between(localDate, now);
		
		if (0 != period.getYears()) {
			timeAgo = period.getYears() == 1 ? ONE_YEAR_AGO : period.getYears() + YEARS_AGO;
		}
		else if (0 != period.getMonths()) {
			timeAgo = period.getMonths() == 1 ? ONE_MONTH_AGO : period.getMonths() + MONTHS_AGO;
		}
		else if (0 != period.getDays()) {
			timeAgo = period.getDays() == 1 ? ONE_DAY_AGO : period.getDays() + DAYS_AGO;
		}
		else if (0 != duration.toHours()) {
			timeAgo = duration.toHours() == 1 ? ONE_HOUR_AGO : duration.toHours() + HOURS_AGO;
		}
		else if (0 != duration.toMinutes()) {
			timeAgo = duration.toMinutes() == 1 ? ONE_MINUTE_AGO : duration.toMinutes() + MINUTE_AGO;
		}
		else if (0 != duration.getSeconds()) {
			timeAgo = duration.getSeconds() == 1 ? ONE_SECOND_AGO : duration.getSeconds() + SECONDS_AGO;
		} else {
			timeAgo = "right now";
		}
		
		return timeAgo;
	}
	
	
	
	

}
