package scrumcourse.env;

public class TimeFake {

	private static final long NANOS_PER_SECONDS = 1000000000L;

	private static final long SECONDS_PER_HOUR = 3600;


	public void nanoTime() {
		return System.nanoTime();
		
	}

}
