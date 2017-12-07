package algo.commons;

public class Sort {

    SortHelper helper = new SortHelper();
    int runningTime = 1;

    public int getRunningtime() {
        return runningTime;
    }

    /**
     * Utilisation des deux boucles Tri n²
     *
     * @param toSort
     * @return
     */
    public int[] bubbleSort(int[] toSort) {
        for (int i = 0; i < toSort.length; i++) {
            for (int k = 0; k < toSort.length; k++) {
                if (toSort[k] > toSort[i]) {
                    helper.exchange(i, k, toSort);
                }
            }
        }
        return toSort;
    }

    public int[] quickSort(int[] toSort) {
        /**
         * Cela peut etre intéressant d'ordonner des parties des tableaux et non seulement en sont intégralité
         */
        return quickSort(0, toSort.length - 1, toSort);
    }

    /**
     * L'idée: choix d'un pivot et ordoner les éléments par rapport au pivot à
     * droite les élément supérieur à gauche inférieurs Base case: retourner le
     * tableau initial si le tableau contient 1 élément Positionner deux
     * pinteurs start et end dans le tableau: Tant que le start n'est pas
     * supérieur au dernier incrémenter start tant qu'il est inférieur au pivot
     * décrémenter end tant qu'il est supérieur au pivot echanger les start avec
     * end car l'un doit etre a gauche du pivot et l'autre à droite, puis
     * incrémente/décremente pour aller au suivant
     *
     * @param initialFrom
     * @param initialTo
     * @param toSort
     * @return
     */
    public int[] quickSort(int initialFrom, int initialTo, int[] toSort) {
        int start = initialFrom;
        int end = initialTo;
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
            /**
             * Vérification nécessaire pour vérifier si la limite n'est pas
             * atteinte (remarque usage de OU EGAL)
             */
            if (start <= end) {
                helper.exchange(start, end, toSort);
                start++;
                end--;
            }
        }
        quickSort(initialFrom, end, toSort);
        quickSort(start, initialTo, toSort);
        return toSort;
    }

    /**
     * L'idée de base est de 1:Choisir un élémént: souvent le milieu du tableau
     * 2:diviser le tableau en 3 sous tableaux 2.1-les elements egaux a
     * l'élément choisi 2.2-les éléments inférieurs a l'element choisi 3.3-les
     * éléments supérieurs à l'élément choisi appliquer recursivement cette
     * opérations sur les deux tableaux -des supérieurs et des inférieurs (pas
     * sur les égaux) merger les les resultats des recurions.
     *
     * @param toSort
     * @return
     */
    public int[] mergeSort(int[] toSort) {
        /**
         * Base case le tableau d'entrée contient un seul élement ou vide
         */
        if (toSort.length <= 1) {
            return toSort;
        }
        /**
         * choix de l'élément, préférable au milieu
         */
        int middleIndex = (toSort.length - 1) / 2;
        int middleValue = toSort[middleIndex];

        /**
         * Créer 3 tableaux: supérieurs, egaux et inférieurs
         */
        int[] equals = helper.getEquals(middleValue, toSort);
        int[] sups = helper.getSuppTo(middleValue, toSort);
        int[] infs = helper.getInfTo(middleValue, toSort);

        /**
         * Merger les tableaux resultant de la récursion
         */
        return helper.merge(mergeSort(infs), equals, mergeSort(sups));
    }

}
