package visual;

import java.lang.reflect.Field;
import java.util.Arrays;

/*
 * OpenGL Loader Class
 * 
 */
public class OpenGLLoader {

	public static void loadNativeLibraries() throws Exception{
		
		if( System.getProperty("os.name").equals( "MAC OS X"))
			addLibraryPath( "natives/macosx");
		
		else if( System.getProperty("os.name").equals( "Linux"))
			addLibraryPath( "natives/linux");
		
		else {
			addLibraryPath( "natives/windows");
			
			if( System.getProperty( "os.arch").equals( "amd64") || System.getProperty( "os.arch").equals( "x86_64"))
				System.loadLibrary( "OpenAL64");
			
			else
				System.loadLibrary( "OpenAL32");
		}
	}
	
	private static void addLibraryPath( String s) throws Exception {
		
		final Field usr_path_field = ClassLoader.class.getDeclaredField( "usr_paths");
		usr_path_field.setAccessible( true);
		
		final String[] paths = ((String[]) usr_path_field.get(null)); 
		
		for( String path: paths) {
			
			if( path.equals( s))
				return;
		}
		
		final String[] new_paths = Arrays.copyOf( paths, paths.length + 1);
		new_paths[ paths.length - 1] = s;
		usr_path_field.set( null, new_paths);
	}
}
