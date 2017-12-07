package struct.map;

import algo.commons.SortHelper;
import struct.list.BstNode;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.IntStream;

public class MainMap {

    public static void main(String[] args) {
        MHashMap<BstNode, BstNode> map = new MHashMap<>();
        int mapInitSize = MHashMap.initSize;
        int len = 1000;

        int[] randInts = new SortHelper().generateRandAndUniq(len);
        Instant start = Instant.now();
        IntStream.of(randInts).forEach(i -> {
            String key = "x_" + i;
            map.put(new BstNode(i), new BstNode(i));
        });

        Instant end = Instant.now();
        System.out.println("\n ---- Duration: " + Duration.between(start, end).getSeconds() + " seconds");
        //map.printAll();
        if (map.size() < len) {
            System.out.println("There is N:" + (len - map.size()) + " Collision!");
        }

        System.out.println("The map is resized : " + MHashMap.countResize + " times");

        if (MHashMap.countResize >= (Math.log(len / 2)) / Math.log(mapInitSize) && MHashMap.countResize <= ((Math.log(len / 2)) / Math.log(mapInitSize) + 1)) {
            System.out.println("Resize: " + MHashMap.countResize + " € [" + ((Math.log(len / 2)) / Math.log(mapInitSize)) + ", " + ((Math.log(len / 2)) / Math.log(mapInitSize) + 1) + "]");
        }
    }

}
