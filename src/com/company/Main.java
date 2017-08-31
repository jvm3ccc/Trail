package com.company;

public class Main {

//    public static String path = "FFFR 4";
//    public static String path = "F 6 R 1 F 4 RFF 2 LFF 1 LFFFR 1 F 2 R 1 F 5";
//    public static String path = "L 1 FR 1 FFFFFL 1 FFFFL 1 F 12 L 1 F 12 L 1 F 12 L 1 FFFFL 1 FFFFFFFFR 1 FFFR 1 FFFL 1";
//    public static String path = "FFRFLFLFFRFRFLFF 3 R 1 FFLFRFRFLFFF 3 R 1 FFFFFF 3 L 1 FFFRFLFLFRFF 2 R 1 FFFRFLFLFRFF 3 R 1 FFFFFF 1 L 1 FFRFLFLFFRFRFLFF 3 R 1 FFLFRFRFFLFLFRFF 2 L 1 FFLFRFRFFLFLFRFF 3 R 1 FFRFLFLFFRFRFLFF 2 R 1 FFRFLFLFFRFRFLFF 2 L 1 FFFFFF 3 R 1 FFFRFLFLFRFF 5 R 1 FFLFRFRFLFFF 1 L 1 FFLFRFRFFLFLFRFF 2 R 1 FFRFLFLFFRFRFLFF 2 L 1";
    public static String path = "FFLFRFRFFLFLFRFF 5 L 1 FFFRFLFLFRFF 4 L 1 FFLFRFRFFLFLFRFF 8 L 1 FFLFRFRFFLFLFRFF 4 L 1 FFFFFF 3 R 1";
//    public static String path = "F 6 R 1 F 4 RFF 2 LFF 1 LFFFR 1 F 2 R 1 F 5";

    public static int kompassAktuell = 0;
    public static int[] coords = {0, 0};

    public static int maxX = 0;
    public static int maxY = 0;
    public static int minX = 0;
    public static int minY = 0;

    public static int sumX = 0;
    public static int sumY = 0;


    public static void main(String[] args) {

//        a1();
        a2();
    }

    public static void a2() {

        String[] pathArray = path.split(" ");
        int distanz = 0;
        int loop = 0;

        for(String x : pathArray) {

            if (loop + 1 > pathArray.length) {
                break;
            }

            String direction = pathArray[loop];                     // Splitten in char array
            int counter = Integer.parseInt(pathArray[loop + 1]);   // Wiederholungen
            char[] steps = direction.toCharArray();

            while (counter > 0) {

                for (char c : steps) {

                    switch (c) {
                        case 'F':
                            switch (kompassAktuell){
                                case 0:
                                    coords[0] += 1;
                                    break;
                                case 1:
                                    coords[1] += 1;
                                    break;
                                case 2:
                                    coords[0] -= 1;
                                    break;
                                case 3:
                                    coords[1] -= 1;
                                    break;
                                default:
                                    break;
                            }

                            if(maxX < coords[0]) {
                                maxX = coords[0];
                            }
                            if(maxY < coords[1]) {
                                maxY = coords[1];
                            }
                            if(minX > coords[0]) {
                                minX = coords[0];
                            }
                            if(minY > coords[1]) {
                                minY = coords[1];
                            }

                            distanz++;
                            break;
                        case 'R':
                            kompassRichtungAendern("R");
                            break;
                        case 'L':
                            kompassRichtungAendern("L");
                            break;
                        default:
                            break;
                    }
                }
                counter--;
            }

            loop += 2;
        }

        sumX = maxX + Math.abs(minX);
        sumY = maxY + Math.abs(minY);

        System.out.print(distanz + " ");
        System.out.print(sumX * sumY);
    }

    public static int kompassRichtungAendern(String richtung) {

        // N, W, S, O
        // kompass = {0, 1, 2, 3};

        if(richtung.equals("R")) {
            kompassAktuell += 1;
        } else if (richtung.equals("L")) {
            kompassAktuell -= 1;
        }

        if(kompassAktuell < 0) {
            kompassAktuell = 3;
        }

        if(kompassAktuell > 3) {
            kompassAktuell = 0;
        }


        return kompassAktuell;
    }

    public static void a1() {

        String[] pathArray = path.split(" ");
        int distanz = 0;
        int loop = 0;

        for(String x : pathArray) {

            if (loop + 1 > pathArray.length) {
                break;
            }

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

        System.out.println(distanz);
    }
}
