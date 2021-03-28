package lambdaExpressions;

import java.io.File;
import java.io.FilenameFilter;

public class JavaFileFilter implements FilenameFilter {

	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return name.endsWith(".java");
	}






}
