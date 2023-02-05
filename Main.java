
package question;

import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
	
	public static void main(String[] args) {
		
		Ball ball = new Ball(30);
		ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
		Obstacle obstacle1 = new Obstacle(2,10,2);
		Obstacle obstacle2 = new Obstacle(1,5,25);
		obstacles.add(obstacle1);
		obstacles.add(obstacle2);
		
		GameScene scene = new GameScene(obstacles, ball, 100);
		double result = scene.findVelocity(45.0);
		System.out.println(result);
	}

}

