

function bubbleSort(array) { 

    for( let i=0 ; i < array.length - 1 ; i++ ){

        for( let j= 0 ; j < array.length - 1 -i ; j++ ){

            if (array[j] > array[j+1])
                [ array[j] ,  array[j+1]] = [array[j+1] ,  array[j] ]
        }

    }


}


const unsortedArray = [5, 2, 4, 1, 3]; 
console.log("Before Sorting");
console.log(unsortedArray);
bubbleSort(unsortedArray);
console.log("AFTER bubblesort Sorting");
console.log(unsortedArray);