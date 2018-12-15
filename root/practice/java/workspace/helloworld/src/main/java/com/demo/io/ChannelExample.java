package com.demo.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

public class ChannelExample {
	public static void main(String args[]) throws IOException {
		RandomAccessFile file = new RandomAccessFile("temp.txt", "r");
		FileChannel fileChannel = file.getChannel();
		ByteBuffer byteBuffer = ByteBuffer.allocate(512);
		
		CharBuffer charBuffer=CharBuffer.allocate(512);
		while (fileChannel.read(byteBuffer) > 0) {
			// flip the buffer to prepare for get operation
			byteBuffer.flip();
			while (byteBuffer.hasRemaining()) {
				System.out.print((char) byteBuffer.get());
			}
			// clear the buffer ready for next sequence of read
			byteBuffer.clear();
		}
		file.close();
	}
}
