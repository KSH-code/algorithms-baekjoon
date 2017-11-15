import java.util.*;
/**
 * BOJ 백준온라인져지 2185 직사각형의 합집합 풀이
 * 아직 코드는 안짬
 * 솔루션 : 
 * 1. 플레인스위핑으로 사각형들을 다 합친다.
 * 2. 라인을 그어서 확인하고 길이를 더해준다.
 * 참고 : https://blog.sisobus.com/2014/02/plane-sweeping.html#.WgwlJbSFjBI
 */
public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int ans = 0;

        ArrayList<rect> d = new ArrayList<>();
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            rect t = new rect();
            t.x = scanner.nextInt() + 10001;
            t.y = scanner.nextInt() + 10001;
            int x2 = scanner.nextInt() + 10001;
            int y2 = scanner.nextInt() + 10001;
            t.width = x2 - t.x;
            t.height = y2 - t.y;

            d.add(t);

            x.add(d.get(i).x);
            x.add(x2);
            y.add(d.get(i).y);
            y.add(y2);
        }

        Collections.sort(x);
        Collections.sort(y);

        for (int i = 0; i < x.size() - 1; i++)
            for (int j = 0; j < y.size() - 1; j++)
                for (int k = 0; k < n; k++)
                    if (x.get(i) >= d.get(k).x && x.get(i + 1) <= d.get(k).x + d.get(k).width &&
                            y.get(j) >= d.get(k).y && y.get(j + 1) <= d.get(k).y + d.get(k).height) {
                        ans += (x.get(i + 1) - x.get(i)) * (y.get(j + 1) - y.get(j));
                        break;
                    }

        System.out.println(ans);
    }

    static class rect {
        int x, y, width, height;
        rect(){}
    }
}