package algo.commons;

public class Sort {

    public int[] bubbleSort(int[] toSort) {
        for (int i = 0; i < toSort.length; i++) {
            for (int k = 0; k < toSort.length; k++) {
                if (toSort[k] > toSort[i]) {
                    exchange(i, k, toSort);
                }
            }
        }
        return toSort;
    }

    private void exchange(int i, int k, int[] toSort) {
        int temp = toSort[i];
        toSort[i] = toSort[k];
        toSort[k] = temp;
    }

    public int[] quickSort(int[] toSort) {

        return quickSort(0, toSort.length - 1, toSort);
    }

    public int[] quickSort(int from, int to, int[] toSort) {
        int start = from;
        int end = to;
        if (start >= end) {
            return toSort;
        }
        int pivot = toSort[(start + end) / 2];
        while (start <= end) {
            while (pivot > toSort[start]) {
                start++;
            }
            while (pivot < toSort[end]) {
                end--;
            }
            if (start <= end) {
                exchange(start, end, toSort);
                start++;
                end--;
            }
        }
        quickSort(from, end, toSort);
        quickSort(start, to, toSort);
        return toSort;
    }

    
    /**
     * L'idée de base est de 
     * 1:Choisir un élémént: souvent le milieu du tableau
     * 2:diviser le tableau en 3 sous tableaux
     *   2.1-les elements egaux a l'élément choisi
     *   2.2-les éléments inférieurs a l'element choisi
     *   3.3-les éléments supérieurs à l'élément choisi
     * appliquer recursivement cette opérations sur les deux tableaux
     *  -des supérieurs et des inférieurs (pas sur les égaux)
     * merger les les resultats des recurions.
     * @param toSort
     * @return 
     */
    public int[] mergeSort(int[]toSort){
        /**
         * Base case le tableau d'entrée contient un seul élement ou vide
         */
        if(toSort.length<=1)
            return toSort;
        /**
         * choix de l'élément, préférable au milieu
         */
        int middleIndex=  (toSort.length-1)/2;
        int midleValue=   toSort[middleIndex];
        
        /**
         * Créer 3 tableaux: supérieurs, egaux et inférieurs
         */
        int[] equals= getEquals(midleValue, toSort);
        int[] sups = getSuppTo(midleValue, toSort);
        int[] infs = getInfTo(midleValue, toSort);
        
        /**
         * Merger les tableaux resultant de la récursion
         */
        return merge(mergeSort(infs),equals,mergeSort(sups));
    }
    
    public int[] getSuppTo(int suppTo,int[] fromArr){
        
        /**
         * La taille n'est pas connue en avance
         */
        int size =0; //calculer la taille
        for(int v:fromArr){
            if(v>suppTo)
                size++;
        }
        int[] arrOfSups= new int[size];
        int k=0;
        for(int i=0;i<fromArr.length;i++){
            if(fromArr[i]>suppTo){
                arrOfSups[k]=fromArr[i];
                k++;
            }
        }
        return arrOfSups;  
    }
    public int[] getInfTo(int infTo,int[] fromArr){
        int size =0;
        for(int v:fromArr){
            if(v<infTo)
                size++;
        }
        int[] arrInfsTo= new int[size];
        int k=0;
        for(int i=0;i<fromArr.length;i++){
            if(fromArr[i]<infTo){
                arrInfsTo[k]=fromArr[i];
                k++;
            }
        }
        return arrInfsTo;  
    }
    
    public int[] getEquals(int equalsTo,int[] fromArr){
        int size =0;
        for(int v:fromArr){
            if(v==equalsTo)
                size++;
        }
        int[] arrInfsTo= new int[size];
        int k=0;
        for(int i=0;i<fromArr.length;i++){
            if(fromArr[i]==equalsTo){
                arrInfsTo[k]=fromArr[i];
                k++;
            }
        }
        return arrInfsTo;  
    }

    public int[] merge(int[] a, int[] b) {
        int[] res = new int[a.length + a.length];
        System.arraycopy(a, 0, res, 0, a.length);
        for (int i = 0; i < b.length; i++) {
            res[i + a.length] = b[i];
        }
        return res;
    }
    public int[] merge(int[] a, int[] b,int[]c) {
        int[] res = new int[a.length + b.length+c.length];
        System.arraycopy(a, 0, res, 0, a.length);
        for (int i = 0; i < b.length; i++) {
            res[i + a.length] = b[i];
        }
        for (int i = 0; i < c.length; i++) {
            res[i + a.length+b.length] = c[i];
        }
        return res;
    }

}
