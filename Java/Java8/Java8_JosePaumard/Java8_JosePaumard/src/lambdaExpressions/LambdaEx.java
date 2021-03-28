package lambdaExpressions;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

public class LambdaEx {

	public static void main(String[] args) {

//		Method-1
	
//		JavaFileFilter fileFilter = new JavaFileFilter();
//		File dir = new File("D:/WORKSPACE/Java/Java8/Java8_JosePaumard/Java8_JosePaumard/src/lambdaExpressions");
//		System.out.println("Path : " + dir.getAbsolutePath());
//		File[] javaFiles = dir.listFiles(fileFilter);
//		System.out.println(Arrays.toString(javaFiles));
		
//		Method -2
//		Anonymous class
		
		FileFilter fileFilter = new FileFilter() {
			
			@Override
			public boolean accept(File file) {
				return file.getName().endsWith(".java");
			}
		};
		
		File dir = new File("D:/WORKSPACE/Java/Java8/Java8_JosePaumard/Java8_JosePaumard/src/lambdaExpressions");
		File[] javaFiles = dir.listFiles(fileFilter);
		System.out.println(Arrays.toString(javaFiles));
		
//		Method - 3
		
//		Why Lambda Expression
//		To make instance of anonymous class easier to write and read!!!
		
	
		
		System.out.println("\nLambda Example ------------------------------- \n");
		
		FileFilter filter = (File file) -> file.getName().endsWith(".java");
		File[] javaFilesLambda = dir.listFiles(filter);
		System.out.println(Arrays.toString(javaFilesLambda));
		
		
		
		
		
	}

}
