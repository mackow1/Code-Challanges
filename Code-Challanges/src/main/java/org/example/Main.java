/*
George and Alex want to live in the same room. There are n rooms. p people living in i-th room, it can accommodate q people.
n - number of rooms
p - people living in i-th room
q - room capacity
p <= q      |      1 <= n <= 100      |      0 <= p <= q <= 100
 */

package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int NUM_OF_ROOMS = (int)(Math.random() * 100) + 1;

    public Main(){

    }

    public int[][] createArrayOfRooms() {
        int[][] roomsArray = new int[NUM_OF_ROOMS][3];

        for (int i = 0; i <= NUM_OF_ROOMS - 1; i++) {
            int roomsCapacity = (int) (Math.random() * 100) + 1;
            roomsArray[i][0] = i + 1;
            roomsArray[i][1] = roomsCapacity;
            roomsArray[i][2] = (int) (Math.random() * roomsCapacity) + 1;
        }
        return roomsArray;
    }

    public int numOfRoomsTheyFit(int[][] roomsArray) {
        int total = 0;

        for (int i = 0; i < roomsArray.length; i++) {
            if (roomsArray[i][1] - roomsArray[i][2] >= 2) total++;
        }

        return total;
    }

    public List<Integer> roomsToCheck(int[][] roomsArray) {
        List<Integer> roomNumbers = new ArrayList<>();
        for (int i = 0; i < roomsArray.length; i++) {
            if (roomsArray[i][1] - roomsArray[i][2] >= 2) roomNumbers.add(roomsArray[i][0]);
        }
        return roomNumbers;
    }

    public static void main(String[] args) {

        Main newObj = new Main();

        int[][] newCase = newObj.createArrayOfRooms();
        int roomsTheyCanFit = newObj.numOfRoomsTheyFit(newCase);
        List<Integer> roomNumbers = newObj.roomsToCheck(newCase);

        System.out.println("There are " + NUM_OF_ROOMS + " rooms overall.");
        System.out.println("George and Alex can fit into " + roomsTheyCanFit + " rooms. There is the list of room numbers which they can check: ");
        System.out.println(roomNumbers);
    }
}