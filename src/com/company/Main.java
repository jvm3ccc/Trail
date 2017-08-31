package com.company;

public class Main {

//    public static String path = "FFFR 4";
//    public static String path = "F 6 R 1 F 4 RFF 2 LFF 1 LFFFR 1 F 2 R 1 F 5";
//    public static String path = "L 1 FR 1 FFFFFL 1 FFFFL 1 F 12 L 1 F 12 L 1 F 12 L 1 FFFFL 1 FFFFFFFFR 1 FFFR 1 FFFL 1";
//    public static String path = "FFRFLFLFFRFRFLFF 3 R 1 FFLFRFRFLFFF 3 R 1 FFFFFF 3 L 1 FFFRFLFLFRFF 2 R 1 FFFRFLFLFRFF 3 R 1 FFFFFF 1 L 1 FFRFLFLFFRFRFLFF 3 R 1 FFLFRFRFFLFLFRFF 2 L 1 FFLFRFRFFLFLFRFF 3 R 1 FFRFLFLFFRFRFLFF 2 R 1 FFRFLFLFFRFRFLFF 2 L 1 FFFFFF 3 R 1 FFFRFLFLFRFF 5 R 1 FFLFRFRFLFFF 1 L 1 FFLFRFRFFLFLFRFF 2 R 1 FFRFLFLFFRFRFLFF 2 L 1";
    public static String path = "FFLFRFRFFLFLFRFF 5 L 1 FFFRFLFLFRFF 4 L 1 FFLFRFRFFLFLFRFF 8 L 1 FFLFRFRFFLFLFRFF 4 L 1 FFFFFF 3 R 1";

    public static void main(String[] args) {
	    // write your code here

        String[] pathArray = path.split(" ");

//        int distanz         = Integer.parseInt(pathArray[0]);   // ORIGIN
//        String direction    = pathArray[1];                     // Splitten in char array
//        int counter         = Integer.parseInt(pathArray[2]);   // Wiederholungen

        int distanz = 0;
        int loop = 0;

        for(String x : pathArray) {

            if (loop + 1 <= pathArray.length) {

//            if(loop % 2 == 0) {
//                loop++;
//                continue;
//            }

                String direction = pathArray[loop];                     // Splitten in char array
                int counter = Integer.parseInt(pathArray[loop + 1]);   // Wiederholungen
                char[] steps = direction.toCharArray();

                while (counter > 0) {

                    for (char c : steps) {

                        switch (c) {
                            case 'F':
                                distanz++;
                                break;
                            case 'R':
                                break;
                            case 'L':
                                break;
                            default:
                                break;
                        }
                    }
                    counter--;
                }

                loop += 2;
            }
        }

        System.out.println(distanz);

    }
}
