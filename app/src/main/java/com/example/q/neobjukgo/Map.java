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
        double rand = Math.random()*1.0;
        if (ManagerGame.getInstance().getTurn() <= 240) {
            if (rand < 0.0125) {
                Room room =iter.getRandom();
                Stuff a = new StuffCreatureMovable("재빠른", "슬라임",6,1,1, 2, 0.05);
                putStuffAt(a,room.getX(),room.getY());
            } else if (rand < 0.025) {
                Room room =iter.getRandom();
                Stuff a = new StuffCreatureMovable("맷집좋은", "슬라임",12,1,2, 2, 0.01);
                putStuffAt(a,room.getX(),room.getY());
            } else if (rand < 0.0375) {
                Room room =iter.getRandom();
                Stuff a = new StuffCreatureMovable("산성", "슬라임",6,3,0, 2, 0.01);
                putStuffAt(a,room.getX(),room.getY());
            }
            else if (rand < 0.075) {
                Room room =iter.getRandom();
                Stuff a = new StuffCreatureFixed(null, "식충 식물",20,0,2);
                putStuffAt(a,room.getX(),room.getY());
            }
        } else if (ManagerGame.getInstance().getTurn() <= 480) {
            if (rand < 0.0125) {
                Room room =iter.getRandom();
                int att = random.nextInt(2); // slime att
                int def = random.nextInt(2); // slime def
                Stuff a = new StuffCreatureMovable("황금", "늑대",16,4+att,2+def,3 ,0.06);
                putStuffAt(a,room.getX(),room.getY());
            }  else if (rand < 0.04) {
                Room room =iter.getRandom();
                int att = random.nextInt(2); // slime att
                int def = random.nextInt(2); // slime def
                Stuff a = new StuffCreatureMovable("어린", "늑대",12,2+att,2+def, 0.02);
                putStuffAt(a,room.getX(),room.getY());
            }  else if (rand < 0.075) {
                Room room =iter.getRandom();
                int att = random.nextInt(2); // slime att
                int def = random.nextInt(2); // slime def
                Stuff a = new StuffCreatureMovable(null, "늑대",16,4+att,2+def,0.03);
                putStuffAt(a,room.getX(),room.getY());
            }
        } else if (ManagerGame.getInstance().getTurn() <= 720) {
            if (rand < 0.025) {
                Room room =iter.getRandom();
                int att = random.nextInt(12); // slime att
                Stuff a = new StuffCreatureMovable(null, "원혼",1,5+att,0, 2,0.05);
                putStuffAt(a,room.getX(),room.getY());
            } else if (rand < 0.0375) {
                Room room =iter.getRandom();
                int att = random.nextInt(3); // slime att
                int def = random.nextInt(3); // slime def
                Stuff a = new StuffCreatureMovable("우두머리", "늑대",48,7+att,7+def, 2, 0.025);
                putStuffAt(a,room.getX(),room.getY());
            } else if (rand < 0.05) {
                Room room =iter.getRandom();
                int att = random.nextInt(3); // slime att
                int def = random.nextInt(3); // slime def
                Stuff a = new StuffCreatureFixed("고대의", "식인 식물",128,5+att,5+def, 3);
                putStuffAt(a,room.getX(),room.getY());
            } else if (rand < 0.0625) {
                Room room =iter.getRandom();
                int att = random.nextInt(3); // slime att
                int def = random.nextInt(3); // slime def
                Stuff a = new StuffCreatureFixed(null, "식인 식물",64,3+att,5+def);
                putStuffAt(a,room.getX(),room.getY());
            } else if (rand < 0.075) {
                Room room =iter.getRandom();
                int att = random.nextInt(3); // slime att
                int def = random.nextInt(3); // slime def
                Stuff a = new StuffCreatureMovable("잿빛", "늑대",32,5+att,5+def,0.05);
                putStuffAt(a,room.getX(),room.getY());
            }
        } else if (ManagerGame.getInstance().getTurn() <= 960) {
            if (rand < 0.025) {
                Room room =iter.getRandom();
                int att = random.nextInt(4); // slime att
                int def = random.nextInt(4); // slime def
                Stuff a = new StuffCreatureMovable(null, "해골 검사",32,10+att,5+def, 0.015);
                putStuffAt(a,room.getX(),room.getY());
            } else if (rand < 0.05) {
                Room room =iter.getRandom();
                int att = random.nextInt(4); // slime att
                int def = random.nextInt(4); // slime def
                Stuff a = new StuffCreatureRange("오크", "마법사",32,4+att,6+def, 2, 0.015);
                putStuffAt(a,room.getX(),room.getY());
            } else if (rand < 0.075) {
                Room room =iter.getRandom();
                int att = random.nextInt(4); // slime att
                int def = random.nextInt(4); // slime def
                Stuff a = new StuffCreatureRange(null, "마법사",16,8+att,2+def,0.008);
                putStuffAt(a,room.getX(),room.getY());
            }
        } else if (ManagerGame.getInstance().getTurn() <= 1200) {
            if (rand < 0.01) {
                Room room =iter.getRandom();
                Stuff a = new StuffCreatureRange(null, "지그문트",64,20,10, 4,0.04);
                putStuffAt(a,room.getX(),room.getY());
            } else if (rand < 0.2) {
                Room room =iter.getRandom();
                int att = random.nextInt(5); // slime att
                int def = random.nextInt(5); // slime def
                Stuff a = new StuffCreatureRange(null, "화염견",16,16+att,4+def, 1, 0.02);
                putStuffAt(a,room.getX(),room.getY());
            }
        } else if (ManagerGame.getInstance().getTurn() <= 1440) {
            if (rand < 0.01) {
                Room room =iter.getRandom();
                Stuff a = new StuffCreatureRange(null, "파멸의 숨결",1,32,0, 3,0.1);
                putStuffAt(a,room.getX(),room.getY());
            } else if (rand < 0.03) {
                Room room =iter.getRandom();
                int att = random.nextInt(6); // slime att
                int def = random.nextInt(6); // slime def
                Stuff a = new StuffCreatureRange("불을 품은", "용",48,20+att,10+def, 2, 0.02);
                putStuffAt(a,room.getX(),room.getY());
            } else if (rand < 0.075) {
                Room room =iter.getRandom();
                int att = random.nextInt(6); // slime att
                int def = random.nextInt(6); // slime def
                Stuff a = new StuffCreatureMovable("작은", "용",24,15+att,15+def, 0.02);
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
