class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] reservedSeat: reservedSeats){
            int row = reservedSeat[0];
            int seat = reservedSeat[1];
            map.computeIfAbsent(row, k -> new HashSet<>()).add(seat);
        }

        //jis row me ek bhi seat booked nhi h usme hum max 2 group ek sath book ks sakte hai
        int result = (n - map.size()) * 2;

        for(Map.Entry<Integer, Set<Integer>> entry: map.entrySet()){
            int rowHasBooking = entry.getKey();
            Set<Integer> bookedSeatsInRow = entry.getValue();

            boolean isGroup1Available = isAvailable(2, bookedSeatsInRow) && isAvailable(3, bookedSeatsInRow) && isAvailable(4, bookedSeatsInRow) && isAvailable(5, bookedSeatsInRow);

            boolean isGroup2Available = isAvailable(4, bookedSeatsInRow) && isAvailable(5, bookedSeatsInRow) && isAvailable(6, bookedSeatsInRow) && isAvailable(7, bookedSeatsInRow);

            boolean isGroup3Available = isAvailable(6, bookedSeatsInRow) && isAvailable(7, bookedSeatsInRow) && isAvailable(8, bookedSeatsInRow) && isAvailable(9, bookedSeatsInRow);

            if(isGroup1Available && isGroup3Available){
                result += 2;
            } else if(isGroup1Available || isGroup2Available || isGroup3Available){
                result += 1;
            }
        }
        return result;
    }
    private boolean isAvailable(final int seat, final Set<Integer> bookedSeatsInRowSet){
        return !bookedSeatsInRowSet.contains(seat);
    }
}