package visual;

import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Canvas {
	
	public void loop() {
		
		while( !Display.isCloseRequested()) {
			
			glClear( GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			glColor3f( 1.0f, 1.0f, 1.0f);
			
			Display.update();
		}
		
		Display.destroy();
	}
	
	public void init( String title, int width, int height) {
		
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
