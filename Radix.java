public class Radix{
  public static int nth(int n, int col){
    return n/(int)Math.pow(10,col)%10;
  }
  public static int length(int n){
    if (n<0){
      n=n*-1;
    }
    return (int) (Math.log10(n))+1;
  }
  public static void merge(SortableLinkedList original, SortableLinkedList[] buckets){
    for (SortableLinkedList i:buckets){
      original.extend(i);
    }
  }
  public static void radixSortSimple(SortableLinkedList data){
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    int maxDigits=1;
    for (int i=0;i<10;i++){
      buckets[i]=new SortableLinkedList();
    }
    for (int i=0;i<maxDigits;i++){
      while (data.size()>0){
        maxDigits=Math.max((length(data.get(0))),maxDigits);
        buckets[Math.abs(nth(data.get(0),i))].add(data.get(0));
        data.remove(0);
      }
      merge(data, buckets);
    }
  }

  public static void radixSort(SortableLinkedList data){
    SortableLinkedList holder= new SortableLinkedList();
    SortableLinkedList pos= new SortableLinkedList();
    SortableLinkedList negative= new SortableLinkedList();
    SortableLinkedList negativeReversed= new SortableLinkedList();
    for (int i=0;i<data.size();i++){
      if (data.get(i)>=0){
        pos.add(data.get(i));
      }
      else{
        negative.add(data.get(i));
      }
    }
    radixSortSimple(pos);
    radixSortSimple(negative);
    holder.extend(data);
    for (int i=0;i<negative.size();i++){
      negativeReversed.add(0, negative.get(i));
    }
    data.extend(negativeReversed);
    data.extend(pos);
  }

}
