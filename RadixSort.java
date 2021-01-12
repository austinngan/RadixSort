public class RadixSort{

  public static int nth(int n, int col){
    return n/ (int)Math.pow(10,col)%10;
  }

  public static int length(int n){
    return (int) (Math.log10(n))+1;
  }

}
