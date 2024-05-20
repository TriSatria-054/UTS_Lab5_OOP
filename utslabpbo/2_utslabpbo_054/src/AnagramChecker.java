import java.util.Arrays;
import java.util.Scanner;

public class AnagramChecker {

    public static boolean areAnagrams(String str1, String str2) {
        //hilangkan spasi dan ubah menjadi huruf kecil
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        //jika panjang kedua string tidak sama, mereka bukan anagram
        if (str1.length() != str2.length()) {
            return false;
        }

        //ubah string menjadi array karakter
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        //urutkan array karakter
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        //bandingkan array karakter yang sudah diurutkan
        return Arrays.equals(charArray1, charArray2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan string pertama: ");
        String str1 = scanner.nextLine();

        System.out.print("Masukkan string kedua: ");
        String str2 = scanner.nextLine();

        boolean result = areAnagrams(str1, str2);

        if (result) {
            System.out.println("Kedua string merupakan anagram.");
        } else {
            System.out.println("Kedua string bukan merupakan anagram.");
        }

        scanner.close();
    }
}
