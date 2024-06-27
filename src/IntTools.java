public class IntTools {
    private int number;

    public IntTools(int number) {
        this.number = number;
    }

    public int digitSum() {
        int sum = 0;
        int temp = Math.abs(number);
        while (temp != 0) {
            sum += temp % 10;
            temp /= 10;
        }
        return sum;
    }

    public int lastDigit() {
        return Math.abs(number) % 10;
    }

    public int digitAt(int position) throws IndexOutOfBoundsException {
        String numStr = Integer.toString(Math.abs(number));
        int length = numStr.length();
        if (position < 0 || position >= length) {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }
        return Character.getNumericValue(numStr.charAt(length - 1 - position));
    }

    public static void main(String[] args) {
        IntTools intTools = new IntTools(12345);

        System.out.println("Sum of digits: " + intTools.digitSum()); // Output: 15

        System.out.println("Last digit: " + intTools.lastDigit()); // Output: 5

        try {
            System.out.println("Digit at position 0: " + intTools.digitAt(0)); // Output: 5
            System.out.println("Digit at position 1: " + intTools.digitAt(1)); // Output: 4
            System.out.println("Digit at position 4: " + intTools.digitAt(4)); // Output: 1
            System.out.println("Digit at position 5: " + intTools.digitAt(5)); // Throws exception
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
