
package question;

import java.util.ArrayList;

public class GameScene {

	// Data Fields
	private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	private Ball ball;

	private int targetX;
	private int targetY = 0;

	private static final int MAX_ANGLE = 90;
	private static final int MAX_VELOCITY = 100;
	private static final int MIN_VELOCITY = 20;
	
	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	
	public GameScene(ArrayList<Obstacle> obstacles, Ball ball, int targetX){		// Constructor for Game scene with obstacles, a ball and a target
		this.obstacles = obstacles;
		this.ball = ball;
		this.targetX = targetX;
	}
	
	public void setTargetX(int targetX) {		// Setter method for the target
		this.targetX = targetX;
	}


	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

	public double findVelocity(double angle) {

		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		double Vx;
		double time;
		double g = 9.81;
		
		double timeSqr = Math.tan(Math.toRadians(angle)) * targetX * 2 / g ;	// First I find the velocity if there is no obstacle using given properties
		
		time = Math.sqrt(timeSqr);
		Vx = targetX / time;
		ball.setVelocity(Vx / Math.cos(Math.toRadians(angle)));
		System.out.println(ball.getVelocity());
		
		for (Obstacle obstacle : obstacles) {				// After that for each obstacle, I find the required time to be reached the obstacle
			double obstacleTime1 = obstacle.getX() / Vx;	// If the ball is at a higher level than the obstacle's height, it can pass over the obstacle
			double obstacleTime2 = ( obstacle.getX() + obstacle.getWidth() ) / Vx;	
															
			double ballHeight = ball.getVelocity() * Math.sin(Math.toRadians(angle)) * obstacleTime1 - 0.5 * g * Math.pow(obstacleTime1, 2);
			double ballHeight2 = ball.getVelocity() * Math.sin(Math.toRadians(angle)) * obstacleTime2 - 0.5 * g * Math.pow(obstacleTime2, 2);
			
			if (ballHeight < obstacle.getHeight() || ballHeight2 < obstacle.getHeight()) {		// If not, it collapses and velocity returns -1
				ball.setVelocity(-1.0);
				return ball.getVelocity();
			}
		}
		
		if (ball.getVelocity() < MIN_VELOCITY || ball.getVelocity() > MAX_VELOCITY)
			ball.setVelocity(-1.0);
		
		
		return ball.getVelocity();

		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
	}
}


