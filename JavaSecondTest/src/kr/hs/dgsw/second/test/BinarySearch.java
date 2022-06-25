package kr.hs.dgsw.second.test;

public class BinarySearch implements Searcher{
    @Override
    public int search(int[] sortedValues, int value) {
        int length = sortedValues.length;
        int low = 0;
        int high = length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedValues[mid] == value)
                return mid;
            else if (sortedValues[mid] > value) {
                high = mid -1;
            } else if (sortedValues[mid] < value) {
                low = mid + 1;
            }
        }
        // 탐색 실패 시 -1 반환
        return -1;
    }
}
