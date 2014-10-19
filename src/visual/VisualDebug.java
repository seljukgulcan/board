package visual;

import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

/*
 * 
 * 
 */

public class VisualDebug {
	
	public static void main( String args[]) {
		
		init( "Visual Debug - Board Package", 800, 600);
		
		while( !Display.isCloseRequested()) {
			
			glClear( GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			glColor3f( 0.25f, 0.25f, 0.25f);
			
			Draw.hexagonMode = Draw.FLAT_TOPPED;
			Draw.triangleMode = Draw.FLAT_TOPPED;
			
			Draw.hexagon( 100, 100, 100);
			Draw.triangle( 300, 300, 20);
			Draw.triangle( 500, 500, 100, Draw.POINTY_TOPPED);
			
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
