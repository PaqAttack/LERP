import java.awt.Point;

public class Lerp {

	/**
	 * This program would be used to update the position of a GameObject between 
	 * waypoints on a graph that would be generated through pathfinding.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		int UPS = 60;					// updates per second
		double moveSpeed = 10.0;		// pixels per second
		
		// Set start and end Point
		Point start = new Point(1, 1);
		Point end = new Point(200, 200);
		
		// Linearly interpolate direct path and step information.
		DoLerp(moveSpeed, UPS, start, end);
	}
	/**
	 * Determine step information for even speed direct travel between two points
	 * @param moveSpeed is the speed in pixels of movement per second.
	 * @param UPS is the # of updates per second.
	 * @param start is the Point that is started from.
	 * @param end is the Point that we're going to.
	 */
	private static void DoLerp(double moveSpeed, int UPS, Point start, Point end) {
		// get distance of travel. We only want positive values here.
		int xDif = Math.abs(start.x - end.x);
		int yDif = Math.abs(start.y - end.y);
		double distance = Math.sqrt(((xDif * xDif) + (yDif * yDif)));
		
		// Determine the % of movement along each axis.
		double xPercent = xDif / distance;
		double yPercent = 1.0 - xPercent;
		
		// Determine pixels of movement each update
		double stepPerUpdate = moveSpeed / UPS;
		
		// determine # of seconds to reach target
		double timeToReachTarget = distance / stepPerUpdate / UPS;
		
		// Determine x change per update
		double xMovePerUpdate = xPercent * stepPerUpdate;
		
		// determine y change per update
		double yMovePerUpdate = yPercent * stepPerUpdate;
		
		// print out information
		System.out.println("Distance to travel is: " + distance);
		System.out.println("Pixels moved per Update: " + stepPerUpdate);
		System.out.println("Time to reach end in seconds: " + timeToReachTarget);
		
		System.out.println("X movement per update: " + xMovePerUpdate);
		System.out.println("Y movement per update: " + yMovePerUpdate);
	}

}
