import java.util.*;

/**
 * Created by rashmimech on 2/22/17.
 */
public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        //Integer[][] intArr = new Integer[][]{{4, 100}, {48, 94}, {16, 21}, {58, 71}, {36, 53}, {49, 68}, {18, 42}, {37, 90}, {68, 75}, {6, 57}, {25, 78}, {58, 79}, {18, 29}, {69, 94}, {5, 31}, {10, 87}, {21, 35}, {1, 32}, {7, 24}, {17, 85}, {30, 95}, {5, 63}, {1, 17}, {67, 100}, {53, 55}, {30, 63}, {7, 76}, {33, 51}, {62, 68}, {78, 83}, {12, 24}, {31, 73}, {64, 74}, {33, 40}, {51, 63}, {17, 31}, {14, 29}, {9, 15}, {39, 70}, {13, 67}, {27, 100}, {10, 71}, {18, 47}, {48, 79}, {70, 73}, {44, 59}, {68, 78}, {24, 67}, {32, 70}, {29, 94}, {45, 90}, {10, 76}, {12, 28}, {31, 78}, {9, 44}, {29, 83}, {21, 35}, {46, 93}, {66, 83}, {21, 72}, {29, 37}, {6, 11}, {56, 87}, {10, 26}, {11, 12}, {15, 88}, {3, 13}, {56, 70}, {40, 73}, {25, 62}, {63, 73}, {47, 74}, {8, 36} };

        //Integer[][] intArr = new Integer[][]{{30, 63}, {66, 94}, {36, 87}, {16, 86}, {26, 85}, {24, 50}, {17, 84}, {5, 25}, {67, 81}, {23, 54}, {84, 99}, {48, 85}, {23, 28}, {3, 86}, {63, 79}, {18, 73}, {6, 68}, {34, 40}, {61, 66}, {60, 96}, {95, 99}, {1, 10}, {4, 82}, {19, 78}, {23, 61}, {30, 45}, {53, 87}, {10, 42}, {80, 93}, {33, 73}, {64, 65}, {29, 71}, {73, 89}, {2, 98}, {62, 67}, {84, 98}, {43, 58}, {20, 45}, {86, 92}, {22, 100}, {72, 74}, {5, 52}, {48, 56}, {69, 93}, {8, 98}, {37, 47}, {19, 45}, {22, 99}, {34, 97}, {21, 80}, {58, 77}, {48, 66}, {59, 91}, {18, 33}, {2, 7}, {8, 92}, {12, 32}, {17, 83}, {11, 16}, {60, 75}, {9, 11}, {3, 61}, {4, 18}, {53, 68}, {17, 39}, {18, 93}, {15, 55}, {4, 34}, {48, 85}, {61, 65}, {59, 77}, {15, 37}, {62, 82}, {4, 78}, {80, 96}, {4, 42}, {15, 48}, {27, 45}};

        Integer[][] intArr = new Integer[][]{{47, 76}, {51, 99}, {28, 78}, {54, 94}, {12, 72}, {31, 72}, {12, 55}, {24, 40}, {59, 79}, {41, 100}, {46, 99}, {5, 27}, {13, 23}, {9, 69}, {39, 75}, {51, 53}, {81, 98}, {14, 14}, {27, 89}, {73, 78}, {28, 35}, {19, 30}, {39, 87}, {60, 94}, {71, 90}, {9, 44}, {56, 79}, {58, 70}, {25, 76}, {18, 46}, {14, 96}, {43, 95}, {70, 77}, {13, 59}, {52, 91}, {47, 56}, {63, 67}, {28, 39}, {51, 92}, {30, 66}, {4, 4}, {29, 92}, {58, 90}, {6, 20}, {31, 93}, {52, 75}, {41, 41}, {64, 89}, {64, 66}, {24, 90}, {25, 46}, {39, 49}, {15, 99}, {50, 99}, {9, 34}, {58, 96}, {85, 86}, {13, 68}, {45, 57}, {55, 56}, {60, 74}, {89, 98}, {23, 79}, {16, 59}, {56, 57}, {54, 85}, {16, 29}, {72, 86}, {10, 45}, {6, 25}, {19, 55}, {21, 21}, {17, 83}, {49, 86}, {67, 84}, {8, 48}, {63, 85}, {5, 31}, {43, 48}, {57, 62}, {22, 68}, {48, 92}, {36, 77}, {27, 63}, {39, 83}, {38, 54}, {31, 69}, {36, 65}, {52, 68}};
        //Integer[][] intArr = new Integer[][]{{13, 71}};
        ArrayList<Interval> inputList = new ArrayList<>();
        for(int i = 0; i < intArr.length; i++){
            Interval newEle = new Interval(intArr[i][0], intArr[i][1] );
            inputList.add(newEle);
        }

        ArrayList<Interval> res = new MergeOverlappingIntervals().merge(inputList);

        for(int i = 0; i < res.size(); i++) {
            Interval ele = res.get(i);
            System.out.println(ele.start +"-->" + ele.end);
        }
    }
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<NumberNode> map = new ArrayList<>();

        for(Interval ele: intervals){
            NumberNode node = new NumberNode(ele);
            map.add(node);
        }

        Collections.sort(map);

        int prevA1 = map.get(0).ele.start;
        int prevB1 = map.get(0).ele.end;

        int i = 0;

        Map<Integer, Integer> res = new TreeMap<>();
        res.put(prevA1, prevB1);
        for(NumberNode starInterval : map){
            if(i == 0){
                i++;
                continue;
            }

            int currA1 = starInterval.ele.start;
            int currB1 = starInterval.ele.end;

            if(Math.max(prevA1, currA1) > Math.min(prevB1, currB1)){
                res.put(currA1, currB1);
                prevA1 = currA1;
                prevB1 = currB1;
                continue;
            }

            int minA1 = Math.min(currA1, prevA1);
            int maxB1 = Math.max(prevB1, currB1);
            res.put(minA1, maxB1);

            prevA1 = minA1;
            prevB1 = maxB1;
        }

        ArrayList<Interval> finalResult = new ArrayList<>();
        for(Integer ele : res.keySet()){
            Interval interval = new Interval(ele, res.get(ele));
            finalResult.add(interval);
        }

        return finalResult;
    }
}



class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }


 class NumberNode implements Comparable<NumberNode> {
     Interval ele;

     NumberNode(Interval ele) {
         this.ele = ele;
     }

     @Override
     public int compareTo(NumberNode o) {
         Integer start1 = ele.start;
         Integer start2 = o.ele.start;
         return start1.compareTo(start2);
     }
 }
