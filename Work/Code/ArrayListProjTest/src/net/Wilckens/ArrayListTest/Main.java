/**
 * Ryan Davis
 * Period 8
 * ArrayList Test Round 3
 */

package net.Wilckens.ArrayListTest;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String args[])
	{
		ArrayList <String> myNotes = new ArrayList<String>();
		boolean running = true;
		
		while (running)
		{
			System.out.println("*** MAIN MENU ***");
			System.out.println("1. Add a note");
			System.out.println("2. Print all notes");
			System.out.println("3. Remove a note");
			System.out.println("4. Exit");
			System.out.println("5. Swap Notes");
			
			Scanner scan = new Scanner(System.in);
			int choice  = scan.nextInt();
		
			Scanner newScan = new Scanner(System.in);
			switch (choice)
			{
			
			case 1:
				System.out.println("Enter your note:");
				String temp = newScan.nextLine();
				myNotes.add(temp);
				break;
			case 2:
				System.out.println("*** My notes ***");
				printList(myNotes);
				System.out.println();
				break;
			case 3:
				System.out.println("Which note do you want to remove?");
				System.out.println();
				printList(myNotes);
				System.out.println();
				int note = newScan.nextInt();
				if (note > 0 && note < myNotes.size())
				{
					myNotes.remove(note-1);
				}
				else
				{
					System.err.println("This note does not exist!");
				}
				break;
			case 4:
				running = false;
				break;
			case 5:
				System.out.println("What notes would you like to swap?\n");
				printList(myNotes);
				System.out.println();
				int note1 = newScan.nextInt();
				int note2 = newScan.nextInt();
				swap(myNotes, note1-1, note2-1);
				
				break;
			}
		}
		
		System.out.println("Goodbye.");
	}
	
	
	public static void printList(ArrayList<String> myNotes)
	{
		for (int i = 0; i < myNotes.size(); i++)
		{
			System.out.format("%d. \"%s\"\n", i+1, myNotes.get(i));
		}
	}
	
	public static void swap(ArrayList<String> strs, int a, int b)
	{
		String first = strs.get(a);
		String second = strs.get(b);
		
		strs.set(a, second);
		strs.set(b, first);
	}
	
}
