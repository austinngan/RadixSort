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
    SortableLinkedList holder= new SortableLinkedList();
    int maxDigits=0;
    for (int i=0;i<10;i++){
      buckets[i]=new SortableLinkedList();
    }
    //amount of times to sort by
    for (int i=0;i<data.size();i++){
      if (length(data.get(i))>maxDigits){
        maxDigits=length(data.get(i));
      }
    }
    for (int y=0;y<maxDigits;y++){
      for (int i=0;i<data.size();i++){
        (buckets[nth(data.get(i),y)]).add(data.get(i));
      }
      holder.extend(data);
      merge(data, buckets);
    }
  }

  public static void radixSort(SortableLinkedList data){
    SortableLinkedList holder= new SortableLinkedList();
    SortableLinkedList pos= new SortableLinkedList();
    SortableLinkedList negative= new SortableLinkedList();
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
    data.extend(negative);
    data.extend(pos);
  }

}
