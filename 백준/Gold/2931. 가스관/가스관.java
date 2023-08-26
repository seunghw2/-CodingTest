import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};

    public static int X, Y;

    public static char[][] map;

    public static boolean isArrived;

    public static class point {
        int x;
        int y;
        int d;

        point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int mx = 0;
        int my = 0;
        int md = 0;
        point before, blank, next;
        char[] pipes = {'1', '2', '3', '4', '|', '-', '+'};
        char[][] mapCopy;

        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        map = new char[Y][X];
        mapCopy = new char[Y][X];

        for (int j = 0; j < Y; j++) {
            String line = br.readLine();
            for (int i = 0; i < X; i++) {
                map[j][i] = line.charAt(i);

                if (map[j][i] == 'M') {
                    mx = i;
                    my = j;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            int tmpx = mx + dx[i];
            int tmpy = my + dy[i];

            if (isRange(tmpx, tmpy)) {
                if (map[tmpy][tmpx] != '.' && map[tmpy][tmpx] != 'Z') {
                    md = i;
                }
            }
        }

        before = move(mx, my, md);

        for (int j = 0; j < Y; j++) {
            for (int i = 0; i < X; i++) {
                mapCopy[j][i] = map[j][i];
            }
        }

        int tmpd = changeD(before.x, before.y, before.d);
        blank = new point(before.x + dx[tmpd], before.y + dy[tmpd], tmpd);

        for (char pipe : pipes) {
//            System.out.println("pipe : " + pipe);

            for (int j = 0; j < Y; j++) {
                for (int i = 0; i < X; i++) {
                    map[j][i] = mapCopy[j][i];
                }
            }

            map[blank.y][blank.x] = pipe;


            move(before.x, before.y, before.d);
//                System.out.println(isArrived ? "ARRIVED" : "ARRIVE FAIL");
            if (isArrived) {
                if(isOnly()) {
                    System.out.println((blank.y + 1) + " " + (blank.x + 1) + " " + pipe);
                    break;
                }
                else{
                    isArrived = false;
                }
            }
        }
    }

    private static point move(int x, int y, int d) {
        int mx, my, md;

        while (true) {
            md = changeD(x, y, d);

            mx = x + dx[md];
            my = y + dy[md];

            if (!isRange(mx, my)) {
//                System.out.println("IMPOSSIBLE");
                break;
            }

            if (map[my][mx] == '.') {
//                System.out.println("ARRIVED");
//                System.out.println(mx + ", " + my);
//                System.out.println();
                return new point(x, y, d);
            }
            else if (map[my][mx] == 'Z') {
                map[y][x] = 'x';
                map[my][mx] = 'x';
                isArrived = true;
//                print();
                break;
            }
            else {
                if (map[y][x] != 'M' && !canGo(map[y][x], map[my][mx], md)) {
//                    System.out.println("IMPOSSIBLE");
                    break;
                }
//                System.out.println(x + ", " + y + " : " + map[y][x] + " (" + d + ") -> " + mx + ", " + my + " : " + map[my][mx] + "(" + md + ")");

                if (map[y][x] == '+') {
                    if (d == 0 || d == 2) {
                        map[y][x] = '-';
                    } else {
                        map[y][x] = '|';
                    }
                }
                else{
                    map[y][x] = 'x';
                }

//                print();

                x = mx;
                y = my;
                d = md;
            }
        }
        return new point(mx, my, md);
    }

    private static int changeD(int x, int y, int d) {
        int ret = d;

        if (map[y][x] == '1') {
            if (d == 3) {
                ret = 2;
            } else if (d == 0) {
                ret = 1;
            }
        } else if (map[y][x] == '2') {
            if (d == 2) {
                ret = 1;
            } else if (d == 3) {
                ret = 0;
            }
        } else if (map[y][x] == '3') {
            if (d == 1) {
                ret = 0;
            } else if (d == 2) {
                ret = 3;
            }
        } else if (map[y][x] == '4') {
            if (d == 1) {
                ret = 2;
            } else if (d == 0) {
                ret = 3;
            }
        }
        return ret;
    }

    public static boolean canGo(char now, char next, int dir) {
        if (now == '|') {
            if (dir == 0) {
                if (next == '|' || next == '+' || next == '1' || next == '4')
                    return true;
                else
                    return false;
            } else if (dir == 2) {
                if (next == '|' || next == '+' || next == '2' || next == '3')
                    return true;
                else
                    return false;
            } else
                return false;
        } else if (now == '-') {
            if (dir == 1) {
                if (next == '-' || next == '+' || next == '3' || next == '4')
                    return true;
                else
                    return false;
            } else if (dir == 3) {
                if (next == '-' || next == '+' || next == '1' || next == '2')
                    return true;
                else
                    return false;
            } else
                return false;
        } else if (now == '+') {
            if (dir == 0) {
                if (next == '|' || next == '+' || next == '1' || next == '4')
                    return true;
                else
                    return false;
            }
            if (dir == 1) {
                if (next == '-' || next == '+' || next == '3' || next == '4')
                    return true;
                else
                    return false;
            } else if (dir == 2) {
                if (next == '|' || next == '+' || next == '2' || next == '3')
                    return true;
                else
                    return false;
            } else if (dir == 3) {
                if (next == '-' || next == '+' || next == '1' || next == '2')
                    return true;
                else
                    return false;
            } else {
                System.out.println("WRONGA");
                return false;
            }
        } else if (now == '1') {
            if (dir == 1) {
                if (next == '-' || next == '+' || next == '3' || next == '4')
                    return true;
                else
                    return false;
            } else if (dir == 2) {
                if (next == '|' || next == '+' || next == '2' || next == '3')
                    return true;
                else
                    return false;
            } else
                return false;
        } else if (now == '2') {
            if (dir == 0) {
                if (next == '|' || next == '+' || next == '1' || next == '4')
                    return true;
                else
                    return false;
            } else if (dir == 1) {
                if (next == '-' || next == '+' || next == '3' || next == '4')
                    return true;
                else
                    return false;
            } else
                return false;
        } else if (now == '3') {
            if (dir == 0) {
                if (next == '|' || next == '+' || next == '1' || next == '4')
                    return true;
                else
                    return false;
            } else if (dir == 3) {
                if (next == '-' || next == '+' || next == '1' || next == '2')
                    return true;
                else
                    return false;
            } else
                return false;
        } else if (now == '4') {
            if (dir == 2) {
                if (next == '|' || next == '+' || next == '2' || next == '3')
                    return true;
                else
                    return false;
            } else if (dir == 3) {
                if (next == '-' || next == '+' || next == '1' || next == '2')
                    return true;
                else
                    return false;
            } else
                return false;
        } else {
//            System.out.println("WRONGB");
            return false;
        }
    }

    public static boolean isOnly(){
        for(int j = 0; j < Y; j++){
            for(int i = 0; i < X; i++){
                if(map[j][i] != '.' && map[j][i] != 'x')
                    return false;
            }
        }
        return true;
    }

    public static void print() {
        for (char[] line : map) {
            for (char item : line) {
                System.out.print(item);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isRange(int x, int y) {
        return (x >= 0 && x < X && y >= 0 && y < Y);
    }
}