package visual;

import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

/*
 * Testing more stuff of opengl
 * 
 */

public class VisualDebug {
	
	/*
	public static float sqrt3 = (float) Math.sqrt(3);
	public static float hexVertices[][] = { {0.5f, sqrt3}, {1.5f, sqrt3}, 
											{2.0f, (float) (0.5 * sqrt3)}, {1.5f, 0}, 
											{0.5f, 0}, {0, (float) (0.5 * sqrt3)}};
	
	public static void drawPolygon( float[][]positionArr) {
		
		//Assumes length of positionArr is greater than 3
		glBegin( GL_POLYGON);
		
		for( int i = 0; i < positionArr.length; i++)
			glVertex2f( positionArr[i][0], positionArr[i][1]);
		
		glEnd();
	}
	
	public static void drawHexagon( float x, float y, int length) {
	
		drawPolygon( new float[][]{{ hexVertices[0][0] * length + x, hexVertices[0][1] * length + y},
							   	  { hexVertices[1][0] * length + x, hexVertices[1][1] * length + y},
							   	  { hexVertices[2][0] * length + x, hexVertices[2][1] * length + y},
							   	  { hexVertices[3][0] * length + x, hexVertices[3][1] * length + y},
							   	  { hexVertices[4][0] * length + x, hexVertices[4][1] * length + y},
							   	  { hexVertices[5][0] * length + x, hexVertices[5][1] * length + y}});
	}

	public static void drawHexagon( float x, float y, int length, int border) {
		
		glColor3f( 0.5f, 0.5f, 0.5f);
		drawHexagon( x, y, length);
		
		glColor3f( 1.0f, 1.0f, 0.0f);
		drawHexagon( x + border, y + border, length - border);
	}
	
	public static void drawHexSeq( float x, float y, int length, int n) {
		
		for( int i = 0; i < n; i++)
			drawHexagon(x + i * ( 3 * length), y, length, 1);
		
		for( int i = 0; i < n; i++)
			drawHexagon( ( 1.5f * length + x) + i * ( 3 * length), y - length * (sqrt3 * 0.5f), length, 1);
		
	}
	
	public static void drawHexGrid( float x, float y, int length, int row, int col) {
		
		for( int i = 0; i < row; i++) {
			drawHexSeq( x, y + i * ( sqrt3 * length), length, col);
		}
	}
	*/
	public static void main( String args[]) {
		
		init( "Visual Debug - Board Package", 800, 600);
		
		float x = 0.0f;
		float coeff = 1.0f;
		
		while( !Display.isCloseRequested()) {
			
			glClear( GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			x += 5.0f * coeff;
			if( x > Display.getWidth() - 100 || x < 0.0f)
				coeff *= -1.0f;
			glColor3f( 0.25f, 0.25f, 0.25f);
			Draw.square( 0, 0, 100, 50);
			Draw.line( 50, 50, 150, 600);
			
			Display.update();
		}
		
		Display.destroy();
	}
	
	public static void init( String title, int width, int height) {
		
		try {
			
			OpenGLLoader.loadNativeLibraries();
		}
		
		catch( Exception e) {
			
			e.printStackTrace();
			System.exit(0);
		}
		
		try {
			Display.setDisplayMode( new DisplayMode( width, height));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		Display.setTitle( title);
		glMatrixMode( GL_PROJECTION);
		
		glLoadIdentity();
		glOrtho( 0, width, 0, height, -1, 1);
		
		glMatrixMode( GL_MODELVIEW);
		glClearColor( 1.0f, 0.8f, 0.0f, 1);
		
		glDisable( GL_DEPTH_TEST); //Disable storing extra information not needed for 2d drawing.
	}
}
