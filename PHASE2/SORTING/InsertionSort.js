function insertionSort(array) { 

    let n = array.length;

    for (let i = 0; i <n ; i++) {


        let currentValue = array[i]; 
      
        let j = i - 1; 

        // Shift elements greater than the current value to the right 
        while (j >= 0 && array[j] > currentValue) { 
            array[j + 1] = array[j]; 
            j--;
        }

         // Insert the current value at the correct position 
        array[j + 1] = currentValue; 
    }


}

const unsortedArray = [5, 2, 4,17, 1, 3]; 
console.log("Before Sorting");
console.log(unsortedArray);
insertionSort(unsortedArray);
console.log("AFTER insertionSort Sorting");
console.log(unsortedArray);