
function quickSort(array, low, high) {

    if (low < high) {
        const pivotIndex = partition(array, low, high);
        // Recursive call for the left part of the array 
        quickSort(array, low, pivotIndex - 1);
        // Recursive call for the right part of the array 
        quickSort(array, pivotIndex + 1, high);
    }
}


function partition(array, low, high) {
    const pivot = array[high];

    let i = low - 1;

    for (let j = low; j < high; j++) {
        if (array[j] < pivot) {
            i++;
            [array[i], array[j]] = [array[j], array[i]]; // Swap elements 
        }
    }

    [array[i+1], array[high]] = [array[high], array[i+1]]; // Swap elements 
    return i+1;
}


const unsortedArray = [5  , 3,  1, 17, 2,  4];
console.log(unsortedArray);
console.time("quickSort");
quickSort(unsortedArray, 0, unsortedArray.length - 1);
console.timeEnd("quickSort"); // Measures and logs the time taken for sorting 
console.log(unsortedArray); // Output: [1, 2, 3, 4, 5] 