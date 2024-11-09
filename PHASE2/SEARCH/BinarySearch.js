
// Binary search function to find the index of the target in a sorted array 
function binarySearch(arr, target) { 

    let left = 0; 
    let right = arr.length - 1; 

    while (left <= right) { 
        const mid = Math.floor((left + right) / 2); 
 
        if (arr[mid] === target) { 
            return mid; // Element found 
        } 
        if (arr[mid] < target) { 
            left = mid + 1; // Search in the right half 
        } else { 
            right = mid - 1; // Search in the left half 
        } 
    } 

    return -1; // Element not found 
}

const arr = [1, 3, 5, 7, 9, 11, 13, 15]; 
const target = 9; 

// Measure the execution time of the binarySearch function 
console.time("binarySearch"); 
const result = binarySearch(arr, target); 
console.timeEnd("binarySearch"); 
 
if (result !== -1) { 
    console.log(`Element found at index: ${result}`); 
} else { 
    console.log('Element not found in the array'); 
} 



