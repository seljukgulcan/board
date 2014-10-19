package visual;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

public class Draw {
	
	public static final int POINTY_TOPPED = 0;
	public static final int FLAT_TOPPED = 1;
	
	public static int triangleMode = POINTY_TOPPED;
	public static int hexagonMode = POINTY_TOPPED;
	
	private static float sqrt3 = (float)Math.sqrt( 3);
	
	public static float TRIANGLE_FLAT_TOPPPED_POINTS[][] = { {0, -1.0f}, {-0.5f * sqrt3, 0.5f}, 
		{0.5f * sqrt3, 0.5f}};
	
	public static float TRIANGLE_POINTY_TOPPPED_POINTS[][] = { {0, 1.0f}, {0.5f * sqrt3, -0.5f}, 
		{-0.5f * sqrt3, -0.5f}};
	
	public static float HEXAGON_FLAT_TOPPPED_POINTS[][] = { {1.0f, 0}, {0.5f, -0.5f * sqrt3}, 
		{-0.5f, -0.5f * sqrt3}, {-1.0f, 0}, 
		{-0.5f, 0.5f * sqrt3}, {0.5f, 0.5f * sqrt3}};
	
	public static float HEXAGON_POINTY_TOPPPED_POINTS[][] = { {sqrt3 * 0.5f, 0.5f}, {sqrt3 * 0.5f, -0.5f}, 
		{0.0f, -1.0f}, { -0.5f * sqrt3, -0.5f}, 
		{-0.5f * sqrt3, 0.5f}, {0.0f, 1.0f}};

	public static void rectangle( Rectangle rect) {
		
		glBegin( GL_QUADS);
		{
			glVertex2f( rect.getX(), rect.getY());
			glVertex2f( rect.getX() + rect.getWidth(), rect.getY());
			glVertex2f( rect.getX() + rect.getWidth(), rect.getY() + rect.getHeight());
			glVertex2f( rect.getX(), rect.getY() + rect.getHeight());
		}
		glEnd();
	}
	
	public static void rectangle( Point leftBottom, int width, int height) {
		
		Rectangle rect = new Rectangle( leftBottom.getX(), leftBottom.getY(), width, height);
		rectangle( rect);
	}
	
	public static void rectangle( int x, int y, int width, int height) {
		
		Rectangle rect = new Rectangle( x, y, width, height);
		rectangle( rect);
	}
	
	public static void square( Point leftBottom, int width) {
		
		rectangle( leftBottom, width, width);
	}
	
	public static void square( int x, int y, int width) {
		
		rectangle( new Point( x, y), width, width);
	}
	
	public static void line( Point start, Point end) {
		
		glBegin( GL_LINES);
		{
			glVertex2f( start.getX(), start.getY());
			glVertex2f( end.getX(), end.getY());
		}
		glEnd();
	}
	
	public static void line( int x1, int y1, int x2, int y2) {
		
		line( new Point( x1, y1), new Point( x2, y2));
	}
	
	public static void triangle( Point center, int size) {
		
		float[][] mode;
		if( triangleMode == FLAT_TOPPED)
			mode = TRIANGLE_FLAT_TOPPPED_POINTS;
		else
			mode = TRIANGLE_POINTY_TOPPPED_POINTS;
		
		glBegin( GL_TRIANGLES);
		{
			glVertex2f( center.getX() + size * mode[0][0], center.getY() + size * mode[0][1]);
			glVertex2f( center.getX() + size * mode[1][0], center.getY() + size * mode[1][1]);
			glVertex2f( center.getX() + size * mode[2][0], center.getY() + size * mode[2][1]);
		}
		glEnd();
	}
	
	public static void triangle( int x, int y, int size) {
		
		triangle( new Point( x, y), size);
	}
	
	public static void triangle( Point center, int size, int mode) {
		
		int temp = hexagonMode;
		if( mode == POINTY_TOPPED)
			triangleMode = POINTY_TOPPED;
		
		else if( mode == FLAT_TOPPED)
			triangleMode = FLAT_TOPPED;
		
		else {
			
			throw new RuntimeException( "Not proper value for shape mode");
		}
		
		triangle( center, size);
		
		triangleMode = temp;
	}
	
	public static void triangle( int x, int y, int size, int mode) {
		
		triangle( new Point( x, y), size, mode);
	}
	
	public static void hexagon( Point center, int size, int mode) {
		
		int temp = hexagonMode;
		if( mode == POINTY_TOPPED)
			hexagonMode = POINTY_TOPPED;
		
		else if( mode == FLAT_TOPPED)
			hexagonMode = FLAT_TOPPED;
		
		else {
			
			throw new RuntimeException( "Not proper value for shape mode");
		}
		
		hexagon( center, size);
		
		hexagonMode = temp;
	}
	
	public static void hexagon( int x, int y, int size, int mode) {
		
		hexagon( new Point( x, y), size, mode);
	}
	
	public static void hexagon( Point center, int size) {
		
		float[][] mode;
		if( hexagonMode == FLAT_TOPPED)
			mode = HEXAGON_FLAT_TOPPPED_POINTS;
		else
			mode = HEXAGON_POINTY_TOPPPED_POINTS;
		
		glBegin( GL_POLYGON);
		{
			
			glVertex2f( center.getX() + mode[0][0] * size, center.getY() + mode[0][1] * size);
			glVertex2f( center.getX() + mode[1][0] * size, center.getY() + mode[1][1] * size);
			glVertex2f( center.getX() + mode[2][0] * size, center.getY() + mode[2][1] * size);
			glVertex2f( center.getX() + mode[3][0] * size, center.getY() + mode[3][1] * size);
			glVertex2f( center.getX() + mode[4][0] * size, center.getY() + mode[4][1] * size);
			glVertex2f( center.getX() + mode[5][0] * size, center.getY() + mode[5][1] * size);
		}
		glEnd();
	}
	
	public static void hexagon( int x, int y, int size) {
		
		hexagon( new Point( x, y), size);
	}
}
