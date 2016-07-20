package com.example.q.neobjukgo;

/**
 * Created by q on 2016-07-20.
 */
public class Map {

    public enum Direction {
        UP(0, -1), DOWN(0, 1), RIGHT(1, 0), LEFT(-1, 0);

        private int x;
        private int y;

        Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    ;

    private Room[][] rooms;

    public Map() {
        initializeMap();
    }

    private void initializeMap() {
        rooms = new Room[10][4];
    }

    public Room getRoomAt(int x, int y) {
        if (x >= 0 && x < rooms[0].length) {
            if (y >= 0 && y < rooms.length) {
                return rooms[y][x];
            }
        }
        return null;
    }

}
