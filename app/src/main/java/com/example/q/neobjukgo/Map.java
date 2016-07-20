package com.example.q.neobjukgo;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by q on 2016-07-20.
 */
public class Map {

    private boolean flag;
    Random random = new Random();

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

    private Room[][] rooms;

    public Map() {
        initializeMap();
    }

    public void putStuffAt(Stuff s, int x, int y) {
        rooms[y][x].add(s);
        s.setRoom(rooms[y][x]);
    }

    public void moveStuffTo(Stuff s, int x, int y) {
        s.getRoom().remove(s);
        rooms[y][x].add(s);
        s.setRoom(rooms[y][x]);
    }

    private void initializeMap() {
        rooms = new Room[10][4];
        rooms[0][0] = new Room(0,0,this);
        rooms[0][1] = new Room(1,0,this);
        rooms[0][2] = new Room(2,0,this);
        rooms[0][3] = new Room(3,0,this);
        rooms[1][0] = new Room(0,1,this);
        rooms[1][3] = new Room(3,1,this);
        rooms[2][0] = new Room(0,2,this);
        rooms[2][3] = new Room(3,2,this);
        rooms[3][0] = new Room(0,3,this);
        rooms[3][1] = new Room(1,3,this);
        rooms[3][2] = new Room(2,3,this);
        rooms[3][3] = new Room(3,3,this);
        rooms[4][0] = new Room(0,4,this);
        rooms[4][3] = new Room(3,4,this);
        rooms[5][0] = new Room(0,5,this);
        rooms[5][3] = new Room(3,5,this);
        rooms[6][0] = new Room(0,6,this);
        rooms[6][1] = new Room(1,6,this);
        rooms[6][2] = new Room(2,6,this);
        rooms[6][3] = new Room(3,6,this);
        rooms[7][0] = new Room(0,7,this);
        rooms[7][3] = new Room(3,7,this);
        rooms[8][0] = new Room(0,8,this);
        rooms[8][3] = new Room(3,8,this);
        rooms[9][0] = new Room(0,9,this);
        rooms[9][1] = new Room(1,9,this);
        rooms[9][2] = new Room(2,9,this);
        rooms[9][3] = new Room(3,9,this);
    }

    public Room getRoomAt(int x, int y) {
        if (x >= 0 && x < rooms[0].length) {
            if (y >= 0 && y < rooms.length) {
                return rooms[y][x];
            }
        }
        return null;
    }

    public  void onUpdate(){
        Iterator<Room> iter = getIterator();

        while (iter.hasNext()) {
            Room i = iter.next();
            i.onUpdate();
        }

        // Mob Generation
        if (!flag) {
            flag = true;

            for (int i = 0 ; i < 5; i++) {
                int x = random.nextInt(4);
                int y = random.nextInt(10);
                int att = random.nextInt(7); // slime att
                int def = random.nextInt(6); // slime def
                Stuff a = new StuffCreatureSlime(10,att,def);
                if (rooms[y][x] != null) putStuffAt(a,x,y);
            }

            for (int i = 0 ; i < 5; i++) {
                int x = random.nextInt(4);
                int y = random.nextInt(10);
                int att = random.nextInt(9); // slime att
                int def = random.nextInt(4); // slime def
                Stuff a = new StuffCreatureWolf(10,att,def);
                if (rooms[y][x] != null) putStuffAt(a,x,y);
            }

            for (int i = 0 ; i < 5; i++) {
                int x = random.nextInt(4);
                int y = random.nextInt(10);
                int att = random.nextInt(4); // slime att
                int def = random.nextInt(9); // slime def
                Stuff a = new StuffCreatureZakum(10,att,def);
                if (rooms[y][x] != null) putStuffAt(a,x,y);
            }

        }
    }

    public Iterator<Room> getIterator() {
        return new RoomIterator();
    }

    private class RoomIterator implements Iterator<Room> {

        int next;
        Room[] arr;

        public RoomIterator() {
            arr = new Room[28];
            int temp = 0;
            for (int i = 0 ; i < rooms.length; i++) {
                for (int j = 0 ; j < rooms[0].length; j++) {
                    if (rooms[i][j] != null)
                        arr[temp++] = rooms[i][j];
                }
            }
        }

        @Override
        public boolean hasNext() {
            return next<arr.length;
        }

        @Override
        public Room next() {
            return arr[next++];
        }
    }

}
