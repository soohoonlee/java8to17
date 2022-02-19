package me.ssoon.java8to17.datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class App {

	public static void main(String[] args) {
		final Instant instant = Instant.now();
		System.out.println(instant);    // 기준시 UTC, GMT
		System.out.println(instant.atZone(ZoneId.of("UTC")));

		final ZoneId zone = ZoneId.systemDefault();
		System.out.println(zone);

		final ZonedDateTime zonedDateTime = instant.atZone(zone);
		System.out.println(zonedDateTime);

		final LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		final LocalDateTime plus1 = now.plus(10, ChronoUnit.DAYS);
		System.out.println(plus1);

		final LocalDateTime birthDay = LocalDateTime.of(1982, Month.NOVEMBER, 26, 0, 0);
		System.out.println(birthDay);

		final ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
		System.out.println(nowInKorea);


		LocalDate today = LocalDate.now();
		LocalDate thisYearBirthday = LocalDate.of(2022, Month.NOVEMBER, 26);
		final Period period = Period.between(today, thisYearBirthday);
		System.out.println(period.getDays());

		final Period until = today.until(thisYearBirthday);
		System.out.println(until.get(ChronoUnit.DAYS));

		final Instant plus = instant.plus(10, ChronoUnit.SECONDS);
		final Duration between = Duration.between(instant, plus);
		System.out.println(between.getSeconds());

		final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		System.out.println(dateTimeFormatter.format(now));

		final LocalDate parse = LocalDate.parse("2022-11-26", dateTimeFormatter);
		System.out.println(parse);

		final Date date = new Date();
		final Instant instant1 = date.toInstant();
		final Date date1 = Date.from(instant1);

		final GregorianCalendar gregorianCalendar = new GregorianCalendar();
		final LocalDateTime localDateTime = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		final GregorianCalendar gregorianCalendar1 = GregorianCalendar.from(localDateTime.atZone(ZoneId.systemDefault()));

		final ZoneId zoneId = TimeZone.getTimeZone("PST").toZoneId();
		final TimeZone timeZone = TimeZone.getTimeZone(zoneId);
	}
}
