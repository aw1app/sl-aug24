function jumpSearch(arr, x) {

    // Calculate the optimal block size 
    let m = Math.floor(Math.sqrt(arr.length));

    // Start the search from the beginning of the array 
    let left = 0;
    let right = m;

    // Check if the element is within the current block 
    while (arr[right] <= x && right < arr.length) {
        left = right;
        right += m;
        if (right >= arr.length) {
            right = arr.length - 1;
        }
    }

    // Perform linear search within the found block 
    for (let i = left; i <= right; i++) {
        if (arr[i] === x) {
            return i;
        }
    }

    // If we are here, then it means the element is not found
    return -1;
}

const arr = [0, 1, 4, 9, 16, 25, 36, 49, 64, 81];
const x = 36;

// Measure execution time 
console.time("jumpSearch");
const index = jumpSearch(arr, x);
console.timeEnd("jumpSearch");

if (index !== -1) {
    console.log(`Element found at index ${index}`);
} else {
    console.log(`Element not found`)
} 