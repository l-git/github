package com.demo.nio;

import java.util.EnumSet;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import static java.nio.file.FileVisitResult.*;
 
public class WalkFileTreeTest extends SimpleFileVisitor<Path> {
 
   // Print the directory visited.
   @Override
   public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attr) {
      System.out.printf("Begin Directory: %s%n", dir);
      return CONTINUE;
   }
 
   // Print information about each file/symlink visited.
   @Override
   public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
      if (attr.isSymbolicLink()) {
         System.out.printf("Symbolic link: %s ", file);
      } else if (attr.isRegularFile()) {
         System.out.printf("Regular file: %s ", file);
      } else {
         System.out.printf("Other: %s ", file);
      }
      System.out.println("(" + attr.size() + "bytes)");
      return CONTINUE;
   }
 
   // Print the directory visited.
   @Override
   public FileVisitResult postVisitDirectory(Path dir, IOException ex) {
      System.out.printf("End Directory: %s%n%n", dir);
      return CONTINUE;
   }
 
   // If there is an error accessing the file, print a message and continue.
   @Override
   public FileVisitResult visitFileFailed(Path file, IOException ex) {
      System.err.println(ex);
      return CONTINUE;  // or TERMINATE
   }
 
   // main
   public static void main(String[] args) {
      try {
         Path startingDir = Paths.get("..");
         Files.walkFileTree(startingDir, new WalkFileTreeTest());
      } catch (IOException ex) {
         System.out.println(ex);
      }
   }
}
