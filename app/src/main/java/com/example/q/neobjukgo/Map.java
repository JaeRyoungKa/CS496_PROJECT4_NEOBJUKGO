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
        rooms[y][x].putStuff(s);
    }

    public void moveStuffTo(Stuff s, int x, int y) {
        s.getRoom().remove(s);
        rooms[y][x].putStuff(s);
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
        RoomIterator iter = getIterator();

        while (iter.hasNext()) {
            Room i = iter.next();
            i.onUpdate();
        }
        double rand = Math.random()*0.5;
        if (ManagerGame.getInstance().getTurn() <= 240) {
            if (rand < 0.0125) {
                Room room =iter.getRandom();
                int att = random.nextInt(2); // slime att
                int def = random.nextInt(2); // slime def
                Stuff a = new StuffCreatureMovable("재빠른", "슬라임",6,1+att,1+def, 2, 0.2);
                putStuffAt(a,room.getX(),room.getY());
            } else if (rand < 0.025) {
                Room room =iter.getRandom();
                int att = random.nextInt(2); // slime att
                int def = random.nextInt(2); // slime def
                Stuff a = new StuffCreatureMovable("맷집좋은", "슬라임",12,1+att,1+def, 2, 0.1);
                putStuffAt(a,room.getX(),room.getY());
            } else if (rand < 0.0375) {
                Room room =iter.getRandom();
                int att = random.nextInt(2); // slime att
                int def = random.nextInt(2); // slime def
                Stuff a = new StuffCreatureMovable("산성", "슬라임",6,3+att,def, 2, 0.1);
                putStuffAt(a,room.getX(),room.getY());
            }
            else if (rand < 0.075) {
                Room room =iter.getRandom();
                int att = random.nextInt(2); // slime att
                int def = random.nextInt(2); // slime def
                Stuff a = new StuffCreatureFixed(null, "식충 식물",12,att,2+def);
                putStuffAt(a,room.getX(),room.getY());
            }
        } else if (ManagerGame.getInstance().getTurn() <= 480) {
            if (rand < 0.0125) {
                Room room =iter.getRandom();
                int att = random.nextInt(2); // slime att
                int def = random.nextInt(2); // slime def
                Stuff a = new StuffCreatureMovable("황금", "늑대",16,2+att,2+def,3 ,0.5);
                putStuffAt(a,room.getX(),room.getY());
            }  else if (rand < 0.0375) {
                Room room =iter.getRandom();
                int att = random.nextInt(2); // slime att
                int def = random.nextInt(2); // slime def
                Stuff a = new StuffCreatureMovable("어린", "늑대",8,2+att,1+def, 0.2);
                putStuffAt(a,room.getX(),room.getY());
            }  else if (rand < 0.075) {
                Room room =iter.getRandom();
                int att = random.nextInt(2); // slime att
                int def = random.nextInt(2); // slime def
                Stuff a = new StuffCreatureMovable(null, "늑대",12,3+att,1+def,0.3);
                putStuffAt(a,room.getX(),room.getY());
            }
        } else if (ManagerGame.getInstance().getTurn() <= 720) {
            if (rand < 0.025) {
                Room room =iter.getRandom();
                int att = random.nextInt(8); // slime att
                Stuff a = new StuffCreatureMovable(null, "원혼",1,2+att,0, 2,0.5);
                putStuffAt(a,room.getX(),room.getY());
            } else if (rand < 0.0375) {
                Room room =iter.getRandom();
                int att = random.nextInt(2); // slime att
                int def = random.nextInt(2); // slime def
                Stuff a = new StuffCreatureMovable("우두머리", "늑대",24,4+att,2+def, 2, 0.25);
                putStuffAt(a,room.getX(),room.getY());
            } else if (rand < 0.05) {
                Room room =iter.getRandom();
                int att = random.nextInt(2); // slime att
                int def = random.nextInt(2); // slime def
                Stuff a = new StuffCreatureFixed("고대의", "식인 식물",40,1+att,3+def, 2);
                putStuffAt(a,room.getX(),room.getY());
            } else if (rand < 0.0625) {
                Room room =iter.getRandom();
                int att = random.nextInt(2); // slime att
                int def = random.nextInt(2); // slime def
                Stuff a = new StuffCreatureFixed(null, "식인 식물",15,1+att,3+def);
                putStuffAt(a,room.getX(),room.getY());
            } else if (rand < 0.075) {
                Room room =iter.getRandom();
                int att = random.nextInt(2); // slime att
                int def = random.nextInt(2); // slime def
                Stuff a = new StuffCreatureMovable(null, "늑대",12,3+att,1+def,1);
                putStuffAt(a,room.getX(),room.getY());
            }
        } else if (ManagerGame.getInstance().getTurn() <= 960) {
            if (rand < 0.025) {
                Room room =iter.getRandom();
                int att = random.nextInt(2); // slime att
                int def = random.nextInt(2); // slime def
                Stuff a = new StuffCreatureMovable(null, "해골 검사",20,4+att,4+def, 0.15);
                putStuffAt(a,room.getX(),room.getY());
            } else if (rand < 0.05) {
                Room room =iter.getRandom();
                int att = random.nextInt(2); // slime att
                int def = random.nextInt(2); // slime def
                Stuff a = new StuffCreatureRange("오크", "마법사",15,2+att,3+def, 2, 0.15);
                putStuffAt(a,room.getX(),room.getY());
            } else if (rand < 0.075) {
                Room room =iter.getRandom();
                int att = random.nextInt(2); // slime att
                int def = random.nextInt(2); // slime def
                Stuff a = new StuffCreatureRange(null, "마법사",10,5+att,def,0.08);
                putStuffAt(a,room.getX(),room.getY());
            }
        } else if (ManagerGame.getInstance().getTurn() <= 1200) {
            if (rand < 0.01) {
                Room room =iter.getRandom();
                Stuff a = new StuffCreatureRange(null, "지그문트",35,8,4, 4,0.4);
                putStuffAt(a,room.getX(),room.getY());
            } else if (rand < 0.15) {
                Room room =iter.getRandom();
                int att = random.nextInt(2); // slime att
                int def = random.nextInt(2); // slime def
                Stuff a = new StuffCreatureRange(null, "화염견",10,4+att,2+def, 2, 0.2);
                putStuffAt(a,room.getX(),room.getY());
            }
        } else if (ManagerGame.getInstance().getTurn() <= 1440) {
            if (rand < 0.01) {
                Room room =iter.getRandom();
                Stuff a = new StuffCreatureRange(null, "파멸의 숨결",1,20,0, 3,1);
                putStuffAt(a,room.getX(),room.getY());
            } else if (rand < 0.03) {
                Room room =iter.getRandom();
                int att = random.nextInt(2); // slime att
                int def = random.nextInt(2); // slime def
                Stuff a = new StuffCreatureRange("불을 품은", "용",20,4+att,2+def, 2, 0.2);
                putStuffAt(a,room.getX(),room.getY());
            } else if (rand < 0.075) {
                Room room =iter.getRandom();
                int att = random.nextInt(2); // slime att
                int def = random.nextInt(2); // slime def
                Stuff a = new StuffCreatureMovable("작은", "용",20,4+att,2+def, 0.2);
                putStuffAt(a,room.getX(),room.getY());
            }
        }

    }

    public RoomIterator getIterator() {
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

        public Room getRandom() {
            return arr[(int)(Math.random()*arr.length)];
        }
    }

}
