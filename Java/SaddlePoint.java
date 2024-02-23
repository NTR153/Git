package Java;

//A saddle point in a matrix is an element that is greater than all elements in its row and smaller than all elements in its column. 
//For example, the number 5 in the above transposed matrix is a saddle point.

class SaddlePoint {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        
        // Find and print all saddle points
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (isSaddlePoint(arr, i, j)) {
                    System.out.println("Saddle point found at (" + i + ", " + j + ")");
                }
            }
        }
    }
    
    static boolean isSaddlePoint(int[][] arr, int row, int col) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[row][col] < arr[i][col]) {
                return false;
            }
        }
        for (int j = 0; j < arr[0].length; j++) {
            if (arr[row][col] > arr[row][j]) {
                return false;
            }
        }
        return true;
    }   
}