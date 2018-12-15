package com.demo.nio;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Iterable<Path> rootDirs = FileSystems.getDefault().getRootDirectories();
		for (Path rootDir : rootDirs) {
		   System.out.println(rootDir);
		}
	}

}
